package com.example.yandre.biontest.ui.calculator;

import java.util.List;

import io.reactivex.Single;

public interface CalculatorPresenter {

    void getCalculatorData();

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

    Single<Double> getDataN(int id);


    Single<Double> getDataH20(long id);

    void onDestroy();

}
