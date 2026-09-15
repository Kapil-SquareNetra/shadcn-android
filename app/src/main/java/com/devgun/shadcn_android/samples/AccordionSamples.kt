package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Accordion
import com.devgun.shadcn_android.ui.components.AccordionContent
import com.devgun.shadcn_android.ui.components.AccordionItem
import com.devgun.shadcn_android.ui.components.AccordionTrigger
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun AccordionSamples(onBack: () -> Unit) {
    var single by rememberSaveable { mutableStateOf(listOf("item-1")) }
    var multiple by rememberSaveable { mutableStateOf(listOf("notify", "billing")) }
    var disabledDemo by rememberSaveable { mutableStateOf(listOf<String>()) }

    SampleScaffold(title = "Accordion", onBack = onBack) {
        SampleSection(title = "Single") {
            Accordion(
                expandedValues = single.toSet(),
                onExpandedChange = { single = it.toList() },
            ) {
                AccordionItem(value = "item-1") {
                    AccordionTrigger("What are your shipping options?")
                    AccordionContent {
                        Text(
                            text = "Standard (5–7 days), express (2–3 days), and overnight. Free shipping on international orders.",
                            color = ShadcnTheme.colors.mutedForeground,
                        )
                    }
                }
                AccordionItem(value = "item-2") {
                    AccordionTrigger("How can I contact support?")
                    AccordionContent {
                        Text(
                            text = "Email support@example.com or use in-app chat. We reply within one business day.",
                            color = ShadcnTheme.colors.mutedForeground,
                        )
                    }
                }
                AccordionItem(value = "item-3") {
                    AccordionTrigger("What payment methods do you accept?")
                    AccordionContent {
                        Text(
                            text = "Visa, Mastercard, American Express, and PayPal.",
                            color = ShadcnTheme.colors.mutedForeground,
                        )
                    }
                }
            }
        }

        SampleSection(title = "Multiple") {
            Accordion(
                expandedValues = multiple.toSet(),
                onExpandedChange = { multiple = it.toList() },
                multiple = true,
            ) {
                AccordionItem(value = "notify") {
                    AccordionTrigger("Notification settings")
                    AccordionContent {
                        Text(
                            text = "Email alerts for updates, or push notifications on mobile.",
                            color = ShadcnTheme.colors.mutedForeground,
                        )
                    }
                }
                AccordionItem(value = "billing") {
                    AccordionTrigger("Billing and subscription")
                    AccordionContent {
                        Text(
                            text = "Plans renew at the start of each cycle. Cancel anytime.",
                            color = ShadcnTheme.colors.mutedForeground,
                        )
                    }
                }
            }
        }

        SampleSection(title = "Disabled item") {
            Accordion(
                expandedValues = disabledDemo.toSet(),
                onExpandedChange = { disabledDemo = it.toList() },
            ) {
                AccordionItem(value = "open") {
                    AccordionTrigger("How do I update my email?")
                    AccordionContent {
                        Text(
                            text = "Open account settings and change the address on file.",
                            color = ShadcnTheme.colors.mutedForeground,
                        )
                    }
                }
                AccordionItem(value = "locked", enabled = false) {
                    AccordionTrigger("Enterprise SSO (coming soon)")
                    AccordionContent {
                        Text("This section is unavailable.")
                    }
                }
            }
        }
    }
}
