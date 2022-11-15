package group4.sensimate.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import group4.sensimate.R
import group4.sensimate.data.repository.EventSource
import group4.sensimate.ui.components.GradientEventList
import group4.sensimate.ui.components.GradientTextField
import group4.sensimate.ui.theme.sensiMateHorizontalColor

@Composable
fun SearchScreen(){
    val eventName = remember { mutableStateOf("") }
    Column(
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background))
    )
    {
        Spacer(modifier = Modifier.padding(top=20.dp))

        val focusManager = LocalFocusManager.current
        GradientTextField(
            text = eventName.value,
            label = "Event Name:",
            onChange = { eventName.value = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = Color.White,
                    contentDescription = "eventName"
                )
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )

        GradientEventList(
            eventList = EventSource().loadEvents(),
            page= "SearchPage",
            navController = rememberNavController()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchEventPreview(){
    SearchScreen()
}