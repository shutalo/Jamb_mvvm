package com.example.jamb_mvvm.Ticket.ViewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jamb_mvvm.R
import com.example.jamb_mvvm.Ticket.TicketItems.ImageItem
import kotlinx.android.synthetic.main.image_item.view.*

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView = itemView.rowTypeImage

    companion object {
        fun create(parent: ViewGroup): ImageViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_item, parent, false)
            return ImageViewHolder(
                    view
            )
        }
    }

    fun bind(image: ImageItem){
        imageView.setImageResource(image.getImage())
    }
}