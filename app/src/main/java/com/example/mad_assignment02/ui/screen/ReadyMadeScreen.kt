@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable

class ReadyMadeScreen {
    @Composable
    fun ReadyMadeList() {
        val readyMadeBurritos = Datasource().loadReadyMade()

        LazyColumn {
            items(readyMadeBurritos.size) { index ->
                Ready_Made_List_Item(readyMadeBurritos[index])
                Divider()
            }
        }
    }
}