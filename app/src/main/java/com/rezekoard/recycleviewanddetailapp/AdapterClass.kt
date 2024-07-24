package com.rezekoard.recycleviewanddetailapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<DataClass>) : RecyclerView.Adapter<AdapterClass.viewHolderClass>() {

    var onItemClick: ((DataClass) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
        return viewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: viewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }


    class viewHolderClass(itemview: View): RecyclerView.ViewHolder(itemview){
        val rvImage: ImageView = itemView.findViewById(R.id.image)
        val rvTitle: TextView = itemView.findViewById(R.id.title)
    }
}