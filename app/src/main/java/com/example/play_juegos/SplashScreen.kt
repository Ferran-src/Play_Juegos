package com.example.play_juegos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onTimeout: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        delay(3000)
        onTimeout()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            painter = painterResource(id = R.drawable.logoaplicacionremovebgpreview), // Tu logo
            contentDescription = null,
            modifier = Modifier.size(220.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.BottomEnd)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = "Made By",
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = "Ferran Campos Iniesta",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 15.dp)
            )
        }
    }
}