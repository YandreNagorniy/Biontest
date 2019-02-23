package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.PhasesModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PhasesDao {

    @Query("SELECT * FROM PhasesModel")
    Flowable<List<PhasesModel>> getAllPhasesModel();

    @Query("SELECT * FROM PhasesModel WHERE id IS :id")
    Single<PhasesModel> getPhasesModel(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PhasesModel phasesModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<PhasesModel> phasesModelList);

    @Query("DELETE FROM PhasesModel WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsRepository user);
}
