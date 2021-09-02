package com.dvinasystems.cryptonews.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dvinasystems.cryptonews.R
import com.dvinasystems.cryptonews.data.Coin
import com.dvinasystems.cryptonews.databinding.ItemCurrencyBinding

class CoinAdapter(
    private var coinData: List<Coin>,
    private val context: Context,
    private val onCoinClick: (coin: Coin) -> Unit,
) : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    override fun getItemCount(): Int {
        return coinData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = ItemCurrencyBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.setCoinData(coinData[position])
    }

    inner class CoinViewHolder internal constructor(private val viewBinding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun setCoinData(coin: Coin) {
            viewBinding.currencyName.text = coin.name
            viewBinding.currencyValue.text = context.getString(R.string.usd_price, coin.currentPrice.toString())
            viewBinding.root.setOnClickListener { onCoinClick(coin) }
        }

    }

}