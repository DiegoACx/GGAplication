package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun Actividades(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE1E5CE))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE1E5CE), shape = RoundedCornerShape(topStart = 16.dp))
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0xFFE1E5CE), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {navController.navigate("mas") {popUpTo("actividades"){inclusive = true}} }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Salir",
                        tint = Color.Black
                    )
                }

            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "ACTIVIDADES",
                fontSize = 24.sp,
                color = Color(0xFFA3D16A),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFFAED581), shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF8CC663), RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "ACTIVIDADES DISPONIBLES",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFAED581), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                ActivityCard(navController = navController, activityName = "Actividad 1")
                Spacer(modifier = Modifier.height(8.dp))

                ActivityCard(navController = navController, activityName = "Actividad 2")
                Spacer(modifier = Modifier.height(8.dp))


                ActivityCard(navController = navController, activityName = "Actividad 3")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {navController.navigate("inscritas") {popUpTo("actividades"){inclusive = true}} },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
        ) {
            Text(text = "INSCRITAS")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {navController.navigate("estado") {popUpTo("actividades"){inclusive = true}} },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A))
        ) {
            Text(text = "ESTADO DE ACTIVIDADES")
        }
    }
}

@Composable
fun ActivityCard(navController: NavController,activityName: String) {
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

            Button(
                onClick = {
                    navController.navigate("actividad") {
                        popUpTo("actividades") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3D16A)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "VER ACTIVIDAD")
            }
        }
    }
}