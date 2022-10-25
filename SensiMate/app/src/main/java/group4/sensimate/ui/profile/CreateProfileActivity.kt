package group4.sensimate.ui.profile

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

class CreateProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RegisterUser()
                }
            }
        }
    }

    @Composable
    fun RegisterUser() {
        val fullname = remember { mutableStateOf("") }
        val username = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val birthday = remember { mutableStateOf("") }
        val gender = remember { mutableStateOf("") }
        val postalcode = remember { mutableStateOf("") }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.background))

        ) {

            Text(
                text = "upload photo",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = fullname.value, onValueChange = { fullname.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        tint = Color.White,
                        contentDescription = "fullname"
                    )
                },
                label = { Text("Fullname:", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(R.color.violets_blue),
                    unfocusedBorderColor = Color(R.color.light_carmine_pink)),
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp, 8.dp, 0.dp)
                    .clip(RoundedCornerShape(50))
            )
            OutlinedTextField(
                value = username.value, onValueChange = { username.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        tint = Color.White,
                        contentDescription = "username"
                    )
                },
                label = { Text("Username:", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(R.color.violets_blue),
                    unfocusedBorderColor = Color(R.color.light_carmine_pink)),
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp, 8.dp, 0.dp)
                    .clip(RoundedCornerShape(50))
            )
            OutlinedTextField(
                value = email.value, onValueChange = { email.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        tint = Color.White,
                        contentDescription = "email"
                    )
                },
                label = { Text("Email:", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(R.color.violets_blue),
                    unfocusedBorderColor = Color(R.color.light_carmine_pink)),
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp, 8.dp, 0.dp)
                    .clip(RoundedCornerShape(50))
            )
            OutlinedTextField(
                value = password.value, onValueChange = { password.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        tint = Color.White,
                        contentDescription = "password"
                    )
                },
                label = { Text("Password:", color = Color.White) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(R.color.violets_blue),
                    unfocusedBorderColor = Color(R.color.light_carmine_pink)),
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp, 8.dp, 0.dp)
                    .clip(RoundedCornerShape(50))
            )
            OutlinedTextField(
                value = birthday.value, onValueChange = { birthday.value = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        tint = Color.White,
                        contentDescription = "birthday"
                    )
                },
                label = { Text("Birthday:", color = Color.White) },
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
            /*OutlinedButton(
                onClick = {
                    val intent = Intent(applicationContext, SigInActivity::class.java)
                    startActivity(intent)
                },
                modifier= Modifier.fillMaxWidth()) {
                Text("Submit", fontSize = 30.sp, color= Color.Blue)
            }*/

            Spacer(modifier = Modifier.padding(20.dp))
            GradientButton(
                onClick = {
                    val intent = Intent(applicationContext, SigInActivity::class.java)
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
    fun SignUpPreview() {
        SensiMateTheme {
            RegisterUser()
        }
    }
}

