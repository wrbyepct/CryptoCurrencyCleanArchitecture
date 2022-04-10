package com.example.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptocurrency.ui.theme.SuckingPink


@Composable
fun Tag(
    tag: String,
    cornerRadius: Dp = 30.dp
) {

    // Outline Border first
    // Then do the padding
    Text(
        text = tag,
        color = SuckingPink,
        style = MaterialTheme.typography.body2,
        modifier = Modifier
            .border(
                width = 2.dp,
                color = SuckingPink,
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(12.dp)
        ,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
