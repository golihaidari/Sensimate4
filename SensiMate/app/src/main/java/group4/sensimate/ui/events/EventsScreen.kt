package group4.sensimate.ui.events

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import group4.sensimate.R
import group4.sensimate.data.Event
import group4.sensimate.data.EventSource
import group4.sensimate.ui.survey.LaunchSurveyActivity
import group4.sensimate.ui.theme.SensiMateTheme


@Composable
fun EventsScreen(){
    EventList(eventList = EventSource().loadEvents())
}

@Composable
fun EventList(eventList: List<Event>) {

    LazyColumn(
        contentPadding = PaddingValues(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color= colorResource(R.color.background))
    ) {
        items(eventList){event ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(R.color.light_carmine_pink),
                                colorResource(R.color.violets_blue)
                            )
                        )
                    )
                )
            {
                EventCard(event = event)
            }
        }
    }

}

@Composable
fun EventCard(event: Event){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(20.dp),
            elevation = 5.dp,
            border= BorderStroke(
                2.dp,
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(R.color.light_carmine_pink),
                        colorResource(R.color.violets_blue)
                    )
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)
        )
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.light_carmine_pink),
                                colorResource(R.color.violets_blue)
                            )
                        )
                    )
            )
            {
                Image(
                    painter = painterResource(event.imageId),
                    contentDescription = null,//stringResource(event.id),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(130.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.Transparent)
                )
                {
                    Text(text = event.title)
                    Text(text = event.description)
                    Text(text = event.startDate)
                    Text(text = event.endDate)

                    val context = LocalContext.current
                    OutlinedButton(
                        onClick = {
                            context.startActivity(
                                Intent(
                                    context,
                                    LaunchSurveyActivity::class.java
                                )
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                        border = BorderStroke(
                            2.dp,
                            Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(R.color.light_carmine_pink),
                                colorResource(R.color.violets_blue)
                            )
                        ))
                    ) {
                        Text("Evaluate", fontSize = 20.sp, color = Color.Black)
                    }
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
