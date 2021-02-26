package com.example.jamb_mvvm.Ticket.ViewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jamb_mvvm.R
import com.example.jamb_mvvm.Ticket.TicketItems.SumItem
import kotlinx.android.synthetic.main.sum_item.view.*

class SumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView = itemView.sumBox
    init{
        textView.text = "0"
    }

    companion object {
        fun create(parent: ViewGroup): SumViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.sum_item, parent, false)
            return SumViewHolder(
                    view
            )
        }
    }

    fun bind(sumBox: SumItem){
        textView.text = sumBox.value.toString()
    }
}