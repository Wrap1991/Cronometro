package com.miempresa.cuarta_evaluacion_moviles


import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Screen3(navController: NavController, texto: String?) {
    var isPowerOn by remember { mutableStateOf(false) }
    var elapsedTime by remember { mutableStateOf(0L) }

    val countDownTimer = remember {
        object : CountDownTimer(Long.MAX_VALUE, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                elapsedTime += 1000
            }

            override fun onFinish() {
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color.Blue, Color.Red),
                        startX = 0f,
                        endX = 1000f
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Pulse en el botón para comenzar",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = if (isPowerOn) R.drawable.encender else R.drawable.apagar),
                contentDescription = null,
                modifier = Modifier
                    .size(240.dp)
                    .clickable {
                        isPowerOn = !isPowerOn
                        if (isPowerOn) {
                            elapsedTime = 0L
                            countDownTimer.start()
                        } else {
                            countDownTimer.cancel()
                        }
                    }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color.Blue, Color.Red),
                        startX = 0f,
                        endX = 1000f
                    )
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tiempo transcurrido: ${elapsedTime / 1000} segundos",
                color = Color.White,
                fontSize = 36.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                elapsedTime = 0L
                if (isPowerOn) {
                    countDownTimer.start()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color.Blue, Color.Red),
                        startX = 0f,
                        endX = 1000f
                    )
                )
        ) {
            Text(
                text = "Reiniciar",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
