package com.example.jamb_mvvm.Ticket

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jamb_mvvm.Ticket.TicketItems.*
import com.example.jamb_mvvm.Ticket.ViewHolders.BlankViewHolder
import com.example.jamb_mvvm.Ticket.ViewHolders.ImageViewHolder
import com.example.jamb_mvvm.Ticket.ViewHolders.InputViewHolder
import com.example.jamb_mvvm.Ticket.ViewHolders.SumViewHolder
import java.lang.RuntimeException

class TicketRecyclerViewAdapter(private var ticket: TicketUI, private val ticketViewModel: TicketViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TicketItem.Type.BOX.ordinal -> {
                InputViewHolder.create(parent, ticketViewModel)
            }
            TicketItem.Type.SUM_BOX.ordinal -> {
                SumViewHolder.create(parent)
            }
            TicketItem.Type.IMAGE.ordinal -> {
                ImageViewHolder.create(parent)
            }
            TicketItem.Type.BLANK.ordinal -> {
                BlankViewHolder.create(parent)
            }
            else -> throw RuntimeException("Invalid type!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when (holder) {
        is InputViewHolder -> {
            holder.bind(ticket.getItemAtPosition(position) as InputItem)
        }
        is SumViewHolder ->{
            holder.bind(ticket.getItemAtPosition(position) as SumItem)
        }
        is ImageViewHolder ->{
            holder.bind(ticket.getItemAtPosition(position) as ImageItem)
        }
        is BlankViewHolder -> {
            holder.bind(ticket.getItemAtPosition(position) as BlankItem)
        }
        else -> throw Exception(" Unknown view type exception")
    }

    override fun getItemCount(): Int {
        return ticket.size
    }

    override fun getItemViewType(position: Int): Int {
        return ticket.getItemAtPosition(position).getType()
    }

    fun setTicket(ticket: TicketUI){
        this.ticket = ticket
    }
}