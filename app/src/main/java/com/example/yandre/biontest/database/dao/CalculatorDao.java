package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.CalculatorModel;
import com.example.yandre.biontest.pojo.CalculateCaO;
import com.example.yandre.biontest.pojo.CalculateH2O;
import com.example.yandre.biontest.pojo.CalculateK2O;
import com.example.yandre.biontest.pojo.CalculateMgO;
import com.example.yandre.biontest.pojo.CalculateN;
import com.example.yandre.biontest.pojo.CalculateP2O5;
import com.example.yandre.biontest.pojo.CalculateS;

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

    @Query("SELECT v.vinos_N, c.productive, s.soil_value, k.kusv_N  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :g or s.subTitle = :ph or s.subTitle = :n) and  k.id = :id")
    Single<List<CalculateN>> getDataN(long id, String n, String ph, String g);

    @Query("SELECT v.vinos_P2O5, c.productive, s.soil_value, k.kusv_P2O5  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :P2O5 or s.subTitle = :ph) and  k.id = :id")
    Single<List<CalculateP2O5>> getDataP2O5(long id, String P2O5, String ph);

    @Query("SELECT v.vinos_K2O, c.productive, s.soil_value, k.kusv_K2O  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :K2O or s.subTitle = :ph) and  k.id = :id")
    Single<List<CalculateK2O>> getDataK2O(long id, String K2O, String ph);

    @Query("SELECT v.vinos_CaO, c.productive, s.soil_value, k.kusv_CaO  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :CaO or s.subTitle = :ph) and  k.id = :id")
    Single<List<CalculateCaO>> getDataCaO(long id, String CaO, String ph);

    @Query("SELECT v.vinos_MgO, c.productive, s.soil_value, k.kusv_MgO  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :MgO or s.subTitle = :ph) and  k.id = :id")
    Single<List<CalculateMgO>> getDataMgO(long id, String MgO, String ph);

    @Query("SELECT v.vinos_S, c.productive, s.soil_value, k.kusv_S  " +
            "FROM VinosModel v,CalculatorModel c, SoilFactorsModel s, KUsvModel k  " +
            "WHERE v.id = :id and (s.subTitle = :S or s.subTitle = :ph) and  k.id = :id")
    Single<List<CalculateS>> getDataS(long id, String S, String ph);

    @Query("Select N From PHModel where ph is :ph")
    Single<Double> getPhN(double ph);

    @Query("Select P From PHModel where ph is :ph")
    Single<Double> getPhP2O5(double ph);

    @Query("Select K From PHModel where ph is :ph")
    Single<Double> getPhK2O(double ph);

    @Query("Select Ca From PHModel where ph is :ph")
    Single<Double> getPhCaO(double ph);

    @Query("Select Mg From PHModel where ph is :ph")
    Single<Double> getPhMgO(double ph);

    @Query("Select S From PHModel where ph is :ph")
    Single<Double> getPhS(double ph);
}
