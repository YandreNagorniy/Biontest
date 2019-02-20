package com.example.yandre.biontest.ui.calculator;

import android.annotation.SuppressLint;
import android.util.Pair;

import com.example.yandre.biontest.pojo.CalculateN;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
        calculatorModel.getDataH2O(1);

        return itemList;
    }

    @SuppressLint("CheckResult")
    @Override
    public void calculateN(int id) {
//        List<CalculateN> array = new ArrayList<>();
//        compositeDisposable.add(calculatorModel.getDataN(id)
//                .subscribeOn(Schedulers.io())
//                .flatMap(list ->
//                    calculatorModel.getPhN(list.get(1).value)
//                            .zipWith(Single.just(list), new BiFunction<Double, List<CalculateN>, Pair<Double,List<CalculateN>>>() {
//                                @Override
//                                public Pair<Double, List<CalculateN>> apply(Double aDouble, List<CalculateN> list) throws Exception {
//                                    return new Pair<>(aDouble,list);
//                                }
//                            })
//                )
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(value -> calculatorView.setN(initN(value, array)),
//                        throwable -> {
//                        }));

        compositeDisposable.add(calculatorModel.getDataN(id)
                .subscribeOn(Schedulers.io())
                .flatMap(list -> calculatorModel.getPhN(list.get(1).value)
                        .zipWith(Single.just(list), Pair::new))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(doubleListPair -> calculatorView.setN(initN(doubleListPair.first, doubleListPair.second)),
                        throwable -> calculatorView.showError(throwable.getMessage())));
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

    public void calculateH2O(long id) {

        compositeDisposable.add(calculatorModel.getDataH2O(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(doubleListPair -> calculatorView.setN(1),
                        throwable -> calculatorView.showError(throwable.getMessage())));
    }

    @Override
    public void onDestroy() {
        calculatorModel.onDestroy();
    }

    private double initN(Double value, List<CalculateN> list) {
        double kusvN = list.get(0).kusv_N;
        double productive = list.get(0).productive;
        double vinosN = list.get(0).vinos_N;
        double settingsN = list.get(0).value;
        double settingsPH = list.get(1).value;
        double settingsG = list.get(2).value;
        return 0;
    }
}
