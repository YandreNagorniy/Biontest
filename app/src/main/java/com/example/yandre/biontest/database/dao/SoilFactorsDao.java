package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface SoilFactorsDao {

    @Query("SELECT * FROM SoilFactorsModel")
    Flowable<List<SoilFactorsModel>> getSoilFactors();
//
//    @Query("SELECT * FROM SoilFactorsModel WHERE id IS :id")
//    Single<SoilFactorsModel> getSoilFactor(long id);

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void insert(SoilFactorsModel soilFactorsModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<SoilFactorsModel> soilFactorsModels);

//    @Query("DELETE FROM SoilFactorsModel WHERE id IS :id")
//    void delete(long id);

//        @Update
//    void update(SettingsModel user);
}
