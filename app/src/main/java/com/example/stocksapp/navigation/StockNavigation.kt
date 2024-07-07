package com.example.stocksapp.navigation

enum class StockNavigation {
    MainScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): StockNavigation
           = when(route?.substringBefore("/")) {
            MainScreen.name -> MainScreen
            DetailScreen.name -> DetailScreen
            null -> MainScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}