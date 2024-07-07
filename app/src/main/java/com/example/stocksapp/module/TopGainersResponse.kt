package com.example.stocksapp.module

data class TopGainersResponse(
    val bestMatches: List<Stock>
)

data class TopLosersResponse(
    val bestMatches: List<Stock>
)

data class StockResponse(
    val bestMatches: List<Stock>
)

data class Stock(
    val symbol: String,
    val name: String,
    val price: String,
    val change: String,
    val changePercent: String,
    val logoUrl: String? = null
)



data class CompanyOverviewResponse(
    val Symbol: String,
    val AssetType: String,
    val Name: String,
    val Description: String,
    val CIK: String,
    val Exchange: String,
    val Currency: String,
    val Country: String,
    val Sector: String,
    val Industry: String,
    val Address: String,
    val FiscalYearEnd: String,
    val LatestQuarter: String,
    val MarketCapitalization: String,
    val EBITDA: String,
    val PERatio: String,
    val PEGRatio: String,
    val BookValue: String,
    val DividendPerShare: String,
    val DividendYield: String,
    val EPS: String,
    val RevenuePerShareTTM: String,
    val ProfitMargin: String,
    val OperatingMarginTTM: String,
    val ReturnOnAssetsTTM: String,
    val ReturnOnEquityTTM: String,
    val RevenueTTM: String,
    val GrossProfitTTM: String,
    val DilutedEPSTTM: String,
    val QuarterlyEarningsGrowthYOY: String,
    val QuarterlyRevenueGrowthYOY: String,
    val AnalystTargetPrice: String,
    val TrailingPE: String,
    val ForwardPE: String,
    val PriceToSalesRatioTTM: String,
    val PriceToBookRatio: String,
    val EVToRevenue: String,
    val EVToEBITDA: String,
    val Beta: String,
    val WeekHigh52: String,
    val WeekLow52: String,
    val MovingAverage50Day: String,
    val MovingAverage200Day: String,
    val SharesOutstanding: String,
    val DividendDate: String,
    val ExDividendDate: String
)

