package com.example.calculator.model

import com.example.calculator.contract.ContractInterface.Model

class MainActivityModel : Model {

    private var answer = 0

    override fun getAnswer() = answer

    override fun plus(digitOne: Int, digitTwo: Int) {
        answer = digitOne + digitTwo
    }

    override fun minus(digitOne: Int, digitTwo: Int) {
        answer = digitOne - digitTwo
    }

    override fun multiply(digitOne: Int, digitTwo: Int) {
        answer = digitOne * digitTwo
    }

    override fun divide(digitOne: Int, digitTwo: Int) {
        answer = digitOne / digitTwo
    }
}