@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.ui.component.BottomNavBar

class CustomScreen {
}

@Preview
@Composable
fun CustomScreenPreview() {
    Main_Filling()
}

@Composable
fun Main_Filling(){
    androidx.compose.material3.ListItem(
        leadingContent = {

        },
        headlineText = { /*TODO*/ }
    )
}
@Composable
fun Main_Fillings_List(){
    androidx.compose.material3.ListItem(
        leadingContent = {
            RadioButton(
                selected = selectedValue == item,
                onClick = {
                    selectedValue = item
                    onSelectionChanged(item)
                }

        },
        headlineText = { /*TODO*/ }
    )


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
            Text(text = "Custom_Screen")
        }
    }
}