package group4.sensimate.ui.survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import group4.sensimate.R
import group4.sensimate.ui.theme.SensiMateTheme

class StartSurveyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StartSurvey()
                }
            }
        }
    }
}

@Composable
fun StartSurvey() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().background(Color.Gray),
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image",
            modifier = Modifier
                .size(72.dp)
                .clip(shape = CircleShape)
        )
        var context= LocalContext.current
        OutlinedButton(
            onClick = { context.startActivity(Intent(context, SurveyActivity:: class.java)) },
            //modifier= Modifier.fillMaxWidth()
        ){
            Text("Start", fontSize = 30.sp, color= Color.Blue)
        }

        Text(
            text = "some text",
            fontSize = 8.sp,
            color = Color.White
        )

        Text(
            text = "Tell us about ur experience",
            modifier = Modifier.padding(3.dp),
            color = Color.White
        )


    }
}

@Preview(showBackground = true)
@Composable
fun StartSurveyPreview() {
    SensiMateTheme {
        StartSurvey()
    }
}