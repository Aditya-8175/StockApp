package com.example.stocksapp.module

data class AssetInfo(
    val iconDrawable: Int,
    val name: String,
    val tickerName: String,
    val lastDayChange: List<Float>,
    val currentValue: Float,
    val total: Float,
)

