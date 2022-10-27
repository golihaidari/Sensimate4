package group4.sensimate.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import group4.sensimate.R
import group4.sensimate.data.EventSource
import group4.sensimate.ui.events.EventList

@Composable
fun SearchScreen(){
    val eventName = remember { mutableStateOf("") }
    Column(
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
    ) {

         OutlinedTextField(value = eventName.value, onValueChange ={ eventName.value = it} ,
             trailingIcon = {
                 Icon(
                     imageVector = Icons.Default.Search,
                     tint = Color.White,
                     contentDescription = "eventName"
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

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
        ) {
            EventList(eventList = EventSource().loadEvents())
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchEventPreview(){
    SearchScreen()
}