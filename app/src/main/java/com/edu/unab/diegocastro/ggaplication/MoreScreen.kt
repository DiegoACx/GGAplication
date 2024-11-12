package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun MoreScreen(navController: NavController) {
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
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("CREAR EVENTO", color = Color.White)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("CREAR FORMULARIO", color = Color.White, textAlign = TextAlign.Center)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            EventCard(navController = navController, eventTitle = "Evento 1", eventDescription = "Descripción Evento 1")
            Spacer(modifier = Modifier.height(8.dp))
            EventCard(navController = navController, eventTitle = "Evento 2", eventDescription = "Descripción Evento 2")
            Spacer(modifier = Modifier.height(8.dp))
            EventCard(navController = navController, eventTitle = "Evento 3", eventDescription = "Descripción Evento 3")


            Spacer(modifier = Modifier.height(16.dp))



        }


        Button(
            onClick = {navController.navigate("home")},
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
fun EventCard(navController: NavController,eventTitle: String, eventDescription: String) {
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
            onClick = {navController.navigate("actividades")},
            colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("SELECCIONAR", color = Color.White)
        }
    }
}