package com.example.yandre.biontest.ui.calculator;

import com.example.yandre.biontest.pojo.CalculateCaO;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateK2O;
import com.example.yandre.biontest.pojo.CalculateMgO;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculateP2O5;
import com.example.yandre.biontest.pojo.CalculateS;

import java.util.List;

import io.reactivex.Single;

public interface CalculatorRepository {

    Single<List<CalculateN>> getDataN(int id);

    Single<List<CalculateP2O5>> getDataP2O5(int id);

    Single<List<CalculateK2O>> getDataK2O(int id);

    Single<List<CalculateCaO>> getDataCaO(int id);

    Single<List<CalculateMgO>> getDataMgO(int id);

    Single<List<CalculateS>> getDataS(int id);

    Single<List<CalculateH2O>> getDataH2O(long id);

    Single<Double> getPhN(double settingsPH);

    Single<Double> getPhP2O5(double settingsPH);

    Single<Double> getPhK2O(double settingsPH);

    Single<Double> getPhCaO(double settingsPH);

    Single<Double> getPhMgO(double settingsPH);

    Single<Double> getPhS(double settingsPH);
}
