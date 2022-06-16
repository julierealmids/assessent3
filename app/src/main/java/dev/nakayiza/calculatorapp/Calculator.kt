package dev.nakayiza.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Calculator : AppCompatActivity() {
    lateinit var tilnum1:TextInputLayout
    lateinit var tilnum2:TextInputLayout
    lateinit var etnum1:TextInputEditText
    lateinit var etnum2:TextInputEditText
    lateinit var tvresult:TextView
    lateinit var btnsum:Button
    lateinit var btnsub:Button
    lateinit var btndiv:Button
    lateinit var btnmod:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        tilnum1=findViewById(R.id.tilnum1)
        tilnum2=findViewById(R.id.tilnum2)
        etnum1=findViewById(R.id.etnum1)
        etnum2=findViewById(R.id.etnum2)
        tvresult=findViewById(R.id.tvresult)
        btnsum=findViewById(R.id.btnsum)
        btnsub=findViewById(R.id.btnsub)
        btndiv=findViewById(R.id.btndiv)
        btnmod=findViewById(R.id.btnmod)

        btnsum.setOnClickListener {

            val inputs = obtainInput()

            addition(inputs!!.number1, inputs!!.number2)



        }

        btnsub.setOnClickListener {

            val inputs = obtainInput()

            subtraction(inputs!!.number1, inputs!!.number2)



        }

        btndiv.setOnClickListener {

            val inputs = obtainInput()

            division(inputs!!.number1, inputs!!.number2)


        }


        btnmod.setOnClickListener {

            val inputs = obtainInput()

            modulus(inputs!!.number1, inputs!!.number2)


        }

    }

    data class Input(var number1: Int, var number2: Int)


    fun obtainInput(): Input?{

        val number1 = etnum1.text.toString()

        val number2 = etnum2.text.toString()


        if (number1.isBlank()) {

            etnum1.error="Number is required"

            return null

        }

        if (number2.isBlank()) {

            etnum2.error="Number Decimal is required"

            return null

        }

        return Input(number1.toInt(), number2.toInt())

    }

    fun addition(number1: Int, number2: Int) {

        val add = number1 + number2

        tvresult.text = add.toString()

    }


    fun subtraction(number1: Int, number2: Int) {

        val subtract = number1 - number2

        tvresult.text = subtract.toString()

    }


    fun division(number1: Int, number2: Int) {

        val divide = number1 / number2

        tvresult.text = divide.toString()

    }


    fun modulus(number1: Int, number2: Int) {

        val remainder = number1 % number2

        tvresult.text = remainder.toString()

    }


}


