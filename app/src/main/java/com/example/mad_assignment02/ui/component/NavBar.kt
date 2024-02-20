package com.example.mad_assignment02.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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

    NavigationBar {
        items.forEachIndexed { index, (label, painter) ->
            NavigationBarItem(
                icon = { Icon(painter, contentDescription = label) },
                label = { Text(label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    when (index) {
                        0 -> navController.navigate(BurritoScreen.Home.name)
                        1 -> navController.navigate(BurritoScreen.ReadyMadeMaster.name)
                        2 -> navController.navigate(BurritoScreen.Custom.name)
                        3 -> navController.navigate(BurritoScreen.Order.name)
                    }
                }
            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavRailPreview() {
    // Mock NavController for preview
    val mockNavController = rememberNavController()

    // Simplified items for preview (using ColorPainter instead of actual resources)
    val items: List<Pair<String, Painter>> = listOf(
        "Home" to ColorPainter(Color.Red),
        "Ready-made" to ColorPainter(Color.Green),
        "Custom" to ColorPainter(Color.Blue),
        "Orders" to ColorPainter(Color.Yellow)
    )

    NavRail(navController = mockNavController)
}


@Composable
fun NavRail(navController: NavHostController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items: List<Pair<String, Painter>> = listOf(
        "Home" to painterResource(id = R.drawable.home_fill0_wght400_grad0_opsz24),
        "Ready-made" to painterResource(id = R.drawable.fastfood_fill0_wght400_grad0_opsz24),
        "Custom" to painterResource(id = R.drawable.build_fill0_wght400_grad0_opsz24),
        "Orders" to painterResource(id = R.drawable.assignment_fill0_wght400_grad0_opsz24),
    )

    NavigationRail {
        items.forEachIndexed { index, (label, painter) ->
            NavigationRailItem(
                icon = { Icon(painter, contentDescription = label) },
                label = { Text(label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    when (index) {
                        0 -> navController.navigate(BurritoScreen.Home.name)
                        1 -> navController.navigate(BurritoScreen.ReadyMadeMaster.name)
                        2 -> navController.navigate(BurritoScreen.Custom.name)
                        3 -> navController.navigate(BurritoScreen.Order.name)
                    }
                }
            )
        }
    }
}
