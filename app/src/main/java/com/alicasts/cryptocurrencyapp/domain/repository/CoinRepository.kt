package com.alicasts.cryptocurrencyapp.domain.repository

import com.alicasts.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.alicasts.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}