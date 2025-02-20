package com.example.eatloop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eatloop.ui.theme.EatloopTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EatloopTheme {
                val navController = rememberNavController() // NavController should be created here
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") { Splash(navController = navController) } // Pass NavController here
                    composable("main") { OnboardingActivity(navController = navController) }
                    composable("login") { Layout(navController = navController) }
//                    composable("login") { Login(navController = navController) }
                    composable("pass") { ans() } // Include any other screen here
                }
            }
        }
    }
}
