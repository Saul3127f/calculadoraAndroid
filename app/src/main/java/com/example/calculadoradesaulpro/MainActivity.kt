package com.example.calculadoradesaulpro

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvTemp:TextView
    private lateinit var tvResult:TextView
    private var primerNumero = 0.0
    private var segundoNumero = 0.0
    private var operador = ""
    private var nuevaOperacion = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tvTemp = findViewById<TextView>(R.id.tvTemp)
        tvResult = findViewById<TextView>(R.id.tvResult)
        var signo:Char
        var resultado:Double
        var primerValor:Double
        var segundoValor:Double
        val button0 = findViewById<Button>(R.id.button_0)
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val buttonAt = findViewById<Button>(R.id.buttonAt)
        val buttonSum = findViewById<Button>(R.id.buttonPlus)
        val buttonRest = findViewById<Button>(R.id.buttonRest)
        val buttonMult = findViewById<Button>(R.id.buttonMult)
        val buttonDiv = findViewById<Button>(R.id.buttonDiv)
        val buttonEqu = findViewById<Button>(R.id.buttonEqual)
        val buttonDel = findViewById<Button>(R.id.buttonDel)

        button0.setOnClickListener{juntarValores("0")}
        button1.setOnClickListener{juntarValores("1")}
        button2.setOnClickListener{juntarValores("2")}
        button3.setOnClickListener{juntarValores("3")}
        button4.setOnClickListener{juntarValores("4")}
        button5.setOnClickListener{juntarValores("5")}
        button6.setOnClickListener{juntarValores("6")}
        button7.setOnClickListener{juntarValores("7")}
        button8.setOnClickListener{juntarValores("8")}
        button9.setOnClickListener{juntarValores("9")}
        buttonAt.setOnClickListener{puntoDecimal()}

        buttonSum.setOnClickListener{asignarOperador("+")}
        buttonRest.setOnClickListener{asignarOperador("-")}
        buttonMult.setOnClickListener{asignarOperador("*")}
        buttonDiv.setOnClickListener{asignarOperador("/")}
        buttonDel.setOnClickListener{borrarTodo()}
        buttonEqu.setOnClickListener{calcularResultado()}
    }
    private fun juntarValores(numero:String){
        if(nuevaOperacion){
            tvTemp.text = ""
            nuevaOperacion = false
        }
        tvTemp.text = tvTemp.text.toString() + numero
    }
    private fun asignarOperador(opera:String){
        if(tvTemp.text.isNotEmpty()){
            primerNumero = tvTemp.text.toString().toDouble()
            operador = opera
            tvResult.text = tvTemp.text.toString() +operador
            tvTemp.text = ""
        }
    }
    private fun calcularResultado(){
        if(tvTemp.text.isNotEmpty()){
            segundoNumero = tvTemp.text.toString().toDouble()
            val resultado = when(operador){
                "+" -> primerNumero+segundoNumero
                "-" -> primerNumero-segundoNumero
                "x" -> primerNumero*segundoNumero
                "/" -> primerNumero/segundoNumero
                else-> 0.0
            }
            tvResult.text = resultado.toString()
            nuevaOperacion = true
        }
    }
    private fun puntoDecimal(){
        if(nuevaOperacion){
            tvTemp.text = "0."
            nuevaOperacion = false
        }else if(!tvTemp.text.contains(".")){
            tvTemp.text = tvTemp.text.toString() + "."
        }
    }
    private fun borrarTodo(){
        tvTemp.text = ""
        tvResult.text = ""
        primerNumero = 0.0
        segundoNumero = 0.0
        operador = ""
        nuevaOperacion = true
    }
}