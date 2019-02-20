package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.Method2Model;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface Method2Dao {

    @Query("SELECT * FROM Method2Model")
    Flowable<List<Method2Model>> getAllMethod2Model();

    @Query("SELECT * FROM Method2Model WHERE id IS :id")
    Single<Method2Model> getMethod2Model(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Method2Model method2Model);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<Method2Model> method2ModelList);

    @Query("DELETE FROM Method2Model WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsModel user);
}
