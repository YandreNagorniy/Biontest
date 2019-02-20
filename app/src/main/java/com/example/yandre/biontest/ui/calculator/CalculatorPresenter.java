package com.example.yandre.biontest.ui.calculator;

import java.util.List;

public interface CalculatorPresenter {

    List<Double> getData();

//
//    void calculateS();
//
//    void calculateP2O5();
//
//    void calculateCa();
//
//    void calculateK2O();
//
//    void calculateMg();
//
//    void calculateH2O();

    void calculateN(int id);

    void calculateS();

    void onDestroy();

}
