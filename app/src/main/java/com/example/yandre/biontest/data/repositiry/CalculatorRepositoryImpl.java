package com.example.yandre.biontest.data.repositiry;

import com.example.yandre.biontest.data.database.AppDatabase;
import com.example.yandre.biontest.data.pojo.CalculateH2O;

import java.util.List;

import io.reactivex.Single;

public class CalculatorRepositoryImpl implements CalculatorRepository {

    private AppDatabase db;

    public CalculatorRepositoryImpl(AppDatabase db) {
        this.db = db;
    }

    @Override
    public Single<List<CalculateH2O>> getDataH2O(long id) {
        return db.calculatorDao().getDataFromCalculateH2O(id);
    }

}
