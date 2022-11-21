package group4.sensimate.ui.profile

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import group4.sensimate.data.model.User
import group4.sensimate.data.repository.UserRepository


class SignUpViewModel : ViewModel() {

    var profileImage by mutableStateOf("")
        private set

    var fullname by mutableStateOf("")
        private set
    var username by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set
    var birthday by mutableStateOf("")
        private set
    var gender by mutableStateOf("")
        private set
    var postalcode by mutableStateOf("")
        private set

    //val enableButton= fullname.isNotBlank() && username.isNotBlank() && password.isNotBlank()

    fun fullnameChange(newValue: String){
        fullname= newValue
    }

    fun emailChange(newValue: String){
        email= newValue
    }

    fun usernameChange(newValue: String){
        username= newValue
    }

    fun passwordChange(newValue: String){
        password= newValue
    }

    fun birthdayChange(newValue: String){
        birthday= newValue
    }

    fun genderChange(newValue: String){
        gender = newValue
    }

    fun postalcodeChange(newValue: String){
        postalcode= newValue
    }

    fun profileImageChange(newValue: String){
        profileImage= newValue
    }

    /*
    suspend fun signUpUser(vm: SignUpViewModel): Boolean{
        val user = User()
        user.fullname = vm.fullname
        user.username = vm.username
        user.email= vm.email
        user.password= vm.password
        user.birthday= vm.birthday
        user.gender= vm.gender
        user.postalcode= vm.postalcode

        return UserRepository().addUser(user)
    }
     */

}

