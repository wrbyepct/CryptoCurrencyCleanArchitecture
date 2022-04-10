package com.example.cryptocurrency.domain.usecases.get_coins




import com.example.cryptocurrency.core.Response
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCoins @Inject constructor (
    private val repo: CoinRepository
) {
    operator fun invoke(): Flow<Response<List<Coin>>> {
        return repo.getCoins()
    }
}