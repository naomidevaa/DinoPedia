package com.ifs21021.dinopedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DinoAdapter(private val dinos: List<Dino>) :
    RecyclerView.Adapter<DinoAdapter.DinoViewHolder>() {

    // ViewHolder for dino item
    class DinoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textDinoName: TextView = itemView.findViewById(R.id.text_dino_name)
        private val textDinoDesc: TextView = itemView.findViewById(R.id.text_dino_description)
        private val textDinoCharacteristic: TextView = itemView.findViewById(R.id.text_dino_characteristic)
        private val textDinoFamily: TextView = itemView.findViewById(R.id.text_dino_family)
        private val textDinoHabitat: TextView = itemView.findViewById(R.id.text_dino_habitat)

        // Bind data to views in ViewHolder
        fun bind(dino: Dino, resources: Resources) {
            textDinoName.text = dino.name
            textDinoDesc.text = dino.description
            textDinoCharacteristic.text = dino.characteristics
            textDinoFamily.text = resources.getString(R.string.info_dino_family, dino.group)
            textDinoHabitat.text = resources.getString(R.string.info_dino_habitat, dino.habitat)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DinoViewHolder {
        // Inflate layout for dino item and return ViewHolder
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dino, parent, false)
        return DinoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DinoViewHolder, position: Int) {
        val dino = dinos[position]
        // Bind data to views in ViewHolder
        holder.bind(dino, holder.itemView.resources)
    }

    override fun getItemCount(): Int {
        return dinos.size
    }
}
