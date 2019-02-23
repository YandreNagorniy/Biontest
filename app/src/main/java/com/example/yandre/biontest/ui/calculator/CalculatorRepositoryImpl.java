package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.CalculatorDao;
import com.example.yandre.biontest.database.data.ValueData;
import com.example.yandre.biontest.pojo.CalculateCaO;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateK2O;
import com.example.yandre.biontest.pojo.CalculateMgO;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculateP2O5;
import com.example.yandre.biontest.pojo.CalculateS;

import java.util.List;

import io.reactivex.Single;

public class CalculatorRepositoryImpl implements CalculatorRepository {
    private CalculatorDao calculatorDao;

    CalculatorRepositoryImpl() {
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
    public Single<List<CalculateCaO>> getDataCaO(int id) {
        return calculatorDao.getDataCaO(id, ValueData.CaO, ValueData.pH);
    }

    @Override
    public Single<List<CalculateMgO>> getDataMgO(int id) {
        return calculatorDao.getDataMgO(id, ValueData.MgO, ValueData.pH);
    }

    @Override
    public Single<List<CalculateS>> getDataS(int id) {
        return calculatorDao.getDataS(id, ValueData.S, ValueData.pH);
    }

    @Override
    public Single<List<CalculateH2O>> getDataH2O(long id) {
        return calculatorDao.getDataH2O(id);
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

    @Override
    public Single<Double> getPhCaO(double settingsPH) {
        return calculatorDao.getPhCaO(settingsPH);
    }

    @Override
    public Single<Double> getPhMgO(double settingsPH) {
        return calculatorDao.getPhMgO(settingsPH);
    }

    @Override
    public Single<Double> getPhS(double settingsPH) {
        return calculatorDao.getPhS(settingsPH);
    }

}
