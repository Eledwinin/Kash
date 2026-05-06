package com.example.kash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kash.ui.ahorros.AhorrosScreen
import com.example.kash.ui.home.HomeScreen
import com.example.kash.ui.informes.InformesScreen
import com.example.kash.ui.login.LoginScreen
import com.example.kash.ui.perfil.perfilScreen
import com.example.kash.ui.presupuestos.PresupuestosScreen
import com.example.kash.ui.theme.KashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KashTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    // FUNCIÓN REUTILIZABLE PARA CERRAR SESIÓN
                    val logoutAction = {
                        navController.navigate("login") {
                            popUpTo("inicio") { inclusive = true }
                        }
                    }

                    // Definimos la ruta del Login
                    composable("login") {
                        LoginScreen(onLoginSuccess = {
                            // Cuando el login sea exitoso, navegamos al inicio
                            navController.navigate("inicio") {
                                // Esto borra el login del historial para que no se pueda volver atrás
                                popUpTo("login") { inclusive = true }
                            }
                        })
                    }
                    composable("inicio") {
                        MainLayout(navController = navController, currentRoute = "Inicio", onLogout = logoutAction) {
                            // Usamos el HomeScreen y definimos qué hace al cerrar sesión
                            HomeScreen(onLogout = {
                                navController.navigate("login") {
                                    popUpTo("inicio") { inclusive = true }
                                }
                            })
                        }
                    }
                    composable("ahorros") {
                        MainLayout(navController = navController, currentRoute = "Ahorros", onLogout = logoutAction) {
                            AhorrosScreen()
                        }
                    }
                    composable("presupuestos") {
                        MainLayout(navController = navController, currentRoute = "Presupuestos", onLogout = logoutAction) {
                            PresupuestosScreen()
                        }
                    }
                    composable("informes") {
                        MainLayout(navController = navController, currentRoute = "Informes", onLogout = logoutAction) {
                            InformesScreen()
                        }
                    }
                    composable("perfil"){
                        MainLayout(navController = navController, currentRoute = "Perfil", onLogout = logoutAction){
                            perfilScreen()
                        }
                    }
                }
            }
        }
    }










}

