package com.example.validar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var text by remember { mutableStateOf("") }
    var validationMessage by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(100.dp))
            TextField(value = text, onValueChange = { text = it })
            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el TextField y el botón
            Button(onClick = {
                validationMessage = if (text.isNotEmpty()) {
                    "Texto válido: $text"
                } else {
                    "Por favor, ingresa un texto."
                }
            }) {
                Text(text = "Validar")
            }
            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el botón y el mensaje
            Text(text = validationMessage)
        }
    }
}

