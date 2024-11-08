package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edu.unab.diegocastro.ggaplication.ui.theme.GGAplicationTheme

@Preview
@Composable

fun RegisterScreen() {
    GGAplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerpadding ->
            Column(
                
                modifier = Modifier
                    .padding(innerpadding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Text(text = "Register")
                OutlinedTextField(
                    value = "", onValueChange = {},
                    label = { Text(text = "Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "", onValueChange = {},
                    label = { Text(text = "Apellido") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "", onValueChange = {},
                    label = { Text(text = "Correo Electronico") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "", onValueChange = {},
                    label = { Text(text = "Telefono") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = "", onValueChange = {},
                    label = { Text(text = "ID") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(350.dp))

                Button(
                    onClick = {/*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Register")
                }
                Button(
                    onClick = {/*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Cancel")
                }
            }
        }
    }
}