package com.example.yandre.biontest.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.data.database.model.VodopotrebModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface VodopotrebDao {

    @Query("SELECT * FROM VodopotrebModel")
    Flowable<List<VodopotrebModel>> getAllVodopotrebModel();

    @Query("SELECT * FROM VodopotrebModel WHERE id IS :id")
    Single<VodopotrebModel> getVodopotrebModel(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(VodopotrebModel vodopotrebModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<VodopotrebModel> vodopotrebModelList);

    @Query("DELETE FROM VodopotrebModel WHERE id IS :id")
    void delete(long id);

    @Query("SELECT value FROM VodopotrebModel WHERE id IS :id")
    Single<Integer> getVodopotrebValue(long id);

//        @Update
//    void update(SettingsModel user);
}