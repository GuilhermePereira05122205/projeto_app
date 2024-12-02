package com.example.projeto_tap_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.projeto_tap_app.componets.Conteudo
import com.example.projeto_tap_app.componets.TopBar
import com.example.projeto_tap_app.nav.NavController
import com.example.projeto_tap_app.ui.theme.Projeto_tap_appTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var state = rememberDrawerState(initialValue = DrawerValue.Closed)
            var navController = rememberNavController()
            Projeto_tap_appTheme {
                ModalNavigationDrawer(
                    drawerContent = { Conteudo(state, navController) },
                    drawerState = state
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopBar(state)
                        }
                    ) { innerPadding ->
                        NavController(navController, innerPadding)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Projeto_tap_appTheme {
        Greeting("Android")
    }
}