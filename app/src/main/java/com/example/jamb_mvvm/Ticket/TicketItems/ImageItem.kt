package com.example.jamb_mvvm.Ticket.TicketItems

import com.example.jamb_mvvm.R

data class ImageItem(private var image: Int = 0) : TicketItem(){

    override fun getType() = Type.IMAGE.ordinal

    fun getImage(): Int{
        return image
    }

    private fun getImageResource(value: Int): Int{
        return when(value){
            1 -> R.drawable.dice1480
            2 -> R.drawable.dice2480
            3 -> R.drawable.dice3480
            4 -> R.drawable.dice4480
            5 -> R.drawable.dice5480
            else -> R.drawable.dice6480
        }
    }

    fun setImageResource(value: Int){
        image = getImageResource(value)
    }
}