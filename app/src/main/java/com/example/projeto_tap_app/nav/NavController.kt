package com.example.projeto_tap_app.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.projeto_tap_app.pages.Cadastro
import com.example.projeto_tap_app.pages.ListarReuniao
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projeto_tap_app.pages.Atualizar
import com.example.projeto_tap_app.pages.AtualizarReuniao
import com.example.projeto_tap_app.pages.CadastrarReuniao
import com.example.projeto_tap_app.pages.Login
import com.example.projeto_tap_app.pages.Valores
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavController(navController: NavHostController, innerPadding: PaddingValues){
    var auth = Firebase.auth
    var firebase = Firebase.firestore

    NavHost(navController = navController, startDestination = "/") {
        composable("/") {
            Login(auth, navController, innerPadding)
        }
        composable("/Cadastrar") {
            Cadastro(auth, navController, innerPadding)
        }
        composable("/CadastrarReuniao") {
            CadastrarReuniao(firebase, navController, innerPadding)
        }
        composable("/ListarReuniao") {
            ListarReuniao(firebase, navController, innerPadding)
        }
        composable("/AtualizarReuniao/{id}", listOf(navArgument("id"){
            type = NavType.StringType
        })) { it ->
            var id = it.arguments?.getString("id").orEmpty()

            var data = remember{
                Valores()
            }

            var AtualizarPage = AtualizarReuniao()

            AtualizarPage.valores = data

            AtualizarPage.getReuniao(firebase, id)

            Atualizar(firebase, id, navController, innerPadding, AtualizarPage)
        }
    }
}


class Teste{

}