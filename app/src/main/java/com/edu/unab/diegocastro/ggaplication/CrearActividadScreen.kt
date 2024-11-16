package com.edu.unab.diegocastro.ggaplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun CrearActividadScreen(navController: NavController, eventTitle: String) {
    val db = FirebaseFirestore.getInstance()
    var nombreActividad by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFE1E5CE))
    ) {
        Text(
            text = "Crear Actividad para $eventTitle",
            fontSize = 24.sp,
            color = Color(0xFFA3D16A),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nombreActividad,
            onValueChange = { nombreActividad = it },
            label = { Text("Nombre de la Actividad") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nombreActividad.isNotEmpty()) {
                    val actividadData = mapOf(
                        "nombre" to nombreActividad,
                        "evento" to eventTitle
                    )
                    db.collection("actividades")
                        .add(actividadData)
                        .addOnSuccessListener {
                            Log.d("Firebase", "Actividad creada exitosamente")
                            navController.popBackStack()
                        }
                        .addOnFailureListener { e ->
                            Log.d("Firebase", "Error al crear actividad: ${e.message}")
                        }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
        ) {
            Text(text = "Guardar Actividad", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE57373))
        ) {
            Text(text = "Cancelar", color = Color.White)
        }
    }
}
