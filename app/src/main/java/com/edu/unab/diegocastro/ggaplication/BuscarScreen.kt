package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edu.unab.diegocastro.ggaplication.ui.theme.GGAplicationTheme

@Preview
@Composable

fun BuscarScreen() {
    GGAplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerpadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color(0x95FFFFFF)),
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
                Text(
                    text = "Buscar",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(vertical = 16.dp),
                    textAlign = TextAlign.Right
                )

                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text("Categorias", fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .width(250.dp)
                            .height(150.dp)
                            .background(Color.White)
                    )
                }

                Spacer(modifier = Modifier.height(220.dp))

                Column { Row(
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
                        Text("Atras", color = Color.White)
                    }
                } }
            }
        }
    }
}