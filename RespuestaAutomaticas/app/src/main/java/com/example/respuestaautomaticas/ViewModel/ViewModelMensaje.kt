package com.example.respuestaautomaticas.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.respuestaautomaticas.ui.Telefono

class ViewModelMensaje ():ViewModel(){
    var Mensaje by mutableStateOf("")
    var Numero by mutableStateOf("")

    fun updateMensaje(value: String){
        Mensaje = value
        Telefono.Telefono.mensaje=value
    }
    fun updateNumero(value: String){
        Numero = value
        Telefono.Telefono.numero=value
    }
}