package com.example.projeto_tap_app.pages

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginPage {
    fun LogarUsuario(auth: FirebaseAuth, email: MutableState<String>, password: MutableState<String>): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email.value, password.value)
    }
}