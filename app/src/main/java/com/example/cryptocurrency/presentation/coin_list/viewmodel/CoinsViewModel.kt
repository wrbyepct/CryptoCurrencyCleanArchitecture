package com.example.cryptocurrency.presentation.coin_list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cryptocurrency.core.Constants
import com.example.cryptocurrency.core.Response
import com.example.cryptocurrency.domain.usecases.get_coins.GetCoins
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor(
    private val getCoins: GetCoins
) : ViewModel() {

    /*
       A ViewModel's job is to:
           1. Hold information(for the corresponding screen to display)
           2. Receive events from screen and do the logic (from use cases)
     */
    /**
     *  Information for screen
     */
    private val _state = mutableStateOf(CoinsState())
    val state: State<CoinsState> = _state

    private var coinsJob: Job? = null

    init {
        showCoins()
    }

    private fun showCoins() {
        coinsJob?.cancel()

        coinsJob = getCoins()
            .onEach { response ->
                when (response) {
                    is Response.Loading -> {
                        _state.value = CoinsState(
                            isLoading = true
                        )
                    }
                    is Response.Success -> {
                        _state.value = CoinsState(
                            coins = response.data ?: emptyList()
                        )
                    }
                    is Response.Error -> {
                        _state.value = CoinsState(
                            errorMessage = response.message ?: Constants.UNKNOWN_ERROR_FROM_COINLISTVIEWMODEL
                        )
                    }
                }

            }
            .launchIn(viewModelScope)

    }


}