@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
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
import com.example.mad_assignment02.data.DataSource.main_fillings
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
fun Custom_Screen(){
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            MainFillingsList(main_fillings)
        }
    }
}