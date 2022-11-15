package group4.sensimate.domain

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import group4.sensimate.data.model.User
import group4.sensimate.data.repository.UserRepository
import group4.sensimate.ui.profile.SignUpViewModel
import group4.sensimate.ui.survey.SurveyState
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(){
    private val repository = UserRepository()

    var isLoggedIn by mutableStateOf(false)

    suspend fun SignIn(username: String) {
        if(repository.getUser(username) != null){
            isLoggedIn= true
        }
    }

    suspend fun SignOut() {
        isLoggedIn =  false
    }

   suspend fun createProfile(user: User): Boolean{
        return repository.addUser(user)
    }

    suspend fun getUserInfo(username: String):User? {
        return repository.getUser(username)
   }

   suspend fun UpdateProfile(user: User):Boolean {
        return repository.updateUser(user)
    }

   suspend fun deleteProfile(username: String): Boolean {
        return repository.deleteUser(username)
   }

   //val UserState = compositionLocalOf<UserViewModel> { error("User State Context Not Found!") }

    companion object {
        private var users: List<User>? = null
        fun getInstance() {
            if (users == null){
                users = UserRepository().getUsers()
            }
        }
    }

    private var _userState = MutableLiveData<User>()
    val userState: LiveData<User> get() = _userState

    fun getUser(username: String) {
        viewModelScope.launch {
           val user = repository.getUser(username)!!
            if(user != null){
                _userState.value= user
            } else {
                _userState.value = (user) { error("User State Context Not Found!") }
            }
        }
    }

}