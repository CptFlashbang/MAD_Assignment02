@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mad_assignment02.R
import com.example.mad_assignment02.data.BurritoClass
import com.example.mad_assignment02.ui.BurritoViewModel
import com.example.mad_assignment02.ui.component.BottomNavBar
import com.example.mad_assignment02.ui.component.FormattedPriceLabel

class OrderScreen {
}

@Preview
@Composable
fun Order_Screen_Preview() {
    OrderDetails(viewModel())
}
@Composable
fun Order_Screen(
    viewModelTest: BurritoViewModel
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { TopTabs(selectedTabIndex, onSelectTab = { index -> selectedTabIndex = index }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            when (selectedTabIndex) {
                0 -> OrderDetails(viewModelTest)
                1 -> PreviousOrder(viewModelTest)
                2 -> FavouriteDetails(viewModelTest)
            }
        }
    }
}

@Composable
fun TopTabs(selectedTabIndex: Int, onSelectTab: (Int) -> Unit) {
    TabRow(selectedTabIndex) {
        Tab(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.shopping_cart_fill0_wght400_grad0_opsz24),
                    contentDescription = "Shopping cart icon"
                )
            },
            selected = selectedTabIndex == 0,
            onClick = { onSelectTab(0) },
            text = { Text("Current Order") }
        )
        Tab(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.history_fill0_wght400_grad0_opsz24),
                    contentDescription = "History icon"
                )
            },
            selected = selectedTabIndex == 1,
            onClick = { onSelectTab(1) },
            text = { Text("Previous Order") }
        )
        Tab(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.favorite_fill0_wght400_grad0_opsz24),
                    contentDescription = "Favourite icon"
                )
            },
            selected = selectedTabIndex == 2,
            onClick = { onSelectTab(2) },
            text = { Text("Favourite") }
        )
    }
}

@Composable
fun OrderDetails(
    viewModel: BurritoViewModel
){
//    val viewModel: BurritoViewModel = viewModel()
    val uiState = viewModel.uiState.value
    Log.d("OrderDetails", "Displaying ${uiState.burritos.size} burritos")

    val context = LocalContext.current
    Scaffold(
        bottomBar = {
            BottomAppBar { // This is your bottom bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(Modifier.weight(1f)) // This spacer pushes the button to the right
                    Button(onClick = { viewModel.resetOrderAndWriteToFile(context) }) {
                        Text("Place Order")
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            uiState.burritos.forEach { burrito ->
                DetailedBurritoListItem(burrito)
            }
        }
    }
}

@Composable
fun DetailedBurritoListItem(burrito: BurritoClass) {
    var expanded by remember { mutableStateOf(false) }

    ListItem(
        headlineText = { Text(text = burrito.title) },
        supportingText = {
            Column {
                Text(text = stringResource(id = burrito.mainFilling))
                if (expanded) {
                    var additionalFillingsString = ""
                    burrito.additionalFillings.forEach { filling ->
                        additionalFillingsString += if (additionalFillingsString.isEmpty()) stringResource(filling) else ", ${stringResource(filling)}"
                    }

                    var saucesString = ""
                    burrito.sauces.forEach { sauce ->
                        saucesString += if (saucesString.isEmpty()) stringResource(sauce) else ", ${stringResource(sauce)}"
                    }

                    var saladsString = ""
                    burrito.salads.forEach { salad ->
                        saladsString += if (saladsString.isEmpty()) stringResource(salad) else ", ${stringResource(salad)}"
                    }

                    if (additionalFillingsString.isNotEmpty()) {
                        Text(text = "Additional Fillings: $additionalFillingsString")
                    }
                    if (saucesString.isNotEmpty()) {
                        Text(text = "Sauces: $saucesString")
                    }
                    if (saladsString.isNotEmpty()) {
                        Text(text = "Salads: $saladsString")
                    }
                }
            }
        },
        trailingContent = { FormattedPriceLabel(burrito.price) },
        modifier = Modifier.clickable { expanded = !expanded }
    )
}

@Composable
fun PreviousOrder(
    viewModel: BurritoViewModel
){
    val previousOrderState by viewModel.previousOrderState
    val faveBurrito = viewModel.faveBurrito

    // Log favorite burrito if not null
    if (faveBurrito != null) {
        Log.d("FavouriteDetails", "Displaying ${faveBurrito.title} burrito")
    }

    Scaffold(
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            // Display burritos from the previous order
            previousOrderState.burritos.forEach { burrito ->
                DetailedBurritoListItem(burrito)
            }
        }
    }
}

@Composable
fun FavouriteDetails(
    viewModel: BurritoViewModel
){
//    val viewModel: BurritoViewModel = viewModel()
    val faveBurrito = viewModel.faveBurrito
    if (faveBurrito != null) {
        Log.d("FavouriteDetails", "Displaying ${faveBurrito.title} burritos")
    }
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
            BottomAppBar { // This is your bottom bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(Modifier.weight(1f)) // This spacer pushes the button to the right
                    Button(onClick = { viewModel.addFavoriteToOrder()
                        Toast.makeText(
                            context,
                            "'${viewModel.faveBurrito?.title}' added to order",
                            Toast.LENGTH_SHORT //can also specify Toast.LENGTH_LONG
                        ).show()}) {
                        Text("Add to order")
                    }
                }
            }
        }
    ) { innerPadding ->
        Column {
            if (faveBurrito != null) {
                Text(faveBurrito.title)
            }
        }
    }
}