package com.example.kash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.* // <-- Importación nueva para los íconos actualizados
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Colores de tu diseño
val TealMain = Color(0xFF00A896)
val BackgroundGray = Color(0xFFF5F7F9)

/**
 * ESTE ES EL LAYOUT MAESTRO.
 * Recibe un parámetro 'content' que es la vista que tus compañeros van a crear.
 */
@Composable
fun MainLayout(
    currentRoute: String = "Inicio", // Para saber qué ícono pintar de seleccionado
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { HeaderTopBar() },
        bottomBar = { FooterBottomBar(currentRoute) },
        containerColor = BackgroundGray // El fondo grisecito claro de la app
    ) { paddingValues ->
        // Aquí adentro es donde se va a renderizar lo que hagan tus compañeros
        Box(
            modifier = Modifier
                .fillMaxSize()
                // El paddingValues evita que el contenido se meta debajo del TopBar o BottomBar
                .padding(paddingValues)
        ) {
            content(paddingValues)
        }
    }
}

// ==========================================
// 1. EL ENCABEZADO (Amarillo Superior)
// ==========================================
@Composable
fun HeaderTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = TealMain,
                // Las curvas en la parte de abajo del encabezado
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
            )
            .padding(top = 40.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Lado Izquierdo: Avatar y Saludo
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF7B7B)), // Color coral/rosado del diseño
                contentAlignment = Alignment.Center
            ) {
                Text("A", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "¡Hola, Alex!",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        // Lado Derecho: Íconos de notificación y salida
        Row {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notificaciones",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                // Cambio 1: Uso de AutoMirrored para ExitToApp
                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                contentDescription = "Salir",
                tint = Color.White
            )
        }
    }
}

// ==========================================
// 2. EL PIE DE PÁGINA (Amarillo Inferior)
// ==========================================
@Composable
fun FooterBottomBar(currentRoute: String) {
    NavigationBar(
        containerColor = TealMain,
        contentColor = Color.White,
        tonalElevation = 8.dp,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        val items = listOf(
            "Inicio" to Icons.Default.Home,
            "Ahorros" to Icons.Default.Star, // Cambia por tu icono de cerdito
            // Cambio 2: Uso de AutoMirrored para List
            "Presupuestos" to Icons.AutoMirrored.Filled.List,
            "Informes" to Icons.Default.Build, // Cambia por tu icono de gráficas
            "Perfil" to Icons.Default.Person
        )

        items.forEach { (route, icon) ->
            val isSelected = currentRoute == route

            NavigationBarItem(
                icon = { Icon(icon, contentDescription = route) },
                label = { Text(route, fontSize = 10.sp) },
                selected = isSelected,
                onClick = {
                    // Aquí irá la lógica de navegación (NavController) más adelante
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = TealMain, // Si está seleccionado, el icono se vuelve verde
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.White // El circulito blanco detrás del ícono seleccionado
                )
            )
        }
    }
} // <--- AQUÍ SE CIERRA EL FOOTER

// ==========================================
// VISTA PREVIA (Totalmente afuera)
// ==========================================
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainLayoutPreview() {
    // Llamamos a tu layout maestro
    // Cambio 3: Usamos '_' porque no necesitamos usar paddingValues en esta vista previa simulada
    MainLayout(currentRoute = "Inicio") { _ ->

        // Aquí simulamos lo que tus compañeros pondrían adentro
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Aquí irá el código de la pantalla de tus compañeros",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}