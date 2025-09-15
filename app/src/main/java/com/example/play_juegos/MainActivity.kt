package com.example.play_juegos

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.play_juegos.ui.theme.Play_JuegosTheme
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Play_JuegosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Portada(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Portada(name: String, modifier: Modifier = Modifier) {
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(
            modifier = modifier
                .size(200.dp)
        )
        Text(
            text = stringResource(R.string.app_name)
        )
        Spacer(
            modifier = modifier
                .size(60.dp)
        )
        FilledButton(stringResource(R.string.boton1))
        FilledButton(stringResource(R.string.boton2))
        FilledButton(stringResource(R.string.boton3))
        FilledButton(stringResource(R.string.boton4))

    }
}
@Composable
fun FilledButton(texto: String) {
    Button(onClick = {},
        modifier = Modifier
            .size(300.dp,80.dp)
            .padding()
            ) {
        Text(texto)

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Play_JuegosTheme {
        Portada("Android")
    }
}