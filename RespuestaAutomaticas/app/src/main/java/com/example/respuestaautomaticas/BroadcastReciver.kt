package com.example.respuestaautomaticas

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.PhoneStateListener
import android.telephony.ServiceState
import android.telephony.SignalStrength
import android.telephony.SmsManager
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService
import com.example.respuestaautomaticas.ViewModel.ViewModelMensaje
import com.example.respuestaautomaticas.ui.Telefono

class BroadcastReciver: BroadcastReceiver() {
    private var mListener: ServiceStateListener? = null
    private var mTelephonyManager: TelephonyManager? = null
    private var mContext: Context? = null

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        mContext = context

        if (action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            mTelephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val ExtraerNumero = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)

            // Envia el mensaje
            if (ExtraerNumero != null) {
                Toast.makeText(
                    mContext,
                    "Numero entrante : ${ExtraerNumero.toString()}",
                    Toast.LENGTH_LONG
                ).show()
                EnviarMensaje(ExtraerNumero)
            }

            Toast.makeText(mContext, "¡Receptor registrado!", Toast.LENGTH_LONG).show()
            mListener = ServiceStateListener()
            mTelephonyManager?.listen(mListener, PhoneStateListener.LISTEN_SERVICE_STATE)/*
            mTelephonyManager?.listen(mListener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)
             */
        }
        Log.d("Llamada detectada","Se detecto")
    }
    private fun EnviarMensaje(numero: String) {
        val smsMensaje = SmsManager.getDefault()
        // Cambiar este mensaje por el que esta escrito en el viewmodel de la caja de texto
        val mensaje = Telefono.Telefono.mensaje
        if (numero==Telefono.Telefono.numero){
            smsMensaje.sendTextMessage(numero,null,mensaje,null,null)
            Log.d("Mensaje Enviado",smsMensaje.toString())
        }

    }
    var connected=false
    // Detecta si el telefono tiene señal
    private inner class ServiceStateListener : PhoneStateListener() {
        override fun onServiceStateChanged(serviceState: ServiceState) {
           // super.onServiceStateChanged(serviceState)
            //var connected = serviceState.state == ServiceState.STATE_IN_SERVICE
            if (connected==false || serviceState.state == ServiceState.STATE_IN_SERVICE){
                connected=true

                if (connected) {
                    Toast.makeText(mContext, "¡Conexión establecida!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(mContext, "¡Conexión perdida!", Toast.LENGTH_LONG).show()
                }
            }


        }

    }
}
