package com.fauzimaulana.fauzimovieapp.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fauzimaulana.fauzimovieapp.core.ui.R
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultToolbar(
    modifier: Modifier = Modifier,
    title: String,
    containerColor: Color =  MaterialTheme.colorScheme.primary,
    onBackPressed: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        navigationIcon = {
            if (onBackPressed != null) {
                DefaultIconButton(
                    icon = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    onClick = onBackPressed
                )
            }
        },
        title = {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        actions = {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    content = actions
                )
            }
        },
        windowInsets = WindowInsets(top = 0.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor
        )
    )
}

@Preview
@Composable
private fun DefaultToolbarPreview() {
    FauziMovieAppTheme {
        DefaultToolbar(
            title = "Fauzi Movie App",
            onBackPressed = {},
            actions = {
                DefaultIconButton(
                    icon = Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    onClick = {}
                )
            }
        )
    }
}