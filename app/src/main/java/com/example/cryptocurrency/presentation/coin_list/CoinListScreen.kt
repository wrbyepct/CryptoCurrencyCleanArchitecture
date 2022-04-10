package com.example.cryptocurrency.presentation.coin_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.cryptocurrency.presentation.Screen
import com.example.cryptocurrency.presentation.coin_list.components.CoinListItem
import com.example.cryptocurrency.presentation.coin_list.viewmodel.CoinsListViewModel
import com.example.cryptocurrency.ui.theme.SuckingPink

/**
 *  Define children composable clearly,
 *      and parent composable just call children and just pass what they need
 */

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel:CoinsListViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.state.value

    Scaffold(scaffoldState = scaffoldState) {
        // Progress bar or error message
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center),
                        color = SuckingPink
                    )
                }
                if (state.errorMessage.isNotBlank()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = state.errorMessage,
                        style = MaterialTheme.typography.h4,
                        color = Color.LightGray
                    )
                }
                if (state.coins.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp)
                    ) {
                        items(state.coins) { coin ->
                            CoinListItem(
                                coin = coin,
                                onClick = {
                                    navController.navigate(
                                        route = Screen.CoinDetailScreen.route +
                                                coin.id
                                    )
                                }
                            )

                        }
                    }
                }
        }

    }

}