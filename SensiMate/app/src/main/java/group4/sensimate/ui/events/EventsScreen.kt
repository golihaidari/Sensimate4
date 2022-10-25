package group4.sensimate.ui.events

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import group4.sensimate.data.Event
import group4.sensimate.data.EventSource
import group4.sensimate.ui.survey.LaunchSurveyActivity
import group4.sensimate.ui.theme.SensiMateTheme


@Composable
fun EventsScreen(){
    EventList(eventList = EventSource().loadEvents())
   /* Box(modifier = Modifier.fillMaxSize().background(Color.Blue),
        contentAlignment = Alignment.Center){
        //Text(text= "Events",fontSize = 100.sp, color= Color.White)
        EventList(eventList = EventSource().loadEvents())
    }*/

    val context = LocalContext.current
    OutlinedButton(
        onClick = { context.startActivity(Intent(context, LaunchSurveyActivity::class.java)) },
        modifier= Modifier.fillMaxWidth()
    ){
        Text("Evaluate", fontSize = 15.sp, color= Color.Blue)
    }
}

@Composable
fun EventList(eventList: List<Event>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        eventList.forEach { event ->
            EventRow(event)
        }
    }
    /*LazyColumn {
        items(eventList) { event ->
            EventRow(event)
        }
    }*/
}

@Composable
fun EventRow(event: Event){
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp), elevation = 4.dp) {
        Row {
            Column {
                Image(
                    painter = painterResource(event.imageId),
                    contentDescription = stringResource(event.id),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                )
            }
            Column (modifier = Modifier.padding(15.dp).align(alignment = CenterVertically)){
                Text(text = event.title)
                Text(text = event.description)
                Text(text = event.startDate)
                Text(text = event.endDate)

                val context = LocalContext.current
                OutlinedButton(
                    onClick = { context.startActivity(Intent(context, LaunchSurveyActivity::class.java)) },
                    modifier= Modifier.fillMaxWidth()
                ){
                    Text("Evaluate", fontSize = 15.sp, color= Color.Blue)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventPreview() {
    SensiMateTheme {
        EventsScreen()
        //EventCard(Event(1, R.drawable.ic_launcher_background,"Test", "Test", "11",""))
    }
}
