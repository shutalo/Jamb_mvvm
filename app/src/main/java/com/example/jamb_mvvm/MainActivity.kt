package com.example.jamb_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jamb_mvvm.Dice.DiceRollingFragment
import com.example.jamb_mvvm.Dice.DiceRollingUI
import com.example.jamb_mvvm.Ticket.ColumnUI
import com.example.jamb_mvvm.Ticket.TicketFragment
import com.example.jamb_mvvm.Ticket.TicketUI

class MainActivity : AppCompatActivity() {

    private val diceRollingFragment = DiceRollingFragment.newInstance()
    private val ticketFragment = TicketFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceRollingFragment.setListener {
            transferData()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ticketFragment).commit()
        }
        ticketFragment.setListener {
            ticketFragment.arguments?.clear()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,diceRollingFragment).commit()

        }
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,ticketFragment).commit()
    }

    private fun transferData() {
        val bundle = Bundle()
        bundle.putIntArray("diceValues", diceRollingFragment.getDiceValue())
        ticketFragment.arguments = bundle
    }
}