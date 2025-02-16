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
                    composable("login") { Login(navController = navController) }
                    composable("pass") { ans() } // Include any other screen here
                }
            }
        }
    }
}

//@Composable
//fun Splash(navController: NavHostController) {
//    // Your splash screen logic goes here
//    // Navigate to the next screen after some time
//    navController.navigate("main") {
//        popUpTo("splash") { inclusive = true } // This ensures you pop the splash screen after navigating
//    }
//}
//
//@Composable
//fun OnBoard(navController: NavHostController) {
//    // Your onboarding logic goes here
//    // After finishing onboarding, navigate to login or another screen
//    // navController.navigate("login")
//}
//
//@Composable
//fun Login(navController: NavHostController) {
//    // Your login logic goes here
//    // After successful login, navigate to the next screen
//    // navController.navigate("pass")
//}
//
//@Composable
//fun ans() {
//    // Your 'ans' screen logic goes here
//}
