package com.devgmg.mx.calculadoraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //cadena valores
    private var displayResultado: String? = null

    private var numero1: Long = 0L
    private var numero2: Long = 0L
    private var operacion: String = ""


    //Numeros BTN
    private lateinit var ceroBtn: Button
    private lateinit var unoBtn: Button
    private lateinit var dosBtn: Button
    private lateinit var tresBtn: Button
    private lateinit var cuatroBtn: Button
    private lateinit var cincoBtn: Button
    private lateinit var seisBtn: Button
    private lateinit var sieteBtn: Button
    private lateinit var ochoBtn: Button
    private lateinit var nueveBtn: Button

    //Comandos

    private lateinit var limpiarBtn: Button
    private lateinit var sumaBtn: Button
    private lateinit var restaBtn: Button
    private lateinit var multiplicaBtn: Button
    private lateinit var divideBtn: Button
    private lateinit var igualdadBtn: Button

    //Resulatdo
    private lateinit var resultadoVista: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recargaElementos() //Craga los elementos del la vista

        limpiarBtn.setOnClickListener {
            limpiarCalculadora()
        }


        ceroBtn.setOnClickListener {
            cargarNumeroVista("0")
        }

        unoBtn.setOnClickListener {
            cargarNumeroVista("1")
        }

        dosBtn.setOnClickListener {
            cargarNumeroVista("2")
        }

        tresBtn.setOnClickListener {
            cargarNumeroVista("3")
        }

        cuatroBtn.setOnClickListener {
            cargarNumeroVista("4")
        }
        cincoBtn.setOnClickListener {
            cargarNumeroVista("5")
        }

        seisBtn.setOnClickListener {
            cargarNumeroVista("6")
        }

        sieteBtn.setOnClickListener {
            cargarNumeroVista("7")
        }

        ochoBtn.setOnClickListener {
            cargarNumeroVista("8")
        }

        nueveBtn.setOnClickListener {
            cargarNumeroVista("9")
        }


        //Funciones de operaciones

        sumaBtn.setOnClickListener {
            prepararNumero("+")
        }
        restaBtn.setOnClickListener {
            prepararNumero("-")
        }

        multiplicaBtn.setOnClickListener {
            prepararNumero("*")
        }
        divideBtn.setOnClickListener {
            prepararNumero("/")
        }

        igualdadBtn.setOnClickListener {
            igualdadOperacion()
        }


    }

    private fun recargaElementos() {
        resultadoVista = findViewById(R.id.resultadoViewText)

        ceroBtn = findViewById(R.id.ceroBtn)
        unoBtn = findViewById(R.id.unoBtn)
        dosBtn = findViewById(R.id.dosBtn)
        tresBtn = findViewById(R.id.tresBtn)
        cuatroBtn = findViewById(R.id.cuatroBtn)
        cincoBtn = findViewById(R.id.cincoBtn)
        seisBtn = findViewById(R.id.seisBtn)
        sieteBtn = findViewById(R.id.sieteBtn)
        ochoBtn = findViewById(R.id.ochoBtn)
        nueveBtn = findViewById(R.id.nueveBtn)

        limpiarBtn = findViewById(R.id.limpiaBtn)
        sumaBtn = findViewById(R.id.sumaBtn)
        restaBtn = findViewById(R.id.restaBtn)
        divideBtn = findViewById(R.id.divideBtn)
        multiplicaBtn = findViewById(R.id.multiplicaBtn)
        igualdadBtn = findViewById(R.id.igualBtn)
    }

    private fun limpiarCalculadora() {
        displayResultado = ""
        resultadoVista.text = displayResultado
    }

    private fun cargarNumeroVista(numero: String) {
        resultadoVista.text =
            if (displayResultado.isNullOrBlank() || displayResultado!!.isEmpty()) {
                displayResultado = numero
                displayResultado
            } else {
                displayResultado += numero
                displayResultado
            }
    }

    private fun convertirNumero(): Long {
        return try {
            if (displayResultado.isNullOrBlank() || displayResultado!!.isEmpty()) {
                displayResultado = "0"
                displayResultado?.toLong() ?: 0L
            } else {
                displayResultado?.toLong() ?: 0L
            }
        } catch (exp: Exception) {
            limpiarCalculadora()
            0L
        } finally {
            limpiarCalculadora()
        }
    }

    private fun prepararNumero(simbolo: String) {
        numero1 = convertirNumero()
        operacion = simbolo
        limpiarCalculadora()
    }

    private fun igualdadOperacion() {
        numero2 = convertirNumero()
        limpiarCalculadora()
        when (operacion) {
            "+" -> {
                cargarNumeroVista((numero1 + numero2).toString())
            }
            "-" -> {
                cargarNumeroVista((numero1 - numero2).toString())
            }
            "*" -> {
                cargarNumeroVista((numero1 * numero2).toString())
            }
            "/" -> {
                try {
                    cargarNumeroVista((numero1 / numero2).toString())
                } catch (ex: Exception) {
                    cargarNumeroVista("ERROR")
                }
            }
            else -> {
                cargarNumeroVista("0")
            }
        }
        operacion = ""
        numero1 = 0L
        numero2 = 0L
    }


}