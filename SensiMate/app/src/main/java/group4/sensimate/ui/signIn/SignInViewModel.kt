package group4.sensimate.ui.signIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import group4.sensimate.data.repository.UserRepository

class SignInViewModel() : ViewModel() {
    var username by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    fun usernameChange(newValue: String) {
        username = newValue
    }

    fun passwordChange(newValue: String) {
        password = newValue
    }

    var isLoggedIn by mutableStateOf(false)

    suspend fun signIn(username: String) {
        if(UserRepository().getUser(username) != null){
            isLoggedIn = true
        }
    }

    suspend fun signOut() {
        isLoggedIn = false
    }
}