package com.example.yandre.biontest.database.data;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.CalculatorDao;
import com.example.yandre.biontest.database.dao.KUsvDao;
import com.example.yandre.biontest.database.dao.Method1Dao;
import com.example.yandre.biontest.database.dao.Method2Dao;
import com.example.yandre.biontest.database.dao.MethodsDao;
import com.example.yandre.biontest.database.dao.MethodsK2ODao;
import com.example.yandre.biontest.database.dao.MethodsNDao;
import com.example.yandre.biontest.database.dao.MethodsP2O5Dao;
import com.example.yandre.biontest.database.dao.PHDao;
import com.example.yandre.biontest.database.dao.PotrebOsadkiDao;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.dao.VinosDao;
import com.example.yandre.biontest.database.dao.VodopotrebDao;
import com.example.yandre.biontest.database.model.CalculatorModel;
import com.example.yandre.biontest.database.model.KUsvModel;
import com.example.yandre.biontest.database.model.Method1Model;
import com.example.yandre.biontest.database.model.Method2Model;
import com.example.yandre.biontest.database.model.MethodsK2OModel;
import com.example.yandre.biontest.database.model.MethodsModel;
import com.example.yandre.biontest.database.model.MethodsNModel;
import com.example.yandre.biontest.database.model.MethodsP2O5Model;
import com.example.yandre.biontest.database.model.PHModel;
import com.example.yandre.biontest.database.model.PotrebOsadkiModel;
import com.example.yandre.biontest.database.model.SoilFactorsModel;
import com.example.yandre.biontest.database.model.VinosModel;
import com.example.yandre.biontest.database.model.VodopotrebModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

//Убрать это и сделать базу в assets/databases/
public class AddStartData {
    List<Method1Model> method1List;
    List<Method2Model> method2List;

    public static void AddAllData() {
        setCalculatorData();
        setSoilFactorsData();         //добавить почвенные факторы
        setKUsvData();
        setMethodsK20();
        setMethodsP2O5();
        setMethodsN();
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


    private static void setMethodsK20() {
        MethodsK2ODao methodsK2ODao =
                App.getInstance().getDatabase().methodsK2ODao();

        List<MethodsK2OModel> methodsK2OList = new ArrayList<>();
        methodsK2OList.add(new MethodsK2OModel("Очень низкое", 40, -1, 20, -1, 100, -1, 2.295, 4.985));
        methodsK2OList.add(new MethodsK2OModel("Низкое", 41, 80, 21, 40, 101, 200, 2.474, 4.812));
        methodsK2OList.add(new MethodsK2OModel("Среднее", 81, 120, 41, 80, 201, 300, 2.468, 4.702));
        methodsK2OList.add(new MethodsK2OModel("Повышенное", 121, 170, 81, 120, 301, 400, 2.577, 4.404));
        methodsK2OList.add(new MethodsK2OModel("Высокое", 171, 250, 121, 180, 401, 600, 2.338, 3.310));
        methodsK2OList.add(new MethodsK2OModel("Очень высокое", 251, -1, 181, -1, 601, -1, 2.400, 3.333));

        Completable.fromAction(() -> methodsK2ODao.insertList(methodsK2OList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setMethodsP2O5() {
        MethodsP2O5Dao methodsP2O5Dao =
                App.getInstance().getDatabase().methodsP2O5Dao();

        List<MethodsP2O5Model> methodsP2O5List = new ArrayList<>();
        methodsP2O5List.add(new MethodsP2O5Model("Очень низкое", 25, -1, 20, -1, 10, -1, 0.400, 0.526));
        methodsP2O5List.add(new MethodsP2O5Model("Низкое", 26, 50, 21, 50, 11, 15, 0.353, 0.372));
        methodsP2O5List.add(new MethodsP2O5Model("Среднее", 51, 100, 51, 100, 16, 30, 0.305, 0.341));
        methodsP2O5List.add(new MethodsP2O5Model("Повышенное", 101, 150, 101, 150, 31, 45, 0.303, 0.315));
        methodsP2O5List.add(new MethodsP2O5Model("Высокое", 151, 250, 151, 200, 46, 60, 0.265, 0.305));
        methodsP2O5List.add(new MethodsP2O5Model("Очень высокое", 251, -1, 201, -1, 61, -1, 0.243, 0.300));

        Completable.fromAction(() -> methodsP2O5Dao.insertList(methodsP2O5List))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setMethodsN() {
        MethodsNDao methodsNDao =
                App.getInstance().getDatabase().methodsNDao();

        List<MethodsNModel> methodsNList = new ArrayList<>();
        methodsNList.add(new MethodsNModel("Очень низкое", 30, -1, 100, -1, 5, -1, 0.265, 0.081));
        methodsNList.add(new MethodsNModel("Низкое", 31, 40, 101, 150, 6, 8, 0.313, 0.095));
        methodsNList.add(new MethodsNModel("Среднее", 41, 50, 151, 200, 9, 15, 0.429, 0.116));
        methodsNList.add(new MethodsNModel("Повышенное", 51, 70, 201, 300, 16, 30, 0.598, 0.156));
        methodsNList.add(new MethodsNModel("Высокое", 71, 100, 301, 500, 31, 60, 0.852, 0.193));
        methodsNList.add(new MethodsNModel("Очень высокое", 101, -1, 501, -1, 61, -1, 1.046, 0.207));

        Completable.fromAction(() -> methodsNDao.insertList(methodsNList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setPhasesData() {
    }

    private static void setPHData() {
        PHDao phDao =
                App.getInstance().getDatabase().phDao();

        List<PHModel> phList = new ArrayList<>();
        phList.add(new PHModel(4.0, 0.37, 0.3, 0.3, 0.2, 0.2, 0.3, 0.2, 0.2, 0.2, 0.2, 0.2, 0.8, 1));
        phList.add(new PHModel(4.1, 0.45, 0.31, 0.4, 0.22, 0.22, 0.4, 0.25, 0.23, 0.25, 0.22, 0.25, 0.19, 1));
        phList.add(new PHModel(4.2, 0.48, 0.32, 0.5, 0.25, 0.25, 0.5, 0.3, 0.25, 0.3, 0.25, 0.3, 0.2, 1));
        phList.add(new PHModel(4.3, 0.52, 0.33, 0.6, 0.27, 0.27, 0.6, 0.35, 0.27, 0.35, 0.3, 0.35, 0.25, 1));
        phList.add(new PHModel(4.4, 0.54, 0.34, 0.65, 0.33, 0.33, 0.65, 0.4, 0.3, 0.4, 0.35, 0.4, 0.3, 1));
        phList.add(new PHModel(4.5, 0.6, 0.35, 0.68, 0.35, 0.35, 0.68, 0.5, 0.32, 0.5, 0.4, 0.5, 0.35, 1));
        phList.add(new PHModel(4.6, 0.6, 0.36, 0.7, 0.39, 0.36, 0.70, 0.6, 0.35, 0.6, 0.45, 0.6, 0.4, 1));
        phList.add(new PHModel(4.7, 0.63, 0.37, 0.72, 0.40, 0.37, 0.72, 0.7, 0.37, 0.7, 0.5, 0.7, 0.41, 1));
        phList.add(new PHModel(4.8, 0.65, 0.38, 0.74, 0.42, 0.39, 0.74, 0.8, 0.39, 0.8, 0.55, 0.8, 0.42, 1));
        phList.add(new PHModel(4.9, 0.75, 0.39, 0.75, 0.44, 0.41, 0.75, 0.9, 0.41, 0.9, 0.6, 0.9, 0.43, 1));
        phList.add(new PHModel(5.0, 0.77, 0.39, 0.76, 0.47, 0.45, 0.76, 1, 0.43, 1, 0.65, 1, 0.44, 1));
        phList.add(new PHModel(5.1, 0.79, 0.39, 0.77, 0.5, 0.47, 0.77, 0.75, 0.45, 0.75, 0.75, 0.75, 0.45, 0.98));
        phList.add(new PHModel(5.2, 0.8, 0.39, 0.78, 0.52, 0.48, 0.78, 0.8, 0.47, 0.8, 0.8, 0.8, 0.46, 0.96));
        phList.add(new PHModel(5.3, 0.81, 0.4, 0.79, 0.54, 0.51, 0.79, 0.95, 0.48, 0.95, 0.95, 0.95, 0.47, 0.94));
        phList.add(new PHModel(5.4, 0.83, 0.43, 0.81, 0.58, 0.55, 0.80, 1, 0.49, 1, 1, 0.97, 0.48, 0.92));
        phList.add(new PHModel(5.5, 0.85, 0.45, 0.84, 0.6, 0.58, 0.81, 1, 0.5, 1, 1, 0.99, 0.49, 0.9));
        phList.add(new PHModel(5.6, 0.87, 0.48, 0.87, 0.64, 0.6, 0.82, 1, 0.53, 1, 1, 1, 0.52, 0.88));
        phList.add(new PHModel(5.7, 0.9, 0.5, 0.9, 0.68, 0.64, 0.83, 1, 0.55, 1, 1, 1, 0.5, 0.86));
        phList.add(new PHModel(5.8, 0.93, 0.53, 0.93, 0.72, 0.72, 0.84, 1, 0.6, 1, 1, 1, 0.51, 0.84));
        phList.add(new PHModel(5.9, 0.98, 0.55, 0.95, 0.74, 0.74, 0.85, 1, 0.65, 1, 1, 1, 0.52, 0.82));
        phList.add(new PHModel(6, 1, 0.6, 0.98, 0.76, 0.76, 0.86, 1, 0.67, 1, 1, 1, 0.53, 0.8));
        phList.add(new PHModel(6.1, 1, 0.68, 1, 0.82, 0.82, 0.9, 1, 0.73, 1, 0.98, 1, 0.54, 0.78));
        phList.add(new PHModel(6.3, 1, 0.78, 1, 0.89, 0.89, 1, 1, 0.82, 1, 0.95, 1, 0.65, 0.74));
        phList.add(new PHModel(6.4, 1, 0.88, 1, 0.92, 0.92, 1, 1, 0.86, 1, 0.93, 1, 0.7, 0.72));
        phList.add(new PHModel(6.5, 1, 0.98, 1, 0.94, 0.94, 1, 1, 0.9, 1, 0.86, 1, 0.75, 0.70));
        phList.add(new PHModel(6.6, 1, 1, 1, 0.95, 0.95, 1, 1, 0.94, 1, 0.83, 1, 0.8, 0.68));
        phList.add(new PHModel(6.7, 1, 1, 1, 0.97, 0.97, 1, 1, 0.98, 1, 0.78, 1, 0.85, 0.66));
        phList.add(new PHModel(6.8, 1, 1, 1, 0.99, 0.99, 1, 1, 1, 1, 0.74, 1, 0.9, 0.64));
        phList.add(new PHModel(6.9, 1, 1, 1, 0.99, 0.99, 1, 1, 1, 1, 0.7, 1, 0.95, 0.62));
        phList.add(new PHModel(7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.68, 1, 1, 0.6));
        phList.add(new PHModel(7.1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.66, 1, 1, 0.58));
        phList.add(new PHModel(7.2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.64, 0.98, 1, 0.56));
        phList.add(new PHModel(7.3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.62, 0.95, 1, 0.54));
        phList.add(new PHModel(7.4, 1, 1, 1, 1, 1, 1, 0.95, 1, 0.95, 0.60, 0.93, 0.95, 0.52));
        phList.add(new PHModel(7.5, 1, 1, 1, 1, 1, 1, 0.9, 1, 0.9, 0.58, 0.9, 0.9, 0.5));
        phList.add(new PHModel(7.6, 1, 1, 1, 0.95, 0.95, 1, 0.85, 1, 0.85, 0.56, 0.85, 0.85, 0.48));
        phList.add(new PHModel(7.7, 1, 0.87, 1, 0.92, 0.92, 1, 0.85, 1, 0.85, 0.54, 0.85, 0.80, 0.46));
        phList.add(new PHModel(7.8, 1, 0.85, 1, 0.9, 0.9, 1, 0.8, 1, 0.8, 0.52, 0.8, 0.75, 0.44));
        phList.add(new PHModel(7.9, 1, 0.7, 1, 0.88, 0.88, 1, 0.75, 1, 0.75, 0.5, 0.75, 0.7, 0.42));
        phList.add(new PHModel(8, 1, 0.65, 1, 0.87, 0.87, 1, 0.7, 1, 0.7, 0.5, 0.7, 0.65, 0.4));
        phList.add(new PHModel(8.1, 0.95, 0.6, 1, 0.85, 0.85, 1, 0.68, 1, 0.68, 0.48, 0.68, 0.6, 0.38));
        phList.add(new PHModel(8.2, 0.9, 0.55, 1, 0.83, 0.83, 1, 0.65, 1, 0.65, 0.46, 0.65, 0.58, 0.36));
        phList.add(new PHModel(8.3, 0.85, 0.55, 1, 0.82, 0.82, 1, 0.68, 1, 0.68, 0.44, 0.68, 0.55, 0.34));
        phList.add(new PHModel(8.4, 0.85, 0.55, 1, 0.8, 0.8, 1, 0.65, 1, 0.65, 0.4, 0.65, 0.53, 0.33));
        phList.add(new PHModel(8.5, 0.75, 0.5, 1, 0.79, 0.79, 1, 0.63, 1, 0.63, 0.38, 0.63, 0.5, 0.32));
        phList.add(new PHModel(8.6, 0.7, 0.6, 1, 0.77, 0.77, 1, 0.6, 1, 0.6, 0.35, 0.6, 0.56, 0.31));
        phList.add(new PHModel(8.7, 0.65, 0.7, 1, 0.75, 0.75, 1, 0.58, 1, 0.58, 0.31, 0.58, 0.68, 0.30));
        phList.add(new PHModel(8.8, 0.65, 0.8, 1, 0.74, 0.74, 1, 0.55, 1, 0.55, 0.28, 0.55, 0.75, 0.29));
        phList.add(new PHModel(8.9, 0.6, 0.9, 1, 0.73, 0.73, 1, 0.53, 1, 0.53, 0.27, 0.53, 0.8, 0.28));
        phList.add(new PHModel(9, 0.55, 0.95, 1, 0.7, 0.7, 1, 0.5, 1, 0.5, 0.25, 0.5, 0.9, 0.27));
        phList.add(new PHModel(9.1, 0.5, 1, 1, 0.69, 0.69, 1, 0.48, 1, 0.48, 0.25, 0.48, 0.95, 0.27));
        phList.add(new PHModel(9.2, 0.45, 1, 1, 0.67, 0.67, 1, 0.46, 1, 0.46, 0.25, 0.46, 1, 0.27));
        phList.add(new PHModel(9.3, 0.4, 1, 1, 0.67, 0.67, 1, 0.44, 1, 0.44, 0.24, 0.44, 1, 0.27));
        phList.add(new PHModel(9.4, 0.45, 1, 1, 0.65, 0.65, 1, 0.41, 1, 0.41, 0.23, 0.41, 1, 0.27));
        phList.add(new PHModel(9.5, 0.35, 1, 1, 0.62, 0.62, 1, 0.38, 1, 0.38, 0.23, 0.38, 1, 0.27));
        phList.add(new PHModel(9.6, 0.35, 1, 1, 0.59, 0.59, 1, 0.36, 1, 0.36, 0.22, 0.36, 1, 0.27));
        phList.add(new PHModel(9.7, 0.3, 1, 1, 0.57, 0.57, 1, 0.35, 1, 0.35, 0.22, 0.35, 1, 0.27));
        phList.add(new PHModel(9.8, 0.25, 1, 1, 0.55, 0.55, 1, 0.35, 1, 0.35, 0.21, 0.35, 1, 0.27));
        phList.add(new PHModel(9.9, 0.25, 1, 1, 0.52, 0.52, 1, 0.34, 1, 0.34, 0.2, 0.34, 1, 0.27));
        phList.add(new PHModel(10, 0.2, 1, 1, 0.49, 0.49, 1, 0.33, 1, 0.33, 0.2, 0.33, 1, 0.27));

        Completable.fromAction(() -> phDao.insertList(phList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setPotrebOsadkiData() {
        PotrebOsadkiDao potrebOsadkiDao =
                App.getInstance().getDatabase().potrebOsadkiDao();

        List<PotrebOsadkiModel> potrebOsadkiList = new ArrayList<>();
        potrebOsadkiList.add(new PotrebOsadkiModel("Озимая пшеница", 246));

        Completable.fromAction(() -> potrebOsadkiDao.insertList(potrebOsadkiList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setVinosData() {
        VinosDao vinosDao =
                App.getInstance().getDatabase().vinosDao();

        List<VinosModel> vinosList = new ArrayList<>();
        vinosList.add(new VinosModel("Озимая пшеница", 3.03, 1.04, 2.17, 1.09, 0.36, 0.45));

        Completable.fromAction(() -> vinosDao.insertList(vinosList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setVodopotrebData() {
        VodopotrebDao vodopotrebDao =
                App.getInstance().getDatabase().vodopotrebDao();

        List<VodopotrebModel> vodopotrebList = new ArrayList<>();
        vodopotrebList.add(new VodopotrebModel("Озимая пшеница", 125));

        Completable.fromAction(() -> vodopotrebDao.insertList(vodopotrebList))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    private static void setCalculatorData() {
        CalculatorDao calculatorDao =
                App.getInstance().getDatabase().calculatorDao();
        CalculatorModel calculatorModel =
                new CalculatorModel(0, 0, 0, 0, 0, 0, 0, 23.5, 0,70);

        Completable.fromAction(() -> calculatorDao.insert(calculatorModel))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

}
