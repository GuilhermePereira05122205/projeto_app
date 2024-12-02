package com.example.projeto_tap_app.pages

import androidx.compose.runtime.MutableState
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class CadastrarReuniaoPage {
    fun CadastrarReuniao(db: FirebaseFirestore, titulo: MutableState<String>, assunto: MutableState<String>, descricao: MutableState<String>, data: MutableState<String>, local: MutableState<String>): Task<DocumentReference> {

        var valores = hashMapOf(
            "titulo" to titulo.value,
            "assunto" to assunto.value,
            "descricao" to descricao.value,
            "data" to data.value,
            "local" to local.value,
            "userId" to Firebase.auth.currentUser?.uid.orEmpty()
        )

        return db.collection("reuniao").add(valores)
    }
}