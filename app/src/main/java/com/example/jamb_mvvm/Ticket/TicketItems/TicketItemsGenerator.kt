package com.example.jamb_mvvm.Ticket.TicketItems

import com.example.jamb_mvvm.R
import com.example.jamb_mvvm.Ticket.ColumnUI
import com.example.jamb_mvvm.Ticket.TicketUI

object TicketItemsGenerator {


    private fun createFirstColumnUI() : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.igra))
            add(ImageItem(R.drawable.dice1480))
            add(ImageItem(R.drawable.dice2480))
            add(ImageItem(R.drawable.dice3480))
            add(ImageItem(R.drawable.dice4480))
            add(ImageItem(R.drawable.dice5480))
            add(ImageItem(R.drawable.dice6480))
            add(ImageItem(R.drawable.sum1))
            add(ImageItem(R.drawable.max))
            add(ImageItem(R.drawable.min))
            add(ImageItem(R.drawable.sum2))
            add(ImageItem(R.drawable.skala))
            add(ImageItem(R.drawable.full))
            add(ImageItem(R.drawable.poker))
            add(ImageItem(R.drawable.yamb))
            add(ImageItem(R.drawable.sum3))
            add(ImageItem(R.drawable.sum4))
            add(ImageItem(R.drawable.dice1480))
        }
        return ColumnUI(
                ColumnUI.Type.FIRST,
                listOfItems
        )
    }

    private fun createSecondColumnUI() : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.downwards))
            repeat(6){
                add(InputItem())
            }
            add(SumItem())
            repeat(2){
                add(InputItem())
            }
            add(SumItem())
            repeat(4){
                add(InputItem())
            }
            add(SumItem())
            add(BlankItem())
            add(ImageItem(R.drawable.dice2480))
        }
        return ColumnUI(
                ColumnUI.Type.SECOND,
                listOfItems
        )
    }

    private fun createThirdColumnUI() : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.both))
            repeat(6){
                add(InputItem())
            }
            add(SumItem())
            repeat(2){
                add(InputItem())
            }
            add(SumItem())
            repeat(4){
                add(InputItem())
            }
            add(SumItem())
            add(BlankItem())
            add(ImageItem(R.drawable.dice3480))
        }
        return ColumnUI(
                ColumnUI.Type.THIRD,
                listOfItems
        )
    }

    private fun createFourthColumnUI() : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.upwards))
            repeat(6){
                add(InputItem())
            }
            add(SumItem())
            repeat(2){
                add(InputItem())
            }
            add(SumItem())
            repeat(4){
                add(InputItem())
            }
            add(SumItem())
            add(BlankItem())
            add(ImageItem(R.drawable.dice4480))
        }
        return ColumnUI(
                ColumnUI.Type.FOURTH,
                listOfItems
        )
    }

    private fun createFifthColumnUI() : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.call))
            repeat(6){
                add(InputItem())
            }
            add(SumItem())
            repeat(2){
                add(InputItem())
            }
            add(SumItem())
            repeat(4){
                add(InputItem())
            }
            add(SumItem())
            add(BlankItem())
            add(ImageItem(R.drawable.dice5480))
        }
        return ColumnUI(
                ColumnUI.Type.FIFTH,
                listOfItems
        )
    }

    private fun createSixthColumnUI() : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            repeat(7){
                add(BlankItem())
            }
            add(SumItem())
            repeat(2){
                add(BlankItem())
            }
            add(SumItem())
            repeat(4){
                add(BlankItem())
            }
            add(SumItem())
            add(SumItem())
            add(ImageItem(R.drawable.dice6480))
        }
        return ColumnUI(
                ColumnUI.Type.SIXTH,
                listOfItems
        )
    }

    fun getItems() = mutableListOf<ColumnUI>().apply {
        add(createFirstColumnUI())
        add(createSecondColumnUI())
        add(createThirdColumnUI())
        add(createFourthColumnUI())
        add(createFifthColumnUI())
        add(createSixthColumnUI())
    }

    fun recreateTicket(ticket: TicketUI) = mutableListOf<ColumnUI>().apply{
        add(recreateFirstColumnUI(ticket))
        add(recreateSecondColumnUI(ticket))
        add(recreateThirdColumnUI(ticket))
        add(recreateFourthColumnUI(ticket))
        add(recreateFifthColumnUI(ticket))
        add(recreateSixthColumnUI(ticket))
    }

    private fun recreateFirstColumnUI(ticket: TicketUI) : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.igra))
            add(ImageItem(R.drawable.dice1480))
            add(ImageItem(R.drawable.dice2480))
            add(ImageItem(R.drawable.dice3480))
            add(ImageItem(R.drawable.dice4480))
            add(ImageItem(R.drawable.dice5480))
            add(ImageItem(R.drawable.dice6480))
            add(ImageItem(R.drawable.sum1))
            add(ImageItem(R.drawable.max))
            add(ImageItem(R.drawable.min))
            add(ImageItem(R.drawable.sum2))
            add(ImageItem(R.drawable.skala))
            add(ImageItem(R.drawable.full))
            add(ImageItem(R.drawable.poker))
            add(ImageItem(R.drawable.yamb))
            add(ImageItem(R.drawable.sum3))
            add(ImageItem(R.drawable.sum4))
            add(ImageItem((ticket[0].listOfItemsInTheColumn[17] as ImageItem).getImage()))
        }
        return ColumnUI(
                ColumnUI.Type.FIRST, listOfItems
        )
    }

    private fun recreateSecondColumnUI(ticket: TicketUI) : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.downwards))

            add(InputItem((ticket[1].listOfItemsInTheColumn[1] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[2] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[3] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[4] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[5] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[6] as InputItem).value))

            add(SumItem((ticket[1].listOfItemsInTheColumn[7] as SumItem).value))

            add(InputItem((ticket[1].listOfItemsInTheColumn[8] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[9] as InputItem).value))

            add(SumItem((ticket[1].listOfItemsInTheColumn[10] as SumItem).value))

            add(InputItem((ticket[1].listOfItemsInTheColumn[11] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[12] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[13] as InputItem).value))
            add(InputItem((ticket[1].listOfItemsInTheColumn[14] as InputItem).value))

            add(SumItem((ticket[1].listOfItemsInTheColumn[15] as SumItem).value))

            add(BlankItem())
            add(ImageItem((ticket[1].listOfItemsInTheColumn[17] as ImageItem).getImage()))
        }
        return ColumnUI(
                ColumnUI.Type.SECOND,
                listOfItems
        )
    }

    private fun recreateThirdColumnUI(ticket: TicketUI) : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.both))

            add(InputItem((ticket[2].listOfItemsInTheColumn[1] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[2] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[3] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[4] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[5] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[6] as InputItem).value))

            add(SumItem((ticket[2].listOfItemsInTheColumn[7] as SumItem).value))

            add(InputItem((ticket[2].listOfItemsInTheColumn[8] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[9] as InputItem).value))

            add(SumItem((ticket[2].listOfItemsInTheColumn[10] as SumItem).value))

            add(InputItem((ticket[2].listOfItemsInTheColumn[11] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[12] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[13] as InputItem).value))
            add(InputItem((ticket[2].listOfItemsInTheColumn[14] as InputItem).value))

            add(SumItem((ticket[2].listOfItemsInTheColumn[15] as SumItem).value))

            add(BlankItem())
            add(ImageItem((ticket[2].listOfItemsInTheColumn[17] as ImageItem).getImage()))
        }
        return ColumnUI(
                ColumnUI.Type.THIRD,
                listOfItems
        )
    }

    private fun recreateFourthColumnUI(ticket: TicketUI) : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.upwards))

            add(InputItem((ticket[3].listOfItemsInTheColumn[1] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[2] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[3] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[4] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[5] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[6] as InputItem).value))

            add(SumItem((ticket[3].listOfItemsInTheColumn[7] as SumItem).value))

            add(InputItem((ticket[3].listOfItemsInTheColumn[8] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[9] as InputItem).value))

            add(SumItem((ticket[3].listOfItemsInTheColumn[10] as SumItem).value))

            add(InputItem((ticket[3].listOfItemsInTheColumn[11] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[12] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[13] as InputItem).value))
            add(InputItem((ticket[3].listOfItemsInTheColumn[14] as InputItem).value))

            add(SumItem((ticket[3].listOfItemsInTheColumn[15] as SumItem).value))

            add(BlankItem())
            add(ImageItem((ticket[3].listOfItemsInTheColumn[17] as ImageItem).getImage()))
        }
        return ColumnUI(
                ColumnUI.Type.FOURTH,
                listOfItems
        )
    }

    private fun recreateFifthColumnUI(ticket: TicketUI) : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            add(ImageItem(R.drawable.call))

            add(InputItem((ticket[4].listOfItemsInTheColumn[1] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[2] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[3] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[4] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[5] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[6] as InputItem).value))

            add(SumItem((ticket[4].listOfItemsInTheColumn[7] as SumItem).value))

            add(InputItem((ticket[4].listOfItemsInTheColumn[8] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[9] as InputItem).value))

            add(SumItem((ticket[4].listOfItemsInTheColumn[10] as SumItem).value))

            add(InputItem((ticket[4].listOfItemsInTheColumn[11] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[12] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[13] as InputItem).value))
            add(InputItem((ticket[4].listOfItemsInTheColumn[14] as InputItem).value))

            add(SumItem((ticket[4].listOfItemsInTheColumn[15] as SumItem).value))

            add(BlankItem())
            add(ImageItem((ticket[4].listOfItemsInTheColumn[17] as ImageItem).getImage()))
        }
        return ColumnUI(
                ColumnUI.Type.FIFTH,
                listOfItems
        )
    }

    private fun recreateSixthColumnUI(ticket: TicketUI) : ColumnUI {
        val listOfItems = mutableListOf<TicketItem>().apply {
            repeat(7){
                add(BlankItem())
            }
            add(SumItem((ticket[5].listOfItemsInTheColumn[7] as SumItem).value))
            repeat(2){
                add(BlankItem())
            }
            add(SumItem((ticket[5].listOfItemsInTheColumn[10] as SumItem).value))
            repeat(4){
                add(BlankItem())
            }
            add(SumItem((ticket[5].listOfItemsInTheColumn[15] as SumItem).value))
            add(SumItem((ticket[5].listOfItemsInTheColumn[16] as SumItem).value))
            add(ImageItem((ticket[5].listOfItemsInTheColumn[17] as ImageItem).getImage()))
        }
        return ColumnUI(
                ColumnUI.Type.SIXTH,
                listOfItems
        )
    }
}