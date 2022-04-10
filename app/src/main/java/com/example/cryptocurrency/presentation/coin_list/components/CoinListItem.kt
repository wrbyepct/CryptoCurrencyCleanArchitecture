package com.example.cryptocurrency.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cryptocurrency.domain.model.Coin
import com.example.cryptocurrency.presentation.Screen
import com.example.cryptocurrency.ui.theme.SuckingPink

@Composable
fun CoinListItem(
    coin: Coin,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Coin Name
        Text(
            text ="${coin.rank}.${coin.name}(${coin.symbol})",
            style = MaterialTheme.typography.body1,
            // If the text too long, cut it with '...'
            overflow = TextOverflow.Ellipsis
        )

        // Is active or not
        Text(
            text = if (coin.isActive)"active" else "inactive",
            // smaller font size
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic,
            color = if (coin.isActive) SuckingPink else Color.Red
        )
    }
}