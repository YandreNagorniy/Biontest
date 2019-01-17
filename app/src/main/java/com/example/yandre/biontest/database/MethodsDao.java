package com.example.yandre.biontest.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.pojo.MethodsModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface MethodsDao {

    @Query("SELECT * FROM MethodsModel")
    Flowable<List<MethodsModel>> getAllMethodsModel();

    @Query("SELECT * FROM MethodsModel WHERE id IS :id")
    Single<MethodsModel> getMethodsModel(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MethodsModel methodsModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<MethodsModel> methodsModelList);

    @Query("DELETE FROM MethodsModel WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsModel user);
}
