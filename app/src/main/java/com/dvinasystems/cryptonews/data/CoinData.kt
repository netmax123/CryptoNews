package com.dvinasystems.cryptonews.data

import com.google.gson.annotations.SerializedName

data class CoinData(

    val id: String? = null,
    val symbol: String? = null,
    val name: String? = null,
    val image: String? = null,
    @SerializedName("current_price")
    val currentPrice: Float

)
