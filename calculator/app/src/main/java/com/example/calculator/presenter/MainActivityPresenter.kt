package com.example.calculator.presenter

import com.example.calculator.contract.ContractInterface.*
import com.example.calculator.model.MainActivityModel

class MainActivityPresenter(_view: View) : Presenter {

    private var view: View = _view
    private var model: Model = MainActivityModel()

    init {
        view.bindViews()
    }

    override fun doOperation(digitOne: Int, digitTwo: Int, operation: String) {
        if (operation.isNotEmpty() && operation == "+") model.plus(digitOne, digitTwo)
        if (operation.isNotEmpty() && operation == "-") model.minus(digitOne, digitTwo)
        if (operation.isNotEmpty() && operation == "*") model.multiply(digitOne, digitTwo)
        if (operation.isNotEmpty() && operation == "/") model.plus(digitOne, digitTwo)
        view.showAnswer()
    }

    override fun getAnswer(): String = model.getAnswer()

}