package group4.sensimate.ui.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import group4.sensimate.R
import group4.sensimate.UserPreferences
import group4.sensimate.ui.components.GradientButton
import group4.sensimate.ui.components.GradientText
import group4.sensimate.ui.navigation.graphs.AuthScreen
import group4.sensimate.ui.navigation.graphs.Graph
import group4.sensimate.ui.theme.SensiMateTheme
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(navController: NavController) {
    val cookieCheckedState = remember { mutableStateOf(true) }
    val ageCheckedState = remember { mutableStateOf(true) }
    Column(
        //horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "SensiMate Logo",
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
                .padding(start = 8.dp, end = 8.dp)
                .background(Color.Transparent)
                .align(Alignment.CenterHorizontally)
        )

        GradientText(text = "Welcome", fontSize = 50 )

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(start=15.dp, end= 15.dp)
        ) {
            Checkbox(
                checked = cookieCheckedState.value,
                onCheckedChange = { cookieCheckedState.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(R.color.violets_blue),
                    uncheckedColor = colorResource(R.color.light_carmine_pink ),
                    colorResource(R.color.background )
                )
            )
            Text(
                text = "Continue using cookie*",
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .background(colorResource(R.color.background))
            )
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(start=15.dp, end= 15.dp)
        ) {
            Checkbox(
                checked = ageCheckedState.value,
                onCheckedChange = { ageCheckedState.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(R.color.violets_blue),
                    uncheckedColor = colorResource(R.color.light_carmine_pink ),
                    checkmarkColor = colorResource(R.color.background )
                )
            )
            Text(
                text = "I'm 18 years or older* ",
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .background(colorResource(R.color.background))
            )
        }

        val context = LocalContext.current
        val scope = rememberCoroutineScope()
        GradientButton(
            onClick = {
                scope.launch {
                    UserPreferences(context).saveRole("Guest")
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            },
            text = "Join as Guest",
            fontSize= 20,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Spacer(modifier = Modifier.padding(30.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
        ) {
            OutlinedButton(
                border = BorderStroke(1.dp, Color.Blue),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.violets_blue)),
                onClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                }
            ) {
                Text("SignUp", fontSize = 18.sp, color = Color.White)
            }
            OutlinedButton(
                border = BorderStroke(1.dp, Color.Blue),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.light_carmine_pink)),
                onClick = {
                    navController.navigate(AuthScreen.SignIn.route)
                }
            ) {
                Text("SignIn", fontSize = 18.sp, color = Color.White)
            }
        }

    }
    //}
}

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    SensiMateTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}