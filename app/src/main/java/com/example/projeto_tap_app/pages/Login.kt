package com.example.projeto_tap_app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projeto_tap_app.Greeting
import com.example.projeto_tap_app.ui.theme.Projeto_tap_appTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


@Composable
fun Login(auth: FirebaseAuth, navController: NavController, innerPadding: PaddingValues){
    var loginPage = LoginPage()

    var email = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }

    var mensagem = remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(innerPadding)
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Column{
            Text("Email: ", fontSize = 20.sp)
            TextField(value = email.value,
                onValueChange = {it -> email.value = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        }

        Column{
            Text("Password: ", fontSize = 20.sp)
            TextField(value = password.value,
                onValueChange = {it -> password.value = it},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        }

        Text(mensagem.value, color = Color.Red)

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(modifier = Modifier.padding(10.dp), onClick = {
                navController.navigate("/Cadastrar")
            }) {
                Text("Cadastrar")
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(modifier = Modifier.padding(20.dp), onClick = {
                loginPage.LogarUsuario(auth, email, password).addOnSuccessListener {
                    navController.navigate("/ListarReuniao")
                }.addOnFailureListener {
                        it -> mensagem.value = it.message.orEmpty()
                }
            }) {
                Text("Logar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VIew() {
    Projeto_tap_appTheme {

    }
}
