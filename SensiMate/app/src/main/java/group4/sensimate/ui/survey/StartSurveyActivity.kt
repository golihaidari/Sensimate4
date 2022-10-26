package group4.sensimate.ui.survey

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddroid.holi.brushes.GradientMixer
import group4.sensimate.R
import group4.sensimate.ui.theme.SensiMateTheme
import java.util.*

class StartSurveyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    StartSurvey()
                }
            }
        }
    }
}

/* old code
@Composable
fun StartSurvey() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.background))
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image",
            modifier = Modifier
                .size(72.dp)
                .clip(shape = CircleShape)
        )
        var context= LocalContext.current
        OutlinedButton(
            onClick = { context.startActivity(Intent(context, SurveyActivity:: class.java)) },
            //modifier= Modifier.fillMaxWidth()
        ){
            Text("Start", fontSize = 30.sp, color= Color.Blue)
        }

        Text(
            text = "some text",
            fontSize = 8.sp,
            color = Color.White
        )

        Text(
            text = "Tell us about ur experience",
            modifier = Modifier.padding(3.dp),
            color = Color.White
        )


    }
}
*/
@Composable
fun StartSurvey(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.pink_50))
    ){
        val brush= GradientMixer.topToBottom(colorResource(R.color.pink_300),colorResource(R.color.pink_100))
        Box(
            modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                //.border(BorderStroke(width = 10.dp, Color.Red))
                .align(alignment = Alignment.TopCenter)
                .background(brush = brush)
        )

        Box(
            modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                //.border(BorderStroke(width = 10.dp, Color.Blue))
                .align(alignment = Alignment.Center)
                .background(colorResource(R.color.pink_200)),

        )
        {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Image",
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .align(Alignment.Center)
            )
        }

        Box(
            modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                .align(alignment = Alignment.TopCenter)
                //.background(brush = brush)
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .size(250.dp)
                    .padding(0.dp,20.dp,0.dp,0.dp)
                    //.alpha(0.99f)
                    .align(Alignment.Center)
                    .background(Color.Transparent)
                //.aspectRatio(20f/30f)
            )
        }

        Box(
            modifier = Modifier
                .size(400.dp)
                .clip(CircleShape)
                //.border(BorderStroke(width = 10.dp, Color.Green))
                .align(alignment = Alignment.BottomCenter)
                .background(brush = brush)
        )
        {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                var context = LocalContext.current
                OutlinedButton(
                    onClick = {
                        context.startActivity(
                            Intent(
                                context,
                                SurveyActivity::class.java
                            )
                        )
                    },
                    modifier = Modifier.padding(25.dp)
                    //modifier = Modifier.align(Alignment.TopCenter).padding(25.dp)
                ) {
                    Text(
                        text="Start",
                        fontSize = 30.sp,
                        color = Color.Black)
                }

                Text(
                    text = "takes 5 minutes",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(5.dp)

                )

                Text(
                    text = "Tell us about ur experience",
                    fontSize=25.sp,
                    modifier = Modifier.padding(15.dp),
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartSurveyPreview() {
    SensiMateTheme {
        StartSurvey()
        //StackElements()
    }
}