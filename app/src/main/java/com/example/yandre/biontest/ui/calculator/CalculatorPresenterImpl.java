package com.example.yandre.biontest.ui.calculator;


import java.util.ArrayList;
import java.util.List;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    CalculatorView calculatorView;
    CalculatorModel calculatorModel;
    List<Double> itemList;

    public CalculatorPresenterImpl(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        itemList = new ArrayList<>();
    }

    @Override
    public void getData() {
        calculateN();
        calculateS();
        calculateP2O5();
        calculateCa();
        calculateK2O();
        calculateMg();
        calculateH2O();
    }

    public void calculateN() {
        calculatorModel.getCalculatorData();

    }

    public void calculateS() {

    }

    public void calculateP2O5() {

    }

    public void calculateCa() {

    }

    public void calculateK2O() {

    }

    public void calculateMg() {

    }

    public void calculateH2O() {

    }

    @Override
    public void onDestroy() {
        calculatorModel.onDestroy();
    }
}
