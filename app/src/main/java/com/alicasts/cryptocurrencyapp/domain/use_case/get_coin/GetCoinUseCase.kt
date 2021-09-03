package com.alicasts.cryptocurrencyapp.domain.use_case.get_coin

import com.alicasts.cryptocurrencyapp.common.Resource
import com.alicasts.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.alicasts.cryptocurrencyapp.domain.model.CoinDetail
import com.alicasts.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e : IOException) {
            emit(Resource.Error<CoinDetail>("A connection error occurred"))
        }
    }
}