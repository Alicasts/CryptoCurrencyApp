package com.alicasts.cryptocurrencyapp.presentation.coin_detail

import com.alicasts.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

