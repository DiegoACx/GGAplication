package com.edu.unab.diegocastro.ggaplication

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.edu.unab.diegocastro.ggaplication.ui.theme.GGAplicationTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun CuentaScreen(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()
    val context = LocalContext.current

    var nombre by remember { mutableStateOf("Cargando...") }
    var correo by remember { mutableStateOf("Cargando...") }
    var userId by remember { mutableStateOf("Cargando...") }
    var telefono by remember { mutableStateOf("Cargando...") }
    var horasLibres by remember { mutableStateOf("10") } // Valor quemado
    var actividadesInscritas by remember { mutableStateOf("5") } // Valor quemado

    // Cargar los datos del usuario desde Firestore
    LaunchedEffect(Unit) {
        val user = auth.currentUser
        if (user != null) {
            correo = user.email ?: "Correo no disponible"

            // Obtener los datos del usuario desde Firestore
            db.collection("users").document(user.uid).get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        nombre = document.getString("nombre") ?: "Nombre no disponible"
                        telefono = document.getString("telefono") ?: "Teléfono no disponible"
                        userId = document.getString("userId") ?: "ID no disponible" // Obtener el ID personalizado
                    } else {
                        Toast.makeText(context, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Error al cargar los datos", Toast.LENGTH_SHORT).show()
                }
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
                    .background(color = Color(0xFFE1E5CE))
                    .padding(vertical = 32.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "CUENTA",
                    fontSize = 24.sp,
                    color = Color(0xFFA3D16A),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
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
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Nombre:   $nombre")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = "Id:   $userId") // Mostrar el ID personalizado
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = "Correo:   $correo")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = "Teléfono:   $telefono")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = "Horas Libres:   $horasLibres")
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = "Actividades Inscritas:   $actividadesInscritas")
                    }
                }

                Button(
                    onClick = {
                        navController.navigate("home") {
                            popUpTo("cuenta") { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(bottom = 16.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
                ) {
                    Text(
                        text = "SALIR",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}