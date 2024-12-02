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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun CadastrarReuniao(db: FirebaseFirestore, navController: NavController, innerPadding: PaddingValues){
        var CadastrarReuniao = CadastrarReuniaoPage()
        var Titulo = remember { mutableStateOf("") }
        var Assunto = remember { mutableStateOf("") }
        var Descricao = remember { mutableStateOf("") }
        var Local = remember { mutableStateOf("") }
        var Data = remember { mutableStateOf("") }
        var mensagem = remember { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cadastro Reuniao", fontSize = 25.sp)
            }
            Column {
                Text("Titulo: ")
                TextField(value = Titulo.value, onValueChange = { it -> Titulo.value = it })
                Text("Assunto: ")
                TextField(value = Assunto.value, onValueChange = { it -> Assunto.value = it })
                Text("Descrição: ")
                TextField(value = Descricao.value, onValueChange = { it -> Descricao.value = it })
                Text("Local: ")
                TextField(value = Local.value, onValueChange = { it -> Local.value = it })
                Text("Data: ")
                TextField(value = Data.value, onValueChange = { it -> Data.value = it })
                Text("Mensagem: " + mensagem.value)
            }

        Spacer(modifier = Modifier.size(10.dp))

        Row (
            horizontalArrangement = Arrangement.End
        ){
            Button(onClick = {
                CadastrarReuniao.CadastrarReuniao(db, Titulo, Assunto, Descricao, Data, Local).addOnSuccessListener {
                    navController.navigate("/ListarReuniao")
                }.addOnFailureListener {
                    mensagem.value = "Erro ao cadastrar reuniao"
                }
            }) {
                Text("Cadastrar")
            }
        }

    }
}