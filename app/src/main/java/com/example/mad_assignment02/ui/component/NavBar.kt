package com.example.mad_assignment02.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.mad_assignment02.BurritoScreen
import com.example.mad_assignment02.R

class NavBar {
}
@Composable
fun BottomNavBar(navController: NavHostController){
    var selectedItem by remember { mutableStateOf(0) }
    val items: List<Pair<String, Painter>> = listOf(
        "Home" to painterResource(id = R.drawable.home_fill0_wght400_grad0_opsz24),
        "Ready-made" to painterResource(id = R.drawable.fastfood_fill0_wght400_grad0_opsz24),
        "Custom" to painterResource(id = R.drawable.build_fill0_wght400_grad0_opsz24),
        "Orders" to painterResource(id = R.drawable.assignment_fill0_wght400_grad0_opsz24),
    )

    androidx.compose.material3.NavigationBar {
        items.forEachIndexed { index, (label, painter) ->
            NavigationBarItem(
                icon = { Icon(painter, contentDescription = label) },
                label = { Text(label) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )

        }
    }
}