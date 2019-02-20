package com.example.yandre.biontest.ui.calculator;

import android.annotation.SuppressLint;

import com.example.yandre.biontest.pojo.CalculateN;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;
    private List<Double> itemList;
    private CompositeDisposable compositeDisposable;


    public CalculatorPresenterImpl(CalculatorView calculatorView) {
        compositeDisposable = new CompositeDisposable();

        calculatorModel = new CalculatorModelImpl(this);
        this.calculatorView = calculatorView;
    }

    @Override
    public List<Double> getData() {
        itemList = new ArrayList<>();

//        calculatorModel.getDataS();
//        calculatorModel.getDataP2O5();
//        calculatorModel.getDataCa();
//        calculatorModel.getDataK20();
//        calculatorModel.getDataMg();
        this.calculateN(1);
        calculatorModel.getDataH2O();

        return itemList;
    }

    //    private double kusvN;
//    private double productive;
//    private double vinosN;
//    private double settingsN;
    private double settingsPH;
    private double settingsG;
    private double phN;

    @SuppressLint("CheckResult")
    @Override
    public void calculateN(int id) {
        compositeDisposable.add(calculatorModel.getDataN(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    double kusvN = list.get(0).kusv_N;
                    double productive = list.get(0).productive;
                    double vinosN = list.get(0).vinos_N;
                    double settingsN = list.get(0).value;
                    settingsPH = list.get(1).value;
                    settingsG = list.get(2).value;

                    calculatorModel.getPhN(settingsPH)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<Double>() {
                                @Override
                                public void accept(Double aDouble) throws Exception {
                                    phN = aDouble;
                                }
                            });
                }, throwable -> {
                }));

        double a = settingsPH;
        double b = phN;
    }

    @Override
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
