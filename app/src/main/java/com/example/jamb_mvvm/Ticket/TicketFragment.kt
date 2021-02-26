package com.example.jamb_mvvm.Ticket

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jamb_mvvm.R
import com.example.jamb_mvvm.Ticket.ViewHolders.InputViewHolder
import kotlinx.android.synthetic.main.ticket_fragment.*

class TicketFragment : Fragment() {

    companion object {
        fun newInstance() = TicketFragment()
    }

    private lateinit var diceValue: IntArray
    private var ticketViewModel = TicketViewModel()
    private var ticketAdapter = ticketViewModel.ticket.value?.let { TicketRecyclerViewAdapter(it,ticketViewModel) }

    private var listener: (() -> Unit)? = null

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ticket_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rollDice.setOnClickListener(){
            if(ticketViewModel.ticket.value?.isValueEntered == true || ticketViewModel.ticket.value?.isCalled == true || ticketViewModel.firstTimeViewCreated){
                ticketViewModel.firstTimeViewCreated = false
                listener?.invoke()
            }
        }

        initUi()

        if(!ticketViewModel.firstTimeViewCreated){
            diceValue = this.arguments?.getIntArray("diceValues")!!
            ticketViewModel.provideDiceValue(diceValue)
            ticketViewModel.setDiceImages()
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ticketViewModel = ViewModelProvider(this).get(TicketViewModel::class.java)

        ticketViewModel.ticket.observe(this){
            ticketAdapter?.setTicket(it)
            ticketAdapter?.notifyDataSetChanged()
        }
    }

    private fun initUi(){
        recyclerView.apply {
            layoutManager = GridLayoutManager(context,6)
            adapter = ticketAdapter
        }
    }

}