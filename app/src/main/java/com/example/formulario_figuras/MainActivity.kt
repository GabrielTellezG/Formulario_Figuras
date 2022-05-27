package com.example.formulario_figuras

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_menu: Button = findViewById<Button>(R.id.btn_menu)
        val btn_salir: Button = findViewById<Button>(R.id.btn_salir)

        btn_menu.setOnClickListener {
            val intent_cambio: Intent = Intent(this,Menu_Formulario::class.java)
            startActivity(intent_cambio)
            this.finish()
        }
        btn_salir.setOnClickListener {
            finishAffinity()
            System.exit(0)
        }
    }
}