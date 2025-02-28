package com.example.eatloop

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
//import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eatloop.ui.theme.EatloopTheme
//import com.example.first.ui.theme.FirstTheme
//
//class OTPScreen : ComponentActivity() {
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            FirstTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    otp()
//                }
//            }
//        }
//    }
//}


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OTP(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ){
        LayoutUI(heading = "Enter OTP", subheading = "A 4 digit has been set to you")

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            val focusRequester1 = FocusRequester()
            val focusRequester2 = FocusRequester()
            val focusRequester3 = FocusRequester()
            val focusRequester4 = FocusRequester()


            var one by remember { mutableStateOf("") }
            var two by remember { mutableStateOf("") }
            var three by remember { mutableStateOf("") }
            var four by remember { mutableStateOf("") }

            TextField(
                value = one, onValueChange = {
                    if(it.length <= 1 && it.all { char -> char.isDigit() }) {
                        one = it
                        if (it.length == 1) focusRequester2.requestFocus()
                    }
                }, modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.Green)
                    .size(50.dp),
//                colors = TextFieldDefaults.textFieldColors(
//                    containerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Blue
//                )
            )

            TextField(
                value = two, onValueChange = {
                    if(it.length <= 1 && it.all { char -> char.isDigit() }) {
                        two = it
                        if (it.length == 1) focusRequester3.requestFocus()
                    } }, modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.Green)
                    .size(50.dp).focusRequester(focusRequester2),
//                colors = androidx.compose.material3.TextFieldDefaults(
//                    containerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Blue
//                )
            )

            TextField(
                value = three, onValueChange = {
                    if(it.length <= 1 && it.all { char -> char.isDigit() }) {
                        three = it
                        if (it.length == 1) focusRequester4.requestFocus()
                    } } , modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.Green)
                    .size(50.dp).focusRequester(focusRequester3),
//                colors = TextFieldDefaults.textFieldColors(
//                    containerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Blue
//                )
            )

            TextField(
                value = four, onValueChange = {
                    if(it.length <= 1 && it.all { char -> char.isDigit() }) {
                        four = it
                        if (it.length == 1) focusRequester1.requestFocus()
                    }
                }, modifier = Modifier
                    .padding(10.dp)
                    .border(2.dp, Color.Green)
                    .size(50.dp).focusRequester(focusRequester4),
//                colors = TextFieldDefaults.textFieldColors(
//                    containerColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Blue
//                )
            )

        }
        Button(onClick = {
            navController.navigate("new_pass")
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff5db760)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = CutCornerShape(5.dp)
        ){
            Text(text = "Verify", fontSize = 20.sp, fontWeight = FontWeight.Normal)
        }
    }

}