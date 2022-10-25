package group4.sensimate.ui.survey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import group4.sensimate.ui.theme.SensiMateTheme

class CreateSurveyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RegisterSurvey("Android")
                }
            }
        }
    }
}

@Composable
fun RegisterSurvey(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun RegisterSurveyPreview() {
    SensiMateTheme {
        RegisterSurvey("Android")
    }
}