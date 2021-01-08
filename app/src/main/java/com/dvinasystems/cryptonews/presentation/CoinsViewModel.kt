package com.dvinasystems.cryptonews.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dvinasystems.cryptonews.api.CoinApi
import com.dvinasystems.cryptonews.data.CoinData
import com.dvinasystems.cryptonews.utils.RequestState
import kotlinx.coroutines.launch

class CoinsViewModel
@ViewModelInject
constructor(
    private val service: CoinApi
) : ViewModel() {
    private val _coins: MutableLiveData<RequestState<List<CoinData>>> = MutableLiveData()
    val coins: LiveData<RequestState<List<CoinData>>> get() = _coins

    init {
        request()
    }

    fun request() {
        _coins.value = RequestState.Loading()

        viewModelScope.launch {
            val result = service.getCoinsList("usd")
            _coins.value = RequestState.Success(result)
        }
    }

}