package group4.sensimate.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddroid.holi.brushes.GradientMixer
import group4.sensimate.R
import group4.sensimate.SensiMateActivity
import group4.sensimate.ui.theme.SensiMateTheme
import group4.sensimate.ui.welcome.GradientButton

class SigInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LogIn()
                }
            }
        }
    }

    @Composable
    fun LogIn() {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.background)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.black_logo),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .size(250.dp)
                    .padding(8.dp, 0.dp, 8.dp, 0.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(colorResource(R.color.background))
                //.aspectRatio(20f/30f)
            )
            Text(
                text = "SensiMate",
                fontSize = 40.sp,
                color= Color.White,
                fontWeight = FontWeight.Bold,
                textAlign= TextAlign.Center,
                modifier= Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = username.value,
                onValueChange = {username.value= it},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person,
                         tint= Color.White,
                         contentDescription = "username"
                    )
                },
                label =  {
                    Text(
                        text= "Username:",
                        color= Color.White
                    )
                 },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(R.color.violets_blue),
                    unfocusedBorderColor = Color(R.color.light_carmine_pink)),
                modifier= Modifier.fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50))
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value= it },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Info,
                         tint= Color.White,
                         contentDescription = "password"
                    )
                },
                label =  {
                    Text(
                        text="Password:",
                        color= Color.White
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(R.color.violets_blue),
                    unfocusedBorderColor = Color(R.color.light_carmine_pink)),
                modifier= Modifier.fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50))
            )

            /*OutlinedButton(
                onClick = {
                    val intent = Intent(applicationContext, SensiMateActivity::class.java)
                    startActivity(intent) },
                modifier= Modifier.fillMaxWidth()
            ){
                Text("SignIn", fontSize = 30.sp, color= Color.Blue)
            }*/

            GradientButton(
                onClick = {
                    val intent = Intent(applicationContext, SensiMateActivity::class.java)
                    startActivity(intent)
                },
                text = "Sign In",
                fontSize= 20,
                shape= RoundedCornerShape(50),
                gradient = GradientMixer.leftToRight(colorResource(R.color.light_carmine_pink),colorResource(R.color.violets_blue)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview4() {
        SensiMateTheme {
            LogIn()
        }
    }
}

