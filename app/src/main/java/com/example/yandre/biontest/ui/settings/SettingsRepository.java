package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.List;

import io.reactivex.Flowable;

public interface SettingsRepository {
    Flowable<List<SoilFactorsModel>> getDataSoilFactors();
}
