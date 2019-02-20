package com.example.yandre.biontest.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.pojo.CalculateH2O;

import java.util.List;

import io.reactivex.Single;

@Dao
public abstract class CalculateNDao {

    @Query("SELECT N FROM VinosModel WHERE id == :id")
   abstract Single<List<CalculateH2O>> getVinosN(long id);
}
