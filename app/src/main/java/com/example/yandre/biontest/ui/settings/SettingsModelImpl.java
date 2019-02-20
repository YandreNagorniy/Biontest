package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SettingsModelImpl implements SettingsModel {

    private SettingsView settingsView;
    private SoilFactorsDao soilFactorsDao;
    Disposable disposable;
    List<SoilFactorsModel> soilFactorsModelList;

    public SettingsModelImpl(SettingsView settingsView) {
        this.settingsView = settingsView;
        soilFactorsDao = App.getInstance().getDatabase().soilFactorsDao();
    }

    @Override //Загружаем значения почвенных факторов из БД
    public void loadSoilFactors() {
        disposable = soilFactorsDao.getSoilFactors()
                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(settingsView::displayData, Throwable::printStackTrace);
                .subscribe(soilFactorsModels -> settingsView.displayData(soilFactorsModels));

//        subscribe(soilFactorsModels -> settingsView.displayData(soilFactorsModels),
//                        Throwable::printStackTrace);
    }
}
