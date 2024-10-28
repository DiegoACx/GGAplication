package com.edu.unab.diegocastro.ggaplication

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable

fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0x95FFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "INICIO",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()

                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Gray, CircleShape),
            contentAlignment = Alignment.Center
        ){
            Text("fotoPrfl", color = Color.White)
        }

        Column(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text("ACTIVIDADES", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(150.dp)
                    .background(Color.White)
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),

                ) {
                Text("BUSCAR", color = Color.White)
            }

            Button(
                onClick = {},
                modifier = Modifier.weight(1f),

                ) {
                Text("MAS", color = Color.White)
            }
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text("FORMULARIOS", color = Color.White)

        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ){
            Text("SALIR", color = Color.White)
        }
    }


}