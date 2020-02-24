package com.writetosid.suvidha

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_1.view.*


class HandlerAdapter(val handler: ArrayList<Handler>) :
    RecyclerView.Adapter<HandlerAdapter.ItemVieHolder>() {
    var onItemClickListener: MovieItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVieHolder {
        return ItemVieHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_1,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = handler.size

    override fun onBindViewHolder(holder: ItemVieHolder, position: Int) {
        holder.bind(handler[position])

    }

    inner class ItemVieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(handle: Handler) {
            itemView.apply {
              distanceTv.text="${handle.distance} Km"
                NameTv.text= handle.name
                Image.setImageResource(handle.image)
                setOnClickListener {
                    onItemClickListener?.onItemClick(handle)
                }
            }

        }
    }

}

interface MovieItemClickListener {
    fun onItemClick(handlers: Handler)
}


