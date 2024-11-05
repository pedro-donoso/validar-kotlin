package com.example.validar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var text by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Ingrese el código") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Usar un Box para centrar el botón
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center // Centrar el contenido
        ) {
            Button(onClick = {
                dialogMessage = if (text == "123456") {
                    "Validado"
                } else {
                    "No validado"
                }
                showDialog = true
            }, modifier = Modifier.padding(2.dp)) {
                Text(text = "Validar")
            }
        }
    }

    // AlertDialog para mostrar el resultado
    if (showDialog) {
        ValidationDialog(
            message = dialogMessage,
            onDismiss = { showDialog = false }
        )
    }
}

@Composable
fun ValidationDialog(message: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Resultado de Validación") },
        text = { Text(text = message) },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Aceptar")
            }
        }
    )
}