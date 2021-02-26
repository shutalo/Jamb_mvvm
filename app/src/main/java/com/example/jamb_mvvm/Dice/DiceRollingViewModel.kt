package com.example.jamb_mvvm.Dice

import androidx.lifecycle.ViewModel

class DiceRollingViewModel : ViewModel() {

    val diceRollingUI: DiceRollingUI = DiceRollingUI()

    fun toggleLock(index: Int){
        diceRollingUI.toggleLock(index)
    }

    fun getDiceValue(): IntArray {
        return diceRollingUI.getDiceValue()
    }

    fun rollDice(){
        if (diceRollingUI.numberOfRolls < 3){

            if(!diceRollingUI.firstDie.value?.isLocked!!){
                diceRollingUI.firstDie.value = DieUI(false, rollDie())
            }
            if(!diceRollingUI.secondDie.value?.isLocked!!){
                diceRollingUI.secondDie.value = DieUI(false, rollDie())
            }
            if(!diceRollingUI.thirdDie.value?.isLocked!!){
                diceRollingUI.thirdDie.value = DieUI(false, rollDie())
            }
            if(!diceRollingUI.fourthDie.value?.isLocked!!){
                diceRollingUI.fourthDie.value = DieUI(false, rollDie())
            }
            if(!diceRollingUI.fifthDie.value?.isLocked!!){
                diceRollingUI.fifthDie.value = DieUI(false, rollDie())
            }
            if(!diceRollingUI.sixthDie.value?.isLocked!!){
                diceRollingUI.sixthDie.value = DieUI(false, rollDie())
            }
            diceRollingUI.numberOfRolls++
        }
    }

    private fun rollDie(): Int{
        return (1..6).random()
    }

    fun checkIfDieIsLocked(index: Int): Boolean? {
        return when(index){
            0 -> diceRollingUI.firstDie.value?.isLocked
            1 -> diceRollingUI.secondDie.value?.isLocked
            2 -> diceRollingUI.thirdDie.value?.isLocked
            3 -> diceRollingUI.fourthDie.value?.isLocked
            4 -> diceRollingUI.fifthDie.value?.isLocked
            else -> diceRollingUI.sixthDie.value?.isLocked
        }
    }

    fun getDieImageResource(index: Int): Int? {
        return when(index){
            0 -> diceRollingUI.firstDie.value?.getImageResource()
            1 -> diceRollingUI.secondDie.value?.getImageResource()
            2 -> diceRollingUI.thirdDie.value?.getImageResource()
            3 -> diceRollingUI.fourthDie.value?.getImageResource()
            4 -> diceRollingUI.fifthDie.value?.getImageResource()
            else -> diceRollingUI.sixthDie.value?.getImageResource()
        }
    }
}