package com.example.stocksapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.stocksapp.screens.DetailScreen
import com.example.stocksapp.screens.MainScreen
import com.example.stocksapp.screens.StockViewModel

//@Composable
//fun NavGraph(startDestination: String = "exploreScreen", viewModel: StockViewModel) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = startDestination) {
//        composable("exploreScreen") {
//            ExploreScreen(viewModel = viewModel, navController = navController)
//        }
//        composable("productScreen/{symbol}") { backStackEntry ->
//            val symbol = backStackEntry.arguments?.getString("symbol") ?: return@composable
//            ProductScreen(viewModel = viewModel, symbol = symbol)
//        }
//    }
//}

@Composable
fun StockScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = StockNavigation.MainScreen.name, builder =

    {

        composable(StockNavigation.MainScreen.name) {
            MainScreen(navController = navController)
        }

        val route = StockNavigation.DetailScreen.name
        composable("$route{symbol}") {
            val name = it.arguments?.getString("symbol")
            DetailScreen(navController = navController, symbol = name?:"IBM" )
        }

//        val route = StockNavigation.DetailScreen.name
//        composable("$route{symbol}",
//            arguments = listOf(navArgument(name = "symbol") {
//                type = NavType.StringType
//            })
//        ) { backStackEntry ->
//            backStackEntry.arguments?.getString("symbol")?.let { symbol ->
//                val viewModel = hiltViewModel<StockViewModel>()
//                DetailScreen(
//                    viewModel = viewModel,
//                    navController = navController,
//                    symbol = symbol
//                )
//
//
//            }
//        }


    }
    )


    }


