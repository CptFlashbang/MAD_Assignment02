@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
            ListItem(
                modifier = Modifier
                    .fillMaxWidth(),
                leadingContent = {
                    Checkbox(
                        checked = fillingId in selectedItems,
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
        bottomBar = {
            Button(onClick = { /* TODO: Add action for button click */ }) {
                Text("Add to Order")
            }
        },
    )
    { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
        ) {
//            // Main Fillings Section
//            item { Text("Main Fillings") }
//            items(main_fillings) { fillingId ->
//                MainFillingListItem(
//                    fillingText = stringResource(fillingId),
//                    isSelected = fillingId in selectedMainFillings.value,
//                    onSelect = {
//                        if (fillingId in selectedMainFillings.value) {
//                            selectedMainFillings.value.remove(fillingId)
//                        } else {
//                            selectedMainFillings.value.add(fillingId)
//                        }
//                    }
//                )
//                Divider()
//            }
//
//            // Additional Fillings Section
//            item { Text("Additional Fillings") }
//            items(additional_fillings) { fillingId ->
//                // Similar structure for additional fillings
//                FillingListItem(
//                    fillingText = stringResource(fillingId),
//                    isSelected = fillingId in selectedAdditionalFillings.value,
//                    onSelect = {
//                        if (fillingId in selectedAdditionalFillings.value) {
//                            selectedAdditionalFillings.value.remove(fillingId)
//                        } else {
//                            selectedAdditionalFillings.value.add(fillingId)
//                        }
//                    }
//                )
//            }
//
//            // Sauces Section
//            item { Text("Sauces") }
//            items(sauces) { sauceId ->
//                // Similar structure for sauces
//                FillingListItem(
//                    fillingText = stringResource(sauceId),
//                    isSelected = sauceId in selectedSauces.value,
//                    onSelect = {
//                        if (sauceId in selectedSauces.value) {
//                            selectedSauces.value.remove(sauceId)
//                        } else {
//                            selectedSauces.value.add(sauceId)
//                        }
//                    }
//                )
//            }
//
//            // Salads Section
//            item { Text("Salads") }
//            items(salads) { saladId ->
//                // Similar structure for salads
//                FillingListItem(
//                    fillingText = stringResource(saladId),
//                    isSelected = saladId in selectedSalads.value,
//                    onSelect = {
//                        if (saladId in selectedSalads.value) {
//                            selectedSalads.value.remove(saladId)
//                        } else {
//                            selectedSalads.value.add(saladId)
//                        }
//                    }
//                )
//            }
            Column {
                BurritoNameField(burritoName)
                MainFillingsSection(main_fillings, selectedMainFilling)
                AdditionalItemsSection(additional_fillings,selectedAdditionalFillings.value, "Additional Fillings")
                AdditionalItemsSection(sauces, selectedSauces.value, "Sauces")
                AdditionalItemsSection(salads, selectedSalads.value, "Salads")
                DisplayPrice(
                    CalculatePrice(
                        additionalFillings = , sauces = , salads =
                    )
                )
            }
        }
    }
}