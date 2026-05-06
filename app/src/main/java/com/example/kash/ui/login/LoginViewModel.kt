package com.example.kash.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    // El estado de los campos ahora vive aquí
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    // Función para validar (mañana aquí conectarás con Room)
    fun LoginVerificar(onSuccess: () -> Unit) {
        if (email == "admin@kash.com" && password == "1234") {
            onSuccess()
        }
    }
}