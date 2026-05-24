package com.example.gonzalezpau_androidstudio_act18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val recycler = findViewById<RecyclerView>(R.id.recyclerSummary)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnConfirm = findViewById<Button>(R.id.btnConfirm)

        val products = intent.getParcelableArrayListExtra<Producte>("products") ?: arrayListOf()

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = AdaptadorSummary(products)

        btnBack.setOnClickListener {
            finish()
        }

        btnConfirm.setOnClickListener {
            val missatge = buildString {
                append("Productes comprats:\n\n")
                products.forEach {
                    append("${it.nom} x${it.quantitat}\n")
                }
            }

            AlertDialog.Builder(this)
                .setTitle("Compra realitzada")
                .setMessage(missatge)
                .setPositiveButton("OK", null)
                .show()
        }
    }
}