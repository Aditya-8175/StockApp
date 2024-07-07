package com.example.stocksapp.network

import com.example.stocksapp.data.TopGainersLosers
import com.example.stocksapp.module.CompanyOverviewResponse
import com.example.stocksapp.module.StockResponse
import com.example.stocksapp.module.TopGainersResponse
import com.example.stocksapp.module.TopLosersResponse
import com.example.stocksapp.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {
        @GET("query")
        suspend fun getTopGainers(
            @Query("function") function: String = "TIME_SERIES_INTRADAY",
            @Query("symbol") symbol: String = "IBM",
            @Query("interval") interval: String = "5min",
            @Query("apikey") apiKey: String = Constant.Api_Key
        ): TopGainersResponse

        @GET("query")
        suspend fun getTopLosers(
            @Query("function") function: String = "TIME_SERIES_INTRADAY",
            @Query("symbol") symbol: String = "IBM",
            @Query("interval") interval: String = "5min",
            @Query("apikey") apiKey: String = Constant.Api_Key
        ): TopLosersResponse

        @GET("query")
        suspend fun getCompanyOverview(
            @Query("function") function: String = "OVERVIEW",
            @Query("symbol") symbol: String ,
            @Query("apikey") apiKey: String = Constant.Api_Key
        ): CompanyOverviewResponse

    @GET("query?function=TOP_GAINERS_LOSERS")
    suspend fun getTopGainersLosers(
        @Query("apikey") apiKey: String = Constant.Api_Key
    ): TopGainersLosers

}