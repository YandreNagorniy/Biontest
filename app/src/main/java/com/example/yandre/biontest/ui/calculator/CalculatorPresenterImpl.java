package com.example.yandre.biontest.ui.calculator;

import android.util.Pair;

import com.example.yandre.biontest.pojo.CalculateCaO;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateK2O;
import com.example.yandre.biontest.pojo.CalculateMgO;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculateP2O5;
import com.example.yandre.biontest.pojo.CalculateS;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;
    private CompositeDisposable compositeDisposable;

    CalculatorPresenterImpl(CalculatorView calculatorView) {
        compositeDisposable = new CompositeDisposable();
        calculatorModel = new CalculatorModelImpl();
        this.calculatorView = calculatorView;
    }

    @Override
    public void getCalculatorData() {
        List<Double> list = new ArrayList<>();
        compositeDisposable.add(Single.concat(getDataS(1), getDataH20(1), getDataMgO(1), getDataCaO(1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list::add,
                        throwable -> calculatorView.showError(throwable.getMessage()),
                        () -> calculatorView.fillData(list)));
    }

    @Override
    public Single<Double> getDataN(int id) {
        return calculatorModel.getDataN(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateNList -> calculatorModel.getPhN(calculateNList.get(1).value)
                        .zipWith(Single.just(calculateNList), Pair::new))
                .map(doubleListPair -> calculateN(doubleListPair.first, doubleListPair.second));
    }

    @Override
    public Single<Double> getDataP2O5(int id) {
        return calculatorModel.getDataP2O5(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateP2O5List -> calculatorModel.getPhP2O5(calculateP2O5List.get(0).value)
                        .zipWith(Single.just(calculateP2O5List), Pair::new)
                        .map(doubleListPair -> calculateP2O5(doubleListPair.first, doubleListPair.second)));
    }

    @Override
    public Single<Double> getDataK2O(int id) {
        return calculatorModel.getDataK2O(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateK2OList -> calculatorModel.getPhK2O(calculateK2OList.get(0).value)
                        .zipWith(Single.just(calculateK2OList), Pair::new)
                        .map(doubleListPair -> calculateK2O(doubleListPair.first, doubleListPair.second)));
    }

    @Override
    public Single<Double> getDataCaO(int id) {
        return calculatorModel.getDataCaO(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateCaOList -> calculatorModel.getPhCaO(calculateCaOList.get(0).value)
                        .zipWith(Single.just(calculateCaOList), Pair::new)
                        .map(doubleListPair -> calculateCaO(doubleListPair.first, doubleListPair.second)));
    }

    @Override
    public Single<Double> getDataMgO(int id) {
        return calculatorModel.getDataMgO(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateMgOList -> calculatorModel.getPhMgO(calculateMgOList.get(0).value)
                        .zipWith(Single.just(calculateMgOList), Pair::new)
                        .map(doubleListPair -> calculateMgO(doubleListPair.first, doubleListPair.second)));
    }

    @Override
    public Single<Double> getDataS(int id) {
        return calculatorModel.getDataS(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateSList -> calculatorModel.getPhS(calculateSList.get(0).value)
                        .zipWith(Single.just(calculateSList), Pair::new)
                        .map(doubleListPair -> calculateS(doubleListPair.first, doubleListPair.second)));
    }

    @Override
    public Single<Double> getDataH20(long id) {
        return calculatorModel.getDataH2O(id)
                .subscribeOn(Schedulers.io())
                .map(this::calculateH2O);
    }

    private double calculateN(Double value, List<CalculateN> list) {
        double kusvN = list.get(0).kusv_N;
        double productive = list.get(0).productive;
        double vinosN = list.get(0).vinos_N;
        double settingsN = list.get(2).value;        //n and g maybe replace
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

    private double calculateH2O(List<CalculateH2O> calculateH2OList) {
        double productive = calculateH2OList.get(0).productive;
        double vodopotreb = calculateH2OList.get(0).value;
        double zpv = calculateH2OList.get(0).zpv;
        double H2O = (productive * vodopotreb * 0.043) - zpv;
        if (H2O < 0) return 0;
        else return H2O;
    }

    private double calculateP2O5(Double value, List<CalculateP2O5> calculateH2OList) {
        double kusvP2O5 = calculateH2OList.get(0).kusv_P2O5;
        double productive = calculateH2OList.get(0).productive;
        double vinosP2O5 = calculateH2OList.get(0).vinos_P2O5;
        double settingsP2O5 = calculateH2OList.get(1).value;
        double phP2O5 = value;
        double P2O5 = vinosP2O5 * productive - settingsP2O5 * kusvP2O5 * 3.96 * phP2O5;
        if (P2O5 < 0) return 0;
        else return P2O5;
    }

    private double calculateK2O(Double value, List<CalculateK2O> calculateK2OList) {
        double kusvK2O = calculateK2OList.get(0).kusv_K2O;
        double productive = calculateK2OList.get(0).productive;
        double vinosK2O = calculateK2OList.get(0).vinos_K2O;
        double settingsK2O = calculateK2OList.get(1).value;
        double phK2O = value;
        double K2O = vinosK2O * productive - settingsK2O * kusvK2O * 3.96 * phK2O;
        if (K2O < 0) return 0;
        else return K2O;
    }

    private double calculateCaO(Double value, List<CalculateCaO> calculateCaOList) {
        double kusvCaO = calculateCaOList.get(0).kusv_CaO;
        double productive = calculateCaOList.get(0).productive;
        double vinosCaO = calculateCaOList.get(0).vinos_CaO;
        double settingsCaO = calculateCaOList.get(1).value;
        double phCaO = value;
        double CaO = vinosCaO * productive - settingsCaO * kusvCaO * 3.96 * 20 * phCaO;
        if (CaO < 0) return 0;
        else return CaO;
    }

    private double calculateMgO(Double value, List<CalculateMgO> calculateMgOList) {
        double kusvMgO = calculateMgOList.get(0).kusv_MgO;
        double productive = calculateMgOList.get(0).productive;
        double vinosMgO = calculateMgOList.get(0).vinos_MgO;
        double settingsMgO = calculateMgOList.get(1).value;
        double phMgO = value;
        double MgO = vinosMgO * productive - settingsMgO * kusvMgO * 3.96 * 12 * phMgO;
        if (MgO < 0) return 0;
        else return MgO;
    }

    private double calculateS(Double value, List<CalculateS> calculateSList) {
        double kusvS = calculateSList.get(0).kusv_S;
        double productive = calculateSList.get(0).productive;
        double vinosS = calculateSList.get(0).vinos_S;
        double settingsS = calculateSList.get(1).value;
        double phS = value;
        double S = vinosS * productive - settingsS * kusvS * 3.96  * phS;
        if (S < 0) return 0;
        else return S;
    }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
    }
}
