package com.example.eatloop

import com.example.eatloop.ui.theme.EatloopTheme
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.first.ui.theme.FirstTheme
import androidx.compose.ui.Modifier

//class SuccessScreen  : ComponentActivity(){
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            EatloopTheme  {
//                Scaffold(modifier = Modifier.fillMaxSize()) {
//                    success()
//                }
//            }
//        }
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PasswordChanged() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LayoutUI(heading = "Success", subheading = "Your password has been reset\n               successfully")

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff5db760)
            ), onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
//            .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            shape = CutCornerShape(5.dp)
        ) {
            Text(text = "Go moody again", fontSize = 25.sp, fontWeight = FontWeight.Normal)
        }
    }
}


