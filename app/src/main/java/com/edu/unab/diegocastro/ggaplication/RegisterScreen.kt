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
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var registerError by remember { mutableStateOf<String?>(null) }

    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()
    val context = LocalContext.current

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
                    text = "REGISTER",
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
                            value = username,
                            onValueChange = { username = it },
                            label = { Text(text = "Nombre de usuario") },
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
                            value = email,
                            onValueChange = { email = it },
                            label = { Text(text = "Correo Electrónico") },
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
                            value = telefono,
                            onValueChange = { telefono = it },
                            label = { Text(text = "Teléfono") },
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
                            value = password,
                            onValueChange = { password = it },
                            label = { Text(text = "Contraseña") },
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
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text(text = "Confirmar Contraseña") },
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

                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            if (username.isEmpty() || email.isEmpty() || telefono.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                                Toast.makeText(context, "Llene todos los campos", Toast.LENGTH_SHORT).show()
                            } else {
                                if (password == confirmPassword) {
                                    registerError = null
                                    auth.createUserWithEmailAndPassword(email, password)
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful) {
                                                val user = auth.currentUser
                                                val newUser = hashMapOf(
                                                    "nombre" to username,
                                                    "correo" to email,
                                                    "telefono" to telefono
                                                )
                                                db.collection("users").document(user!!.uid).set(newUser)
                                                    .addOnSuccessListener {
                                                        Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                                                        navController.navigate("login")
                                                    }
                                                    .addOnFailureListener {
                                                        Toast.makeText(context, "Error al guardar en Firestore", Toast.LENGTH_SHORT).show()
                                                    }
                                            } else {
                                                Toast.makeText(context, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                } else {
                                    registerError = "Las contraseñas no coinciden"
                                    Toast.makeText(context, registerError, Toast.LENGTH_SHORT).show()
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1AC48D))
                    ) {
                        Text(
                            text = "CREAR",
                            color = Color(0xFFA3D16A),
                            fontSize = 18.sp
                        )
                    }

                    Button(
                        onClick = {
                            navController.navigate("login") {
                                popUpTo("register") { inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
                    ) {
                        Text(
                            text = "Cancel",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

