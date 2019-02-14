package com.example.yandre.biontest.presentation.ui.calculator;



import com.example.yandre.biontest.data.pojo.CalculateH2O;
import com.example.yandre.biontest.data.repositiry.CalculatorRepository;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    CalculatorView calculatorView;
    CalculatorModel calculatorModel;
    List<Double> itemList;
    CalculatorRepository repository;

    public CalculatorPresenterImpl(CalculatorView calculatorView, CalculatorRepository repository) {
        this.calculatorView = calculatorView;
        itemList = new ArrayList<>();
        this.repository = repository;
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

    @Override
    public void calculateN() {
        calculatorModel.getDataN();

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
        List<CalculateH2O> list = new ArrayList<>();
        list = calculatorModel.getDataH2O();

    }

    @Override
    public void onDestroy() {
        calculatorModel.onDestroy();
    }
}
