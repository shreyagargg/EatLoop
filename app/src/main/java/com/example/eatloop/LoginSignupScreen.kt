package com.example.eatloop

import androidx.activity.ComponentActivity
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.eatloop.ui.theme.EatloopTheme

class LoginSignupScreen : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent(){
            EatloopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    Layout()
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginSigup(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .padding(16.dp)
            .fillMaxSize()
    ) {
        LayoutUI("Welcome Back", "Login to your account")


        val tabs = listOf("Login", "Sign Up")
        val selectedTabIndex = remember { mutableStateOf(0) }

        // Box to center everything vertically and horizontally
        Box(modifier = Modifier.fillMaxSize()) {
            // Column for the TabRow and Content
            Column(
                modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(), // Ensures the column wraps the content and doesn't take full height
//            ,horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center // Vertically centers the items within the Column
            ) {
                // Tab Row
                TabRow(
                    selectedTabIndex = selectedTabIndex.value,
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    modifier = Modifier
                        .clip(RoundedCornerShape(160.dp))
                        .height(50.dp),
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value])
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                            selected = selectedTabIndex.value == index,
                            onClick = { selectedTabIndex.value = index },
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
//                val navController = rememberNavController()

                // Content for selected tab
                when (selectedTabIndex.value) {
                    0 -> {
//                        Login(navController)
                        var mail by remember {mutableStateOf("")}
                        var pass by remember {mutableStateOf("")}
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ){
                            TextField(
                                value = mail,
                                onValueChange = { mail = it },
                                textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                placeholder = { Text(text = "E-mail or Phone")},
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            )
                            TextField(
                                value = pass,
                                onValueChange = { pass = it },
                                textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
                                placeholder = { Text(text = "Password")},
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                            )
                            TextButton(
                                modifier = Modifier.align(Alignment.End)
                                ,onClick = { navController.navigate("forget_pass") }) {
                                Text(text = "Forget Password ?", fontSize = 18.sp, fontWeight = FontWeight.Normal,
                                    color = Color.Black)
                            }
                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff5db760)
                                )
                                ,onClick = { },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally)
                                    .padding(20.dp),
                                shape = CutCornerShape(5.dp)
                            ) {
                                Text(text = "Login", fontSize = 25.sp, fontWeight = FontWeight.Normal)

                            }
                        }
                    }
                    1 -> Signup()
                }
            }
        }
    }}

//@Composable
//fun Login(navController : NavController){
//    var mail by remember {mutableStateOf("")}
//    var pass by remember {mutableStateOf("")}
//    Column(
//        modifier = Modifier.padding(10.dp)
//    ){
//        TextField(
//            value = mail,
//            onValueChange = { mail = it },
//            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
//            placeholder = { Text(text = "E-mail or Phone")},
//            modifier = Modifier
//                .padding(10.dp)
//                .fillMaxWidth()
//        )
//        TextField(
//            value = pass,
//            onValueChange = { pass = it },
//            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
//            placeholder = { Text(text = "Password")},
//            modifier = Modifier
//                .padding(10.dp)
//                .fillMaxWidth()
//        )
//        TextButton(
//            modifier = Modifier.align(Alignment.End)
//            ,onClick = { navController.navigate("pass") }) {
//            Text(text = "Forget Password ?", fontSize = 18.sp, fontWeight = FontWeight.Normal,
//                color = Color.Black)
//        }
//        Button(
//            colors = ButtonDefaults.buttonColors(
//                containerColor = Color(0xff5db760)
//            )
//            ,onClick = { },
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(Alignment.CenterHorizontally)
//                .padding(20.dp),
//            shape = CutCornerShape(5.dp)
//        ) {
//            Text(text = "Login", fontSize = 25.sp, fontWeight = FontWeight.Normal)
//
//        }
//    }
//}


@Composable
fun Signup(){
//    LayoutUI(heading = "Register", subheading = "Create your new account")
    var mail by remember {mutableStateOf("")}
    var pass by remember {mutableStateOf("")}
    var name by remember {mutableStateOf("")}
    Column(modifier = Modifier.padding(10.dp)){
        TextField(
            value = name,
            onValueChange = { name = it },
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
            placeholder = { Text(text = "Username")},
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = mail,
            onValueChange = { mail = it },
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
            placeholder = { Text(text = "E-mail or Phone")},
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = pass,
            onValueChange = { pass = it },
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
            placeholder = { Text(text = "Password")},
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically // To align the text and checkbox vertically
        ) {
            var check by remember { mutableStateOf(false) }
            Checkbox(
                checked = check,
                onCheckedChange = { check = it }
            )
            Spacer(modifier = Modifier.width(8.dp)) // Adds some space between checkbox and text
            Text(
                text = "I agree to your privacy policy and terms of use",
                fontSize = 15.sp
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff5db760)
            )
            ,onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            shape = CutCornerShape(5.dp)
        ) {
            Text(text = "Sign up", fontSize = 25.sp, fontWeight = FontWeight.Normal)
        }

    }
}