package com.dvinasystems.cryptonews.utils

sealed class RequestState<T> {
    class Loading<T> : RequestState<T>()
    class Success<T>(val body: T) : RequestState<T>()
}