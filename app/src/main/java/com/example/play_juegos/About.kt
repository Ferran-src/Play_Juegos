package com.example.play_juegos
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun InterfaceAbout(modifier: Modifier){
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(getPeople()) { individual ->
            ItemIndividual(individual, context)

        }
        //TODO usar HorizontalDivider para separar
    }
}

fun getPeople(): List<Individual>{
    return listOf(
        Individual(
            "Marcos",
            1343,
            R.drawable.hornet
        ),
        Individual(
            "Lana",
            989,
            R.drawable.caballeropantuflas
        ),
        Individual(
            "Jose",
            666,
            R.drawable.android
        ),
        Individual(
            "Alberto",
            536,
            R.drawable.android
        ),
        Individual(
            "Luis",
            234,
            R.drawable.android
        ),
        Individual(
            "Miguel",
            1,
            R.drawable.android
        )
    )
}
@Composable
fun ItemIndividual(individual: Individual, context: Context){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(true){
            Toast.makeText(context,"Usuario: ${individual.name}, Puntuacion: ${individual.points}",Toast.LENGTH_LONG).show()
        }) {
        Image(
            painter = painterResource(individual.icon ),
            contentDescription = null,
            Modifier.clip(CircleShape).requiredSize(120.dp)
            )
        Spacer(modifier = Modifier.size(50.dp))
        Column {
            Text( text = individual.name,
                style = MaterialTheme.typography.bodyLarge)
            Text(text =  "Total Points: ${individual.points}",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}