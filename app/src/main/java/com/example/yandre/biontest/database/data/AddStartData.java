package com.example.yandre.biontest.database.data;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.KUsvDao;
import com.example.yandre.biontest.database.dao.Method1Dao;
import com.example.yandre.biontest.database.dao.Method2Dao;
import com.example.yandre.biontest.database.dao.MethodsDao;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.model.KUsvModel;
import com.example.yandre.biontest.database.model.Method1Model;
import com.example.yandre.biontest.database.model.Method2Model;
import com.example.yandre.biontest.database.model.MethodsModel;
import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class AddStartData {
    List<Method1Model> method1List;
    List<Method2Model> method2List;

    public static void AddAllData() {
        setSoilFactorsData();         //добавить почвенные факторы
//        setCalculatorData();
        setKUsvData();
        setMethod1Data();
        setMethod2Data();
        setMethodsData();
        setPhasesData();
        setPHData();
        setPotrebOsadkiData();
        setVinosData();
        setVodopotrebData();
    }

    private static void setSoilFactorsData() {
        SoilFactorsDao soilFactorsDao;
        soilFactorsDao = App.getInstance().getDatabase().soilFactorsDao();

        List<SoilFactorsModel> soilFactorsList = new ArrayList<>();
        soilFactorsList.add(new SoilFactorsModel("Гумус", "g", 3));
        soilFactorsList.add(new SoilFactorsModel("title", "pH", 4));
        soilFactorsList.add(new SoilFactorsModel("title", "N", 1));
        soilFactorsList.add(new SoilFactorsModel("title", "P205", 2));
        soilFactorsList.add(new SoilFactorsModel("title", "K20", 5));
        soilFactorsList.add(new SoilFactorsModel("title", "CaO", 5));
        soilFactorsList.add(new SoilFactorsModel("title", "MgO", 7));
        soilFactorsList.add(new SoilFactorsModel("title", "S", 3));
        soilFactorsList.add(new SoilFactorsModel("title", "Zn", 9));
        soilFactorsList.add(new SoilFactorsModel("title", "Mo", 7));
        soilFactorsList.add(new SoilFactorsModel("title", "Cu", 5));
        soilFactorsList.add(new SoilFactorsModel("title", "Mn", 8));
        soilFactorsList.add(new SoilFactorsModel("title", "Co", 8));
        soilFactorsList.add(new SoilFactorsModel("title", "B", 8));
        soilFactorsList.add(new SoilFactorsModel("title", "Fe", 8));

        Completable.fromAction(() -> soilFactorsDao.insertList(soilFactorsList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private void setCalculatorData() {
    }

    private static void setKUsvData() {
        KUsvDao kUsvDao =
                App.getInstance().getDatabase().kUsvDao();

        List<KUsvModel> kUsvList = new ArrayList<>();
        kUsvList.add(new KUsvModel("Озимая пшеница", 0.6, 0.25, 0.13, 0.06,
                0.13, 0.6, 0.3, 0.03, 0.05, 0.01, 0.03, 0.01, 0.06));

        Completable.fromAction(() -> kUsvDao.insertList(kUsvList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setMethod1Data() {
        Method1Dao method1Dao =
                App.getInstance().getDatabase().method1Dao();

        List<Method1Model> method1List = new ArrayList<>();
        method1List.add(new Method1Model("Очень низкое", 40, -1,
                20, -1, 100, -1, 2.295, 4.985));
        method1List.add(new Method1Model("Низкое", 41, 80,
                21, 40, 101, 200, 2.474, 4.812));
        method1List.add(new Method1Model("Среднее", 81, 120,
                41, 80, 201, 300, 2.468, 4.702));
        method1List.add(new Method1Model("Повышенное", 121, 170,
                81, 120, 301, 400, 2.577, 4.404));
        method1List.add(new Method1Model("Высокое", 171, 250,
                121, 180, 401, 600, 2.338, 3.310));
        method1List.add(new Method1Model("Очень высокое", 251, -1,
                181, -1, 601, -1, 2.400, 3.333));

        Completable.fromAction(() -> method1Dao.insertList(method1List))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setMethod2Data() {
        Method2Dao method2Dao =
                App.getInstance().getDatabase().method2Dao();

        List<Method2Model> method2List = new ArrayList<>();
        method2List.add(new Method2Model("Очень низкое", 25, -1,
                20, -1, 10, -1, 0.400, 0.526));
        method2List.add(new Method2Model("Низкое", 26, 50,
                21, 50, 11, 15, 0.353, 0.372));
        method2List.add(new Method2Model("Среднее", 51, 100,
                51, 100, 16, 30, 0.305, 0.341));
        method2List.add(new Method2Model("Повышенное", 101, 150,
                101, 150, 31, 45, 0.303, 0.315));
        method2List.add(new Method2Model("Высокое", 151, 250,
                151, 200, 46, 60, 0.265, 0.305));
        method2List.add(new Method2Model("Очень высокое", 251, -1,
                201, -1, 61, -1, 0.243, 0.300));

        Completable.fromAction(() -> method2Dao.insertList(method2List))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setMethodsData() {
        MethodsDao methodsDao =
                App.getInstance().getDatabase().methodsDao();

        List<MethodsModel> methodsList = new ArrayList<>();
    }

    private static void setPhasesData() {
    }

    private static void setPHData() {
    }

    private static void setPotrebOsadkiData() {
    }

    private static void setVinosData() {
    }

    private static void setVodopotrebData() {
    }
}
