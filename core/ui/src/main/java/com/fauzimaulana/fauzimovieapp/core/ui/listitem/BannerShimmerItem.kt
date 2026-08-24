package com.fauzimaulana.fauzimovieapp.core.ui.listitem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fauzimaulana.fauzimovieapp.core.ui.components.shimmer

@Composable
fun BannerShimmerItem(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(320.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .shimmer()
    )
}
