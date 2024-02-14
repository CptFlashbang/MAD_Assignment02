@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.ui.component.BottomNavBar

class OrderScreen {
}

@Preview
@Composable
fun Order_Screen_Preview() {
    TopTabs()
}
@Composable
fun Order_Screen(){
    Scaffold(

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = "Order_Screen")
        }
    }
}

@Composable
fun TopTabs(){
    var selectedTabIndex:Int =0
    TabRow(selectedTabIndex) {
        Tab(
            selected = (selectedTabIndex == 0),
            onClick = { selectedTabIndex = 0 },
            text = { Text("Tab 1") }
        )
        Tab(
            selected = (selectedTabIndex == 1),
            onClick = { selectedTabIndex = 1 },
            text = { Text("Tab 2") }
        )
        Tab(
            selected = (selectedTabIndex == 2),
            onClick = { selectedTabIndex = 2 },
            text = { Text("Tab 3") }
        )

    }
}