package com.example.introduction

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class ExercisesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        tEjercicio1()
        tEjercicio2()
        tEjercicio3()
        tEjercicio4()
    }

    private fun tEjercicio1() {
        val etNumero1 = findViewById<EditText>(R.id.etNumero1)
        val etNumero2 = findViewById<EditText>(R.id.etNumero2)
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoSuma)

        btnSumar.setOnClickListener {
            val n1 = etNumero1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = etNumero2.text.toString().toDoubleOrNull() ?: 0.0
            val suma = n1 + n2
            tvResultado.text = "Resultado: $suma"
        }
    }

    private fun tEjercicio2() {
        val etCantidadP = findViewById<EditText>(R.id.etCantidadP)
        val etPago = findViewById<EditText>(R.id.etPago)
        val btnCalcularVenta = findViewById<Button>(R.id.btnCalcularVenta)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val precioProducto = 15000

        btnCalcularVenta.setOnClickListener {
            val cantidad = etCantidadP.text.toString().toIntOrNull() ?: 0
            val pago = etPago.text.toString().toDoubleOrNull() ?: 0.0
            val total = cantidad * precioProducto
            val cambio = pago - total

            if (pago < total) {
                tvResultado.text = "Total: $$total\nFalta dinero: $${total - pago}"
            } else {
                tvResultado.text = "Total: $$total\nCambio: $$cambio"
            }
        }
    }

    private fun tEjercicio3() {
        val etF = findViewById<EditText>(R.id.etF)
        val btnConvertir = findViewById<Button>(R.id.btnConvertirTemp)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoTemp)

        btnConvertir.setOnClickListener {
            val f = etF.text.toString().toDoubleOrNull() ?: 0.0
            val c = ((f - 32) * 5) / 9
            tvResultado.text = "Grados Celsius: $c °C"
        }
    }

    private fun tEjercicio4() {
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularDosis)
        val tvResultado = findViewById<TextView>(R.id.tvResultadoDosis)

        btnCalcular.setOnClickListener {
            val peso = etPeso.text.toString().toDoubleOrNull() ?: 0.0
            val edad = etEdad.text.toString().toIntOrNull() ?: 0
            val dosis = (peso + edad) / 2
            tvResultado.text = "Dosis: $dosis ml"
        }
    }
}
