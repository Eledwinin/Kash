package com.example.kash.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kash.ui.theme.EmeraldPrimary

@Composable
fun HomeScreen(onLogout: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("¡Bienvenido a Kash! 🚀", fontSize = 24.sp, color = EmeraldPrimary)
        Spacer(modifier = Modifier.height(20.dp))

    }
}