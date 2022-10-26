package group4.sensimate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import group4.sensimate.ui.events.EventsScreen
import group4.sensimate.ui.profile.ProfileScreen

@Composable
fun SensiMateNavHost( navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Events.route
    ){
        composable(route = Events.route) {
            EventsScreen( )
        }
        composable(route = Search.route) {
           // SearchScreen( )
        }
        composable(route = Profile.route) {
            ProfileScreen( )
        }
    }
}

