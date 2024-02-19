@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.R
import com.example.mad_assignment02.ui.component.BottomNavBar

class HomeScreen {
}
@Composable
fun Home_Screen(){
    Scaffold(

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            LazyColumnExample()
        }
    }
}


@Composable
fun LazyColumnExample() {
    val stringIds = listOf(
        R.string.HomeScreenSectionTitle1,
        R.string.HomeScreenSection1,
        R.string.HomeScreenSection2,
        R.string.HomeScreenSection3,
        R.string.HomeScreenSectionTitle2,
        R.string.HomeScreenSubSectionTitle1,
        R.string.HomeScreenSection4,
        R.string.HomeScreenSection5,
        R.string.HomeScreenSubSectionTitle2,
        R.string.HomeScreenSection6,
        R.string.HomeScreenSection7
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Image(painter = painterResource(id = R.drawable.sangria_senorial_ah2fCJP9Eok_unsplash), contentDescription = "Sangria Image")
        }
        items(stringIds) { stringId ->
            Text(text = stringResource(id = stringId))
        }
    }
}