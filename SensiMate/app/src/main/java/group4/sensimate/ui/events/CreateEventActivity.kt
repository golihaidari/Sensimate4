package group4.sensimate.ui.events

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
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
import com.siddroid.holi.brushes.GradientMixer
import group4.sensimate.R
import group4.sensimate.SensiMateActivity
import group4.sensimate.ui.login.SigInActivity
import group4.sensimate.ui.theme.SensiMateTheme
import group4.sensimate.ui.welcome.GradientButton

class CreateEventActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RegisterEvent()
                }
            }
        }
    }
}

@Composable
fun RegisterEvent() {
    val name = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val time = remember { mutableStateOf("") }
    val survey = remember { mutableStateOf("") }
    val link = remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(20.dp)

    ) {
        Text(
            text = "Add Image",
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "name"
                )
            },
            label = { Text("Event Name:", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        OutlinedTextField(
            value = location.value, onValueChange = { location.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "location"
                )
            },
            label = { Text("Location", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        OutlinedTextField(
            value = date.value, onValueChange = { date.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "date"
                )
            },
            label = { Text("Date", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        OutlinedTextField(
            value = time.value, onValueChange = { time.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "time"
                )
            },
            label = { Text("Time", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        OutlinedTextField(
            value = survey.value, onValueChange = { survey.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "survey"
                )
            },
            label = { Text("Survey", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        OutlinedTextField(
            value = link.value, onValueChange = { link.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "link"
                )
            },
            label = { Text("Link", color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(R.color.violets_blue),
                unfocusedBorderColor = Color(R.color.light_carmine_pink)),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )

        /*OutlinedButton(
            onClick = {
                //val intent = Intent(applicationContext, SigInActivity::class.java) startActivity(intent)
            },
            modifier= Modifier.fillMaxWidth()) {
            Text("Submit", fontSize = 30.sp, color= Color.Blue)
        }*/

        Spacer(modifier = Modifier.padding(20.dp))

        val context= LocalContext.current
        GradientButton(
            onClick = {
                context.startActivity(Intent(context, SensiMateActivity::class.java))
            },
            text = "Create Event",
            fontSize= 20,
            shape= RoundedCornerShape(50),
            gradient = GradientMixer.leftToRight(
                colorResource(R.color.light_carmine_pink),
                colorResource(R.color.violets_blue)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterEventPreview() {
    SensiMateTheme {
        RegisterEvent()
    }
}