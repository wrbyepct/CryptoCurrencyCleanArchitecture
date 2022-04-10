package com.example.cryptocurrency.data.repository

import android.util.Log
import com.example.cryptocurrency.core.Constants
import com.example.cryptocurrency.core.Response
import com.example.cryptocurrency.data.remote.CoinPaprikaApi
import com.example.cryptocurrency.data.remote.dto.CoinDto
import com.example.cryptocurrency.data.remote.dto.DetailedCoinDto
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override fun getCoins(): Flow<Response<List<Coin>>> = flow {
        emit(Response.Loading())
        try {
            val coinList = api.getCoins().map { it.toCoin() }
            emit(Response.Success(coinList))
        } catch (e: HttpException) {
            // Server side error
            emit(Response.Error(e.localizedMessage ?: "Unknown error from HttpException"))
        } catch (e: IOException) {
            // Client side error
            emit(Response.Error(Constants.NO_INTERNET_CONNECTION))
        }
    }
    override fun getCoinById(coinId: String): Flow<Response<CoinDetail>> = flow {
        emit(Response.Loading())
        try {
            val detailedCoin = api.getCoinById(coinId).toCoinDetail()
            emit(Response.Success(detailedCoin))

        } catch (e: HttpException) {

            emit(Response.Error(e.localizedMessage ?: "Unknown error from HttpException"))
        } catch (e: IOException) {
            emit(Response.Error(Constants.NO_INTERNET_CONNECTION))
        }
    }
}