package com.dvinasystems.cryptonews.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coin(

    val id: String? = null,
    val symbol: String? = null,
    val name: String? = null,
    val image: String? = null,
    @SerializedName("current_price")
    val currentPrice: Float

):Parcelable
