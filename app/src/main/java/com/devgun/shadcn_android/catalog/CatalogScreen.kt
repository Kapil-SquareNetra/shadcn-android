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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.components.Input
import com.devgun.shadcn_android.ui.components.Separator
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    onNavigateToSample: (CatalogDestination) -> Unit,
) {
    var query by rememberSaveable { mutableStateOf("") }
    val destinations = CatalogDestination.entriesSorted.filter { destination ->
        query.isBlank() ||
            destination.title.contains(query, ignoreCase = true) ||
            destination.route.contains(query, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("shadcn/ui Components") },
                    actions = { ThemeToggleButton() },
                )
                Input(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    placeholder = "Search components",
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null)
                    },
                    trailingIcon = if (query.isNotEmpty()) {
                        {
                            IconButton(onClick = { query = "" }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear search")
                            }
                        }
                    } else {
                        null
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                )
                Separator()
            }
        },
        containerColor = ShadcnTheme.colors.background,
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            if (destinations.isEmpty()) {
                item {
                    Text(
                        text = "No components match \"$query\"",
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        color = ShadcnTheme.colors.mutedForeground,
                    )
                }
            } else {
                items(destinations) { destination ->
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
}
