package com.example.jamb_mvvm.Ticket.ViewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jamb_mvvm.R
import com.example.jamb_mvvm.Ticket.TicketFragment
import com.example.jamb_mvvm.Ticket.TicketItems.InputItem
import com.example.jamb_mvvm.Ticket.TicketRecyclerViewAdapter
import com.example.jamb_mvvm.Ticket.TicketViewModel
import kotlinx.android.synthetic.main.input_item.view.*

class InputViewHolder(itemView: View, private val listener: MyListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

    private var textView = itemView.box

    companion object {
        fun create(parent: ViewGroup, ticketViewModel: TicketViewModel): InputViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.input_item, parent, false)
            return InputViewHolder(view, ticketViewModel)
        }
    }

    init {
        textView.setOnClickListener(this)
    }

    fun bind(box: InputItem){
        textView.text = box.value
    }

    override fun onClick(p0: View?) {
        listener.onBoxClicked(adapterPosition)
    }

    /**
     * ZAŠTO OVDJE MOGU PRISTUPITI diceValues VARIJABLI IZ JAMBFRAGMENTA, A U ADAPTERU MORAM KORISTITI JambFragment.diceValues??
     */

    interface MyListener{
        fun onBoxClicked(position: Int)
    }
}