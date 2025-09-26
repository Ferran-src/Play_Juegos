package com.example.play_juegos

import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
@Composable
fun Interfacepreference(modifier: Modifier) {
    var persona4RadioButtonSelected by rememberSaveable { mutableStateOf("") }
    var persona5RoyalRadioButtonSelected by rememberSaveable { mutableStateOf("") }
    var metaphorReFantazioRadioButtonSelected by rememberSaveable { mutableStateOf("") }
    var shinMegamiTenseiVengeanceRadioButtonSelected by rememberSaveable { mutableStateOf("") }
    var persona3ReloadRadioButtonSelected by rememberSaveable { mutableStateOf("") }
    var etrianOdysseyNexusRadioButtonSelected by rememberSaveable { mutableStateOf("") }
    var soulHackers2RadioButtonSelected by rememberSaveable { mutableStateOf("") }
    Box(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState())
    ) {
        //TODO cambiar el metodo por un for iterativo que vaya generando los button
        Column(

        ) {
            Text(
                text = "Seleccione una opcion",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium

            )
            Spacer(modifier = Modifier.size(50.dp))
            Row {
                CreateRadioButton(
                    stringResource(R.string.Persona4RadioButton),
                    persona4RadioButtonSelected,
                    onValueChange = { persona4RadioButtonSelected = it }
                )
                Text(stringResource(R.string.Persona4RadioButton))
            }

            Row {
                CreateRadioButton(
                    stringResource(R.string.SoulHackers2RadioButton),
                    soulHackers2RadioButtonSelected,
                    onValueChange = { soulHackers2RadioButtonSelected }
                )
                Text(stringResource(R.string.SoulHackers2RadioButton))
            }
            Row {
                CreateRadioButton(
                    stringResource(R.string.EtrianOdysseyNexusRadioButton),
                    etrianOdysseyNexusRadioButtonSelected,
                    onValueChange = { etrianOdysseyNexusRadioButtonSelected }
                )
                Text(stringResource(R.string.EtrianOdysseyNexusRadioButton))
            }
            Row {
                CreateRadioButton(
                    stringResource(R.string.ShinMegamiTenseiVengeanceRadioButton),
                    shinMegamiTenseiVengeanceRadioButtonSelected,
                    onValueChange = { shinMegamiTenseiVengeanceRadioButtonSelected }
                )
                Text(stringResource(R.string.ShinMegamiTenseiVengeanceRadioButton))
            }
            Row {
                CreateRadioButton(
                    stringResource(R.string.MetaphorReFantazioRadioButton),
                    metaphorReFantazioRadioButtonSelected,
                    onValueChange = { metaphorReFantazioRadioButtonSelected }
                )
                Text(stringResource(R.string.MetaphorReFantazioRadioButton))
            }
            Row {
                CreateRadioButton(
                    stringResource(R.string.Persona3ReloadRadioButton),
                    persona3ReloadRadioButtonSelected,
                    onValueChange = {persona3ReloadRadioButtonSelected}
                    )
                Text(stringResource(R.string.Persona3ReloadRadioButton))
            }
            Row {
                CreateRadioButton(
                    stringResource(R.string.Persona5RoyalRadioButton),
                    persona5RoyalRadioButtonSelected,
                    onValueChange = {persona5RoyalRadioButtonSelected}
                    )
                Text(stringResource(R.string.Persona5RoyalRadioButton))
            }
        }
    }
}
@Composable
fun CreateRadioButton(opcion: String, variable: String, onValueChange: (String) -> Unit){
    return RadioButton(
        onClick = {onValueChange},
        selected = (opcion  == variable),
        modifier = Modifier,
        enabled = true,
        colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.tertiary)
    )
}