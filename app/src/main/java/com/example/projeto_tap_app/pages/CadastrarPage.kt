package com.example.projeto_tap_app.pages

import androidx.compose.runtime.MutableState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class CadastrarPage{
    fun cadastrar(auth: FirebaseAuth, email: MutableState<String>, password: MutableState<String>): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email.value, password.value)
    }
}