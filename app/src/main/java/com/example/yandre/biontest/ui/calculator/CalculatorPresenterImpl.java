package com.example.yandre.biontest.ui.calculator;

import android.annotation.SuppressLint;
import android.util.Pair;

import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateN;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;
    private CompositeDisposable compositeDisposable;


    public CalculatorPresenterImpl(CalculatorView calculatorView) {
        compositeDisposable = new CompositeDisposable();

        calculatorModel = new CalculatorModelImpl(this);
        this.calculatorView = calculatorView;

    }

    @Override
    public void getCalculatorData() {
        List<Double> list = new ArrayList<>();
        compositeDisposable.add(Single.concat(getDataN(1), getDataH20(1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list::add,
                        throwable -> calculatorView.showError(throwable.getMessage()),
                        () -> calculatorView.fillData(list)));
    }

    @SuppressLint("CheckResult")
    @Override
    public Single<Double> getDataN(int id) {

        return calculatorModel.getDataN(id)
                .subscribeOn(Schedulers.io())
                .flatMap(list -> calculatorModel.getPhN(list.get(1).value)
                        .zipWith(Single.just(list), Pair::new))
                .map(doubleListPair -> calculateN(doubleListPair.first, doubleListPair.second));
    }

    @Override
    public Single<Double> getDataH20(long id) {
        return calculatorModel.getDataH2O(id)
                .subscribeOn(Schedulers.io())
                .map(this::calculateH20);
    }

    @Override
    public void onDestroy() {
        calculatorModel.onDestroy();
    }

    private double calculateN(Double value, List<CalculateN> list) {
        double kusvN = list.get(0).kusv_N;
        double productive = list.get(0).productive;
        double vinosN = list.get(0).vinos_N;
        //n and g maybe replace
        double settingsN = list.get(2).value;
        double settingsG = list.get(0).value;
        double phN = value;
        double x;
        double N;

        if (settingsG > 4) x = 64 + settingsG * 0.16;
        else x = settingsG * 16;
        N = vinosN * productive - (settingsN * 3.96 * kusvN * phN + x);
        if (N < 0) return 0;
        else return N;
    }

    private double calculateH20(List<CalculateH2O> calculateH2OList) {
        double productive = calculateH2OList.get(0).productive;
        double vodopotreb = calculateH2OList.get(0).value;
        double zpv = calculateH2OList.get(0).zpv;
        double H2O = (productive * vodopotreb * 0.043) - zpv;
        if (H2O < 0) return 0;
        else return H2O;
    }
}
