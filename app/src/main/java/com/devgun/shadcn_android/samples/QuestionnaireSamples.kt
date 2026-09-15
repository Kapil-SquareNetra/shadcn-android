package com.devgun.shadcn_android.samples

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.devgun.shadcn_android.catalog.SampleScaffold
import com.devgun.shadcn_android.catalog.SampleSection
import com.devgun.shadcn_android.ui.components.Questionnaire
import com.devgun.shadcn_android.ui.components.QuestionnaireQuestion
import com.devgun.shadcn_android.ui.components.QuestionnaireQuestionType
import com.devgun.shadcn_android.ui.components.SelectOption
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

@Composable
fun QuestionnaireSamples(onBack: () -> Unit) {
    var answers by remember { mutableStateOf(mapOf<String, List<String>>()) }
    var submitted by remember { mutableStateOf(false) }
    val questions = listOf(
        QuestionnaireQuestion(
            id = "name",
            prompt = "Your name",
            type = QuestionnaireQuestionType.Text,
            required = true,
        ),
        QuestionnaireQuestion(
            id = "role",
            prompt = "Primary role",
            type = QuestionnaireQuestionType.Single,
            options = listOf(
                SelectOption("design", "Design"),
                SelectOption("eng", "Engineering"),
                SelectOption("pm", "Product"),
            ),
        ),
        QuestionnaireQuestion(
            id = "tools",
            prompt = "Tools you use",
            type = QuestionnaireQuestionType.Multiple,
            options = listOf(
                SelectOption("compose", "Compose"),
                SelectOption("figma", "Figma"),
                SelectOption("jira", "Jira"),
            ),
        ),
    )

    SampleScaffold(title = "Questionnaire", onBack = onBack) {
        SampleSection(title = "Onboarding") {
            Questionnaire(
                questions = questions,
                answers = answers,
                onAnswersChange = {
                    answers = it
                    submitted = false
                },
                onSubmit = { submitted = true },
                title = "Tell us about you",
                description = "Used to personalize the catalog examples.",
            )
            if (submitted) {
                Text("Submitted ${answers.size} answers.", color = ShadcnTheme.colors.mutedForeground)
            }
        }
    }
}
