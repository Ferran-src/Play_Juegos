 package com.example.play_juegos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun InterfaceNewPlayer(modifier: Modifier){
    val rowAligment = 64.dp
    var campoNombre by remember {  mutableStateOf(false)}
    var campoNickname by remember {  mutableStateOf(false)}

    var nombreTextField by rememberSaveable { mutableStateOf(" ") }
    var apellidoTextField by rememberSaveable { mutableStateOf(" ") }
    var nickNameTextField by rememberSaveable { mutableStateOf(" ") }
    var phoneTextField by rememberSaveable { mutableStateOf(" ") }
    var mailTextField by rememberSaveable { mutableStateOf(" ") }
    val modifier: Modifier = Modifier
    Column(
        Modifier
            .fillMaxSize()
            .padding(0.dp,20.dp,0.dp,0.dp)
            .background(MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)

    ){
        Column {
            Row() {
                Image(
                    modifier = Modifier
                        .size(64.dp)
                        .size(200.dp, 40.dp),
                    painter = painterResource(R.drawable.account),
                    contentDescription = stringResource(R.string.imagen1)

                )

                CreateTextField(
                    nombreTextField,
                    stringResource(R.string.NewPlayerTextFieldName),
                    modifier,
                    onValueChange = { nombreTextField = it }
                )
            }
            Text(
                text = if (campoNombre) "Error: Campo obligatorio" else "",
                color = MaterialTheme.colorScheme.error
            )
        }
        Row {
            CreateTextField(
                apellidoTextField,
                stringResource(R.string.NewPlayerTextFieldLastName),
                modifier.padding(64.dp,0.dp,0.dp,0.dp),
                onValueChange = { apellidoTextField = it })
        }
        Column {
            Row {
                Spacer(modifier = modifier.size(rowAligment, 0.dp))

                CreateTextField(
                    nickNameTextField,
                    stringResource(R.string.NewPlayerTextFieldNickName),
                    modifier,
                    onValueChange = { nickNameTextField = it })
            }
            Text(
                text = if (campoNickname) "Error: Campo obligatorio" else "",
                color = MaterialTheme.colorScheme.error
            )
        }


        Row() {
            Spacer(modifier = modifier.size(rowAligment,0.dp))

            Image(
                modifier = modifier
                    .size(80.dp)
                    .size(200.dp, 40.dp),
                painter = painterResource(R.drawable.android),
                contentDescription = stringResource(R.string.imagen1)

            )
            Button(onClick = {
                campoNombre = nombreTextField.isBlank()
                campoNickname = nickNameTextField.isBlank()
            },
                modifier = Modifier
                    .size(180.dp, 100.dp)
                    .padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary )
            ) {
                Text(stringResource(R.string.Change))
            }
        }
        Row() {
            Image(
                modifier = modifier
                    .size(64.dp)
                    .size(200.dp, 40.dp),
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
                modifier = modifier
                    .size(64.dp)
                    .size(200.dp, 40.dp),
                painter = painterResource(R.drawable.gmail),
                contentDescription = stringResource(R.string.imagen1)

            )

            CreateTextField(mailTextField,
                stringResource(R.string.NewPlayerTextFieldPhone),
                modifier,
                onValueChange ={mailTextField = it})

        }
        Button(onClick = {
            campoNombre = nombreTextField.isBlank()
            campoNickname = nickNameTextField.isBlank()
        },
            modifier = Modifier
                .size(180.dp, 100.dp)
                .padding(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary )
        ) {
            Text(stringResource(R.string.NewPlayerButtonChange))
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