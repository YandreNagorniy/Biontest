package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.yandre.biontest.database.model.CultureModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface CultureDao {

    @Query("SELECT * FROM CultureModel")
    Flowable<List<CultureModel>> getCultureList();

    @Query("SELECT * FROM CultureModel WHERE id IS :id")
    Single<CultureModel> getCultureData(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CultureModel cultureModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<CultureModel> cultureModelList);


}
