package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.CalculatorModel;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateN;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface CalculatorDao {

    @Query("SELECT * FROM CalculatorModel")
    Flowable<List<CalculatorModel>> getAllCalculatorDate();

    @Query("SELECT * FROM CalculatorModel WHERE id IS :id")
    Single<CalculatorModel> getCalculatorDate(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CalculatorModel calculatorModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<CalculatorModel> calculatorModelList);

    @Query("DELETE FROM CalculatorModel WHERE id IS :id")
    void delete(long id);


    @Query("SELECT productive, zpv, humidityOfSoil FROM CalculatorModel WHERE id == :id")
    Single<List<CalculateH2O>> getDataFromCalculateH2O(long id);

    @Query("SELECT vinosN FROM vinosmodel WHERE id IS :id")
    Single<Double> getVinosN(long id);

    @Query("SELECT value FROM SoilFactorsModel WHERE subTitle == :n")
    Single<Integer> getSettingsN(String n);

//    @Query("SELECT vinosmodel.N, SoilFactorsModel.value /**, KUsvModel.N, SoilFactorsModel.value, SoilFactorsModel.value, SoilFactorsModel.value  **/ " +
//            " FROM VinosModel, SoilFactorsModel/**, KUsvModel, PHModel **/" +
//            "WHERE id IS :id AND SoilFactorsModel.subTitle IS :n /**AND SoilFactorsModel.subTitle IS :pH AND SoilFactorsModel.subTitle IS :g **/")
//    List<CalculateN> getDataFromCalculateN(long id, String n /**,String pH, String g**/);

    @Query("SELECT vinosN FROM VinosModel WHERE id IS :id union" +
            " SELECT value From SoilFactorsModel Where subTitle == \"N\" union" +
            " Select N From KUsvModel Where id is :id union" +
            " Select N From phmodel where ph= (Select value From SoilFactorsModel Where  subTitle == \"pH\") union" +
            " Select value From SoilFactorsModel Where subTitle == \"g\"")
    List<CalculateN> getDataFromCalculateN(long id);
}
