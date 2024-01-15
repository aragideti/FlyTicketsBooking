package com.compose.flyticketsbooking.feature.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.compose.flyticketsbooking.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.flyticketsbooking.ui.theme.ColorBottomBar
import com.compose.flyticketsbooking.ui.theme.PurpleGrey80

@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {
        val emailState = remember { mutableStateOf("") }
        val passwordState = remember { mutableStateOf("") }

        Spacer(modifier = Modifier.padding(top = 56.dp))

        Title(modifier = Modifier)

        Spacer(modifier = Modifier.padding(top = 28.dp))

        Email(
            modifier = Modifier
                .fillMaxWidth(),
            email = emailState.value,
            onEmailChanged = {
                emailState.value = it
            }
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))

        Password(
            modifier = Modifier
                .fillMaxWidth(),
            password = passwordState.value,
            onPasswordChanged = {
                passwordState.value = it
            },
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        KeepSignedInCheckbox(
            checked = true,
            onCheckedChange = {},
            text = stringResource(R.string.keep)
        )

        SignInButton(
            modifier = Modifier
                .fillMaxWidth(),
            enabled = (emailState.value.isNotEmpty() && passwordState.value.isNotEmpty()),
            onClick = {
                signIn(emailState.value, passwordState.value)
            }
        )

        LineTextLine()

        SignInWithGoogleButton(modifier = Modifier
            .fillMaxWidth(),
            enabled = (emailState.value.isNotEmpty() && passwordState.value.isNotEmpty()),
            onClick = {
            })

        Spacer(modifier = Modifier.padding(top = 38.dp))

        RegisterNow(onRegisterClick)

        Spacer(modifier = Modifier.padding(top = 38.dp))
    }
}

fun signIn(email: String, password: String) {
    Log.d("TEST","email $email, password $password")
}

@Composable
fun Title(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.login),
        style = MaterialTheme.typography.h5
    )
    Text(
        modifier = modifier,
        text = stringResource(R.string.welcome),
        fontSize = 16.sp,
        color = PurpleGrey80
    )
}

@Composable
fun Email(
    modifier: Modifier = Modifier,
    email : String = "",
    onEmailChanged: (String) -> Unit = {},
) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.email),
        fontSize = 16.sp,
        color = Color.Black
    )
    OutlinedTextField(
        modifier = modifier.requiredHeight(56.dp),
        value = email,
        onValueChange = { onEmailChanged(it) },
        label = { Text(text = stringResource(R.string.emailHint)) },
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
    )
}

@Composable
fun Password(
    modifier: Modifier = Modifier,
    password : String = "",
    onPasswordChanged: (String) -> Unit = {},
    imeAction: ImeAction = ImeAction.Done
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            modifier = Modifier,
            text = stringResource(R.string.password),
            fontSize = 16.sp,
            color = Color.Black
        )
        ForgotPassword(
            modifier = Modifier,
            onClick = {  }
        )
    }

    OutlinedTextField(
        modifier = modifier.requiredHeight(56.dp),
        value = password,
        onValueChange = { onPasswordChanged(it) },
        label = { Text(text = stringResource(R.string.passwordHint))},
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Visibility,
                contentDescription = ""
            )
        }
    )
}

@Composable
fun ForgotPassword(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Text(
        modifier = modifier.clickable { onClick() },
        text = stringResource(R.string.forgotPassword),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = ColorBottomBar
    )
}

@Composable
fun KeepSignedInCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = ColorBottomBar,
                uncheckedColor = PurpleGrey80,
                disabledColor = Color.Gray
            ),
            modifier = Modifier
        )

        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
fun SignInButton(
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier.requiredHeight(46.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorBottomBar,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
        enabled = enabled,
    ) {
        Text(text = stringResource(R.string.login))
    }
}

@Composable
fun RegisterNow(onRegisterClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        val annotatedText = AnnotatedString.Builder(stringResource(R.string.register))
            .apply {
                addStyle(
                    style = SpanStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = ColorBottomBar,
                    ),
                    start = 0,
                    end = 17
                )
            }
            .toAnnotatedString()
        ClickableText(
            onClick = { onRegisterClick() },
            text = annotatedText,
        )
    }
}

@Composable
fun LineTextLine() {
    Row(
        modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp)
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stringResource(id = R.string.signIn),
            style = MaterialTheme.typography.body1,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.LightGray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    androidx.compose.material3.MaterialTheme {
        LoginScreen()
    }
}

@Composable
fun SignInWithGoogleButton(enabled: Boolean,
modifier: Modifier = Modifier,
onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier.requiredHeight(46.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorBottomBar,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
        enabled = enabled,
    ) {
        Image(
            painter = painterResource(id = R.drawable.gmail),
            contentDescription = "",
            modifier = Modifier.padding(end = 12.dp)
                .size(24.dp)
        )
        Text(text = stringResource(R.string.continueWithGoogle))
    }
}