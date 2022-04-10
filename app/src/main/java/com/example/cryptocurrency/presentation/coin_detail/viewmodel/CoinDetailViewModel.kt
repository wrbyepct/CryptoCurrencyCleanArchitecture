package com.example.cryptocurrency.presentation.coin_detail.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.core.Constants
import com.example.cryptocurrency.core.Response
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.domain.model.CoinDetail
import com.example.cryptocurrency.domain.usecases.get_coin.GetCoin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoin: GetCoin,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getNoteBytId(it)
        }
    }

    private fun getNoteBytId(coinId: String) {

        getCoin(coinId).onEach { response ->
            when(response) {
                is Response.Loading -> {
                    _state.value = CoinDetailState(
                        isLoading = true
                    )
                }
                is Response.Success -> {
                    _state.value = CoinDetailState(
                        coinDetail = response.data
                    )
                }
                is Response.Error -> {
                    _state.value = CoinDetailState(
                        errorMessage = response.message ?: Constants.UNKNOWN_ERROR_FROM_COINDETAIL_VIEWMODEL
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}