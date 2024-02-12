@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.data.Burrito
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos
import com.example.mad_assignment02.ui.component.BottomNavBar

class ReadyMadeDetailScreen {
}
@Composable
fun Ready_Made_Detail_Screen(burritoId: Int, navHostController: NavHostController){
    val burrito = ReadyMadeBurritos.first { burrito ->
        burrito.id == burritoId
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { /* TODO */ }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text("Top app bar")
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = stringResource(id = burrito.title))
            Text(text = stringResource(id = burrito.description))
            Text(text = "Price: ${burrito.price}")
            Text(text = "Main Filling: ${burrito.mainFilling}")
            Text(text = "Additional Fillings: ${burrito.additionalFillings.joinToString(", ")}")
            Text(text = "Sauces: ${burrito.sauces.joinToString(", ")}")
            Text(text = "Salads: ${burrito.salads.joinToString(", ")}")
        }
    }
}