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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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

@Preview
@Composable
fun CustomScreenPreview() {
    MainFillingsList(main_fillings)
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
fun MainFillingsList(mainFillings: List<Int>) {
    var selectedFilling by remember { mutableStateOf(mainFillings.firstOrNull() ?: 0) }

    Column {
        mainFillings.forEach { fillingId ->
            val fillingText = stringResource(fillingId)
            MainFillingListItem(
                fillingText = fillingText,
                isSelected = fillingId == selectedFilling,
                onSelect = { selectedFilling = fillingId }
            )
        }
    }
}
@Composable
fun FillingListItem(fillingText: String, isSelected: Boolean, onSelect: () -> Unit) {
    ListItem(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onSelect),
        leadingContent = {
            Checkbox(
                checked = isSelected,
                onCheckedChange = { onSelect() }
            )
        },
        headlineText = { Text(fillingText) }
    )
}

@Composable
fun FillingsList(fillings: List<Int>, selectedFillings: MutableSet<Int>) {
    Column {
        fillings.forEach { fillingId ->
            val fillingText = stringResource(fillingId)
            FillingListItem(
                fillingText = fillingText,
                isSelected = fillingId in selectedFillings,
                onSelect = {
                    if (fillingId in selectedFillings) {
                        selectedFillings.remove(fillingId)
                    } else {
                        selectedFillings.add(fillingId)
                    }
                }
            )
        }
    }
}
@Composable
//fun Custom_Screen(){
//    val selectedMainFillings = remember { mutableStateOf(mutableSetOf<Int>()) }
//    val selectedAdditionalFillings = remember { mutableStateOf(mutableSetOf<Int>()) }
//    val selectedSauces = remember { mutableStateOf(mutableSetOf<Int>()) }
//    val selectedSalads = remember { mutableStateOf(mutableSetOf<Int>()) }
//
//    Scaffold { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(innerPadding),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//        ) {
//            // Pass the state and the list to FillingsList
//            FillingsList(main_fillings, selectedMainFillings.value)
//            FillingsList(additional_fillings, selectedAdditionalFillings.value)
//            FillingsList(sauces, selectedSauces.value)
//            FillingsList(salads, selectedSalads.value)
//        }
//    }
//}

fun Custom_Screen() {
    val selectedMainFillings = remember { mutableStateOf(mutableSetOf<Int>()) }
    val selectedAdditionalFillings = remember { mutableStateOf(mutableSetOf<Int>()) }
    val selectedSauces = remember { mutableStateOf(mutableSetOf<Int>()) }
    val selectedSalads = remember { mutableStateOf(mutableSetOf<Int>()) }

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Main Fillings Section
            item { Text("Main Fillings") }
            items(main_fillings) { fillingId ->
                MainFillingListItem(
                    fillingText = stringResource(fillingId),
                    isSelected = fillingId in selectedMainFillings.value,
                    onSelect = {
                        if (fillingId in selectedMainFillings.value) {
                            selectedMainFillings.value.remove(fillingId)
                        } else {
                            selectedMainFillings.value.add(fillingId)
                        }
                    }
                )
                Divider()
            }

            // Additional Fillings Section
            item { Text("Additional Fillings") }
            items(additional_fillings) { fillingId ->
                // Similar structure for additional fillings
                FillingListItem(
                    fillingText = stringResource(fillingId),
                    isSelected = fillingId in selectedAdditionalFillings.value,
                    onSelect = {
                        if (fillingId in selectedAdditionalFillings.value) {
                            selectedAdditionalFillings.value.remove(fillingId)
                        } else {
                            selectedAdditionalFillings.value.add(fillingId)
                        }
                    }
                )
            }

            // Sauces Section
            item { Text("Sauces") }
            items(sauces) { sauceId ->
                // Similar structure for sauces
                FillingListItem(
                    fillingText = stringResource(sauceId),
                    isSelected = sauceId in selectedSauces.value,
                    onSelect = {
                        if (sauceId in selectedSauces.value) {
                            selectedSauces.value.remove(sauceId)
                        } else {
                            selectedSauces.value.add(sauceId)
                        }
                    }
                )
            }

            // Salads Section
            item { Text("Salads") }
            items(salads) { saladId ->
                // Similar structure for salads
                FillingListItem(
                    fillingText = stringResource(saladId),
                    isSelected = saladId in selectedSalads.value,
                    onSelect = {
                        if (saladId in selectedSalads.value) {
                            selectedSalads.value.remove(saladId)
                        } else {
                            selectedSalads.value.add(saladId)
                        }
                    }
                )
            }
        }
    }
}