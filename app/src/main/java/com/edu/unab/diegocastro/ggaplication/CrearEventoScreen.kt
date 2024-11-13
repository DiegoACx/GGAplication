package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.edu.unab.diegocastro.ggaplication.ui.theme.GGAplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearEventoScreen(navController: NavController) {
    // Estados para los campos de texto
    val NombreEvento = remember { mutableStateOf(TextFieldValue("")) }
    val HoraInicio = remember { mutableStateOf(TextFieldValue("")) }
    val Cupos = remember { mutableStateOf(TextFieldValue("")) }
    val Lider = remember { mutableStateOf(TextFieldValue("")) }
    val Descripcion = remember { mutableStateOf(TextFieldValue("")) }

    // Instancia de Firestore
    val db = FirebaseFirestore.getInstance()

    // Función para registrar el evento en Firestore
    fun registrarEvento() {
        val nombreEvento = NombreEvento.value.text
        val horaInicio = HoraInicio.value.text
        val cupos = Cupos.value.text
        val lider = Lider.value.text
        val descripcion = Descripcion.value.text

        // Verifica que los campos no estén vacíos
        if (nombreEvento.isNotEmpty() && horaInicio.isNotEmpty() && cupos.isNotEmpty() && lider.isNotEmpty() && descripcion.isNotEmpty()) {
            val evento = hashMapOf(
                "nombre" to nombreEvento,
                "hora_inicio" to horaInicio,
                "cupos" to cupos,
                "lider" to lider,
                "descripcion" to descripcion
            )

            // Guardar en Firestore
            db.collection("eventos")
                .add(evento)
                .addOnSuccessListener {
                    // Evento guardado exitosamente
                    println("Evento registrado con éxito.")
                    // Navegar a otra pantalla si es necesario
                    navController.navigate("otroDestino") // Cambiar 'otroDestino' al nombre de la pantalla que desees
                }
                .addOnFailureListener { e ->
                    // Error al guardar
                    println("Error al registrar el evento: $e")
                }
        } else {
            println("Por favor, completa todos los campos.")
        }
    }

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
                // Título de la pantalla
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

                // Formulario para ingresar los datos
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
                                cursorColor = Color.Black
                            )
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
                                cursorColor = Color.Black
                            )
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
                                cursorColor = Color.Black
                            )
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
                                cursorColor = Color.Black
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = Descripcion.value,
                            onValueChange = { Descripcion.value = it },
                            label = { Text(text = "Descripción:") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp)),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0xFF4CAF50),
                                unfocusedBorderColor = Color(0xFFA3D16A),
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                cursorColor = Color.Black
                            )
                        )
                    }
                }

                // Botones de acción
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            registrarEvento() // Llamamos a la función para guardar el evento
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
