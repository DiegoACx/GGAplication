package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.edu.unab.diegocastro.ggaplication.ui.theme.GGAplicationTheme
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearEventoScreen(navController: NavController) {
    val db = FirebaseFirestore.getInstance() // Instancia de Firestore
    val NombreEvento = remember { mutableStateOf(TextFieldValue("")) }
    val HoraInicio = remember { mutableStateOf(TextFieldValue("")) }
    val Cupos = remember { mutableStateOf(TextFieldValue("")) }
    val Lider = remember { mutableStateOf(TextFieldValue("")) }
    val Descripcion = remember { mutableStateOf(TextFieldValue("")) }

    GGAplicationTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFE1E5CE))
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color(0xFFE1E5CE))
                    .padding(vertical = 32.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Crear Evento",
                    fontSize = 24.sp,
                    color = Color(0xFFA3D16A),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFAED581))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        OutlinedTextField(
                            value = NombreEvento.value,
                            onValueChange = { NombreEvento.value = it },
                            label = { Text(text = "Nombre del Evento:") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp)),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF4CAF50),
                                unfocusedBorderColor = Color(0xFFA3D16A),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                cursorColor = Color.Black )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = HoraInicio.value,
                            onValueChange = { HoraInicio.value = it },
                            label = { Text(text = "Hora de Inicio:") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp)),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF4CAF50),
                                unfocusedBorderColor = Color(0xFFA3D16A),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                cursorColor = Color.Black )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = Cupos.value,
                            onValueChange = { Cupos.value = it },
                            label = { Text(text = "Cupos:") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp)),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF4CAF50),
                                unfocusedBorderColor = Color(0xFFA3D16A),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                cursorColor = Color.Black )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = Lider.value,
                            onValueChange = { Lider.value = it },
                            label = { Text(text = "Lider:") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp)),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF4CAF50),
                                unfocusedBorderColor = Color(0xFFA3D16A),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                cursorColor = Color.Black )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = Descripcion.value,
                            onValueChange = { Descripcion.value = it },
                            label = { Text(text = "Descripcion:") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp)),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF4CAF50),
                                unfocusedBorderColor = Color(0xFFA3D16A),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                cursorColor = Color.Black )
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            // Guardar el evento en Firestore
                            val evento = hashMapOf(
                                "nombre" to NombreEvento.value.text,
                                "hora_inicio" to HoraInicio.value.text,
                                "cupos" to Cupos.value.text,
                                "lider" to Lider.value.text,
                                "descripcion" to Descripcion.value.text
                            )

                            db.collection("eventos")
                                .add(evento)
                                .addOnSuccessListener {
                                    println("Evento registrado con éxito")
                                }
                                .addOnFailureListener { e ->
                                    println("Error al registrar el evento: $e")
                                }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
                    ) {
                        Text(
                            text = "Registrar Evento",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        onClick = {
                            navController.navigate("mas") {
                                popUpTo("crearevento") {
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
                    ) {
                        Text(
                            text = "Salir",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}