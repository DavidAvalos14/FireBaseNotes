package com.example.firebasenotes.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.firebasenotes.R
import com.example.firebasenotes.ui.theme.Amarillo2
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate(route = "Login") {
            popUpTo(route = "Login") {
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Amarillo2)
    ) {
        Image(
            // La app se hará con equipos de la MLB
            painter = painterResource(id= R.drawable.publicalo__1_),
            contentDescription = "Notas",
            modifier = Modifier.fillMaxSize()
        )
    }
}