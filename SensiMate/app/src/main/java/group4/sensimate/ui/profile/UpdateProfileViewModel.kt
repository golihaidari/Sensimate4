package group4.sensimate.ui.profile

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import group4.sensimate.data.model.User
import group4.sensimate.data.repository.UserRepository
import kotlinx.coroutines.launch

class UpdateProfileViewModel(un : String) : ViewModel() {
    private val _user: MutableState<User?> = mutableStateOf(null)
    val user: State<User?> = _user

    /*
    var fullname by mutableStateOf("")
        private set
    var username by mutableStateOf(un)
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


    init{
        getUserInfo()
    }

    fun getUserInfo(){
        viewModelScope.launch {
            val response = UserRepository().getUser(username)
            if(response != null) {
                _user.value = response
                fullname = response.fullname
                username = response.username
                email= response.email
                password = response.password
                birthday = response.birthday
                gender = response.gender
                postalcode = response.postalcode
            }
        }
    }
*/



    private val _fullname: MutableState<String> = mutableStateOf("")
    val fullname: State<String> = _fullname

    private val _username: MutableState<String> = mutableStateOf(un)
    val username: State<String> = _username

    private val _email: MutableState<String> = mutableStateOf("")
    val email: State<String> = _email

    private val _password: MutableState<String> = mutableStateOf("")
    val password: State<String> = _password

    private val _birthday: MutableState<String> = mutableStateOf("")
    val birthday: State<String> = _birthday

    private val _gender: MutableState<String> = mutableStateOf("")
    val gender: State<String> = _gender

    private val _postalcode: MutableState<String> = mutableStateOf("")
    val postalcode: State<String> = _postalcode

    init {
        getUserInfo()
    }

    fun getUserInfo(){
        viewModelScope.launch {
            val response = UserRepository().getUser(username.value)
            if(response != null) {
                _user.value = response
                _fullname.value = response.fullname
                _username.value = response.username
                _email.value = response.email
                _password.value = response.password
                _birthday.value = response.birthday
                _gender.value = response.gender
                _postalcode.value = response.postalcode
            }
        }
    }


    fun fullnameChange(newValue: String){
        _fullname.value = newValue
    }

    fun emailChange(newValue: String){
        _email.value= newValue
    }

    fun usernameChange(newValue: String){
        _username.value= newValue
    }

    fun passwordChange(newValue: String){
        _password.value= newValue
    }

    fun birthdayChange(newValue: String){
        _birthday.value= newValue
    }

    fun genderChange(newValue: String){
        _gender.value = newValue
    }

    fun postalcodeChange(newValue: String){
        _postalcode.value= newValue
    }



    //fun updateProfile(fn: String, un: String, em: String, ps: String, br:String, gn: String, pc: String ): Boolean{
    fun updateProfile():Boolean{
        var result= false
        viewModelScope.launch {
            // var currentUser= user.value
            //val currentUser:User= User(fullname, username, email,password,birthday,gender,postalcode)
            result= UserRepository().updateUser(User(fullname.value, username.value, email.value,password.value,birthday.value,gender.value,postalcode.value))
            //result= UserRepository().updateUser(User(fn, un, em,ps,br,gn,pc))
        }
        return result
    }

}