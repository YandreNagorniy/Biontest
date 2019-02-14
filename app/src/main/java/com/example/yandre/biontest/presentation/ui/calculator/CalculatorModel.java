package com.example.yandre.biontest.presentation.ui.calculator;

import com.example.yandre.biontest.data.pojo.CalculateH2O;

import java.util.List;

import io.reactivex.Flowable;

public interface CalculatorModel {

    List<Double> getDataN();

    void getDataS();

    void getDataP2O5();

    void getDataCa();

    void getDataK2O();

    void getDataMg();

    List<CalculateH2O> getDataH2O();

    void onDestroy();
}
