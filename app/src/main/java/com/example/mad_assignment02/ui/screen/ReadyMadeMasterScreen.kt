@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.data.Burrito
import com.example.mad_assignment02.data.DataSource
import com.example.mad_assignment02.ui.component.BottomNavBar
import com.example.mad_assignment02.ui.component.FormattedPriceLabel

class ReadyMadeMasterScreen {

}

@Composable
fun Ready_Made_List_Item(burrito: Burrito) {
    androidx.compose.material3.ListItem(
        headlineText = {
            Text(text = stringResource(burrito.title))
        },
        supportingText = {
            Text(text = stringResource(burrito.mainFilling))
        },
        trailingContent = { FormattedPriceLabel(burrito.price) }
    )
}
@Composable
fun ReadyMadeList() {
    val readyMadeBurritos = DataSource.loadReadyMade()

    LazyColumn {
        items(readyMadeBurritos.size) { index ->
            Ready_Made_List_Item(readyMadeBurritos[index])
            Divider()
        }
    }
}
@Composable
fun Ready_Made_Master_Screen(){
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            ReadyMadeList()
        }
    }
}