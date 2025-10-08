package com.example.play_juegos

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun InterfaceGame(modifier: Modifier) {
    val checkBoxValues = listOf(
        stringResource(R.string.Persona4RadioButton),
        stringResource(R.string.Persona5RoyalRadioButton),
        stringResource(R.string.Persona3ReloadRadioButton),
        stringResource(R.string.MetaphorReFantazioRadioButton),
        stringResource(R.string.ShinMegamiTenseiVengeanceRadioButton),
        stringResource(R.string.EtrianOdysseyNexusRadioButton),
        stringResource(R.string.SoulHackers2RadioButton)
    )
    val checkBoxImages = listOf(painterResource(R.drawable.persona4logo),
        painterResource(R.drawable.persona5logo),
        painterResource(R.drawable.persona3logo),
        painterResource(R.drawable.metaphorlogo),
        painterResource(R.drawable.smtvvlogo),
        painterResource(R.drawable.etryan),
        painterResource(R.drawable.soulshakerslogo),

        )
    val context = LocalContext.current


    val checkBoxes = getOptions(checkBoxValues,checkBoxImages)
    Box(modifier = modifier.background(MaterialTheme.colorScheme.primaryContainer)
        .fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(top = 15.dp)
        ) {
            for (i in checkBoxes) {
                FlowRow {
                    Image(
                        painter = i.image,
                        contentDescription = "",
                        modifier = Modifier.requiredSize(100.dp,70.dp)
                    )
                    MyCheckBox(i)
                }
            }
        }
        FloatingActionButton(
            onClick = {
                val objectsSelected = mutableListOf<String>()
                for (i in checkBoxes) {
                    if (i.selected) objectsSelected.add(i.title)
                }
              //  if (objectsSelected.size >= 2){
               //     objectsSelected.add(objectsSelected.size-1, "y")
              //  }
                Toast.makeText(
                    context,
                    if (objectsSelected.isEmpty()) {
                        "No se ha marcado ninguna opcion"
                    } else {
                        "Juegos marcados: ${objectsSelected.joinToString()} "
                    },
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier.align(Alignment.BottomEnd).padding(20.dp),
            shape = CircleShape,
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "add"
            )
        }
    }
}

@Composable
fun getOptions(titles: List<String>, images: List<Painter>): List<CheckInfo> {
    var i = -1
    return titles.map {
        i++
        var estadoCheck by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            image = images[i],
            selected = estadoCheck,
            onCheckedChange = { estadoCheck = it }
        )
    }
}

@Composable
fun MyCheckBox(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {
                checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text =checkInfo.title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}