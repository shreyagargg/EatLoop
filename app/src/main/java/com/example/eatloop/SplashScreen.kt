package com.example.eatloop

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eatloop.ui.theme.EatloopTheme
import kotlinx.coroutines.delay


class SplashScreen : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EatloopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    Navigation()
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Splash(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "EatLoop",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff333333),
            modifier = Modifier.padding(10.dp)
        )
//        Text(
//            text = "Translate your text in any language",
//            fontSize = 15.sp,
//            fontWeight = FontWeight.Normal,
//            color = Color(0xff333333),
//            modifier = Modifier.padding(10.dp)
//        )
        Image(
            painter = painterResource(id = R.drawable.eatloop_logo),
            contentDescription = "Logo",
            modifier = Modifier.padding(10.dp).size(200.dp)
        )
//        Button(
//            onClick = {
//                Toast.makeText(context, "Continue", Toast.LENGTH_SHORT).show()
////            navController.navigate("main")
//            },
//            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
//                containerColor = Color(0xffff6f61)
//            ),
//            modifier = Modifier.padding(50.dp)
//        ) {
//            Text(text = "Continue", fontSize = 20.sp, fontWeight = FontWeight.Normal)
//        }
    }

    LaunchedEffect(key1 = true) {
        delay(3000) // Delay for 3 seconds
////        val intent = Intent(context, LoginSignupScreen::class.java)
////        context.startActivity(intent)
////        startActivity(Intent(this@SplashScreen, LoginSignupScreen::class.java))
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true } // Prevents going back to splash screen
        }
    }
}




//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun Navigation() {
//    Splash(navController = rememberNavController())
//}