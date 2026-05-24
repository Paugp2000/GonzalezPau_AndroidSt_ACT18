package com.example.gonzalezpau_androidstudio_act18

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorSummary(private val products: List<Producte>)
    : RecyclerView.Adapter<AdaptadorSummary.SummaryVH>() {

    inner class SummaryVH(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txtName)
        val qty = view.findViewById<TextView>(R.id.txtQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryVH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_summary, parent, false)
        return SummaryVH(v)
    }

    override fun onBindViewHolder(holder: SummaryVH, position: Int) {
        val p = products[position]
        holder.name.text = p.nom
        holder.qty.text = "x${p.quantitat}"
    }

    override fun getItemCount() = products.size
}