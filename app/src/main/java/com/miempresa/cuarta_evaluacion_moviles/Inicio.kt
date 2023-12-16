package com.miempresa.cuarta_evaluacion_moviles


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController



@Composable
fun Screen1(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFFFF0048), Color(0xFF0800FF))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CONOMETRO",
                color = Color.White,
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = painterResource(id = R.drawable.temporizador),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Button(
            onClick = {
                navController.navigate("pantalla2")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFFFFFFFF), Color(0xFFFFFFFF))
                    )
                )
        ) {
            Text(
                text = "Comenzar",
                color = Color.White
            )
        }
    }
}
