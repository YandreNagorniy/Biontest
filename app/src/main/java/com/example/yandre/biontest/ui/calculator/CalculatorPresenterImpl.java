package com.example.yandre.biontest.ui.calculator;

import android.util.Pair;

import com.example.yandre.biontest.pojo.CalculateCaO;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateK2O;
import com.example.yandre.biontest.pojo.CalculateMgO;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculateP2O5;
import com.example.yandre.biontest.pojo.CalculateS;
import com.example.yandre.biontest.pojo.ElementModel;
import com.example.yandre.biontest.pojo.TypeElement;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    private CalculatorView calculatorView;
    private CalculatorRepository calculatorRepository;
    private CompositeDisposable compositeDisposable;

    CalculatorPresenterImpl(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;
        calculatorRepository = new CalculatorRepositoryImpl();
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getCalculatorData() {
        List<Single<ElementModel>> list = new ArrayList<>();
        list.add(getDataN(1));
        list.add(getDataP2O5(1));
        list.add(getDataK2O(1));
        list.add(getDataCaO(1));
        list.add(getDataMgO(1));
        list.add(getDataS(1));
        list.add(getDataH20(1));

        compositeDisposable.add(Single.concat(list)
                .observeOn(AndroidSchedulers.mainThread())
                .buffer(7)
                .cache()
                .subscribe(elementModels -> calculatorView.displayData(elementModels)));
    }

    @Override
    public Single<ElementModel> getDataN(int id) {
        return calculatorRepository.getDataN(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateNList -> calculatorRepository.getPhN(calculateNList.get(1).value)
                        .zipWith(Single.just(calculateNList), Pair::new))
                .map(doubleListPair -> calculateN(doubleListPair.first, doubleListPair.second))
                .map(n -> new ElementModel(TypeElement.N, n));
    }

    @Override
    public Single<ElementModel> getDataP2O5(int id) {
        return calculatorRepository.getDataP2O5(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateP2O5List -> calculatorRepository.getPhP2O5(calculateP2O5List.get(0).value)
                        .zipWith(Single.just(calculateP2O5List), Pair::new)
                        .map(doubleListPair -> calculateP2O5(doubleListPair.first, doubleListPair.second))
                        .map(p2O5 -> new ElementModel(TypeElement.P2O5, p2O5)));
    }

    @Override
    public Single<ElementModel> getDataK2O(int id) {
        return calculatorRepository.getDataK2O(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateK2OList -> calculatorRepository.getPhK2O(calculateK2OList.get(0).value)
                        .zipWith(Single.just(calculateK2OList), Pair::new)
                        .map(doubleListPair -> calculateK2O(doubleListPair.first, doubleListPair.second))
                        .map(k2O -> new ElementModel(TypeElement.K2O, k2O)));
    }

    @Override
    public Single<ElementModel> getDataCaO(int id) {
        return calculatorRepository.getDataCaO(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateCaOList -> calculatorRepository.getPhCaO(calculateCaOList.get(0).value)
                        .zipWith(Single.just(calculateCaOList), Pair::new)
                        .map(doubleListPair -> calculateCaO(doubleListPair.first, doubleListPair.second))
                        .map(caO -> new ElementModel(TypeElement.CaO, caO)));
    }

    @Override
    public Single<ElementModel> getDataMgO(int id) {
        return calculatorRepository.getDataMgO(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateMgOList -> calculatorRepository.getPhMgO(calculateMgOList.get(0).value)
                        .zipWith(Single.just(calculateMgOList), Pair::new)
                        .map(doubleListPair -> calculateMgO(doubleListPair.first, doubleListPair.second))
                        .map(mgO -> new ElementModel(TypeElement.MgO, mgO)));
    }

    @Override
    public Single<ElementModel> getDataS(int id) {
        return calculatorRepository.getDataS(id)
                .subscribeOn(Schedulers.io())
                .flatMap(calculateSList -> calculatorRepository.getPhS(calculateSList.get(0).value)
                        .zipWith(Single.just(calculateSList), Pair::new)
                        .map(doubleListPair -> calculateS(doubleListPair.first, doubleListPair.second))
                        .map(s -> new ElementModel(TypeElement.S, s)));

    }

    @Override
    public Single<ElementModel> getDataH20(long id) {
        return calculatorRepository.getDataH2O(id)
                .subscribeOn(Schedulers.io())
                .map(this::calculateH2O)
                .map(h2O -> new ElementModel(TypeElement.H2O, h2O));
    }

    private double calculateN(Double value, List<CalculateN> list) {
        double kusvN = list.get(0).kusv_N;
        double productive = list.get(0).productive;
        double vinosN = list.get(0).vinos_N;
        double settingsN = list.get(2).value;        //n and g maybe replace
        double settingsG = list.get(0).value;
        double phN = value;
        double x;
        double n;
        if (settingsG > 4) x = 64 + settingsG * 0.16;
        else x = settingsG * 16;
        n = vinosN * productive - (settingsN * 3.96 * kusvN * phN + x);
        if (n < 0) return 0;
        else return n;
    }

    private double calculateH2O(List<CalculateH2O> calculateH2OList) {
        double productive = calculateH2OList.get(0).productive;
        double vodopotreb = calculateH2OList.get(0).value;
        double zpv = calculateH2OList.get(0).zpv;
        double h2O = (productive * vodopotreb * 0.043) - zpv;
        if (h2O < 0) return 0;
        else return h2O;
    }

    private double calculateP2O5(Double value, List<CalculateP2O5> calculateH2OList) {
        double kusvP2O5 = calculateH2OList.get(0).kusv_P2O5;
        double productive = calculateH2OList.get(0).productive;
        double vinosP2O5 = calculateH2OList.get(0).vinos_P2O5;
        double settingsP2O5 = calculateH2OList.get(1).value;
        double phP2O5 = value;
        double p2O5 = vinosP2O5 * productive - settingsP2O5 * kusvP2O5 * 3.96 * phP2O5;
        if (p2O5 < 0) return 0;
        else return p2O5;
    }

    private double calculateK2O(Double value, List<CalculateK2O> calculateK2OList) {
        double kusvK2O = calculateK2OList.get(0).kusv_K2O;
        double productive = calculateK2OList.get(0).productive;
        double vinosK2O = calculateK2OList.get(0).vinos_K2O;
        double settingsK2O = calculateK2OList.get(1).value;
        double phK2O = value;
        double k2O = vinosK2O * productive - settingsK2O * kusvK2O * 3.96 * phK2O;
        if (k2O < 0) return 0;
        else return k2O;
    }

    private double calculateCaO(Double value, List<CalculateCaO> calculateCaOList) {
        double kusvCaO = calculateCaOList.get(0).kusv_CaO;
        double productive = calculateCaOList.get(0).productive;
        double vinosCaO = calculateCaOList.get(0).vinos_CaO;
        double settingsCaO = calculateCaOList.get(1).value;
        double phCaO = value;
        double caO = vinosCaO * productive - settingsCaO * kusvCaO * 3.96 * 20 * phCaO;
        if (caO < 0) return 0;
        else return caO;
    }

    private double calculateMgO(Double value, List<CalculateMgO> calculateMgOList) {
        double kusvMgO = calculateMgOList.get(0).kusv_MgO;
        double productive = calculateMgOList.get(0).productive;
        double vinosMgO = calculateMgOList.get(0).vinos_MgO;
        double settingsMgO = calculateMgOList.get(1).value;
        double phMgO = value;
        double mgO = vinosMgO * productive - settingsMgO * kusvMgO * 3.96 * 12 * phMgO;
        if (mgO < 0) return 0;
        else return mgO;
    }

    private double calculateS(Double value, List<CalculateS> calculateSList) {
        double kusvS = calculateSList.get(0).kusv_S;
        double productive = calculateSList.get(0).productive;
        double vinosS = calculateSList.get(0).vinos_S;
        double settingsS = calculateSList.get(1).value;
        double phS = value;
        double s = vinosS * productive - settingsS * kusvS * 3.96 * phS;
        if (s < 0) return 0;
        else return s;
    }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
    }
}