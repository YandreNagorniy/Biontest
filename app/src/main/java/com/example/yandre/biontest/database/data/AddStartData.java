package com.example.yandre.biontest.database.data;

import com.example.yandre.biontest.App;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.ArrayList;
import java.util.List;

public class AddStartData {
    SoilFactorsDao soilFactorsDao;
    List<SoilFactorsModel> soilFactorsModelList;

    public void AddAllData() {

        setSoilFactorsData();         //добавить почвенные факторы
        setCalculatorData();
        setKUsvData();
        setMethod1Data();
        setMethod2Data();
        setMethodsData();
        setPhasesData();
        setPHData();
        setPotrebOsadkiData();
        setVinosData();
        setVodopotrebData();
    }

    private void setSoilFactorsData() {
        soilFactorsDao = App.getInstance().getDatabase().soilFactorsDao();

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

    }

    private void setCalculatorData() {
    }

    private void setKUsvData() {
    }

    private void setMethod1Data() {
    }

    private void setMethod2Data() {
    }

    private void setMethodsData() {
    }

    private void setPhasesData() {
    }

    private void setPHData() {
    }

    private void setPotrebOsadkiData() {
    }

    private void setVinosData() {
    }

    private void setVodopotrebData() {
    }
}
