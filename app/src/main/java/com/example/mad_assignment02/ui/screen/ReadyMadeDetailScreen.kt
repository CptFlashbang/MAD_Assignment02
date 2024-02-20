@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mad_assignment02.R
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos
import com.example.mad_assignment02.ui.BurritoViewModel

@Composable
fun Ready_Made_Detail_Screen(
    burritoId: Int,
    navHostController: NavHostController,
    viewModel: BurritoViewModel,
    navigateUp: () -> Unit = {},
    ) {
//    val burrito = ReadyMadeBurritos.first { burrito ->
//        burrito.id == burritoId
//    val viewModel: BurritoViewModel = viewModel()
    val burrito = viewModel.getBurritoById(burritoId)
//    }
    val context = LocalContext.current
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
                    Text(text = burrito.title)
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.addToOrder(burrito);
                        Toast.makeText(
                            context,
                            "'${burrito.title}' added to order",
                            Toast.LENGTH_SHORT //can also specify Toast.LENGTH_LONG
                        ).show()

                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.add_shopping_cart_fill0_wght400_grad0_opsz24),
                            contentDescription = "Add to cart action Icon"
                        )
                    }
                    IconButton(onClick = {
                        viewModel.addFavoriteBurrito(burrito)
                        Toast.makeText(
                            context,
                            "'${burrito.title}' saved as favourite",
                            Toast.LENGTH_SHORT //can also specify Toast.LENGTH_LONG
                        ).show()
                    }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.favorite_fill0_wght400_grad0_opsz24),
                            contentDescription = "Add to favourite action Icon"
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
//            Text(text = burrito.description.toString())
//            Text(text = "Price: ${burrito.price}")
//            Text(text = "Main Filling: " + stringResource(burrito.mainFilling))
            item {
                Image(
                    painter = painterResource(id = R.drawable.burrito_hero),
                    contentDescription = "Sangria Image",
                    modifier = Modifier.clip(RoundedCornerShape(28.dp))
                )
            }

            item { Divider() }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(text = "Description", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = burrito.description.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            item { Divider() }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(text = "Main Filling:", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = stringResource(burrito.mainFilling),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            item { Divider() }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(
                        text = "Additional Fillings:",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    burrito.additionalFillings.forEach { filling ->
                        Text(
                            text = stringResource(filling),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            item { Divider() }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(text = "Sauces:", style = MaterialTheme.typography.headlineSmall)
                    burrito.sauces.forEach { sauce ->
                        Text(
                            text = stringResource(sauce),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            item { Divider() }

            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(text = "Salads:", style = MaterialTheme.typography.headlineSmall)
                    burrito.salads.forEach { salad ->
                        Text(
                            text = stringResource(salad),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

        }
    }
}

