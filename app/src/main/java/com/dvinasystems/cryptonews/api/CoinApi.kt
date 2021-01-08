package com.dvinasystems.cryptonews.api

import com.dvinasystems.cryptonews.data.CoinData
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApi {

    @GET("coins/markets")
    suspend fun getCoinsList(
        @Query("vs_currency") vsCurrency: String
    ): List<CoinData>

}