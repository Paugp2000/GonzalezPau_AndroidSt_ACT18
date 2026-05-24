package com.example.gonzalezpau_androidstudio_act18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AdaptadorProducte
    private lateinit var txtTotal : TextView
    private val productesLlista = listOf(
        Producte("Poma", 2.80, R.drawable.poma),
        Producte("Pera", 3.40, R.drawable.pera),
        Producte("Platan", 1.80, R.drawable.platan),
        Producte("Raïm", 3.99, R.drawable.raim)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txtTotal = findViewById(R.id.txtTotal)
        val recycler = findViewById<RecyclerView>(R.id.recyclerProducts)
        val btnContinue = findViewById<Button>(R.id.btnContinue)

        adapter = AdaptadorProducte(productesLlista) {
            updateTotal()
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter


        btnContinue.setOnClickListener {
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putParcelableArrayListExtra(
                "products",
                ArrayList(productesLlista.filter { it.quantitat > 0 })
            )
            startActivity(intent)
        }


        updateTotal()
    }

    private fun updateTotal() {
        val total = productesLlista.sumOf { it.preu * it.quantitat }
        txtTotal.text = "Total: %.2f €".format(total)
    }
}