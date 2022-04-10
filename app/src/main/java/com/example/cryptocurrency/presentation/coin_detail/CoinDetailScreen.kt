package com.example.cryptocurrency.presentation.coin_detail


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptocurrency.presentation.coin_detail.components.DescriptionSection
import com.example.cryptocurrency.presentation.coin_detail.components.TagsSection
import com.example.cryptocurrency.presentation.coin_detail.components.Team

import com.example.cryptocurrency.presentation.coin_detail.viewmodel.CoinDetailViewModel
import com.example.cryptocurrency.ui.theme.SuckingPink


/**
 *
 */

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        // Show progress bar
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center),
                color = Color.Green
            )
        }
        // Show error message
        if (state.errorMessage.isNotBlank()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = state.errorMessage,
                style = MaterialTheme.typography.h4,
                color = Color.LightGray
            )
        }
        // Show coin information
        state.coinDetail?.let { coin ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                /**
                 *  Coin name and active indicator
                 */
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Coin name
                    Text(
                        text = "${coin.rank}. ${coin.name}(${coin.symbol})",
                        style = MaterialTheme.typography.h1,
                    )
                    // Active indicator
                    Text(
                        text = if (coin.isActive) "active" else "inactive",
                        color = if (coin.isActive) SuckingPink else Color.Red,
                        fontStyle = FontStyle.Italic,
                        style = MaterialTheme.typography.body2
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                /**
                 *  Description
                 */
                DescriptionSection(description = coin.description)

                Spacer(modifier = Modifier.height(16.dp))

                /**
                 * Tag title
                 */

                Text(
                    text = "Tags",
                    style = MaterialTheme.typography.h2,
                )

                Spacer(modifier = Modifier.height(16.dp))

                /**
                 * Tags section
                 */

                TagsSection(
                    tags = coin.tags
                )

                Spacer(modifier = Modifier.height(16.dp))

                /**
                 * Team members title
                 */

                Text(
                    text = "Team members",
                    style = MaterialTheme.typography.h2,
                )

                Spacer(modifier = Modifier.height(16.dp))

                /**
                 * Team section
                 */
                Team(team = coin.team)

            }
        }
    }
}