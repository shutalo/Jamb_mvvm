package com.example.jamb_mvvm.Ticket

import com.example.jamb_mvvm.Ticket.TicketItems.*

class ColumnUI(private val type: Type, val listOfItemsInTheColumn: List<TicketItem>) {

    private var isValueEntered: Boolean = false

    enum class Type {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH,
        SIXTH
    }

    fun getType(): Type{
        return type
    }

    fun checkIfValueIsEntered(): Boolean{
        return isValueEntered
    }

    fun enterValue(diceValues: IntArray, positionInTheColumn: Int){
        when(type){
            Type.SECOND -> {
                when(listOfItemsInTheColumn[positionInTheColumn]){
                    is InputItem -> {
                        if(listOfItemsInTheColumn[positionInTheColumn - 1] is SumItem){
                            if((listOfItemsInTheColumn[positionInTheColumn - 2] as InputItem).isFilled){
                                (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                                (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                                isValueEntered = true
                            }
                        } else if(listOfItemsInTheColumn[positionInTheColumn - 1] is ImageItem){
                            (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                            (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                            isValueEntered = true
                        } else if((listOfItemsInTheColumn[positionInTheColumn - 1] as InputItem).isFilled){
                            (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                            (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                            isValueEntered = true
                        } else isValueEntered = false
                        updateSumBoxes()
                    }
                }
            }
            Type.THIRD -> {
                if((!(listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled))
                {
                    (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                    (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                    isValueEntered = true
                    updateSumBoxes()
                } else isValueEntered = false
            }
            Type.FOURTH -> {
                when(listOfItemsInTheColumn[positionInTheColumn]){
                    is InputItem -> {
                        if(listOfItemsInTheColumn[positionInTheColumn + 2] is BlankItem){
                            (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                            (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                            isValueEntered = true
                        } else if(listOfItemsInTheColumn[positionInTheColumn + 1] is SumItem){
                            if((listOfItemsInTheColumn[positionInTheColumn + 2] as InputItem).isFilled){
                                (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                                (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                                isValueEntered = true
                            }
                        } else if((listOfItemsInTheColumn[positionInTheColumn + 1] as InputItem).isFilled){
                                (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                                (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                                isValueEntered = true
                        } else isValueEntered = false

                        updateSumBoxes()
                    }
                }
            }
            else -> {
                if((!(listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled)) {
                    (listOfItemsInTheColumn[positionInTheColumn] as InputItem).enterValue(diceValues,positionInTheColumn)
                    (listOfItemsInTheColumn[positionInTheColumn] as InputItem).isFilled = true
                    isValueEntered = true
                    updateSumBoxes()
                } else isValueEntered = false
            }
        }
    }


    /**
     * pozvana nakon svakog unosa vrijednosti u box
     */
    private fun updateSumBoxes(){
        (listOfItemsInTheColumn[7] as SumItem).value = 0
        for(i in 1..6) {
            if((listOfItemsInTheColumn[i] as InputItem).value == ""){
                (listOfItemsInTheColumn[7] as SumItem).value += 0
            } else {
                (listOfItemsInTheColumn[7] as SumItem).value += Integer.parseInt((listOfItemsInTheColumn[i] as InputItem).value)
            }
        }
        if((listOfItemsInTheColumn[7] as SumItem).value >= 60){
            (listOfItemsInTheColumn[7] as SumItem).value += 30
        }


        if((listOfItemsInTheColumn[8] as InputItem).value == "" || (listOfItemsInTheColumn[9] as InputItem).value == "" || (listOfItemsInTheColumn[1] as InputItem).value == ""){
            (listOfItemsInTheColumn[10] as SumItem).value = 0
        } else {
            (listOfItemsInTheColumn[10] as SumItem).value = Integer.parseInt((listOfItemsInTheColumn[1] as InputItem).value) * (Integer.parseInt((listOfItemsInTheColumn[8] as InputItem).value) - Integer.parseInt((listOfItemsInTheColumn[9] as InputItem).value))
        }


        (listOfItemsInTheColumn[15] as SumItem).value = 0
        for(i in 11..14) {
            if((listOfItemsInTheColumn[i] as InputItem).value == ""){
                (listOfItemsInTheColumn[15] as SumItem).value += 0
            } else {
                (listOfItemsInTheColumn[15] as SumItem).value += Integer.parseInt((listOfItemsInTheColumn[i] as InputItem).value)
            }
        }
    }
}