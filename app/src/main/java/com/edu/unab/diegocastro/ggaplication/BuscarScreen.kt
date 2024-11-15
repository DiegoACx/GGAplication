package com.edu.unab.diegocastro.ggaplication

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.tasks.await

data class Eventoss(
    val nombre: String = "",
    val descripcion: String = ""
)

@Composable
fun BuscarScreen(navController: NavController) {
    val db = FirebaseFirestore.getInstance()
    var eventos by remember { mutableStateOf(listOf<Eventoss>()) }
    val searchText = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    var filteredEventos by remember { mutableStateOf(listOf<Eventoss>()) }

    LaunchedEffect(Unit) {
        try {
            val snapshot = db.collection("eventos").get().await()
            eventos = snapshot.toObjects()
            filteredEventos = eventos
        } catch (e: Exception) {
            Toast.makeText(context, "Error al cargar eventos: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1E5CE))
            .padding(16.dp)
    ) {
        Text(
            text = "BUSCAR",
            fontSize = 24.sp,
            color = Color(0xFFA3D16A),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFAED581), shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = searchText.value,
                onValueChange = { newValue ->
                    searchText.value = newValue
                    val searchQuery = newValue.text.trim().lowercase()
                    filteredEventos = if (searchQuery.isEmpty()) {
                        eventos
                    } else {
                        val results = eventos.filter { it.nombre.lowercase().contains(searchQuery) }
                        if (results.isEmpty()) {
                            Toast.makeText(context, "Evento no encontrado", Toast.LENGTH_SHORT).show()
                        }
                        results
                    }
                },
                label = { Text("Buscar actividades, eventos o formularios") },
                leadingIcon = {
                    IconButton(
                        onClick = {
                            val searchQuery = searchText.value.text.trim().lowercase()
                            filteredEventos = eventos.filter { it.nombre.lowercase().contains(searchQuery) }
                            if (filteredEventos.isEmpty()) {
                                Toast.makeText(context, "Evento no encontrado", Toast.LENGTH_SHORT).show()
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp))
                    .border(1.dp, Color(0xFFA3D16A), shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp))
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredEventos) { evento ->
                        BuscarActivityCard(eventName = evento.nombre, eventDescription = evento.descripcion)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    navController.navigate("home") { popUpTo("buscar") { inclusive = true } }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A), contentColor = Color.Black)
            ) {
                Text(text = "ATRAS")
            }
        }
    }
}

@Composable
fun BuscarActivityCard(eventName: String, eventDescription: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = eventName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = eventDescription,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}
