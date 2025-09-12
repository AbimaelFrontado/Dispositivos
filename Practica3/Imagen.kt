/*
Descripción: Actividad principal que muestra una imagen y al hacer clic en ella despliega un Toast.
Abimael Ernesto Frontado Fajardo
Fecha de creación: 09/09/2025
Última modificación: 11/09/2025
*/
package com.abi.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.abi.myapplication.R
import com.abi.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ImagenConToast()
            }
        }
    }
}

@Composable
fun ImagenConToast() {
    val context = LocalContext.current
    Image(
        painter = painterResource(id = R.drawable.perrito), // tu imagen en res/drawable
        contentDescription = "Imagen de perrito",
        modifier = Modifier
            .size(400.dp)
            .clickable {
            Toast.makeText(context, "Tocaste al perrito", Toast.LENGTH_SHORT).show()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun VistaPrevia() {
    MyApplicationTheme {
        ImagenConToast()
    }
}
