package com.example.play_juegos

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Play_JuegosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Portada"){
                        composable("Portada"){ElegirPortada(Modifier.padding(innerPadding),navController)}
                        composable("NewPlayer"){InterfaceNewPlayer()}
                    }

                }
            }
        }
    }
}

@Composable
fun ElegirPortada(modifier: Modifier, navController : NavController){
    when(LocalConfiguration.current.orientation) {
        ORIENTATION_LANDSCAPE -> PortadaLandscape(
            modifier = modifier)


        else ->  Portada(
            modifier = modifier,
            navController=navController

        )
    }
}

@Composable
fun Portada(modifier: Modifier = Modifier, navController: NavController) {
    Column (
        Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(
            modifier = modifier
                .size(200.dp)
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge

        )
        Spacer(
            modifier = modifier
                .size(30.dp)
        )
        FilledButton(stringResource(R.string.boton1))
        FilledActionableButton(stringResource(R.string.boton2),navController,"NewPlayer")
        FilledButton(stringResource(R.string.boton3))
        FilledButton(stringResource(R.string.boton4))

    }
}

@Composable
fun PortadaLandscape(modifier: Modifier) {

        Column(
            Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = modifier
                    .size(25.dp)
            )
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.titleLarge

            )
            Spacer(
                modifier = modifier
                    .size(10.dp)
            )
            Row {
                FilledButton(stringResource(R.string.boton1))
                FilledButton(stringResource(R.string.boton2))
            }
            Row {
                FilledButton(stringResource(R.string.boton3))
                FilledButton(stringResource(R.string.boton4))
            }

        }
    }
@Composable
fun FilledButton(texto: String) {
    Button(onClick = {},
        modifier = Modifier
            .size(300.dp,80.dp)
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary )
            ) {
        Text(texto)

    }
}
@Composable
fun FilledActionableButton(texto: String, navController: NavController, ruta:String) {
    Button(onClick = {navController.navigate(ruta)},
        modifier = Modifier
            .size(300.dp,80.dp)
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary )
    ) {
        Text(texto)

    }
}
