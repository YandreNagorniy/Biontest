package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.SoilFactorsDao;
import com.example.yandre.biontest.pojo.SoilFactorsModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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

    @Override //Берем начальные значения почыенных факторов
    public void addStartSoilFactors() {
        soilFactorsModelList = new ArrayList<>();
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "1"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "2"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "3"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "4"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "7"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "3"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "9"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "7"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "8"));
        settingsView.displayData(soilFactorsModelList);

        //зносим в бд первоначалные значения
        Completable.fromAction(() -> soilFactorsDao.insertList(soilFactorsModelList))
                .subscribeOn(Schedulers.io())
                .subscribe();

        //отображаем их во вью
        settingsView.displayData(soilFactorsModelList);
    }
}
