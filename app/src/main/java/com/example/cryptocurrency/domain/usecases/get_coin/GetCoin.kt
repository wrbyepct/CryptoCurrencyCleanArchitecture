package com.example.cryptocurrency.domain.usecases.get_coin


import com.example.cryptocurrency.core.Response

import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCoin @Inject constructor (
    private val repo: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Response<CoinDetail>> {
        return repo.getCoinById(coinId)
    }
}