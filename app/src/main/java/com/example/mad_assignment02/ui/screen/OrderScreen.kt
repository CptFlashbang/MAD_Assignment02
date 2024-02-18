@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mad_assignment02.data.BurritoClass
import com.example.mad_assignment02.ui.BurritoViewModel
import com.example.mad_assignment02.ui.component.BottomNavBar

class OrderScreen {
}

@Preview
@Composable
fun Order_Screen_Preview() {
    OrderDetails()
}
@Composable
fun Order_Screen() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { TopTabs(selectedTabIndex, onSelectTab = { index -> selectedTabIndex = index }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
//            when (selectedTabIndex) {
//                0 -> OrderDetails()
//                1 -> Text("Content of Tab 2")
//                2 -> Text("Content of Tab 3")
//            }
            OrderDetails()
        }
    }
}

@Composable
fun TopTabs(selectedTabIndex: Int, onSelectTab: (Int) -> Unit) {
    TabRow(selectedTabIndex) {
        Tab(
            selected = selectedTabIndex == 0,
            onClick = { onSelectTab(0) },
            text = { Text("Tab 1") }
        )
        Tab(
            selected = selectedTabIndex == 1,
            onClick = { onSelectTab(1) },
            text = { Text("Tab 2") }
        )
        Tab(
            selected = selectedTabIndex == 2,
            onClick = { onSelectTab(2) },
            text = { Text("Tab 3") }
        )
    }
}

@Composable
fun OrderDetails(){
    val viewModel: BurritoViewModel = viewModel()
    val uiState = viewModel.uiState.value
    Log.d("OrderDetails", "Displaying ${uiState.burritos.size} burritos")
    Column {
        uiState.burritos.forEach { burrito ->
            Text(stringResource(burrito.title)) // Burrito Name
        }
    }
//    Column {
//        Text("Burrito Name")
//        Text("Main Filling:")
//        Text("Grilled chicken marinated in a zesty mango-chipotle glaze.")
//        Divider()
//        Text("Additional Fillings: ")
//        Text("Mango salsa, avocado slices, cilantro-lime rice, and a drizzle of spicy mango-habanero sauce.")
//        Divider()
//        Text("Sauces:")
//        Text("Mango salsa, avocado slices, cilantro-lime rice, and a drizzle of spicy mango-habanero sauce.")
//        Divider()
//        Text("Salads:")
//        Text("Mango salsa, avocado slices, cilantro-lime rice, and a drizzle of spicy mango-habanero sauce.")
//        Divider()
//        Text("£8.99")
//    }

}