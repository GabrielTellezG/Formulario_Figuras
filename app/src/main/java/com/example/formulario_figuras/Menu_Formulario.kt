package com.example.formulario_figuras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.*

class Menu_Formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_formulario)

        //Inicializando Variables de las imagenes
        val img_cuadrado: ImageView = findViewById<ImageView>(R.id.img_cuadrado)
        val img_circulo: ImageView = findViewById<ImageView>(R.id.img_circulo)
        val img_triangulo: ImageView = findViewById<ImageView>(R.id.img_triangulo)
        val img_rectangulo: ImageView = findViewById<ImageView>(R.id.img_rectangulo)
        val img_pentagono: ImageView = findViewById<ImageView>(R.id.img_pentagono)

        //Inicializando Variables de los EditText
        val txt_ladosCuadrado: EditText = findViewById<EditText>(R.id.txt_ladosCuadrado)
        val txt_radioCirculo: EditText = findViewById<EditText>(R.id.txt_radioCirculo)
        val txt_trianguloLadoA: EditText = findViewById<EditText>(R.id.txt_trianguloLadoA)
        val txt_trianguloLadoB: EditText = findViewById<EditText>(R.id.txt_trianguloLadoB)
        val txt_trianguloLadoC: EditText = findViewById<EditText>(R.id.txt_trianguloLadoC)
        val txt_alturaRec: EditText = findViewById<EditText>(R.id.txt_alturaRec)
        val txt_baseRec: EditText = findViewById<EditText>(R.id.txt_baseRec)
        val txt_ladosPen: EditText = findViewById<EditText>(R.id.txt_ladosPen)
        val txt_apotema: EditText = findViewById<EditText>(R.id.txt_apotema)

        //Inicializando Variables de los botones
        val btn_inicio: Button = findViewById<Button>(R.id.btn_inicio)

        //Método para calcular area y perimetro del cuadrado
        img_cuadrado.setOnClickListener{
            var area:Double = 0.0
            var perimetro:Double = 0.0

            if(txt_ladosCuadrado.text.isEmpty() || txt_ladosCuadrado.text.toString().toDouble() < 0){
                Toast.makeText(this, "Rellena bien los datos", Toast.LENGTH_LONG).show()
            }else{
                val lados = txt_ladosCuadrado.text.toString().toDouble()
                area = lados.pow(2)
                perimetro = lados*4
                Toast.makeText(this, "Área:${area} - Perimetro:${perimetro}", Toast.LENGTH_LONG).show()
            }
        }
        //Método para calcular area y perimetro del circulo
        img_circulo.setOnClickListener{
            var area:Double = 0.0
            var perimetro:Double = 0.0

            if(txt_radioCirculo.text.isEmpty() || txt_radioCirculo.text.toString().toDouble() < 0){
                Toast.makeText(this, "Rellena bien los datos", Toast.LENGTH_LONG).show()
            }else{
                val radio = txt_radioCirculo.text.toString().toDouble()
                area = (3.141592) * (radio.pow(2))
                perimetro = 2 * (3.141592) * radio
                Toast.makeText(this, "Área:${area} - Perimetro:${perimetro}", Toast.LENGTH_LONG).show()
            }
        }

        //Método para calcular area y perimetro del triangulo
        img_triangulo.setOnClickListener{
            var area:Double = 0.0
            var perimetro:Double = 0.0
            var s: Double = 0.0

            if((txt_trianguloLadoA.text.isEmpty() || txt_trianguloLadoA.text.toString().toDouble() < 0) ||
                (txt_trianguloLadoB.text.isEmpty() || txt_trianguloLadoB.text.toString().toDouble() < 0)||
                (txt_trianguloLadoC.text.isEmpty() || txt_trianguloLadoC.text.toString().toDouble() < 0)){
                Toast.makeText(this, "Rellena bien los datos", Toast.LENGTH_LONG).show()
            }else{
                val ladoA = txt_trianguloLadoA.text.toString().toDouble()
                val ladoB = txt_trianguloLadoB.text.toString().toDouble()
                val ladoC = txt_trianguloLadoC.text.toString().toDouble()
                s = (ladoA + ladoB + ladoC) / 2
                area = sqrt(s*(s-ladoA)*(s-ladoB)*(s-ladoC))
                perimetro = ladoA + ladoB + ladoC
                Toast.makeText(this, "Área:${area} - Perimetro:${perimetro}", Toast.LENGTH_LONG).show()
            }
        }
        //Método para calcular area y perimetro del rectangulo
        img_rectangulo.setOnClickListener {
            var area:Double = 0.0
            var perimetro:Double = 0.0

            if((txt_alturaRec.text.isEmpty() || txt_alturaRec.text.toString().toDouble() < 0)||
                (txt_baseRec.text.isEmpty() || txt_baseRec.text.toString().toDouble() < 0)) {
                Toast.makeText(this, "Rellena bien los datos", Toast.LENGTH_LONG).show()
            }else{
                val altura = txt_alturaRec.text.toString().toDouble()
                val base = txt_baseRec.text.toString().toDouble()
                area = (base * altura)
                perimetro = 2*base + 2*altura
                Toast.makeText(this, "Área:${area} - Perimetro:${perimetro}", Toast.LENGTH_LONG).show()
            }
        }
        //Método para calcular area y perimetro del pentagono
        img_pentagono.setOnClickListener {
            var area:Double = 0.0
            var perimetro:Double = 0.0

            if((txt_apotema.text.isEmpty() || txt_apotema.text.toString().toDouble() < 0)||
                (txt_ladosPen.text.isEmpty() || txt_ladosPen.text.toString().toDouble() < 0)) {
                Toast.makeText(this, "Rellena bien los datos", Toast.LENGTH_LONG).show()
            }else{
                val apotema = txt_apotema.text.toString().toDouble()
                val lados = txt_ladosPen.text.toString().toDouble()
                perimetro = 5*lados
                area = (perimetro*apotema) / 2
                Toast.makeText(this, "Área:${area} - Perimetro:${perimetro} ", Toast.LENGTH_LONG).show()
            }
        }
        btn_inicio.setOnClickListener {
            val intent_cambio: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent_cambio)
            this.finish()
        }
    }
}