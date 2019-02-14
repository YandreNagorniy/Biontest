package com.example.yandre.biontest.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.data.database.model.PotrebOsadkiModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface PotrebOsadkiDao {

    @Query("SELECT * FROM PotrebOsadkiModel")
    Flowable<List<PotrebOsadkiModel>> getAllPotrebOsadki();

    @Query("SELECT * FROM PotrebOsadkiModel WHERE id IS :id")
    Single<PotrebOsadkiModel> getPotrebOsadki(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PotrebOsadkiModel potrebOsadkiModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertList(List<PotrebOsadkiModel> potrebOsadkiModelList);

    @Query("DELETE FROM PotrebOsadkiModel WHERE id IS :id")
    void delete(long id);


//        @Update
//    void update(SettingsModel user);
}
