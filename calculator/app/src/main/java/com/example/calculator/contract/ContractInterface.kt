package com.example.calculator.contract

interface ContractInterface {

    interface View {
        fun bindViews()
        fun showAnswer()
    }

    interface Presenter {
        fun doOperation(digitOne: Int, digitTwo: Int, operation: String)
        fun getAnswer(): String
    }

    interface Model {
        fun getAnswer(): String
        fun plus(digitOne: Int, digitTwo: Int)
        fun minus(digitOne: Int, digitTwo: Int)
        fun multiply(digitOne: Int, digitTwo: Int)
        fun divide(digitOne: Int, digitTwo: Int)
    }
}