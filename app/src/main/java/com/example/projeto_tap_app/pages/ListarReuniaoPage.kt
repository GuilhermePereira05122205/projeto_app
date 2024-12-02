package com.example.projeto_tap_app.pages

import android.annotation.SuppressLint
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.core.CompositeFilter

class ListarReuniaoPage {
    @SuppressLint("RestrictedApi")
    fun listarReuniao(db: FirebaseFirestore): Task<QuerySnapshot> {
        return db.collection("reuniao")
            .whereEqualTo("userId", Firebase.auth.currentUser?.uid.orEmpty())
            .get()

    }
}