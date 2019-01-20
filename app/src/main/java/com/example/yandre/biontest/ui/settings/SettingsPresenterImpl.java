package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SettingsPresenterImpl implements SettingsPresenter {

    private SettingsView settingsView;
    private SoilFactorsDao soilFactorsDao;
    Disposable disposable;
    List<SoilFactorsModel> soilFactorsModelList;

    public SettingsPresenterImpl(SettingsView settingsView) {
        this.settingsView = settingsView;
        soilFactorsDao = App.getInstance().getDatabase().soilFactorsDao();
    }

    @Override //Загружаем значения почвенных факторов из БД
    public void loadSoilFactors() {
        disposable = soilFactorsDao.getSoilFactors()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(settingsView::displayData, Throwable::printStackTrace);

//        subscribe(soilFactorsModels -> settingsView.displayData(soilFactorsModels),
//                        Throwable::printStackTrace);
    }

    @Override
    public void saveSoilFactors() {

    }

    @Override //Берем начальные значения почвенных факторов
    public void addStartSoilFactors() {
        soilFactorsModelList = new ArrayList<>();
        soilFactorsModelList.add(new SoilFactorsModel("title", "g", 3));
        soilFactorsModelList.add(new SoilFactorsModel("title", "pH", 4));
        soilFactorsModelList.add(new SoilFactorsModel("title", "N", 1));
        soilFactorsModelList.add(new SoilFactorsModel("title", "D", 2));
        soilFactorsModelList.add(new SoilFactorsModel("title", "K", 5));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Ca", 5));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Mg", 7));
        soilFactorsModelList.add(new SoilFactorsModel("title", "S", 3));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Mn", 9));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Zn", 7));
        soilFactorsModelList.add(new SoilFactorsModel("title", "B", 5));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Fe", 8));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Cu", 8));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Mo", 8));
        soilFactorsModelList.add(new SoilFactorsModel("title", "Co", 8));
      //  settingsView.displayData(soilFactorsModelList);

        //зaносим в бд первоначалные значения
        Completable.fromAction(() -> soilFactorsDao.insertList(soilFactorsModelList))
                .subscribeOn(Schedulers.io())
                .subscribe();

        //отображаем их во вью
        settingsView.displayData(soilFactorsModelList);
    }
}
