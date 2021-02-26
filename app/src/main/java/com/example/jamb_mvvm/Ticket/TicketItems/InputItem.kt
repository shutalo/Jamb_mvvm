package com.example.jamb_mvvm.Ticket.TicketItems

data class InputItem (var value: String = "", var isFilled: Boolean = false) : TicketItem() {

    override fun getType() = Type.BOX.ordinal

    fun enterValue(diceValues: IntArray, positionInTheColumn: Int){
        when(positionInTheColumn){
            1 -> value = enterOnes(diceValues).toString()
            2 -> value = enterTwos(diceValues).toString()
            3 -> value = enterThrees(diceValues).toString()
            4 -> value = enterFours(diceValues).toString()
            5 -> value = enterFives(diceValues).toString()
            6 -> value = enterSixes(diceValues).toString()
            8 -> value = enterMax(diceValues).toString()
            9 -> value = enterMin(diceValues).toString()
            11 -> value = enterStraight(diceValues).toString()
            12 -> value = enterFull(diceValues).toString()
            13 -> value = enterPoker(diceValues).toString()
            14 -> value = enterYamb(diceValues).toString()
        }
    }

    private fun enterOnes(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }

        diceValues.forEach {
            dice[it - 1]++
        }

        return dice[0] * 1
    }

    private fun enterTwos(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }

        diceValues.forEach {
            dice[it - 1]++
        }

        return dice[1] * 2
    }

    private fun enterThrees(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }

        diceValues.forEach {
            dice[it - 1]++
        }

        return dice[2] * 3
    }

    private fun enterFours(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }

        diceValues.forEach {
            dice[it - 1]++
        }

        return dice[3] * 4
    }

    private fun enterFives(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }

        diceValues.forEach {
            dice[it - 1]++
        }

        return dice[4] * 5
    }

    private fun enterSixes(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }

        diceValues.forEach {
            dice[it - 1]++
        }

        return dice[5] * 6
    }

    private fun enterMax(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }
        var counter = 0
        var value = 0

        diceValues.forEach {
            dice[it - 1]++
        }

        for(i in 5 downTo 0 ){
            if(counter == 5){
                return value
            }
            if(counter == 4 && dice[i] == 2){
                counter ++
                value += i + 1
            } else {
                value += dice[i] * (i + 1)
                counter += dice[i]
            }
        }
        return value
    }

    private fun enterMin(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }
        var counter = 0
        var value = 0

        diceValues.forEach {
            dice[it - 1]++
        }

        for(index in dice.indices){
            if(counter == 5){
                return value
            }
            if(counter == 4 && dice[index] == 2){
                counter ++
                value += index + 1
            } else {
                value += dice[index] * (index + 1)
                counter += dice[index]
            }
        }
        return value
    }

    private fun enterStraight(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }

        diceValues.forEach {
            dice[it - 1]++
        }

        return if(dice[1] >= 1 && dice[2] >= 1 && dice[3] >= 1 && dice[4] >= 1 && dice[5] >= 1){
            45
        }  else if(dice[0] >= 1 && dice[1] >= 1 && dice[2] >= 1 && dice[3] >= 1 && dice[4] >= 1 ){
            35
        } else 0
    }

    private fun enterFull(diceValues: IntArray): Int{
        val dice = IntArray(6){0}
        var valueOfTriples = 0
        var valueOfDoubles = 0
        var flag3 = false
        var flag2 = false

        diceValues.forEach {
            dice[it - 1]++
        }
        for(index in dice.indices){
            if(dice[index] >= 3 && !flag3){
                flag3 = true
                valueOfTriples = (index + 1) * 3
            } else if(dice[index] >= 3 && flag3 && valueOfTriples / 3 < (index + 1)){
                valueOfDoubles = valueOfTriples / 3 * 2
                flag2 = true
                valueOfTriples = (index + 1) * 3
            } else if(dice[index] >= 2 && !flag2 ){
                flag2 = true
                valueOfDoubles = (index + 1) * 2
            } else if(dice[index] >= 2 && flag2 && valueOfDoubles / 2 < (index + 1)){
                valueOfDoubles = (index + 1) * 2
            }
        }

        return if(flag2 && flag3)
            valueOfDoubles + valueOfTriples + 30
        else 0
    }

    private fun enterPoker(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }
        var valueOfPoker = 0

        diceValues.forEach {
            dice[it - 1]++
        }
        for(index in dice.indices){
            if (dice[index] >= 4) {
                valueOfPoker = (index + 1) * 4
                valueOfPoker += 40
            }
        }
        return valueOfPoker
    }

    private fun enterYamb(diceValues: IntArray): Int{
        val dice = IntArray(6) { 0 }
        var valueOfYamb = 0

        diceValues.forEach {
            dice[it - 1]++
        }
        for(index in dice.indices){
            if (dice[index] >= 5) {
                valueOfYamb = (index + 1) * 5
                valueOfYamb += 50
            }
        }
        return valueOfYamb
    }
}