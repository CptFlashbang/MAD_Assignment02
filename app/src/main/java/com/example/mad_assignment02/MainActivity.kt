@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.mad_assignment02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mad_assignment02.data.DataSource.ReadyMadeBurritos
import com.example.mad_assignment02.ui.BurritoViewModel
import com.example.mad_assignment02.ui.component.BottomNavBar
import com.example.mad_assignment02.ui.screen.Custom_Screen
import com.example.mad_assignment02.ui.screen.Home_Screen
import com.example.mad_assignment02.ui.screen.Order_Screen
import com.example.mad_assignment02.ui.screen.Ready_Made_Detail_Screen
import com.example.mad_assignment02.ui.screen.Ready_Made_Master_Screen
import com.example.mad_assignment02.ui.theme.MAD_Assignment02Theme


enum class BurritoScreen() {
    Home,
    ReadyMadeMaster,
    Custom,
    Order
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAD_Assignment02Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    BurritoApp()
                }
            }
        }
    }
}
@Composable
fun BurritoApp(
    navController: NavHostController = rememberNavController()
) {
    val viewModelTest: BurritoViewModel = viewModel()
    Scaffold(
        bottomBar = {
            BottomAppBar(
            ) {
                BottomNavBar(navController)
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BurritoScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = BurritoScreen.Home.name) {
                Home_Screen()
            }
            composable(route = BurritoScreen.ReadyMadeMaster.name) {
                Ready_Made_Master_Screen(navController)
            }
            composable(
                //userId is placeholder for profileDetails composable
                route = "ReadyMadeBurritos/{id}",

                //arguments accepts list of objects created by navArgument()
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            )
            { navBackStackEntry ->
                Ready_Made_Detail_Screen(
                    //navBackStackEntry used to extract userId from route
                    navBackStackEntry.arguments!!.getInt("id"),
                    navController,
                    viewModelTest,
                    navigateUp = { navController.navigateUp() }
                )
            }

            composable(route = BurritoScreen.Custom.name) {
                Custom_Screen(
                    viewModelTest,
                )
            }
            composable(route = BurritoScreen.Order.name) {
                Order_Screen(
                    viewModelTest
                )
            }
        }
    }
}


