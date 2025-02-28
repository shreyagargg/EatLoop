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
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") { Splash(navController = navController) }
                    composable("main") { OnboardingActivity(navController = navController) }
                    composable("login") { LoginSigup(navController = navController) }
                    composable("forget_pass") { ForgetPassword(navController = navController) }
                    composable("otp") { OTP(navController = navController) }
                    composable("new_pass") { ChangePassword(navController = navController) }
                    composable("pass_change") { PasswordChanged() }
                }
            }
        }
    }
}
