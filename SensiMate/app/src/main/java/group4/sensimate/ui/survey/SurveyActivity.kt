package group4.sensimate.ui.survey

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddroid.holi.brushes.GradientMixer
import group4.sensimate.R
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Card(
            elevation = 4.dp,
            modifier = Modifier.fillMaxSize()
        ){
            Image(painter = painterResource(id = R.drawable.survey_background), contentDescription = null)
            LazyColumn() {
                items(survey.questions) { question ->
                    QuestionRow(question)
                }
            }
        }
    }
}

@Composable
fun QuestionRow(question: Question){
    Row(Modifier.padding(50.dp)) {
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
        //StartSurveyTest()
    }
}

@Composable
fun StartSurveyTest(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.pink_50))
    ){
        val brush= GradientMixer.topToBottom(
            colorResource(R.color.pink_300),
            colorResource(R.color.pink_100)
        )


        Box(
            modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                //.border(BorderStroke(width = 10.dp, Color.Red))
                .align(alignment = Alignment.TopCenter)
                .background(brush = brush)
        )

        Box(
            modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                //.border(BorderStroke(width = 10.dp, Color.Blue))
                .align(alignment = Alignment.Center)
                .background(colorResource(R.color.pink_200)),

            )
        {

        }

        Box(
            modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                //.border(BorderStroke(width = 10.dp, Color.Green))
                .align(alignment = Alignment.BottomCenter)
                .background(brush = brush)
        )
        {

        }
    }
}