package com.example.stocksapp.di

import com.example.stocksapp.network.StockApi
import com.example.stocksapp.repository.StocksRepository
import com.example.stocksapp.utils.Constant
import com.google.android.gms.common.internal.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(Constant.Base_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//    }
//
//    @Provides
//    @Singleton
//    fun provideAlphaVantageApi(retrofit: Retrofit): StockApi {
//        return retrofit.create(StockApi::class.java)
//    }
//
//}
//

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): StockApi {
        return Retrofit.Builder()
            .baseUrl(Constant.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StockApi::class.java)

    }

    @Provides
    @Singleton
    fun provideStockApi(api: StockApi) = StocksRepository(api)

}

