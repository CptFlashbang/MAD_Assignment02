@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.mad_assignment02.ui.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.R
import com.example.mad_assignment02.data.BurritoClass
import com.example.mad_assignment02.data.DataSource.additional_fillings
import com.example.mad_assignment02.data.DataSource.main_fillings
import com.example.mad_assignment02.data.DataSource.salads
import com.example.mad_assignment02.data.DataSource.sauces
import com.example.mad_assignment02.ui.BurritoViewModel
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
fun AdditionalItemsSection(items: List<Int>, selectedItems: MutableList<Int>) {
    Column {
        items.forEach { itemId ->
            // Remember the checked state for each item
            val isChecked = remember { mutableStateOf(itemId in selectedItems) }

            Row(Modifier.fillMaxWidth().padding(8.dp)) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { selected ->
                        isChecked.value = selected
                        if (selected) {
                            if (itemId !in selectedItems) {
                                selectedItems.add(itemId)
                            }
                        } else {
                            selectedItems.remove(itemId)
                        }
                    }
                )
                Text(stringResource(id = itemId))
            }
        }
    }
}

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
fun Custom_Screen(
    viewModel: BurritoViewModel,
) {
    var burritoName = remember { mutableStateOf("") }
    var selectedMainFilling = remember { mutableStateOf(main_fillings.first()) }
    val selectedAdditionalFillings = remember { mutableStateOf(mutableListOf<Int>()) }
    val selectedSauces = remember { mutableStateOf(mutableListOf<Int>()) }
    val selectedSalads = remember { mutableStateOf(mutableListOf<Int>()) }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Build-a-Burrito") },
                actions = {
                    IconButton(onClick = {
                        val customBurrito = BurritoClass(
                            title = burritoName.value,
                            mainFilling = selectedMainFilling.value,
                            additionalFillings = selectedAdditionalFillings.value,
                            sauces = selectedSauces.value,
                            salads = selectedSalads.value,
                            price = CalculatePrice(
                                selectedAdditionalFillings.value,
                                selectedSauces.value,
                                selectedSalads.value
                            ),
                        )
                        viewModel.addToOrder(customBurrito)
                        Toast.makeText(
                            context,
                            "'${customBurrito.title}' added to order",
                            Toast.LENGTH_SHORT //can also specify Toast.LENGTH_LONG
                        ).show()
                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.add_shopping_cart_fill0_wght400_grad0_opsz24),
                            contentDescription = "Add to cart action Icon"
                        )
                    }
                    IconButton(onClick = {
                        val customBurrito = BurritoClass(
                            title = burritoName.value,
                            mainFilling = selectedMainFilling.value,
                            additionalFillings = selectedAdditionalFillings.value,
                            sauces = selectedSauces.value,
                            salads = selectedSalads.value,
                            price = CalculatePrice(
                                selectedAdditionalFillings.value,
                                selectedSauces.value,
                                selectedSalads.value
                            ),
                        )
                        /* TODO: Turn this into a function */
                        viewModel.addFavoriteBurrito(customBurrito)
                        Toast.makeText(
                            context,
                            "'${customBurrito.title}' saved as favourite",
                            Toast.LENGTH_SHORT //can also specify Toast.LENGTH_LONG
                        ).show()
                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.favorite_fill0_wght400_grad0_opsz24),
                            contentDescription = "Add to favourite action Icon"
                        )
                    }
                }
            )
         },
        bottomBar = {
//            DisplayPrice(
//                CalculatePrice(
//                    selectedAdditionalFillings.value,
//                    selectedSauces.value,
//                    selectedSalads.value
//                )
//            )
        },
    )
    { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item { BurritoNameField(burritoName) }

            item {
                ExpandableSection(title = "Main Fillings") {
                    MainFillingsSection(main_fillings, selectedMainFilling)
                }
            }

            item { Divider() }

            item {
                ExpandableSection(title = "Additional Fillings") {
                    AdditionalItemsSection(additional_fillings, selectedAdditionalFillings.value)
                }
            }

            item { Divider() }

            item {
                ExpandableSection(title = "Sauces") {
                    AdditionalItemsSection(sauces, selectedSauces.value)
                }
            }

            item { Divider() }

            item {
                ExpandableSection(title = "Salads") {
                    AdditionalItemsSection(salads, selectedSalads.value)
                }
            }

            item { Divider() }

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
            .clickable { expanded = !expanded }
            .padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = if (expanded) painterResource(id = R.drawable.expand_less_fill0_wght400_grad0_opsz24) else painterResource(id = R.drawable.expand_more_fill0_wght400_grad0_opsz24),
                contentDescription = if (expanded) "Collapse" else "Expand"
            )
        }
        if (expanded) {
            content()
        }
    }
}