package group4.sensimate.ui.profile

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.OutlinedButton
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
import group4.sensimate.data.EventSource
import group4.sensimate.ui.events.EventList
import group4.sensimate.ui.theme.SensiMateTheme
import group4.sensimate.R
import group4.sensimate.ui.survey.LaunchSurveyActivity

@Composable
fun ProfileScreen(){

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray),
    ){
        // User's image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "profile Image",
            modifier = Modifier
                .size(140.dp)
                .clip(shape = CircleShape)
        )
        val context= LocalContext.current
        FloatingActionButton(
            onClick = { context.startActivity(Intent(context, UpdateProfileActivity ::class.java)) },
            modifier= Modifier.fillMaxWidth()
        ){
            Text("Update Profile", fontSize = 30.sp, color= Color.Blue)
        }

        Column( modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Red)
        ){

            Text(
                text = "username    Goli",
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "age         30",
                modifier = Modifier.padding(3.dp),
                color = Color.White
            )

            Text(
                text = "gender      Female",
                modifier = Modifier.padding(3.dp),
                color = Color.White
            )

            Text(
                text = "postalcode  2000",
                modifier = Modifier.padding(3.dp),
                color = Color.White
            )

            Text(
                text = "email       gggg@gmail.com",
                modifier = Modifier.padding(3.dp),
                color = Color.White
            )


        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        ) {
            //EventList(eventList = EventSource().loadEvents())
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    SensiMateTheme {
        ProfileScreen()
    }
}