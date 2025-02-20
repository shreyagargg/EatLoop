package com.example.eatloop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eatloop.ui.theme.EatloopTheme

class ChangePassword  : ComponentActivity(){
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent(){
            EatloopTheme {
                Scaffold(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
                    pass()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun pass(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = androidx.compose.ui.Modifier
//            .padding(16.dp)
            .fillMaxSize()
    ) {
        LayoutUI(
            heading = "Set new password",
            subheading = "Atleast 9 characters with uppercase\n            and lowercase letters"
        )

        var pass by remember { mutableStateOf("") }
        TextField(
            value = pass,
            onValueChange = { pass = it },
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
            placeholder = { Text(text = "New Password")},
            modifier = androidx.compose.ui.Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        var npass by remember { mutableStateOf("") }

        TextField(
            value = npass,
            onValueChange = { npass = it },
            textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
            placeholder = { Text(text = "Confirm Password")},
            modifier = androidx.compose.ui.Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff5db760)
            )
            ,onClick = { },
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            shape = CutCornerShape(5.dp)
        ) {
            Text(text = "Confirm", fontSize = 25.sp, fontWeight = FontWeight.Normal)
        }

    }

}

