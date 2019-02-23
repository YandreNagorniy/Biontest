package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.List;

import io.reactivex.Flowable;

public class SettingsRepositoryImpl implements SettingsRepository {

    private SettingsPresenter settingsPresenter;
    private SoilFactorsDao soilFactorsDao;

    SettingsRepositoryImpl(SettingsPresenter settingsPresenter) {
        this.settingsPresenter = settingsPresenter;
        soilFactorsDao = App.getInstance().getDatabase().soilFactorsDao();
    }

//       soilFactorsDao.getSoilFactors()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(soilFactorsModels -> settingsView.displayData(soilFactorsModels));

    @Override
    public Flowable<List<SoilFactorsModel>> getDataSoilFactors() {
        return soilFactorsDao.getAllSoilFactors();
    }
}
