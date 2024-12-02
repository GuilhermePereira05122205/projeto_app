package com.example.projeto_tap_app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun Atualizar(db: FirebaseFirestore, id:String, navController: NavHostController, innerPadding: PaddingValues, AtualizarReuniao: AtualizarReuniao){

    var mensagem = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(innerPadding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Atualizar Reuniao", fontSize = 25.sp)
        }
        Column {
            Text("Titulo: ")
            TextField(value = AtualizarReuniao.valores.Titulo.value, onValueChange = { it -> AtualizarReuniao.valores.Titulo.value = it })
            Text("Assunto: ")
            TextField(value = AtualizarReuniao.valores.Assunto.value, onValueChange = { it -> AtualizarReuniao.valores.Assunto.value = it })
            Text("Descrição: ")
            TextField(value = AtualizarReuniao.valores.Descricao.value, onValueChange = { it -> AtualizarReuniao.valores.Descricao.value = it })
            Text("Local: ")
            TextField(value = AtualizarReuniao.valores.Local.value, onValueChange = { it -> AtualizarReuniao.valores.Local.value = it })
            Text("Data: ")
            TextField(value = AtualizarReuniao.valores.Data.value, onValueChange = { it -> AtualizarReuniao.valores.Data.value = it })
            Text(mensagem.value, color = Color.Red)
        }

        Spacer(modifier = Modifier.size(10.dp))

        Row (
            horizontalArrangement = Arrangement.End
        ){
            Button(onClick = {

                AtualizarReuniao.atualizarReuniao(db, id, AtualizarReuniao.valores.Titulo, AtualizarReuniao.valores.Assunto, AtualizarReuniao.valores.Descricao, AtualizarReuniao.valores.Data, AtualizarReuniao.valores.Local).addOnSuccessListener {
                    navController.navigate("/ListarReuniao")
                }.addOnFailureListener {
                    it -> mensagem.value = it.message.orEmpty()
                }

            }) {
                Text("Atualizar", fontSize = 25.sp)
            }
        }

    }
}