package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.MethodsNModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface MethodsNDao {

    @Query("SELECT * FROM MethodsNModel")
    Flowable<List<MethodsNModel>> getAllMethodsN();

    @Query("SELECT * FROM MethodsNModel WHERE id IS :id")
    Single<MethodsNModel> getMethodN(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MethodsNModel methodsN);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<MethodsNModel> methodsNList);

    @Query("DELETE FROM MethodsNModel WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsRepository user);
}
