package com.example.yandre.biontest.ui.settings;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SettingsPresenterImpl implements SettingsPresenter {
    SettingsView settingsView;
    SettingsRepository settingsRepository;
    CompositeDisposable compositeDisposable;

    SettingsPresenterImpl(SettingsView settingsView) {
        this.settingsView = settingsView;
        settingsRepository = new SettingsRepositoryImpl();
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getSettingsData() {
        compositeDisposable.add(settingsRepository.getDataSoilFactors()
                .observeOn(Schedulers.io())
                .subscribe(soilFactorsModelList -> settingsView.displayData(soilFactorsModelList)));
    }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
    }
}
