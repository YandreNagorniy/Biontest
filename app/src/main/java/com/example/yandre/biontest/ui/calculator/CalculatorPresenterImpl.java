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
    double productive = calculateH2OList.get(0).productive;
    double zpv = calculateH2OList.get(0).zpv;

    @Override
    public void getCalculatorData() {
        long id = 1; //Брать id

        // get vodopotrebValue
        compositeDisposable.add(vodopotrebDao.getVodopotrebModel(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(vodopotrebModel -> vodopotrebValue = vodopotrebModel.getValue()));

        // get productive, zpv, humidityOfSoil
        compositeDisposable.add(calculatorDao.getDataFromCalculateH2O(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(calculateH2O -> calculateH2OList = calculateH2O));
    }

    private void calculateH2O(List<CalculateH2O> calculateH2OS) {
        calculateH2OList = calculateH2OS;
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
