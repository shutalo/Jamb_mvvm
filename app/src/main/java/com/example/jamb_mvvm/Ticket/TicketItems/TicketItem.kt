package com.example.jamb_mvvm.Ticket.TicketItems

abstract class TicketItem {
    abstract fun getType(): Int

    enum class Type {
        SUM_BOX,
        BOX,
        IMAGE,
        BLANK
    }
}