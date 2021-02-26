package com.example.jamb_mvvm.Ticket

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jamb_mvvm.Ticket.ViewHolders.InputViewHolder

class TicketViewModel : ViewModel(), InputViewHolder.MyListener {

    private lateinit var diceValue: IntArray
    var ticket: MutableLiveData<TicketUI> = MutableLiveData(TicketUI())
    var firstTimeViewCreated = true

    fun setDiceImages(){
        ticket.value?.setDiceImages(diceValue)
        ticket.value = ticket.value?.let{
            TicketUI(ticket.value!!)
        }
    }

    fun provideDiceValue(diceValue: IntArray){
        this.diceValue = diceValue
    }

    override fun onBoxClicked(position: Int) {
        /**
         * kako izbjeci ovaj null assertion
         */
        if(!ticket.value?.isCalled!!){
            if(ticket.value?.get(position)?.getType()?.ordinal == ColumnUI.Type.FIFTH.ordinal){
                Log.i("info","Box in Call at position $position is clicked!")
                ticket.value!!.isCalled = true
                ticket.value!!.positionOfCall = position

            } else if(!firstTimeViewCreated && !ticket.value!!.isValueEntered) {
                Log.i("info","Box at position $position is clicked!")

                ticket.value = ticket.value?.let {
                    TicketUI(it).apply {
                        enterValue(diceValue,position)
                    }
                }
            }
        }
    }
}