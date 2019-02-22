package com.example.yandre.biontest.ui.calculator;

import java.util.List;

import io.reactivex.Single;

public interface CalculatorPresenter {

    void getCalculatorData();

    Single<Double> getDataN(int id);


    Single<Double> getDataP2O5(int id);

    Single<Double> getDataK2O(int id);

    Single<Double> getDataH20(long id);

    void onDestroy();

}
