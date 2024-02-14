@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.R
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos

@Composable
fun Ready_Made_Detail_Screen(
    burritoId: Int,
    navHostController: NavHostController,
    navigateUp: () -> Unit = {},
    ){
    val burrito = ReadyMadeBurritos.first { burrito ->
        burrito.id == burritoId
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = navigateUp
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = burrito.title))
                },
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
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(text = stringResource(burrito.description))
            Text(text = "Price: ${burrito.price}")
            Text(text = "Main Filling: " + stringResource(burrito.mainFilling))

            // Additional Fillings
            Text(text = "Additional Fillings: ")
            burrito.additionalFillings.forEach { filling ->
                Text(text = stringResource(filling))
            }

            // Sauces
            Text(text = "Sauces: ")
            burrito.sauces.forEach { sauce ->
                Text(text = stringResource(sauce))
            }

            // Salads
            Text(text = "Salads: ")
            burrito.salads.forEach { salad ->
                Text(text = stringResource(salad))
            }
        }
    }
}