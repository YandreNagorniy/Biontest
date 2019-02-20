package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.CalculatorDao;
import com.example.yandre.biontest.database.dao.VodopotrebDao;
import com.example.yandre.biontest.database.data.ValueData;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateN;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

public class CalculatorModelImpl implements CalculatorModel {
    private CalculatorPresenter calculatorPresenter;
    private CalculatorDao calculatorDao;
    private VodopotrebDao vodopotrebDao;
    private CompositeDisposable compositeDisposable;

    public CalculatorModelImpl(CalculatorPresenter calculatorPresenter) {
        this.calculatorPresenter = calculatorPresenter;

        compositeDisposable = new CompositeDisposable();
        calculatorDao = App.getInstance().getDatabase().calculatorDao();
        vodopotrebDao = App.getInstance().getDatabase().vodopotrebDao();
    }

    private int vodopotrebValue;

    @Override
    public Single<List<CalculateN>> getDataN(int id) {
        return calculatorDao.getDataN(id, ValueData.N, ValueData.pH, ValueData.g);
//        long id = 1; //Брать id
//        compositeDisposable.add(calculatorDao.getDataN(1, ValueData.N, ValueData.pH, ValueData.g)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<CalculateN>>() {
//                    @Override
//                    public void accept(List<CalculateN> calculateNS) throws Exception {
//                        int a = 0;
//                    }
//
    }

    @Override
    public Single<Double> getPhN(double settingsPH) {
        return calculatorDao.getPhN(settingsPH);
    }

    @Override
    public void getDataS() {

    }

    @Override
    public void getDataP2O5() {

    }

    @Override
    public void getDataCa() {

    }

    @Override
    public void getDataK20() {

    }

    @Override
    public void getDataMg() {

    }

    private List<CalculateH2O> list;

    @Override
    public Single<List<CalculateH2O>> getDataH2O(long id) {
        return calculatorDao.getDataFromCalculateH2O(id);
//        long id = 1; //Брать id
//        list = new ArrayList<>();
//
//        // get productive, zpv, humidityOfSoil
//        compositeDisposable.add(calculatorDao.getDataFromCalculateH2O(id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(calculateH2OList -> list = calculateH2OList));
    }


    public void calculateH2O(List<CalculateH2O> calculateH2OList) {
        double H2O = 0;
        //не 0, а id-1
        double productive = calculateH2OList.get(0).productive;
        double zpv = calculateH2OList.get(0).zpv;

        double result = (productive * vodopotrebValue * 0.043) - zpv;
        if (result < 0) {
            H2O = 0;
        } else H2O = result;
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }


}
