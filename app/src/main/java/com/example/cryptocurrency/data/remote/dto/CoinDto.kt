package com.example.cryptocurrency.data.remote.dto

import com.example.cryptocurrency.domain.model.Coin

// Dto to receive json data
data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
) {
    fun toCoin(): Coin {
        return Coin(
            id = id,
            isActive = is_active,
            name = name,
            rank = rank,
            symbol = symbol
        )
    }
}