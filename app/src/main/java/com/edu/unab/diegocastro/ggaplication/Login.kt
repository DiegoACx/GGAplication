package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edu.unab.diegocastro.ggaplication.ui.theme.GGAplicationTheme

@Preview
@Composable

fun Login() {
    GGAplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize()
                    .background(color = Color(0xFFA3D16A)),
                verticalArrangement = Arrangement.Center
            ) {


                Card(modifier = Modifier.padding(10.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "LOGIN", Modifier.background(color = Color(0xFFA3D16A))
                        )

                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "ID")
                            }, modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(text = "Password")
                            }, modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(400.dp))

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(Color(0xFFA3D16A))
                        ) {
                            Text(text = "Log In")

                        }

                        //OutlinedButton(onClick = ) {}


                    }
                }

            }

        }
    }

}
