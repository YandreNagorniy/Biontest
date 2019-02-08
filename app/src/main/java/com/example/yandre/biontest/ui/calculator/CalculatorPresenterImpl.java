package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.CalculatorDao;
import com.example.yandre.biontest.database.dao.VodopotrebDao;
import com.example.yandre.biontest.database.model.VodopotrebModel;
import com.example.yandre.biontest.pojo.CalculateH2O;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CalculatorPresenterImpl implements CalculatorPresenter {
    private CalculatorView calculatorView;
    private CalculatorDao calculatorDao;
    private VodopotrebDao vodopotrebDao;
    private List<CalculateH2O> calculateH2OList;
    private CompositeDisposable compositeDisposable;

    public CalculatorPresenterImpl(CalculatorView calculatorView) {
        compositeDisposable = new CompositeDisposable();

        this.calculatorView = calculatorView;
        calculatorDao = App.getInstance().getDatabase().calculatorDao();
        vodopotrebDao = App.getInstance().getDatabase().vodopotrebDao();
    }

    private int vodopotrebValue;
    double productive;
    double zpv;
    double humidityOfSoil;
    private double vinosN;
    double kusvN;
    double phN;
    int settingsN;
    int settingsG;

    @Override
    public void getCalculatorData() {
        long id = 1; //Брать id

        // get vodopotrebValue
        compositeDisposable.add(vodopotrebDao.getVodopotrebValue(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> vodopotrebValue = integer));

//        // get productive, zpv, humidityOfSoil
        compositeDisposable.add(calculatorDao.getDataFromCalculateH2O(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(calculateH2OList -> {
                    zpv = calculateH2OList.get(0).zpv;
                    productive = calculateH2OList.get(0).productive;
                    humidityOfSoil = calculateH2OList.get(0).humidityOfSoil;
                }));

        compositeDisposable.add(calculatorDao.getVinosN(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aDouble -> vinosN = aDouble, Throwable::printStackTrace));

        compositeDisposable.add(calculatorDao.getSettingsN()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> settingsN = integer));

        compositeDisposable.add(calculatorDao.getSettingsG()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> settingsG = integer));

//        compositeDisposable.add(calculatorDao.getPhN()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(aDouble -> phN = aDouble));

        compositeDisposable.add(calculatorDao.getKUsvN(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aDouble -> kusvN = aDouble));
//        calculateN();
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

    public void calculateN() {
        int a = 0;
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }
}
