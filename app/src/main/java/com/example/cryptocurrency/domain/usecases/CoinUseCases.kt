package com.example.cryptocurrency.domain.usecases

import com.example.cryptocurrency.domain.usecases.get_coin.GetCoin
import com.example.cryptocurrency.domain.usecases.get_coins.GetCoins

data class CoinUseCases(
    val getCoin: GetCoin,
    val getCoins: GetCoins
)