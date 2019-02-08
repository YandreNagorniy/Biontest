package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.model.SoilFactorsModel;

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
//                .subscribe(settingsView::displayData, Throwable::printStackTrace);
                .subscribe(new Consumer<List<SoilFactorsModel>>() {
                    @Override
                    public void accept(List<SoilFactorsModel> soilFactorsModels) throws Exception {
                        settingsView.displayData(soilFactorsModels);
                    }
                });

//        subscribe(soilFactorsModels -> settingsView.displayData(soilFactorsModels),
//                        Throwable::printStackTrace);
    }
}
