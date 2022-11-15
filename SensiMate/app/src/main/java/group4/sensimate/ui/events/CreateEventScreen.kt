package group4.sensimate.ui.events


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import group4.sensimate.R
import group4.sensimate.ui.components.GradientButton
import group4.sensimate.ui.components.GradientTextField
import group4.sensimate.ui.components.ProfileImage
import group4.sensimate.ui.theme.SensiMateTheme

@Composable
fun CreateEventScreen(navController: NavController) {
    val name = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val time = remember { mutableStateOf("") }
    val survey = remember { mutableStateOf("") }
    val link = remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(20.dp)

    ) {

        ProfileImage()
        Text(
            text = "Add Image",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        GradientTextField(
            text = name.value,
            onChange ={name.value=it},
            label = "Event Name",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "name"
                )
            }
        )

        GradientTextField(
            text = location.value,
            onChange ={location.value=it},
            label = "Location:",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    tint = Color.White,
                    contentDescription = "location"
                )
            }
        )

        GradientTextField(
            text = date.value,
            onChange ={date.value=it},
            label = "Date:",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.CalendarMonth ,
                    tint = Color.White,
                    contentDescription = "date"
                )
            }
        )
        GradientTextField(
            text = time.value,
            onChange ={time.value=it},
            label = "Time:",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.PunchClock,
                    tint = Color.White,
                    contentDescription = "time"
                )
            }
        )
        GradientTextField(
            text = survey.value,
            onChange ={survey.value=it},
            label = "Survey",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "survey"
                )
            }
        )
        GradientTextField(
            text = link.value,
            onChange ={link.value=it},
            label = "Link",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = "link"
                )
            }
        )

        /*/_________________________________________________-
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
                unfocusedBorderColor = Color(R.color.light_carmine_pink)
            ),
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
                unfocusedBorderColor = Color(R.color.light_carmine_pink)
            ),
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
                unfocusedBorderColor = Color(R.color.light_carmine_pink)
            ),
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
                unfocusedBorderColor = Color(R.color.light_carmine_pink)
            ),
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
                unfocusedBorderColor = Color(R.color.light_carmine_pink)
            ),
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
                unfocusedBorderColor = Color(R.color.light_carmine_pink)
            ),
            modifier= Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp, 8.dp, 0.dp)
                .clip(RoundedCornerShape(50))
        )
        //---------------------------
        */

        Spacer(modifier = Modifier.padding(20.dp))

        GradientButton(
            onClick = {
                      navController.popBackStack()
            },
            text = "Create Event",
            fontSize= 20,
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
        CreateEventScreen(navController = rememberNavController())
    }
}