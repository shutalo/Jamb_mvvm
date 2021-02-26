package com.example.jamb_mvvm.Ticket.ViewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jamb_mvvm.R
import com.example.jamb_mvvm.Ticket.TicketItems.BlankItem

class BlankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): BlankViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.blank_item, parent, false)
            return BlankViewHolder(
                    view
            )
        }
    }

    fun bind(blankItem: BlankItem){
    }

}