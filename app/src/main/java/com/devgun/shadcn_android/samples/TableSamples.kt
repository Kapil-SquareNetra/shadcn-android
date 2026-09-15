package com.devgun.shadcn_android.samples

import androidx.compose.runtime.Composable
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Table
import com.devgun.shadcn_android.ui.components.TableCell
import com.devgun.shadcn_android.ui.components.TableHead
import com.devgun.shadcn_android.ui.components.TableHeader
import com.devgun.shadcn_android.ui.components.TableRow

@Composable
fun TableSamples(onBack: () -> Unit) {
    SampleScaffold(title = "Table", onBack = onBack) {
        SampleSection(title = "Invoices") {
            Table {
                TableHeader {
                    TableHead("Invoice")
                    TableHead("Status")
                    TableHead("Amount")
                }
                TableRow {
                    TableCell("INV-001")
                    TableCell("Paid")
                    TableCell("$250.00")
                }
                TableRow {
                    TableCell("INV-002")
                    TableCell("Pending")
                    TableCell("$150.00")
                }
                TableRow {
                    TableCell("INV-003")
                    TableCell("Unpaid")
                    TableCell("$350.00")
                }
            }
        }
    }
}
