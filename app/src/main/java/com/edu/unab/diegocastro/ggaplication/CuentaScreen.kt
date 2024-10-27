package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edu.unab.diegocastro.ggaplication.ui.theme.GGAplicationTheme

@Preview
@Composable

fun CuentaScreen() {
    GGAplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerpadding ->
            Column {
                Card(
                    modifier = Modifier
                        .padding(innerpadding)
                        .padding(16.dp)
                        .fillMaxSize()

                ) {
                    Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text(text = "Cuenta")
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    Card(
                        modifier = Modifier
                            .padding(innerpadding)
                            .padding(16.dp)
                            .fillMaxWidth()

                    ) {
                        Text(text = "Nombre:")

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(text = "Id:")

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(text = "Correo:")

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(text = "Horas Libres:")

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(text = "Actividades Incritas:")

                        Spacer(modifier = Modifier.height(15.dp))
                    }

                    Card(modifier = Modifier
                        .padding(innerpadding)
                        .padding(16.dp)) {
                        Button(
                        onClick = {/*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 225.dp)
                    ) {

                        Text(text = "SALIR") }

                    }
                }
            }
        }
    }
}
