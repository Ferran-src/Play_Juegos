package com.example.play_juegos

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun InterfaceNewPlayer(modifier: Modifier){

    var nombreTextField by rememberSaveable { mutableStateOf(" ") }
    var apellidoTextField by rememberSaveable { mutableStateOf(" ") }
    var nickNameTextField by rememberSaveable { mutableStateOf(" ") }
    var phoneTextField by rememberSaveable { mutableStateOf(" ") }
    var mailTextField by rememberSaveable { mutableStateOf(" ") }

    Column(
        modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        //horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row() {
            Image(
                modifier = modifier.size(64.dp)
                    .size(200.dp,40.dp),
                painter = painterResource(R.drawable.account),
                contentDescription = stringResource(R.string.imagen1)

            )

            TextField(
                modifier= modifier,
                value = nombreTextField,
                onValueChange = {nombreTextField = it},
                label = {Text(text ="Nombre",
                    color = Color.Black
                )},
                shape = RoundedCornerShape(16.dp)
            )
        }
        Row() {  }
        Row() {  }
        Row() {  }

    }
}