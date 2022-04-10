package com.example.cryptocurrency.presentation.coin_detail.viewmodel

import com.example.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val coinDetail: CoinDetail? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
