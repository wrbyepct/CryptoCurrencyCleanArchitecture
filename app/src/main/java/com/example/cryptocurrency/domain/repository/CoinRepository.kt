package com.example.cryptocurrency.domain.repository

import com.example.cryptocurrency.core.Response
import com.example.cryptocurrency.data.remote.dto.CoinDto
import com.example.cryptocurrency.data.remote.dto.DetailedCoinDto
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow


interface CoinRepository {

    fun getCoins(): Flow<Response<List<Coin>>>

    fun getCoinById(coinId: String): Flow<Response<CoinDetail>>
}