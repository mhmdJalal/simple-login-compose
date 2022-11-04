package com.mhmdjalal.logincompose.ui.screens.auth

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.mhmdjalal.logincompose.navigation.LocalNavigationProvider
import com.mhmdjalal.logincompose.ui.components.BaseLayout
import com.mhmdjalal.logincompose.ui.components.ButtonLogin
import com.mhmdjalal.logincompose.ui.components.EmailOutlinedTextField
import com.mhmdjalal.logincompose.ui.components.PasswordOutlinedText
import org.koin.androidx.compose.koinViewModel

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
) {
    val navigationProvider = LocalNavigationProvider.current
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isValidate by remember { derivedStateOf { email.isNotBlank() && password.isNotBlank() } }

    val loginResult = viewModel.loginResult.collectAsState().value
    val errorResult = viewModel.errorMessage.collectAsState().value

    if (!loginResult?.token.isNullOrEmpty()) {
        LaunchedEffect(key1 = loginResult?.token) {
            Toast.makeText(context, "${loginResult?.token}", Toast.LENGTH_SHORT).show()
            navigationProvider.navigateToMain(loginResult?.token)
        }
    }
    if (!errorResult.isNullOrEmpty()) {
        LaunchedEffect(key1 = errorResult) {
            Toast.makeText(context, errorResult, Toast.LENGTH_SHORT).show()
        }
    }

    val focusManager = LocalFocusManager.current

    BaseLayout {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            EmailOutlinedTextField(
                textValue = email,
                isReadOnly = viewModel.showLoading.value,
                onValueChange = { email = it },
                onClickButton = { email = "" },
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )

            Spacer(modifier = Modifier.height(20.dp))
            PasswordOutlinedText(
                textValue = password,
                isReadOnly = viewModel.showLoading.value,
                onValueChange = { password = it },
                onDone = { focusManager.clearFocus() }
            )

            Spacer(modifier = Modifier.height(20.dp))
            ButtonLogin(
                onClick = { viewModel.login(email, password) },
                enabled = isValidate,
                isLoading = viewModel.showLoading.value,
            )
        }
    }
}