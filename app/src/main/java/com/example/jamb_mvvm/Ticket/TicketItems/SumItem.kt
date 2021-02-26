package com.example.jamb_mvvm.Ticket.TicketItems

class SumItem(var value: Int = 0) : TicketItem() {
    override fun getType() = Type.SUM_BOX.ordinal
}