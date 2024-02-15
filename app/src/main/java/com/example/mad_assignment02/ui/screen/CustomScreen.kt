@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.R
import com.example.mad_assignment02.data.DataSource.additional_fillings
import com.example.mad_assignment02.data.DataSource.main_fillings
import com.example.mad_assignment02.data.DataSource.salads
import com.example.mad_assignment02.data.DataSource.sauces
import com.example.mad_assignment02.ui.component.BottomNavBar

class CustomScreen {
}

@Composable
fun BurritoNameField(burritoName: MutableState<String>){
    TextField(
        value = burritoName.value,
        onValueChange = { burritoName.value = it },
        label = { Text("Name Your Burrito") },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

@Composable
fun MainFillingListItem(fillingText: String, isSelected: Boolean, onSelect: () -> Unit) {
    ListItem(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onSelect),
        leadingContent = {
            RadioButton(
                selected = isSelected,
                onClick = onSelect
            )
        },
        headlineText = { Text(fillingText) }
    )
}

@Composable
fun MainFillingsSection(mainFillings: List<Int>, selectedMainFilling: MutableState<Int>) {
    Column {
        Text("Select Main Filling")
        mainFillings.forEach { fillingId ->
            val fillingText = stringResource(fillingId)
            ListItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedMainFilling.value = fillingId },
                leadingContent = {
                    RadioButton(
                        selected = (fillingId == selectedMainFilling.value),
                        onClick = { selectedMainFilling.value = fillingId }
                    )
                },
                headlineText = { Text(stringResource(id = fillingId)) }
            )
        }
    }
}

@Composable
fun AdditionalItemsSection(items: List<Int>, selectedItems: MutableList<Int>, title: String){
    Column {
        Text(title)
        items.forEach { fillingId ->
            val fillingText = stringResource(fillingId)
            val isSelected = fillingId in selectedItems
            ListItem(
                modifier = Modifier
                    .fillMaxWidth(),
                leadingContent = {
                    Checkbox(
                        checked = isSelected
                        onCheckedChange = { isChecked ->
                            if (isChecked) selectedItems.add(fillingId)
                            else selectedItems.remove(fillingId)
                        }
                    )
                },
                headlineText = { Text(stringResource(id = fillingId)) }
            )
        }
    }
}

@Composable
fun CalculatePrice(
    additionalFillings: List<Int>,
    sauces: List<Int>,
    salads: List<Int>
):Double {
    val basePrice = 5.00
    val additionalPrice = 0.50

    return basePrice + (additionalFillings.size + sauces.size + salads.size) * additionalPrice
}

@Composable
fun DisplayPrice(price: Double) {
    Text("Current Price: £${String.format("%.2f", price)}")
}

@Composable
fun Custom_Screen() {
    var burritoName = remember { mutableStateOf("") }
    var selectedMainFilling = remember { mutableStateOf(main_fillings.first()) }
    val selectedAdditionalFillings = remember { mutableStateOf(mutableListOf<Int>()) }
    val selectedSauces = remember { mutableStateOf(mutableListOf<Int>()) }
    val selectedSalads = remember { mutableStateOf(mutableListOf<Int>()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Build-a-Burrito") },
                actions = {
                    IconButton(onClick = { /* Handle navigation icon click */ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.add_shopping_cart_fill0_wght400_grad0_opsz24),
                            contentDescription = "Add to cart action Icon"
                        )
                    }
                    IconButton(onClick = { /* Handle action icon click */ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.favorite_fill0_wght400_grad0_opsz24),
                            contentDescription = "Add to favourite action Icon"
                        )
                    }
                }
            )
         },
//        bottomBar = {
//            Button(onClick = { /* TODO: Add action for button click */ }) {
//                Text("Add to Order")
//            }
//        },
    )
    { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item { BurritoNameField(burritoName) }

            item {
                ExpandableSection(title = "Main Fillings") {
                    MainFillingsSection(main_fillings, selectedMainFilling)
                }
            }

            item {
                ExpandableSection(title = "Additional Fillings") {
                    AdditionalItemsSection(additional_fillings, selectedAdditionalFillings.value, "Additional Fillings")
                }
            }

            item {
                ExpandableSection(title = "Sauces") {
                    AdditionalItemsSection(sauces, selectedSauces.value, "Sauces")
                }
            }

            item {
                ExpandableSection(title = "Salads") {
                    AdditionalItemsSection(salads, selectedSalads.value, "Salads")
                }
            }
            item {
                DisplayPrice(
                    CalculatePrice(
                        selectedAdditionalFillings.value,
                        selectedSauces.value,
                        selectedSalads.value
                    )
                )
            }
        }
    }
}

@Composable
fun ExpandableSection(
    title: String,
    content: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )
//            Icon(
//                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
//                contentDescription = if (expanded) "Collapse" else "Expand"
//            )
        }
        if (expanded) {
            content()
        }
    }
}