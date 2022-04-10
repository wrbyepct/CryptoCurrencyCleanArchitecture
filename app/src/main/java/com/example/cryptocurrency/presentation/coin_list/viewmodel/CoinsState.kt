package com.example.cryptocurrency.presentation.coin_list.viewmodel

import com.example.cryptocurrency.domain.model.Coin

/*
   What do we need here?
       1. to show progress bar or not
       2. show the list of the coins from the api
       3. if we don't get the resource from internet,
             just show the error message
 */

data class CoinsState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val errorMessage: String = ""
)
