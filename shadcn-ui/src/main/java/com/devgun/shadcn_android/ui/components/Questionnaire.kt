package com.devgun.shadcn_android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devgun.shadcn_android.ui.theme.ShadcnTheme

enum class QuestionnaireQuestionType {
    Text,
    Single,
    Multiple,
}

data class QuestionnaireQuestion(
    val id: String,
    val prompt: String,
    val type: QuestionnaireQuestionType,
    val description: String? = null,
    val options: List<SelectOption> = emptyList(),
    val required: Boolean = false,
)

@Composable
fun Questionnaire(
    questions: List<QuestionnaireQuestion>,
    answers: Map<String, List<String>>,
    onAnswersChange: (Map<String, List<String>>) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    submitLabel: String = "Submit",
    submitEnabled: Boolean = true,
) {
    val colors = ShadcnTheme.colors
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        if (title != null) {
            Text(
                text = title,
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                color = colors.foreground,
            )
        }
        if (description != null) {
            Text(
                text = description,
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                color = colors.mutedForeground,
            )
        }
        questions.forEach { question ->
            Field(
                label = question.prompt,
                required = question.required,
                description = question.description,
            ) {
                QuestionControl(
                    question = question,
                    values = answers[question.id].orEmpty(),
                    onValuesChange = { next ->
                        onAnswersChange(answers + (question.id to next))
                    },
                )
            }
        }
        Button(onClick = onSubmit, enabled = submitEnabled) {
            Text(submitLabel)
        }
    }
}

@Composable
private fun QuestionControl(
    question: QuestionnaireQuestion,
    values: List<String>,
    onValuesChange: (List<String>) -> Unit,
) {
    when (question.type) {
        QuestionnaireQuestionType.Text -> {
            Input(
                value = values.firstOrNull().orEmpty(),
                onValueChange = { onValuesChange(listOf(it)) },
            )
        }

        QuestionnaireQuestionType.Single -> {
            RadioGroup(
                options = question.options.map { RadioOption(it.value, it.label) },
                selectedValue = values.firstOrNull().orEmpty(),
                onValueChange = { onValuesChange(listOf(it)) },
            )
        }

        QuestionnaireQuestionType.Multiple -> {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                question.options.forEach { option ->
                    val checked = option.value in values
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { isChecked ->
                            onValuesChange(
                                if (isChecked) values + option.value else values - option.value,
                            )
                        },
                        label = option.label,
                    )
                }
            }
        }
    }
}
