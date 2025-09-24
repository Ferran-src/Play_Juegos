 package com.example.play_juegos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
    val rowAligment = 64.dp
    var nombreTextField by rememberSaveable { mutableStateOf(" ") }
    var apellidoTextField by rememberSaveable { mutableStateOf(" ") }
    var nickNameTextField by rememberSaveable { mutableStateOf(" ") }
    var phoneTextField by rememberSaveable { mutableStateOf(" ") }
    var mailTextField by rememberSaveable { mutableStateOf(" ") }

    Column(
        modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row() {
            Image(
                modifier = modifier.size(64.dp)
                    .size(200.dp,40.dp),
                painter = painterResource(R.drawable.account),
                contentDescription = stringResource(R.string.imagen1)

            )

            CreateTextField(nombreTextField,
                stringResource(R.string.NewPlayerTextFieldName),
                modifier,
                onValueChange ={nombreTextField = it})
        }
        Row {
            Spacer(modifier = modifier.size(rowAligment,0.dp))
            CreateTextField(
                apellidoTextField,
                stringResource(R.string.NewPlayerTextFieldLastName),
                modifier,
                onValueChange = { apellidoTextField = it })
        }
        Row {
            Spacer(modifier = modifier.size(rowAligment,0.dp))

            CreateTextField(
                nickNameTextField,
                stringResource(R.string.NewPlayerTextFieldNickName),
                modifier,
                onValueChange = { nickNameTextField = it })
        }


        Row() {
            Spacer(modifier = modifier.size(rowAligment,0.dp))

            Image(
                modifier = modifier.size(80.dp)
                    .size(200.dp,40.dp),
                painter = painterResource(R.drawable.android),
                contentDescription = stringResource(R.string.imagen1)

            )
            Button(onClick = {},
                modifier = Modifier
                    .size(180.dp,100.dp)
                    .padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary )
            ) {
                Text(stringResource(R.string.NewPlayerButtonChange))
            }
        }
        Row() {
            Image(
                modifier = modifier.size(64.dp)
                    .size(200.dp,40.dp),
                painter = painterResource(R.drawable.phone),
                contentDescription = stringResource(R.string.imagen1)

            )

            CreateTextField(phoneTextField,
                stringResource(R.string.NewPlayerTextFieldPhone),
                modifier,
                onValueChange ={phoneTextField = it})

        }
        Row() {
            Image(
                modifier = modifier.size(64.dp)
                    .size(200.dp,40.dp),
                painter = painterResource(R.drawable.gmail),
                contentDescription = stringResource(R.string.imagen1)

            )

            CreateTextField(mailTextField,
                stringResource(R.string.NewPlayerTextFieldPhone),
                modifier,
                onValueChange ={mailTextField = it})

        }

    }
}
 @Composable
fun CreateTextField(variable: String, texto: String,
                    modifier: Modifier,
                    onValueChange: (String) -> Unit){

    TextField(
        modifier= modifier.padding(vertical = 2.dp),
        value = variable,
        onValueChange = onValueChange,
        label = {Text(text =texto,
            color = Color.Black
        )},
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
            focusedContainerColor = MaterialTheme.colorScheme.secondary,
            focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
            unfocusedIndicatorColor = Color.Transparent)
    )
}