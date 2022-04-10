package com.example.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.cryptocurrency.data.remote.dto.TeamMember

@Composable
fun TeamMember(
    teamMember: String,
    position: String,
) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = teamMember,
                style = MaterialTheme.typography.h3,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = position,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
        }

}