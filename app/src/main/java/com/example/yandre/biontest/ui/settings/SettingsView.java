package com.example.yandre.biontest.ui.settings;

import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.List;

public interface SettingsView {
    void displayData(List<SoilFactorsModel> soilList);
}
