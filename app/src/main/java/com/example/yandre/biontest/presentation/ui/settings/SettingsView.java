package com.example.yandre.biontest.presentation.ui.settings;

import com.example.yandre.biontest.data.database.model.SoilFactorsModel;

import java.util.List;

public interface SettingsView {
    void displayData(List<SoilFactorsModel> soilList);
}
