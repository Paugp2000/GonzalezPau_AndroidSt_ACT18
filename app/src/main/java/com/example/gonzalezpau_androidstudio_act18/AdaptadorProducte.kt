package com.example.gonzalezpau_androidstudio_act18

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorProducte (
        private val products: List<Producte>,
        private val onQuantityChanged: () -> Unit
    ) : RecyclerView.Adapter<AdaptadorProducte.ProductVH>() {

        inner class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
            val img = view.findViewById<ImageView>(R.id.imgProduct)
            val name = view.findViewById<TextView>(R.id.txtName)
            val price = view.findViewById<TextView>(R.id.txtPrice)
            val qty = view.findViewById<TextView>(R.id.txtQuantity)
            val add = view.findViewById<Button>(R.id.btnAdd)
            val remove = view.findViewById<Button>(R.id.btnRemove)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_producte, parent, false)
            return ProductVH(v)
        }

        override fun onBindViewHolder(holder: ProductVH, position: Int) {
            val p = products[position]

            holder.img.setImageResource(p.imatgeId)
            holder.name.text = p.nom
            holder.price.text = "${p.preu} €"
            holder.qty.text = p.quantitat.toString()

            holder.add.setOnClickListener {
                p.quantitat++ ;
                holder.qty.text = p.quantitat.toString()
                onQuantityChanged()
            }

            holder.remove.setOnClickListener {
                if (p.quantitat > 0) {
                    p.quantitat--
                    holder.qty.text = p.quantitat.toString()
                    onQuantityChanged()
                }
            }
        }

        override fun getItemCount() = products.size
    }

