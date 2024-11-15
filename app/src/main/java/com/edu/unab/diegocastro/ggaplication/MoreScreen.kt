package com.edu.unab.diegocastro.ggaplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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

data class Evento(
    val nombre: String = "",
    val descripcion: String = ""
)

@Composable
fun MoreScreen(navController: NavController) {
    val db = FirebaseFirestore.getInstance()
    val eventos = remember { mutableStateListOf<Evento>() }

    LaunchedEffect(Unit) {
        db.collection("eventos")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    // Mostrar un error o registrar el error
                    Log.d("Firebase", "Error al cargar eventos: ${error.message}")
                } else if (snapshot != null) {
                    eventos.clear()
                    eventos.addAll(snapshot.toObjects())
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1E5CE))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "MAS",
            fontSize = 24.sp,
            color = Color(0xFFA3D16A),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFAED581), RoundedCornerShape(16.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        navController.navigate("crearevento") { popUpTo("more") { inclusive = true } }
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("CREAR EVENTO", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            eventos.forEach { evento ->
                EventCard(
                    navController = navController,
                    eventTitle = evento.nombre,
                    eventDescription = evento.descripcion
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = {
                navController.navigate("home") {
                    popUpTo("more") { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A))
        ) {
            Text("SALIR", color = Color.White)
        }
    }
}

@Composable
fun EventCard(navController: NavController, eventTitle: String, eventDescription: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD6E6A7), RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = eventTitle, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = eventDescription, fontSize = 14.sp, color = Color.DarkGray)

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                try {
                    navController.navigate("actividades") {
                        popUpTo("more") { inclusive = true }
                    }
                } catch (e: Exception) {
                    Log.d("Navigation", "Error al navegar a actividades: ${e.message}")
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("SELECCIONAR", color = Color.White)
        }
    }
}
