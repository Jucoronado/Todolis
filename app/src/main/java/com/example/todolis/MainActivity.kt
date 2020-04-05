package com.example.todolis

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.io.OutputStreamWriter
import java.util.*

class MainActivity : AppCompatActivity() {

    var n=0
    var arreglo = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val check = findViewById(R.id.b1) as Button
        val texto = findViewById<EditText>(R.id.tex)

        //Mostrar Lista
        listaprincipal()

        //Agregar Lista
        check.setOnClickListener{
          agregar()
            texto.editableText.clear()
        }

        //Borrar Lista
            lista.setOnItemClickListener  { parent, view, i, id ->
            borrar(i)
        }

    }


    companion object {
        const val FILE_NAME = "bd.txt"
    }

    fun listaprincipal() {

            val scanner = Scanner(resources.openRawResource(R.raw.dic))
            while (scanner.hasNextLine()) {
                arreglo.add(scanner.nextLine())
            }
            scanner.close()

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo)
         lista.adapter = adapter

        adapter?.notifyDataSetChanged()
         }

        fun agregar() {
            arreglo.add(tex.text.toString()+"\n")
            val archivo = OutputStreamWriter(openFileOutput("dic.txt", Context.MODE_APPEND))
            archivo.write(tex.text.toString())
            archivo.flush()
            archivo.close()

    }

        fun borrar(i: Int){
            arreglo.removeAt(i)

                           }
    }


