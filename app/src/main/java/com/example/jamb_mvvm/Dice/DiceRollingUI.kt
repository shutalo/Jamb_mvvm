package com.example.jamb_mvvm.Dice

import androidx.lifecycle.MutableLiveData

class DiceRollingUI {

    var firstDie: MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var secondDie: MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var thirdDie: MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var fourthDie: MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var fifthDie: MutableLiveData<DieUI> = MutableLiveData(DieUI())
    var sixthDie: MutableLiveData<DieUI> = MutableLiveData(DieUI())

    var numberOfRolls: Int = 0

    fun toggleLock(index: Int){
        if(numberOfRolls == 1 || numberOfRolls == 2){
            when(index) {
                0 -> firstDie.value = firstDie.value?.let { DieUI(it.toggleLock(), firstDie.value!!.value) }
                1 -> secondDie.value = secondDie.value?.let { DieUI(it.toggleLock(), secondDie.value!!.value) }
                2 -> thirdDie.value = thirdDie.value?.let { DieUI(it.toggleLock(), thirdDie.value!!.value) }
                3 -> fourthDie.value = fourthDie.value?.let { DieUI(it.toggleLock(), fourthDie.value!!.value) }
                4 -> fifthDie.value = fifthDie.value?.let { DieUI(it.toggleLock(), fifthDie.value!!.value) }
                5 -> sixthDie.value = sixthDie.value?.let { DieUI(it.toggleLock(), sixthDie.value!!.value) }
            }
        }
    }

    /**
     * dodana funkcija za povrat svih vrijednosti kockica kako bi se u MainActivityu mogli predati kroz transferData funkciju preko DiceRollFragmenta
     */
    fun getDiceValue(): IntArray{
        val diceValue = IntArray(6)
        diceValue[0] = firstDie.value?.value!!
        diceValue[1] = secondDie.value?.value!!
        diceValue[2] = thirdDie.value?.value!!
        diceValue[3] = fourthDie.value?.value!!
        diceValue[4] = fifthDie.value?.value!!
        diceValue[5] = sixthDie.value?.value!!
        return diceValue
    }

}