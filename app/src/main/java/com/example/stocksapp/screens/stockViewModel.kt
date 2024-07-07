package com.example.stocksapp.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stocksapp.data.TopGainersLosers
import com.example.stocksapp.dataorexception.DataOrException
import com.example.stocksapp.module.CompanyOverviewResponse
import com.example.stocksapp.module.StockResponse
import com.example.stocksapp.module.TopGainersResponse
import com.example.stocksapp.module.TopLosersResponse
import com.example.stocksapp.repository.StocksRepository
import com.example.stocksapp.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class StocksViewModel @Inject constructor(private val repository: StocksRepository) : ViewModel() {
//    private val _topGainers = MutableLiveData<TopGainersResponse>()
//    val topGainers: LiveData<TopGainersResponse> = _topGainers
//
//    private val _topLosers = MutableLiveData<TopLosersResponse>()
//    val topLosers: LiveData<TopLosersResponse> = _topLosers
//
//    private val _companyOverview = MutableLiveData<CompanyOverviewResponse>()
//    val companyOverview: LiveData<CompanyOverviewResponse> = _companyOverview
//
//    fun fetchTopGainers(apiKey: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val response = repository.getTopGainers(apiKey)
//                _topGainers.postValue(response)
//            } catch (e: Exception) {
//                // Handle the error
//            }
//        }
//    }
//
//    fun fetchTopLosers(apiKey: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val response = repository.getTopLosers(apiKey)
//                _topLosers.postValue(response)
//            } catch (e: Exception) {
//                // Handle the error
//            }
//        }
//    }
//
//    fun fetchCompanyOverview(symbol: String, apiKey: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val response = repository.getCompanyOverview(symbol, apiKey)
//                _companyOverview.postValue(response)
//            } catch (e: Exception) {
//                // Handle the error
//            }
//        }
//    }
//}


@HiltViewModel
class StockViewModel @Inject constructor(private val repository: StocksRepository) : ViewModel() {

    // Everything type news
    suspend fun getTopGainers(): DataOrException<TopGainersResponse, Boolean, Exception> {
        return repository.getGainer()
    }

    suspend fun getTopLosers(): DataOrException<TopLosersResponse, Boolean, Exception> {
        return repository.getLoser()
    }

    suspend fun getCompany(symbol: String): DataOrException<CompanyOverviewResponse, Boolean, Exception> {
        return repository.getCompany(symbol)
    }


    suspend fun getTopGainersLosers(): DataOrException<TopGainersLosers, Boolean, Exception> {
        return repository.getTopGainersLosers()
    }


    // Function to run both operations in parallel

//    suspend fun getNewsAndHeadlines(specificNews: String, category: String): Pair<DataOrException<TopNews, Boolean, Exception>, DataOrException<TopNews, Boolean, Exception>> {
//        return coroutineScope {
//            val newsDataDeferred = async { getNewsData(specificNews) }
//            val topHeadlinesDeferred = async { getTopHeadlines(
////                country,
//                category) }
//
//            val newsData = newsDataDeferred.await()
//            val topHeadlines = topHeadlinesDeferred.await()
//
//            Pair(newsData, topHeadlines)
//        }
//    }

//    val data: MutableState<DataOrException<TopNews,
//            Boolean, Exception>> = mutableStateOf(
//        DataOrException(null, true, Exception("")) )

//    init {
//        loadNews()
//    }
//
//    private fun loadNews() {
//        getAllNews("apple")
//    }
//
//    private fun getAllNews(specificNews: String) {
//        viewModelScope.launch {
//            if (specificNews.isNotEmpty()) return@launch
//            data.value.loading = true
//            data.value = repository.getAllNews(specificQuery = specificNews)
//           if (data.value.data.toString().isNotEmpty()) data.value.loading = false
//        }
//        Log.d("GET", "getAllNews: ${data.value.data.toString()}")
//
//    }
//    fun getTotalQuestionCount(): Int {
//        return data.value.data?.toMutableList()?.size!!
//    }

}

