package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.CalculatorDao;
import com.example.yandre.biontest.database.dao.VodopotrebDao;
import com.example.yandre.biontest.database.data.ValueData;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateK2O;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculateP2O5;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

public class CalculatorModelImpl implements CalculatorModel {
    private CalculatorDao calculatorDao;

    CalculatorModelImpl() {
        calculatorDao = App.getInstance().getDatabase().calculatorDao();
    }

    @Override
    public Single<List<CalculateN>> getDataN(int id) {
        return calculatorDao.getDataN(id, ValueData.N, ValueData.pH, ValueData.g);
    }

    @Override
    public Single<List<CalculateP2O5>> getDataP2O5(int id) {
        return calculatorDao.getDataP2O5(id, ValueData.P2O5, ValueData.pH);
    }

    @Override
    public Single<List<CalculateK2O>> getDataK2O(int id) {
        return calculatorDao.getDataK2O(id, ValueData.K2O, ValueData.pH);
    }

    @Override
    public Single<List<CalculateH2O>> getDataH2O(long id) {
        return calculatorDao.getDataH2O(id);
//        long id = 1; //Брать id
//        list = new ArrayList<>();
//
//        // get productive, zpv, humidityOfSoil
//        compositeDisposable.add(calculatorDao.getDataFromCalculateH2O(id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(calculateH2OList -> list = calculateH2OList));
    }

    @Override
    public Single<Double> getPhN(double settingsPH) {
        return calculatorDao.getPhN(settingsPH);
    }

    @Override
    public Single<Double> getPhP2O5(double settingsPH) {
        return calculatorDao.getPhP2O5(settingsPH);
    }

    @Override
    public Single<Double> getPhK2O(double settingsPH) {
        return calculatorDao.getPhK2O(settingsPH);
    }

}
