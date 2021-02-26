package com.example.jamb_mvvm.Dice

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.jamb_mvvm.R
import kotlinx.android.synthetic.main.dice_rolling_fragment.*

class DiceRollingFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance(/*foo: Int*/ ): DiceRollingFragment {
            //val args = Bundle()
            //args.putInt("foo", foo)
            //fragment.arguments = args
            return DiceRollingFragment()
        }
    }

    private var listener: (() -> Unit)? = null
    private lateinit var diceRollViewModel: DiceRollingViewModel

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dice_rolling_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Jamb - kako centrirati"
        setUpListeners()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        diceRollViewModel = ViewModelProvider(this).get(DiceRollingViewModel::class.java)

        diceRollViewModel.diceRollingUI.firstDie.observe(this) {

            diceRollViewModel.checkIfDieIsLocked(0)?.let { it1 ->   setFixedBackgroundColor(die0, it1) }
            setImageResource(0)
        }

        diceRollViewModel.diceRollingUI.secondDie.observe(this) {

            diceRollViewModel.checkIfDieIsLocked(1)?.let { it1 -> setFixedBackgroundColor(die1, it1) }
            setImageResource(1)
        }

        diceRollViewModel.diceRollingUI.thirdDie.observe(this) {

            diceRollViewModel.checkIfDieIsLocked(2)?.let { it1 -> setFixedBackgroundColor(die2, it1) }
            setImageResource(2)
        }

        diceRollViewModel.diceRollingUI.fourthDie.observe(this) {

            diceRollViewModel.checkIfDieIsLocked(3)?.let { it1 -> setFixedBackgroundColor(die3, it1) }
            setImageResource(3)
        }

        diceRollViewModel.diceRollingUI.fifthDie.observe(this) {

            diceRollViewModel.checkIfDieIsLocked(4)?.let { it1 -> setFixedBackgroundColor(die4, it1) }
            setImageResource(4)
        }

        diceRollViewModel.diceRollingUI.sixthDie.observe(this) {

            diceRollViewModel.checkIfDieIsLocked(5)?.let { it1 -> setFixedBackgroundColor(die5, it1) }
            setImageResource(5)
        }

    }


    private fun setUpListeners(){
        enterValue.setOnClickListener(this)
        roll.setOnClickListener(this)
        die0.setOnClickListener(this)
        die1.setOnClickListener(this)
        die2.setOnClickListener(this)
        die3.setOnClickListener(this)
        die4.setOnClickListener(this)
        die5.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id){
            enterValue.id -> {
                if(diceRollViewModel.diceRollingUI.numberOfRolls == 3){
                    diceRollViewModel.diceRollingUI.numberOfRolls = 0
                    listener?.invoke()
                }

            }
            roll.id -> {
                diceRollViewModel.rollDice()
                resetBackgroundColors()
            }

            die0.id -> {
                diceRollViewModel.toggleLock(0)
            }
            die1.id -> {
                diceRollViewModel.toggleLock(1)
            }
            die2.id -> {
                diceRollViewModel.toggleLock(2)
            }
            die3.id -> {
                diceRollViewModel.toggleLock(3)
            }
            die4.id -> {
                diceRollViewModel.toggleLock(4)
            }
            die5.id -> {
                diceRollViewModel.toggleLock(5)
            }
        }
    }

    private fun setImageResource(index: Int){
        when(index){
            0 -> diceRollViewModel.getDieImageResource(0)?.let{die0.setImageResource(it)}
            1 -> diceRollViewModel.getDieImageResource(1)?.let{die1.setImageResource(it)}
            2 -> diceRollViewModel.getDieImageResource(2)?.let{die2.setImageResource(it)}
            3 -> diceRollViewModel.getDieImageResource(3)?.let{die3.setImageResource(it)}
            4 -> diceRollViewModel.getDieImageResource(4)?.let{die4.setImageResource(it)}
            5 -> diceRollViewModel.getDieImageResource(5)?.let{die5.setImageResource(it)}
        }
    }

    private fun resetBackgroundColors() {

        context?.let { ContextCompat.getColor(it, R.color.whiteColor) }?.let {
            die0.setBackgroundColor(it)
        }
        context?.let { ContextCompat.getColor(it, R.color.whiteColor) }?.let {
            die1.setBackgroundColor(it)
        }
        context?.let { ContextCompat.getColor(it, R.color.whiteColor) }?.let {
            die2.setBackgroundColor(it)
        }
        context?.let { ContextCompat.getColor(it, R.color.whiteColor) }?.let {
            die3.setBackgroundColor(it)
        }
        context?.let { ContextCompat.getColor(it, R.color.whiteColor) }?.let {
            die4.setBackgroundColor(it)
        }
        context?.let { ContextCompat.getColor(it, R.color.whiteColor) }?.let {
            die5.setBackgroundColor(it)
        }
    }

    private fun setFixedBackgroundColor(die: ImageView, isFixed: Boolean){
        if(isFixed){
            context?.let { ContextCompat.getColor(it, R.color.fixedColor) }?.let {
                die.setBackgroundColor(it)
            }
        } else {
            context?.let { ContextCompat.getColor(it, R.color.whiteColor) }?.let {
                die.setBackgroundColor(it)
            }
        }
    }

    /**
     * dodana funkcija za povrat svih vrijednosti kockica kako bi se u MainActivityu mogli predati kroz transferData funkciju preko DiceRollFragmenta
     */
    fun getDiceValue(): IntArray {
        return diceRollViewModel.getDiceValue()
    }

}