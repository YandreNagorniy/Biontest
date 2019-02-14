package com.example.yandre.biontest.presentation.ui.calculator;

import android.util.Log;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.data.database.dao.CalculatorDao;
import com.example.yandre.biontest.data.database.dao.VodopotrebDao;
import com.example.yandre.biontest.data.pojo.CalculateH2O;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

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
    public List<Double> getDataN() {
        long id = 1; //Брать id

        List<Single<Double>> list = new ArrayList<>();
        list.add(calculatorDao.getVinosN(id));
        list.add(calculatorDao.getSettingsN().map(Integer::doubleValue));
        list.add(calculatorDao.getSettingsG().map(Integer::doubleValue));
        list.add(calculatorDao.getKUsvN(id));
        list.add(calculatorDao.getSettingsPh().map(Integer::doubleValue));
        list.add(vodopotrebDao.getVodopotrebValue(id).map(Integer::doubleValue));

        List<Double> elList = new ArrayList<>();
        compositeDisposable.add(Single.concat(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aDouble -> {
                            if (elList.size() < 6)
                                elList.add(aDouble);
                            else {
                                compositeDisposable.add(calculatorDao.getPhN(Double.valueOf(elList.get(elList.size() - 1)))
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(aDouble1 -> {
                                            elList.add(aDouble1);
                                            print(elList);
                                        }));
                            }
                        }, Throwable::printStackTrace
                ));

        double d = calculatorDao.getKUsvN(id).blockingGet();

        return elList;
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
    public void getDataK2O() {

    }

    @Override
    public void getDataMg() {

    }

    private List<CalculateH2O> list;

    @Override
    public List<CalculateH2O> getDataH2O() {
        long id = 1; //Брать id
        list = new ArrayList<>();

        // get productive, zpv, humidityOfSoil
        compositeDisposable.add(calculatorDao.getDataFromCalculateH2O(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(calculateH2OList -> list = calculateH2OList));
        return list;
    }

    public void print(List<Double> list) {
        for (Double d : list) {
            Log.d("TAG", d.toString());
        }
        int a = 0;
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
