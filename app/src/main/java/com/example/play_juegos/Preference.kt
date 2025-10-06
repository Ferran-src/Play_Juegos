package com.example.play_juegos

import android.widget.Toast
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FilterChip

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun Interfacepreference(modifier: Modifier) {
    val radioButtonValues = listOf(stringResource(R.string.Persona4RadioButton),
        stringResource(R.string.Persona5RoyalRadioButton)
        ,stringResource(R.string.Persona3ReloadRadioButton),
        stringResource(R.string.MetaphorReFantazioRadioButton),
        stringResource(R.string.ShinMegamiTenseiVengeanceRadioButton),
        stringResource(R.string.EtrianOdysseyNexusRadioButton)
        ,stringResource(R.string.SoulHackers2RadioButton))

    val plataformas = listOf(
        "PS5",
        "XBOX X",
        "3DS",
        "PS4",
        "Steam Deck"
    )
    var plataformaSeleccionada by rememberSaveable { mutableStateOf("") }
    var estadoRadio by rememberSaveable { mutableStateOf("") }
    var selection by rememberSaveable { mutableStateOf(5f) }
    var rating by rememberSaveable { mutableStateOf(2.5f) }

    val context = LocalContext.current


    Box(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState())
    ) {
        Column(

        )
         {
            Spacer(modifier = Modifier.size(50.dp))

            Text(
                text = "Seleccione una opcion",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium

            )
            Spacer(modifier = Modifier.size(50.dp))
            for (i in radioButtonValues) {
                Row {
                    CreateRadioButton(i, estadoRadio) { estadoRadio = i }

                    Text(i)
                }
            }

            Spacer(modifier = Modifier.size(50.dp))

            val range = 0f..10f
            Slider(
                value = selection,
                valueRange = range,
                onValueChange = { selection = it},
                steps = 9,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.primary
                )
            )
             FlowRow(
                 horizontalArrangement = Arrangement.spacedBy(4.dp),
                 verticalArrangement = Arrangement.spacedBy(4.dp)
             ) {
                 plataformas.forEach { plataforma ->
                     FilterChip(
                         selected = plataformaSeleccionada == plataforma,
                         onClick = {
                             plataformaSeleccionada = plataforma
                             Toast.makeText(context,
                                 "Plataforma seleccionada: $plataformaSeleccionada",
                                 Toast.LENGTH_LONG).show()
                         },
                         label = {
                             Row {
                                 if (plataformaSeleccionada == plataforma) {
                                     Icon(
                                         painter =painterResource(R.drawable.check),
                                         contentDescription = "Seleccionado",
                                         modifier = Modifier.size(16.dp) // Tamaño del icono
                                     )
                                 }
                                 Text(plataforma)
                             }
                         }
                     )
                 }
             }
             RatingBar(rating = rating, onRatingChanged = {newrating -> rating = newrating})
        }
            FloatingActionButton(
                onClick = { Toast.makeText(context,
                    if(estadoRadio.equals("")){"No se ha marcado nada"}
                    else {"Se ha marcado $estadoRadio con una puntuacion de $selection"},
                    Toast.LENGTH_LONG).show()},

                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.BottomEnd)
                    .padding(10.dp)
            ){
              Icon(
                  painter = painterResource(id = R.drawable.check),
                  contentDescription = "add"
              )
            }

    }
}
@Composable
fun CreateRadioButton(opcion: String, estadoRadio: String, onValueChange: (String) -> Unit){
    return RadioButton(
        onClick = {onValueChange(opcion)},
        selected = opcion  == estadoRadio,
        enabled = true,
        colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.tertiary )
    )
}

@Composable
fun RatingBar(
    rating: Float,
    maxRating: Int = 10,
    onRatingChanged: (Float) -> Unit
) {
    Row {
        for (i in 1..maxRating) {
            IconButton(onClick = { onRatingChanged(i.toFloat()) }) {
                Icon(
                painter =  painterResource(if (i <= rating)R.drawable.star else R.drawable.star),
                    contentDescription = null,
                    tint = Color.Yellow
                )
            }
        }
    }
}