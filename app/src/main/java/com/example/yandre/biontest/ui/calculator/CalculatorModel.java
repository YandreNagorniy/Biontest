package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.pojo.CalculateN;

import java.util.List;

import io.reactivex.Single;

public interface CalculatorModel {

    Single<List<CalculateN>> getDataN(int id);

    Single<Double> getPhN(double settingsPH);

    void getDataS();

    void getDataP2O5();

    void getDataCa();

    void getDataK20();

    void getDataMg();

    void getDataH2O();

    void onDestroy();

}
