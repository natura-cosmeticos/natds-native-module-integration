package com.natura

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.natura.data.Icon

class NativeIconsListAdapter internal constructor(context: Context, private var icons: List<Icon>): RecyclerView.Adapter<NativeIconsListAdapter.IconViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    inner class IconViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val iconView: ImageView = itemView.findViewById(R.id.icon)
        val labelView: TextView = itemView.findViewById(R.id.label)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val itemView = inflater.inflate(R.layout.icon_item, parent, false)
        return IconViewHolder(itemView)    }

    override fun onBindViewHolder(holderIcon: IconViewHolder, position: Int) {
        val current = icons[position]
        holderIcon.iconView.setImageResource(current.resourceId)
        holderIcon.labelView.text = current.name
    }

    override fun getItemCount(): Int = icons.size

    fun setIcons(words: List<Icon>) {
        this.icons = icons
        notifyDataSetChanged()
    }
}
