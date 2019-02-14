package com.example.yandre.biontest.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.data.database.model.MethodsP2O5Model;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface MethodsP2O5Dao {

    @Query("SELECT * FROM MethodsP2O5Model")
    Flowable<List<MethodsP2O5Model>> getAllMethodsP2O5();

    @Query("SELECT * FROM MethodsP2O5Model WHERE id IS :id")
    Single<MethodsP2O5Model> getMethodP2O5(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MethodsP2O5Model methodsP2O5);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<MethodsP2O5Model> methodsP2O5List);

    @Query("DELETE FROM MethodsP2O5Model WHERE id IS :id")
    void delete(long id);

//        @Update
//    void update(SettingsModel user);
}
