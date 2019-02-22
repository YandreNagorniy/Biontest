package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.pojo.ElementModel;

import io.reactivex.Single;

public interface CalculatorPresenter {

    void getCalculatorData();

    Single<ElementModel> getDataN(int id);

    Single<ElementModel> getDataP2O5(int id);

    Single<ElementModel> getDataK2O(int id);

    Single<ElementModel> getDataCaO(int id);

    Single<ElementModel> getDataMgO(int id);

    Single<ElementModel> getDataS(int id);

    Single<ElementModel> getDataH20(long id);

    void onDestroy();

}
