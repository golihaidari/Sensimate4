package group4.sensimate.ui.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import group4.sensimate.ui.signIn.SignInScreen
import group4.sensimate.ui.profile.SignUpScreen
import group4.sensimate.ui.welcome.WelcomeScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(
        route= Graph.AUTHENTICATION,
        startDestination = AuthScreen.Welcome.route
    ){
        composable(route = AuthScreen.Welcome.route){
            WelcomeScreen(navController = navController)
           /* WelcomeContent(
                onJoinAsGuestClick ={
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onSignInClick = { navController.navigate(AuthScreen.SignIn.route) },
                onSignUpClick = { navController.navigate(AuthScreen.SignUp.route)}
            )*/
        }

        composable(route = AuthScreen.SignIn.route){
            SignInScreen(navController = navController)
        }

        composable(route = AuthScreen.SignUp.route){
            SignUpScreen(navController = navController)
        }

    }
}

sealed class AuthScreen(val route: String){
    object Welcome: AuthScreen("WELCOME")
    object SignIn: AuthScreen("SIGN_IN")
    object SignUp: AuthScreen("SIGN_UP")
}