package com.example.projeto_tap_app.pages

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class AtualizarReuniao{

    var valores:Valores = Valores()

    fun findReuniao(db:FirebaseFirestore, id:String): Task<DocumentSnapshot> {
        return db.collection("reuniao")
            .document(id)
            .get()
    }

    fun getReuniao(db:FirebaseFirestore, id:String){
        db.collection("reuniao").document(id).get().addOnSuccessListener {
            it ->
            valores.Titulo.value = it.get("titulo").toString()
            valores.Assunto.value = it.get("assunto").toString()
            valores.Descricao.value = it.get("descricao").toString()
            valores.Data.value = it.get("data").toString()
            valores.Local.value = it.get("local").toString()
        }
    }


    fun atualizarReuniao(db: FirebaseFirestore, id:String, titulo: MutableState<String>, assunto:MutableState<String>, descricao:MutableState<String>, data:MutableState<String>, local:MutableState<String>): Task<Void> {
        var valores = hashMapOf(
            "titulo" to titulo.value,
            "assunto" to assunto.value,
            "descricao" to descricao.value,
            "data" to data.value,
            "local" to local.value,
            "userId" to Firebase.auth.currentUser?.uid.orEmpty()
        )
        return db.collection("reuniao").document(id).update(valores as Map<String, Any>)
    }
}

data class Valores(
    var Titulo: MutableState<String> = mutableStateOf(""),
    var Assunto: MutableState<String> = mutableStateOf(""),
    var Descricao: MutableState<String> =  mutableStateOf(""),
    var Local: MutableState<String> = mutableStateOf(""),
    var Data: MutableState<String> = mutableStateOf("")
)