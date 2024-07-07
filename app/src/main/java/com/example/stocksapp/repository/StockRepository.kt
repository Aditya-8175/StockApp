package com.example.stocksapp.repository

import com.example.stocksapp.data.TopGainersLosers
import com.example.stocksapp.dataorexception.DataOrException
import com.example.stocksapp.module.CompanyOverviewResponse
import com.example.stocksapp.module.StockResponse
import com.example.stocksapp.module.TopGainersResponse
import com.example.stocksapp.module.TopLosersResponse
import com.example.stocksapp.network.StockApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StocksRepository @Inject constructor(private val api: StockApi) {
//    suspend fun getTopGainers(apiKey: String): TopGainersResponse {
//        return api.getTopGainers(apiKey = apiKey)
//    }
//
//    suspend fun getTopLosers(apiKey: String): TopLosersResponse {
//        return api.getTopLosers(apiKey = apiKey)
//    }
//
//    suspend fun getCompanyOverview(symbol: String, apiKey: String): CompanyOverviewResponse {
//        return api.getCompanyOverview(symbol = symbol, apiKey = apiKey)
//    }


    suspend fun getGainer(): DataOrException<TopGainersResponse, Boolean, Exception> {
        val  response = try {
            api.getTopGainers( )
        } catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }

    suspend fun getLoser(): DataOrException<TopLosersResponse, Boolean, Exception> {
        val  response = try {
            api.getTopLosers( )
        } catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }

    suspend fun getCompany(symbol: String): DataOrException<CompanyOverviewResponse, Boolean, Exception> {
        val  response = try {
            api.getCompanyOverview(symbol = symbol )
        } catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }


    suspend fun getTopGainersLosers() :DataOrException<TopGainersLosers,Boolean,Exception> {
        val  response = try {
            api.getTopGainersLosers()
        } catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)

    }


}
