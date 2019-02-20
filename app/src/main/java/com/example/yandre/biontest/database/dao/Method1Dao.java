package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.Method1Model;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface Method1Dao {

    @Query("SELECT * FROM Method1Model")
    Flowable<List<Method1Model>> getAllMethod1Model();

    @Query("SELECT * FROM Method1Model WHERE id IS :id")
    Single<Method1Model> getMethod1Model(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Method1Model method1Model);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<Method1Model> method1ModelList);

    @Query("DELETE FROM Method1Model WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsModel user);
}
