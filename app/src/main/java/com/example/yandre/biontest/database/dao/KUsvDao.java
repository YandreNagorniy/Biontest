package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.database.model.KUsvModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface KUsvDao {

    @Query("SELECT * FROM KUsvModel")
    Flowable<List<KUsvModel>> getAllKUsv();

    @Query("SELECT * FROM KUsvModel WHERE id IS :id")
    Single<KUsvModel> getKUsv(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(KUsvModel kUsvModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<KUsvModel> kUsvModelList);

    @Query("DELETE FROM SoilFactorsModel WHERE id IS :id")
    void delete(long id);
}
