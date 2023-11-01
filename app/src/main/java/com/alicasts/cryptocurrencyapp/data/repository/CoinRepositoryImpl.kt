package com.alicasts.cryptocurrencyapp.data.repository

import com.alicasts.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.alicasts.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.alicasts.cryptocurrencyapp.data.remote.dto.CoinDto
import com.alicasts.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}