package group4.sensimate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import group4.sensimate.ui.theme.SensiMateTheme

class SensiMateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensiMateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SensiMateApp()
                }
            }
        }
    }
}


@Composable
fun SensiMateApp(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {  Tabs(navController)  }
    ) { 
            SensiMateNavHost(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SensiMateTheme {
        SensiMateApp()
    }
}


@Composable
fun Tabs(navController: NavController){
    val screens = listOf( Profile, Events)
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    BottomNavigation(
        backgroundColor = Color.Cyan,
        modifier = Modifier
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                shadowElevation = 2.2f
            }
            .height(80.dp),
        elevation = 8.dp,
    ){
        screens.forEach{
            screen-> AddScreen(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddScreen(
    screen : SensiMateDestination,
    currentDestination: NavDestination?,
    navController: NavController
){
    BottomNavigationItem(
        label = { Text(text= screen.title)},
        icon = { Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")},
        selected = currentDestination?.hierarchy?.any{ it.route == screen.route } == true,
        unselectedContentColor= LocalContentColor.current.copy(alpha= ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}









