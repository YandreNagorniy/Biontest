package com.example.yandre.biontest.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.pojo.PHModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PHDao {

    @Query("SELECT * FROM PHModel")
    Flowable<List<PHModel>> getAllPHModel();

    @Query("SELECT * FROM PHModel WHERE id IS :id")
    Single<PHModel> getPHModel(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PHModel phModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<PHModel> phModelList);

    @Query("DELETE FROM PHModel WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsModel user);
}
