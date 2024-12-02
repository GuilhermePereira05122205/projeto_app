package com.example.projeto_tap_app.componets

import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun Conteudo(state: DrawerState, navController: NavHostController){
    ModalDrawerSheet {
        Text("Reunioes", fontSize = 20.sp)
        HorizontalDivider()
        NavigationDrawerItem(
            label = { Text("Cadastrar") },
            selected = false,
            onClick = {
                navController.navigate("/CadastrarReuniao")
            }
        )
        NavigationDrawerItem(
            label = { Text("Listar") },
            selected = false,
            onClick = {
                navController.navigate("/ListarReuniao")
            }
        )
        NavigationDrawerItem(
            label = { Text("Deslogar") },
            selected = false,
            onClick = {
                Firebase.auth.signOut()
                navController.navigate("/")
            }
        )
    }
}