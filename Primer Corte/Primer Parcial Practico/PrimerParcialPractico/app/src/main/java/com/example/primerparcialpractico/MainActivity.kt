package com.example.primerparcialpractico

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagos = listOf(
            mapOf("persona" to "Persona 1 - Casa 1", "estado" to "aprobado"),
            mapOf("persona" to "Persona 2 - Casa 2", "estado" to "aprobado"),
            mapOf("persona" to "Persona 3 - Casa 3", "estado" to "no aprobado"),
            mapOf("persona" to "Persona 4 - Casa 4", "estado" to "no adjuntado"),
            mapOf("persona" to "Persona 3 - Casa 3", "estado" to "no aprobado")
        )

        var pagosAprobadosCount = 0
        var pagosFaltantesCount = 0

        for (pago in pagos) {
            val estado = pago["estado"]
            if (estado == "aprobado") {
                pagosAprobadosCount++
            } else {
                pagosFaltantesCount++
            }
        }

        val btnRevisar1 = findViewById<Button>(R.id.btnRevisar1)
        val btnRevisar2 = findViewById<Button>(R.id.btnRevisar2)

        btnRevisar1.setOnClickListener {
            revisarPago("Persona 1 - Casa 1", pagosAprobadosCount, pagosFaltantesCount)
        }

        btnRevisar2.setOnClickListener {
            revisarPago("Persona 2 - Casa 2", pagosAprobadosCount, pagosFaltantesCount)
        }
    }

    private fun revisarPago(persona: String, aprobados: Int, faltantes: Int) {
        val mensaje = when {
            aprobados > faltantes -> "$persona verificado. Hay más pagos aprobados ($aprobados) que faltantes ($faltantes)."
            aprobados < faltantes -> "$persona verificado. Atención: hay más pagos faltantes ($faltantes) que aprobados ($aprobados)."
            else -> "$persona verificado. Los pagos aprobados y faltantes están en equilibrio."
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}