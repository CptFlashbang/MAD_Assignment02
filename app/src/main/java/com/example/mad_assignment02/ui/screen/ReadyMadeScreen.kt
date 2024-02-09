@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mad_assignment02.data.Burrito
import com.example.mad_assignment02.data.DataSource

class ReadyMadeScreen {
    @Composable
    fun Ready_Made_List_Item(burrito: Burrito) {
        androidx.compose.material3.ListItem(
            headlineText = {
                Text(text = stringResource(burrito.title))
            },
            supportingText = {
                Text(text = stringResource(burrito.mainFilling))
            },
            trailingContent = { Text(text = "£${burrito.price}") }
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
}