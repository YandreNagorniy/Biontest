package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.CalculatorModel;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculateP2O5;

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

    @Query("SELECT c.productive, c.zpv, v.value " +
            " FROM CalculatorModel c, VodopotrebModel v " +
            "WHERE v.id = :id")
    Single<List<CalculateH2O>> getDataH2O(long id);

    @Query("SELECT vinos_N FROM vinosmodel WHERE id IS :id")
    Single<Double> getVinosN(long id);


    @Query("SELECT v.vinos_N, c.productive, s.soil_value, k.kusv_N  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :g or s.subTitle = :ph or s.subTitle = :n) and  k.id = :id")
    Single<List<CalculateN>> getDataN(long id, String n, String ph, String g);

    @Query("SELECT v.vinos_P2O5, c.productive, s.soil_value, k.kusv_P2O5  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :P2O5 or s.subTitle = :ph) and  k.id = :id")
    Single<List<CalculateP2O5>> getDataP2O5(long id, String P2O5, String ph);


//    @Query("Select  soil_value From SoilFactorsModel Where subTitle == \"N\" or subTitle == \"pH\"")
//    Single<List<Integer>> getSettingsData();
//    @Query("SELECT value FROM SoilFactorsModel WHERE subTitle == :n")
//    Single<Integer> getSettingsN(String n);


    @Query("Select kusv_N From KUsvModel Where id is :id")
    Single<Double> getKUsvN(long id);

    @Query("Select N From PHModel where ph is :ph")
    Single<Double> getPhN(double ph);

    @Query("Select P From PHModel where ph is :ph")
    Single<Double> getPhP2O5(double ph);
}
