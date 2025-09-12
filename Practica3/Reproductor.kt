/*
Descripción: Creando un reproductor simple de música
Abimael Ernesto Frontado Fajardo
Fecha de creación: 11/09/2025
Última modificación: 12/09/2025
*/
package com.abi.myapplication

import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.abi.myapplication.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    ReproductorMusica()
                }
            }
        }
    }
}
@Composable
fun ReproductorMusica() {
    val context = LocalContext.current


    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.cancion)
    }


    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                    Toast.makeText(context, "Reproduciendo...", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Reproducir")
        }

        Button(
            onClick = {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                    Toast.makeText(context, "Pausado", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Pausar")
        }

        Button(
            onClick = {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.stop()
                    mediaPlayer.prepare()
                    Toast.makeText(context, "Detenido", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Detener")
        }
    }
}
