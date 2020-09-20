package com.example.calculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.calculator.R
import com.example.calculator.contract.ContractInterface.View
import com.example.calculator.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), View {

    private var presenter: MainActivityPresenter? = null
    private var valueOne: Int = INITIAL_VALUE
    private var valueTwo: Int = INITIAL_VALUE
    private var operation: String = ""

    private lateinit var editText: EditText
    private lateinit var _9: Button
    private lateinit var _8: Button
    private lateinit var _7: Button
    private lateinit var _6: Button
    private lateinit var _5: Button
    private lateinit var _4: Button
    private lateinit var _3: Button
    private lateinit var _2: Button
    private lateinit var _1: Button
    private lateinit var _0: Button
    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var multiply: Button
    private lateinit var divide: Button
    private lateinit var equals: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenter(this)
        valueOne = INITIAL_VALUE
        valueTwo = INITIAL_VALUE
    }

    override fun bindViews() {
        editText = findViewById(R.id.editText)
        _9 = findViewById(R.id._9)
        _8 = findViewById(R.id._8)
        _7 = findViewById(R.id._7)
        _6 = findViewById(R.id._6)
        _5 = findViewById(R.id._5)
        _4 = findViewById(R.id._4)
        _3 = findViewById(R.id._3)
        _2 = findViewById(R.id._2)
        _1 = findViewById(R.id._1)
        _0 = findViewById(R.id._0)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        divide = findViewById(R.id.divide)
        equals = findViewById(R.id.equals)

        _9.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.nine))
            else editText.append(getString(R.string.nine))
        }

        _8.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.eight))
            else editText.append(getString(R.string.eight))
        }

        _7.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.seven))
            else editText.append(getString(R.string.seven))
        }

        _6.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.six))
            else editText.append(getString(R.string.six))
        }

        _5.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.five))
            else editText.append(getString(R.string.five))
        }

        _4.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.four))
            else editText.append(getString(R.string.four))
        }

        _3.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.three))
            else editText.append(getString(R.string.three))
        }

        _2.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.two))
            else editText.append(getString(R.string.two))
        }

        _1.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.one))
            else editText.append(getString(R.string.one))
        }

        _0.setOnClickListener {
            if (editText.text.toString() == getString(R.string.zero)) editText.setText(getString(R.string.zero))
            else editText.append(getString(R.string.zero))
        }

        plus.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                valueOne = editText.text.toString().toInt()
                operation = "+"
                editText.setText("")
            }
        }

        minus.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                valueOne = editText.text.toString().toInt()
                operation = "-"
                editText.setText("")
            }
        }

        multiply.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                valueOne = editText.text.toString().toInt()
                operation = "*"
                editText.setText("")
            }
        }

        divide.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                valueOne = editText.text.toString().toInt()
                operation = "/"
                editText.setText("")
            }
        }

        equals.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                valueTwo = editText.text.toString().toInt()
                presenter?.doOperation(valueOne, valueTwo, operation)
            }
        }
        showAnswer()
    }

    override fun showAnswer() {
        val info = presenter?.getAnswer()
        editText.setText(info)
    }

    companion object {
        const val INITIAL_VALUE = 0
    }
}