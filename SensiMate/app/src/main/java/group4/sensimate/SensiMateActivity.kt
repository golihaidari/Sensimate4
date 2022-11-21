package group4.sensimate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import group4.sensimate.ui.theme.SensiMateTheme
import androidx.compose.material.Scaffold
import androidx.navigation.NavHostController
import group4.sensimate.data.repository.surveyQuestions
import group4.sensimate.ui.navigation.ButtonNavBar
import group4.sensimate.ui.navigation.graphs.HomeNavGraph
import group4.sensimate.ui.navigation.graphs.RootNavigationGraph
import group4.sensimate.ui.survey.writeCsv
import java.io.FileOutputStream

class SensiMateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                RootNavigationGraph(navController= rememberNavController())
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SenSiMateAppPreview() {
    SensiMateTheme {
        HomeScreen()
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController())
{
    Scaffold(
        bottomBar = {  ButtonNavBar(navController)  }
    ) {
            HomeNavGraph(navController)
    }
}











