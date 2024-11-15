package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.tasks.await
import androidx.annotation.Keep
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


data class Eventos(
    val nombre: String = "",
    val descripcion: String = ""
)

@Composable
fun HomeScreen(navController: NavController) {
    val db = FirebaseFirestore.getInstance()
    val eventos = remember { mutableStateListOf<Eventos>() }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            val snapshot = db.collection("eventos").get().await()
            eventos.clear()
            eventos.addAll(snapshot.toObjects())
            errorMessage = if (eventos.isEmpty()) "No hay eventos disponibles" else null
        } catch (e: Exception) {
            errorMessage = "Error al cargar eventos: ${e.message}"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1E5CE))
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "INICIO",
            fontSize = 24.sp,
            color = Color(0xFFA3D16A),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Gray, CircleShape)
                .clickable {
                    navController.navigate("cuenta")
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Icono de perfil",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFAED581), RoundedCornerShape(16.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text("ACTIVIDADES", fontSize = 18.sp, color = Color.White)

            Spacer(modifier = Modifier.height(8.dp))

            if (errorMessage != null) {
                Text(
                    text = errorMessage!!,
                    fontSize = 14.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(eventos) { evento ->
                        ActivityCard(eventName = evento.nombre, eventDescription = evento.descripcion)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { navController.navigate("buscar") },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A))
            ) {
                Text("BUSCAR", color = Color.White)
            }

            Button(
                onClick = { navController.navigate("mas") },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A))
            ) {
                Text("MAS", color = Color.White)
            }
        }

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A))
        ) {
            Text("SALIR", color = Color.White)
        }
    }
}

@Composable
fun ActivityCard(eventName: String, eventDescription: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = eventName, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = eventDescription, fontSize = 14.sp, color = Color.DarkGray)
    }
}
