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



@Composable
fun Actividades(navController: NavController, eventTitle: String) {
    val db = FirebaseFirestore.getInstance()
    val actividades = remember { mutableStateListOf<Pair<String, String>>() }

    LaunchedEffect(Unit) {
        db.collection("actividades")
            .whereEqualTo("evento", eventTitle)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.d("Firebase", "Error al cargar actividades: ${error.message}")
                } else if (snapshot != null) {
                    actividades.clear()
                    snapshot.documents.forEach { doc ->
                        val id = doc.id
                        val nombre = doc.getString("nombre") ?: ""
                        actividades.add(id to nombre)
                    }
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1E5CE))
            .padding(16.dp)
    ) {
        Text(
            text = "ACTIVIDADES DE $eventTitle",
            fontSize = 24.sp,
            color = Color(0xFFA3D16A),
            modifier = Modifier.fillMaxWidth(),
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
            if (actividades.isEmpty()) {
                Text(
                    text = "No hay actividades para este evento.",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                actividades.forEach { (id, nombre) ->
                    ActivityCard(
                        navController = navController,
                        activityName = nombre,
                        onDeleteClick = { deleteActivity(db, id, actividades) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("crear_actividad/$eventTitle") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
        ) {
            Text(text = "CREAR ACTIVIDAD", color = Color.White)
        }
    }
}

@Composable
fun ActivityCard(
    navController: NavController,
    activityName: String,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD6E6A7), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = activityName,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        navController.navigate("actividad") {
                            popUpTo("actividades") { inclusive = true }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
                ) {
                    Text(text = "VER ACTIVIDAD", color = Color.White)
                }

                Button(
                    onClick = onDeleteClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE57373))
                ) {
                    Text(text = "ELIMINAR", color = Color.White)
                }
            }
        }
    }
}

fun deleteActivity(db: FirebaseFirestore, id: String, actividades: MutableList<Pair<String, String>>) {
    db.collection("actividades").document(id)
        .delete()
        .addOnSuccessListener {
            Log.d("Firebase", "Actividad eliminada exitosamente")
            actividades.removeAll { it.first == id }
        }
        .addOnFailureListener { e ->
            Log.d("Firebase", "Error al eliminar actividad: ${e.message}")
        }
}

