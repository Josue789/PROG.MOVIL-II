package com.example.respuestaautomaticas.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import com.example.respuestaautomaticas.R
import com.example.respuestaautomaticas.ViewModel.ViewModelMensaje
import com.example.respuestaautomaticas.ui.Telefono

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Mensaje(viewModel: ViewModelMensaje){

    Scaffold(
        topBar = {
            Text(

                text = "Contestador personal",
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                textAlign = TextAlign.Center,


            )
        }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
        , contentAlignment = Alignment.Center){
            Column(
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.CenterVertically) // Asegura que la altura del Column se ajuste al contenido y esté centrado verticalmente
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = viewModel.Numero,
                    onValueChange ={viewModel.updateNumero(it)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    label = { Text(text = "Numero de Telefono")},
                    singleLine = true,
                    modifier = Modifier
                        .size(350.dp, 70.dp)
                        .background(Color.Transparent)
                )
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 13.dp, 0.dp, 8.dp)
                )
                OutlinedTextField(
                    value = viewModel.Mensaje,
                    onValueChange ={viewModel.updateMensaje(it)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = { Text(text = "Mensaje de respuesta")},
                    placeholder = { Text(text = "Ingrese el mensaje de respuesta")},
                    modifier = Modifier.fillMaxWidth()
                )
                IconButton(onClick = {
                    Telefono.Telefono.mensaje=viewModel.Mensaje
                    Telefono.Telefono.numero=viewModel.Numero
                },
                    Modifier.fillMaxWidth()) {
                    Row {
                        Text(text = "Guardar")
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "check")
                    }
                }
            }
        }
    }
}
