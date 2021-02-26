package com.example.jamb_mvvm.Ticket

import com.example.jamb_mvvm.Ticket.TicketItems.ImageItem
import com.example.jamb_mvvm.Ticket.TicketItems.SumItem
import com.example.jamb_mvvm.Ticket.TicketItems.TicketItem
import com.example.jamb_mvvm.Ticket.TicketItems.TicketItemsGenerator

class TicketUI() {
    private var listOfItems: MutableList<ColumnUI> = TicketItemsGenerator.getItems()
    val size: Int = listOfItems.size * listOfItems[0].listOfItemsInTheColumn.size

    var positionOfCall = 0
    var isCalled = false
    var isValueEntered = false

    constructor(ticket: TicketUI) : this(){
        listOfItems = TicketItemsGenerator.recreateTicket(ticket)
    }

    fun getItemAtPosition(position: Int): TicketItem{
        return listOfItems[getPositionOfColumnInTheList(position)].listOfItemsInTheColumn[getPositionForItemInTheColumn(position)]
    }

    fun enterValue(diceValues: IntArray, position: Int){
        listOfItems[getPositionOfColumnInTheList(position)].enterValue(diceValues,getPositionForItemInTheColumn(position))
        if(listOfItems[getPositionOfColumnInTheList(position)].checkIfValueIsEntered()){
            isValueEntered = true
            isCalled = false
        } else isValueEntered = false

        updateFinalSumBoxes()
    }


    private fun getPositionOfColumnInTheList(position: Int): Int{
        return position % listOfItems.size
    }

    private fun getPositionForItemInTheColumn(position: Int): Int{
        return position / listOfItems.size
    }

    fun setDiceImages(diceValues: IntArray){
        for(index in 0..5){
            (listOfItems[index].listOfItemsInTheColumn[17] as ImageItem).setImageResource(diceValues[index])
        }
    }

    /**
     * pozvana nakon svakog unosa vrijednosti u box
     */
    private fun updateFinalSumBoxes(){
        (listOfItems[5].listOfItemsInTheColumn[7] as SumItem).value = 0
        for(i in 1..4){
            (listOfItems[5].listOfItemsInTheColumn[7] as SumItem).value += (listOfItems[i].listOfItemsInTheColumn[7] as SumItem).value
        }


        (listOfItems[5].listOfItemsInTheColumn[10] as SumItem).value = 0
        for(i in 1..4){
            (listOfItems[5].listOfItemsInTheColumn[10] as SumItem).value += (listOfItems[i].listOfItemsInTheColumn[10] as SumItem).value
        }


        (listOfItems[5].listOfItemsInTheColumn[15] as SumItem).value = 0
        for(i in 1..4){
            (listOfItems[5].listOfItemsInTheColumn[15] as SumItem).value += (listOfItems[i].listOfItemsInTheColumn[15] as SumItem).value
        }


        (listOfItems[5].listOfItemsInTheColumn[16] as SumItem).value = 0
        (listOfItems[5].listOfItemsInTheColumn[16] as SumItem).value = (listOfItems[5].listOfItemsInTheColumn[7] as SumItem).value + (listOfItems[5].listOfItemsInTheColumn[10] as SumItem).value + (listOfItems[5].listOfItemsInTheColumn[15] as SumItem).value
    }

    operator fun get(position: Int): ColumnUI {
        return listOfItems[getPositionOfColumnInTheList(position)]
    }
}