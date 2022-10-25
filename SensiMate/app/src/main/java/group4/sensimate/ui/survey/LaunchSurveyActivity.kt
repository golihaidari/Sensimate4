package group4.sensimate.ui.survey

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import group4.sensimate.R
import group4.sensimate.SensiMateActivity
import group4.sensimate.ui.theme.SensiMateTheme

class LaunchSurveyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LaunchSurvey()
                }
            }
        }
    }
}

@Composable
fun LaunchSurvey() {
    val age = remember { mutableStateOf("") }
    val gender = remember { mutableStateOf("") }
    val postalcode = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(20.dp)

    ) {
        Text(
            text = "Before we start, we would like to know a little about you.",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.padding(30.dp))

        OutlinedTextField(
            value = age.value, onValueChange = { age.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "age"
                )
            },
            label = { Text("Age:", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        OutlinedTextField(
            value = gender.value, onValueChange = { gender.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "gender"
                )
            },
            label = { Text("Gender:", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        OutlinedTextField(
            value = postalcode.value, onValueChange = { postalcode.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "postalcode"
                )
            },
            label = { Text("Postalcode:", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )

        Spacer(modifier = Modifier.padding(40.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            var context= LocalContext.current
            OutlinedButton(
                onClick = {
                    context.startActivity(Intent(context, SensiMateActivity:: class.java))
                },
                border = BorderStroke(1.dp, Color.Blue),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.violets_blue))
            )
            {
                Text("Back", fontSize = 20.sp, color= Color.White)
            }

            OutlinedButton(
                onClick = {
                    context.startActivity(Intent(context, StartSurveyActivity:: class.java))
                },
                border = BorderStroke(1.dp, Color.Blue),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.light_carmine_pink))
            )
            {
                Text("Next", fontSize = 20.sp, color= Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LaunchSurveyPreview() {
    SensiMateTheme {
        LaunchSurvey()
    }
}