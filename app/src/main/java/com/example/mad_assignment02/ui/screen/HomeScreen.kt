@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mad_assignment02.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_assignment02.R
import com.example.mad_assignment02.ui.component.BottomNavBar
@Composable
fun Home_Screen() {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.burrito_hero),
                contentDescription = "Sangria Image",
                modifier = Modifier.clip(RoundedCornerShape(28.dp))
            )
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp))  {
                Text(text = stringResource(id = R.string.HomeScreenSectionTitle1), style = MaterialTheme.typography.headlineMedium)
                Text(text = stringResource(id = R.string.HomeScreenSection1), style = MaterialTheme.typography.bodyMedium)
                Text(text = stringResource(id = R.string.HomeScreenSection2), style = MaterialTheme.typography.bodyMedium)
                Text(text = stringResource(id = R.string.HomeScreenSection3), style = MaterialTheme.typography.bodyMedium)
            }
        }
        item {
            Divider()
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp))  {
                Text(text = stringResource(id = R.string.HomeScreenSectionTitle2), style = MaterialTheme.typography.headlineSmall)
                Text(text = stringResource(id = R.string.HomeScreenSubSectionTitle1), style = MaterialTheme.typography.titleLarge)
                Text(text = stringResource(id = R.string.HomeScreenSection4), style = MaterialTheme.typography.bodyMedium)
                Text(text = stringResource(id = R.string.HomeScreenSection5), style = MaterialTheme.typography.bodyMedium)
            }
        }
        item {
            Divider()
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(text = stringResource(id = R.string.HomeScreenSubSectionTitle2), style = MaterialTheme.typography.titleLarge)
                Text(text = stringResource(id = R.string.HomeScreenSection6), style = MaterialTheme.typography.bodyMedium)
                Text(text = stringResource(id = R.string.HomeScreenSection7), style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}