package group4.sensimate.ui.survey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import group4.sensimate.data.Question
import group4.sensimate.data.Survey
import group4.sensimate.data.SurveySource
import group4.sensimate.ui.theme.SensiMateTheme

class SurveyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoadSurvey(survey = SurveySource().loadSurveyData())
                }
            }
        }
    }
}

@Composable
fun LoadSurvey(survey: Survey) {
    Column{
        LazyColumn {
            items(survey.questions) { question ->
                QuestionRow(question)
            }
        }
    }
}

@Composable
fun QuestionRow(question: Question){
    Row(Modifier.padding(5.dp)) {
        Text(text = question.id.toString() +". ")
        Text(text = question.description)
        if(question.type.equals("list")){
            val radioOptions= question.option
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
            Column {
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                }
                            )
                            .padding(horizontal = 16.dp)
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        )
                        Text(
                            text = text,
                            style = MaterialTheme.typography.body1.merge(),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }

        }
        else {
            val radioOptions= question.option
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
            Row {
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                }
                            )
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) }
                        )
                        Text(
                            text = text,
                            style = MaterialTheme.typography.body1.merge()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadSurveyPreview() {
    SensiMateTheme {
        LoadSurvey(survey = SurveySource().loadSurveyData())
        //QuestionRow(SurveySource().loadSurveyData().questions[1])
    }
}