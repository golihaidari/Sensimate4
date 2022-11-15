package group4.sensimate.ui.profile

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import group4.sensimate.R
import group4.sensimate.ui.components.GradientButton
import group4.sensimate.ui.components.GradientTextField
import group4.sensimate.ui.components.ProfileImage
import group4.sensimate.ui.theme.SensiMateTheme
import group4.sensimate.UserPreferences
import java.util.*

@Composable
fun UpdateProfileScreen(navController: NavController) {
    ProvideWindowInsets {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.background))
                .verticalScroll(rememberScrollState())
                .navigationBarsWithImePadding()

        ) {
            ProfileImage()
            Text(
                text = "Upload Photo",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            val context= LocalContext.current
            val role = UserPreferences(context).getRole.collectAsState(initial = "")
            val vm= UpdateProfileViewModel(role.value!!)
            val focusManager = LocalFocusManager.current

            if (vm != null) {
                GradientTextField(
                    text = vm.fullname.value,
                    label = "Fullname:",
                    onChange = { vm.fullnameChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            tint = Color.White,
                            contentDescription = "fullname"
                        )
                    },
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text,
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )

                GradientTextField(
                    text = vm.username.value,
                    label = "Username:",
                    onChange = { vm.usernameChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            tint = Color.White,
                            contentDescription = "username"
                        )
                    },
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text,
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )

                GradientTextField(
                    text = vm.email.value,
                    label = "Email:",
                    onChange = { vm.emailChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            tint = Color.White,
                            contentDescription = "email"
                        )
                    },
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text,
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )

                var isPasswordVisible by remember { mutableStateOf(false) }
                GradientTextField(
                    text = vm.password.value,
                    label = "Password:",
                    onChange = { vm.passwordChange(it) },
                    leadingIcon = {
                        IconButton(onClick = {
                            isPasswordVisible = !isPasswordVisible
                        }) {
                            Icon(
                                imageVector = if (isPasswordVisible)
                                    Icons.Filled.Visibility
                                else
                                    Icons.Filled.VisibilityOff,
                                contentDescription = "Password Visibility",
                                tint = Color.White
                            )
                        }
                    },
                    visualTransformation = if (isPasswordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password,
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )

                GradientTextField(
                    text = vm.birthday.value,
                    label = "Birthday:",
                    onChange = { vm.birthdayChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            tint = Color.White,
                            contentDescription = "birthday"
                        )
                    },
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text,
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    modifier = Modifier
                        .clickable {
                            val calendar = Calendar.getInstance()
                            DatePickerDialog(
                                context, { _, year, month, day ->
                                    vm.birthdayChange(getPickedDateAsString(year, month, day))
                                },
                                calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH),
                                calendar.get(Calendar.DAY_OF_MONTH)
                            ).show()
                        }
                )

                GradientTextField(
                    text = vm.gender.value,
                    label = "Gender:",
                    onChange = { vm.genderChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            tint = Color.White,
                            contentDescription = "gender"
                        )
                    },
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Text,
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )

                GradientTextField(
                    text = vm.postalcode.value,
                    label = "Postal Code:",
                    onChange = { vm.postalcodeChange(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            tint = Color.White,
                            contentDescription = "postalCode"
                        )
                    },
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number,
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))

            GradientButton(
                onClick = {
                    if (vm.updateProfile()) {
                        navController.popBackStack()
                        //context.startActivity(Intent(context, SensiMateActivity::class.java))
                    } else {
                        Toast.makeText(context, "Error occured!", Toast.LENGTH_SHORT).show()
                    }
                },
                text = "Update Info",
                fontSize = 20,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpdateProfilePreview() {
    SensiMateTheme {
        UpdateProfileScreen(navController = rememberNavController())
    }
}

@SuppressLint("SimpleDateFormat")
private fun getPickedDateAsString(year: Int, month: Int, day: Int): String {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, day)
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    return dateFormat.format(calendar.time)
}