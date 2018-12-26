package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.SoilFactorsDao;
import com.example.yandre.biontest.pojo.SoilFactorsModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SettingsPresenterImpl implements SettingsPresenter {

    private SettingsView settingsView;
    private SoilFactorsDao soilFactorsDao;
    Disposable disposable;
    List<SoilFactorsModel> soilFactorsModelList;

    public SettingsPresenterImpl(SettingsView settingsView) {
        this.settingsView = settingsView;
        soilFactorsDao = App.getInstance().getDatabase().soilFactorsDao();
    }

    @Override //Загружаем значения почыенных факторов из БД
    public void loadSoilFactors() {
        disposable = soilFactorsDao.getSoilFactors()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(soilFactorsModels -> settingsView.displayData(soilFactorsModels),
                        Throwable::printStackTrace);
    }


    @Override //Берем начальные значения почыенных факторов
    public void getStartSoilFactors() {
        soilFactorsModelList = new ArrayList<>();
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
        soilFactorsModelList.add(new SoilFactorsModel("title", "subTitle", "5"));
    }

    @Override
    public void saveSoilFactors() {

    }
}
