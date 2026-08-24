package com.fauzimaulana.fauzimovieapp.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme

@Composable
fun DefaultIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String,
    containerColor: Color = Color.Transparent,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultIconButtonPreview() {
    FauziMovieAppTheme {
        DefaultIconButton(
            icon = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = "Back",
            contentColor = MaterialTheme.colorScheme.primary,
            onClick = {}
        )
    }
}