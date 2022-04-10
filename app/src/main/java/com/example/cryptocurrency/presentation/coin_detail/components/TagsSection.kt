package com.example.cryptocurrency.presentation.coin_detail.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun TagsSection(
    tags: List<String> = emptyList(),
) {
    /**
     * FlowRow can automatically wrap items to next line
     */
    FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisAlignment = MainAxisAlignment.Start,
            mainAxisSize = SizeMode.Expand,
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 16.dp
        ) {
            tags.forEach { tag ->
                Tag(tag = tag)
            }
        }
}