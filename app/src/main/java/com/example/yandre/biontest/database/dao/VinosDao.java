package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.VinosModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface VinosDao {

    @Query("SELECT * FROM VinosModel")
    Flowable<List<VinosModel>> getAllVinosModel();

    @Query("SELECT * FROM VinosModel WHERE id IS :id")
    Single<VinosModel> getVinosModel(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(VinosModel vinosModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<VinosModel> vinosModelList);

    @Query("DELETE FROM VinosModel WHERE id IS :id")
    void delete(long id);

}
