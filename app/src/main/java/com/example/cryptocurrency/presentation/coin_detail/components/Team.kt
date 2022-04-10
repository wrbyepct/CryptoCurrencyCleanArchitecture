package com.example.cryptocurrency.presentation.coin_detail.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cryptocurrency.data.remote.dto.TeamMember

@Composable
fun Team(
    team: List<TeamMember>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(team) { teamMember ->
            TeamMember(
                teamMember = teamMember.name,
                position = teamMember.position,
            )
        }
    }
}