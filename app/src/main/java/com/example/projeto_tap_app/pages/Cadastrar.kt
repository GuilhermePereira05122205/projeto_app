package com.example.projeto_tap_app.pages

import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Cadastro(auth: FirebaseAuth, navController: NavController, innerPadding: PaddingValues){
    var CadastrarPage = CadastrarPage()

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
        modifier = Modifier.padding(innerPadding).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Cadastro", fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.size(20.dp))
        Column {
            Text("Email: ", fontSize = 25.sp)
            TextField(
                value = email.value,
                onValueChange = { it -> email.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))

            Text("Password: ", fontSize = 25.sp)
            TextField(value = password.value,
                onValueChange = { it -> password.value = it },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        }

        Text(mensagem.value, color = Color.Red)

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(modifier = Modifier.padding(20.dp),onClick = {
                CadastrarPage.cadastrar(auth, email, password).addOnSuccessListener {
                    navController.navigate("/")
                }.addOnFailureListener { it ->
                    mensagem.value = it.message.orEmpty()
                }
            }) {
                Text("Cadastrar", fontSize = 20.sp)
            }
        }
    }
}