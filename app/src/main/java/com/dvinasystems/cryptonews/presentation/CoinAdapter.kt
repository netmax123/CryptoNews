package com.dvinasystems.cryptonews.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dvinasystems.cryptonews.R
import com.dvinasystems.cryptonews.data.CoinData
import com.dvinasystems.cryptonews.databinding.ItemCurrencyBinding

class CoinAdapter(private var itemsCells: List<CoinData>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return itemsCells.size
    }

    class ItemViewHolder(var viewBinding: ItemCurrencyBinding) : RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemCurrencyBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as ItemViewHolder
        itemViewHolder.viewBinding.currencyName.text = itemsCells[position].name
        val currentPrice = itemsCells[position].currentPrice.toString()
        itemViewHolder.viewBinding.currencyValue.text = context.getString(R.string.usd_price, currentPrice)
    }

}