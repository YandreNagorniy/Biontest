package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.MethodsK2OModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface MethodsK2ODao {

    @Query("SELECT * FROM MethodsK2OModel")
    Flowable<List<MethodsK2OModel>> getAllMethodsK2O();

    @Query("SELECT * FROM MethodsK2OModel WHERE id IS :id")
    Single<MethodsK2OModel> getMethod1K2O(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MethodsK2OModel methodsK2O);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<MethodsK2OModel> methodsK2OList);

    @Query("DELETE FROM MethodsK2OModel WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsRepository user);
}
