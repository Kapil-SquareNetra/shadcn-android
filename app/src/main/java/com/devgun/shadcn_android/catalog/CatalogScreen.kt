package com.devgun.shadcn_android.catalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.components.Separator
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    darkTheme: Boolean,
    onToggleTheme: () -> Unit,
    onNavigateToSample: (CatalogDestination) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("shadcn/ui Components") },
                actions = {
                    IconButton(onClick = onToggleTheme) {
                        Icon(
                            imageVector = if (darkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                            contentDescription = if (darkTheme) "Switch to light mode" else "Switch to dark mode",
                        )
                    }
                },
            )
        },
        containerColor = ShadcnTheme.colors.background,
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            items(CatalogDestination.entriesSorted) { destination ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNavigateToSample(destination) }
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = destination.title,
                        style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
                        color = ShadcnTheme.colors.foreground,
                    )
                    Text(
                        text = destination.route,
                        style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
                        color = ShadcnTheme.colors.mutedForeground,
                    )
                }
                Separator()
            }
        }
    }
}
