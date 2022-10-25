package group4.sensimate.ui.welcome

import android.content.Intent
import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siddroid.holi.brushes.GradientMixer
import com.siddroid.holi.localComposition.HoliPaletteComposition
import com.siddroid.holi.localComposition.gradientMixer
import group4.sensimate.R
import group4.sensimate.SensiMateActivity
import group4.sensimate.ui.login.SigInActivity
import group4.sensimate.ui.profile.CreateProfileActivity
import group4.sensimate.ui.theme.SensiMateTheme
import kotlinx.coroutines.CoroutineStart

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Welcome()
                }
            }
        }
    }

    @Composable
    fun Welcome() {

        //HoliPaletteComposition {

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
                    painter = painterResource(id = R.drawable.black_logo),
                    contentDescription = "Logo Image",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(8.dp, 0.dp, 8.dp, 0.dp)
                        .align(Alignment.CenterHorizontally)
                        .background(colorResource(R.color.background))
                    //.aspectRatio(20f/30f)
                )

                val colorList= listOf<Color>(Color(R.color.purple_200),colorResource(R.color.light_carmine_pink))
                Text(
                    text = "Welcome",
                    fontSize = 50.sp,
                    //style= TextStyle(color = s),
                    //fontFamily= FontFamily.,
                    //color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer(alpha = 0.99f)
                        .drawWithCache {
                            val brush = Brush.horizontalGradient(colorList)
                            onDrawWithContent {
                                drawContent()
                                drawRect(brush, blendMode = BlendMode.SrcAtop)
                            }
                        }
                )
                //GradientText(name = "Welcome")
                
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(15.dp, 0.dp, 15.dp, 0.dp)
                ) {
                    Checkbox(
                        checked = cookieCheckedState.value,
                        onCheckedChange = { cookieCheckedState.value = it },
                        colors = CheckboxDefaults.colors(Color.Gray)
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
                    modifier = Modifier.padding(15.dp, 0.dp, 15.dp, 0.dp)
                ) {
                    Checkbox(
                        checked = ageCheckedState.value,
                        onCheckedChange = { ageCheckedState.value = it },
                        colors = CheckboxDefaults.colors(Color.Gray)
                    )
                    Text(
                        text = "I'm 18 years or older* ",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .background(colorResource(R.color.background))
                    )
                }
                /*
                OutlinedButton(
                    onClick = {
                        val intent = Intent(applicationContext, SensiMateActivity::class.java)
                        startActivity(intent)
                    },
                    border = BorderStroke(1.dp, Color.Blue),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)

                ) {
                    Text(
                        text="Login as Guest",
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth()
                        .background(brush = GradientMixer.leftToRight(Color.Red,Color.Blue))
                    )
                }*/

                GradientButton(
                    onClick = {
                        val intent = Intent(applicationContext, SensiMateActivity::class.java)
                        startActivity(intent)
                    },
                    text = "Join as Guest",
                    fontSize= 20,
                    shape= RoundedCornerShape(50),
                    gradient = GradientMixer.leftToRight(colorResource(R.color.light_carmine_pink),colorResource(R.color.violets_blue)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            val intent =
                                Intent(applicationContext, CreateProfileActivity::class.java)
                            startActivity(intent)
                        },
                        border = BorderStroke(1.dp, Color.Blue),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.violets_blue))
                    ) {
                        Text("SignUp", fontSize = 18.sp, color = Color.White)
                    }
                    OutlinedButton(
                        onClick = {
                            val intent = Intent(applicationContext, SigInActivity::class.java)
                            startActivity(intent)
                        },
                        border = BorderStroke(1.dp, Color.Blue),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.light_carmine_pink)),
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
            Welcome()
        }
    }
}

@Composable
fun GradientButton(
    text: String,
    fontSize: Int,
    shape: Shape,
    gradient : Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .clip(shape)
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text, fontSize= fontSize.sp)
        }
    }
}

