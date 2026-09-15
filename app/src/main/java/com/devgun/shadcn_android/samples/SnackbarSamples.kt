package com.devgun.shadcn_android.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Button
import com.devgun.shadcn_android.ui.components.ButtonVariant
import com.devgun.shadcn_android.ui.components.SnackbarHost
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SnackbarSamples(onBack: () -> Unit) {
    val hostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        SampleScaffold(title = "Snackbar", onBack = onBack) {
            SampleSection(title = "Message") {
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = {
                        scope.launch {
                            hostState.showSnackbar("Event created")
                        }
                    }) { Text("Show") }
                    Button(
                        onClick = {
                            scope.launch {
                                hostState.showSnackbar(
                                    message = "File deleted",
                                    actionLabel = "Undo",
                                )
                            }
                        },
                        variant = ButtonVariant.Outline,
                    ) { Text("With action") }
                }
            }
        }
        SnackbarHost(
            hostState = hostState,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}
