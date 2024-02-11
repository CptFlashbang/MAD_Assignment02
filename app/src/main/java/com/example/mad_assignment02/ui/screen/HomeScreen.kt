@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mad_assignment02.ui.component.BottomNavBar

class HomeScreen {
}
@Composable
fun Home_Screen(){
    Scaffold(
        bottomBar = {
            BottomAppBar(
            ) {
                BottomNavBar()
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = "Home_Screen")
        }
    }
}