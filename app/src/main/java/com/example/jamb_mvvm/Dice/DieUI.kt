package com.example.jamb_mvvm.Dice

import com.example.jamb_mvvm.R

data class DieUI(var isLocked: Boolean = false, var value: Int = 1) {

    /**
     * promjenjeno u public zbog getDiceValue funkcije za transferData izmedu fragmenata
     */

    fun toggleLock(): Boolean {
        return !isLocked
    }

    fun getImageResource() :Int {
        return when (value) {
            1 -> R.drawable.dice1480
            2 -> R.drawable.dice2480
            3 -> R.drawable.dice3480
            4 -> R.drawable.dice4480
            5 -> R.drawable.dice5480
            else -> R.drawable.dice6480
        }
    }
}