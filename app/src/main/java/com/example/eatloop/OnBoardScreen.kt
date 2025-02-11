package com.example.eatloop

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
//import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eatloop.ui.theme.EatloopTheme
//import android.os.Bundle
//import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//class OnboardScreen : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            OnboardingActivity()
//        }
//    }
//}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun OnboardingActivity() {
    var currentIndex by remember { mutableStateOf(0) }
    val progress by animateFloatAsState(
        targetValue = (currentIndex + 1) / 4f, // Progress fills 1/4th each step
        animationSpec = tween(durationMillis = 500)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image Transition
        AnimatedContent(
            targetState = onboardingItems[currentIndex],
            transitionSpec = {
                (slideInHorizontally { width -> width } + fadeIn()).togetherWith(
                    slideOutHorizontally { width -> -width } + fadeOut())
            }
        ) { item ->
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Text Content
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            AnimatedContent(targetState = onboardingItems[currentIndex]) { item ->
                Column(modifier = Modifier.padding(bottom = 100.dp)) {
                    Text(
                        text = item.title,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.description,
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }

        // Next Button with Progress Indicator
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Box(
                modifier = Modifier.padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                // Circular Progress Animation
                Canvas(
                    modifier = Modifier.size(64.dp),
                    onDraw = {
                        drawCircle(
                            color = Color.LightGray.copy(alpha = 0.3f),
                            radius = size.minDimension / 2
                        )
                        drawArc(
                            color = Color.Green,
                            startAngle = -90f,
                            sweepAngle = progress * 360f,
                            useCenter = true
                        )
                    }
                )
                Button(
                    onClick = {
                        if (currentIndex < onboardingItems.lastIndex) {
                            currentIndex++
                        }
                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier.size(50.dp)
                ) {
                    Text("→", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}


val onboardingItems = listOf(
    OnboardingItem(
        "Find and Get Your Best Food",
        "Find the most delicious food and have it delivered to your home.",
        R.drawable.mic // Replace with actual drawable
    ),
    OnboardingItem(
        "Build Your Order",
        "Select your preferred restaurant and manage your order.",
        R.drawable.mic
    ),
    OnboardingItem(
        "24/7 Customer Support",
        "Enjoy dedicated support for your queries anytime, anywhere.",
        R.drawable.mic
    ),
    OnboardingItem(
        "Customize Your Order",
        "Choose your preferred style and taste. Special, or normal.",
        R.drawable.mic
    )
)