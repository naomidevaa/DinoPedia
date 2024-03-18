package com.ifs21021.dinopedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DinoFamilyAdapter(
    private val familyList: List<Dino>,
    private val clickListener: FamilyItemClickListener
) : RecyclerView.Adapter<DinoFamilyAdapter.FamilyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_family, parent, false)
        return FamilyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        val currentItem = familyList[position]
        holder.textViewFamilyName.text = currentItem.name
    }

    override fun getItemCount() = familyList.size

    inner class FamilyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val textViewFamilyName: TextView = itemView.findViewById(R.id.textFamilyName)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val family = familyList[position]
                clickListener.onFamilyItemClick(family)
            }
        }
    }
}