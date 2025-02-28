package com.example.eatloop

import android.annotation.SuppressLint
import com.example.eatloop.ui.theme.EatloopTheme

//mport android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//import com.example.first.ui.theme.FirstTheme

class ForgetPasswordScreen : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Ensure the method is available on the correct API version.
        setContent {
            EatloopTheme  {
                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    LayoutUI("Welcome Back")
//                    ans()
                }
            }
        }
    }
}
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ForgetPassword(navController: NavController){
    Column() {
        LayoutUI("Forgot Password ?", "Me shreya")

    var context = LocalContext.current

        Text(
            text = "Enter e-mail id or Mobile number", color = Color.Black,
            fontSize = 20.sp, fontWeight = FontWeight.Normal, fontFamily = FontFamily.Default,
            modifier = Modifier.padding(10.dp)
        )
        var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "E-mail ID or Mobile Number")}
        )
        Button(
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xff5db760)
            ),
            onClick = { Toast.makeText(context, "OTP sent", Toast.LENGTH_SHORT).show()
                navController.navigate("otp")
                      },
            modifier = Modifier.align(Alignment.CenterHorizontally))
        { Text(text = "Send OTP") }
    }
}

@Composable
fun LayoutUI(heading : String, subheading : String ) {
//    var context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.eatloop_logo),
            contentDescription = "Logo",
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = heading, color = Color(0xff5db760),
            fontSize = 35.sp, fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(1.dp)
        )
        Text(
            text = subheading, color = Color.Black,
            fontSize = 20.sp, fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}
