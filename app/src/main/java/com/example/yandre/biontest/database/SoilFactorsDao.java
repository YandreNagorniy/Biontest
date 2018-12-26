package com.example.yandre.biontest.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.yandre.biontest.pojo.SoilFactorsModel;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface SoilFactorsDao {

    @Query("SELECT * FROM soilfactorsmodel")
    Flowable<List<SoilFactorsModel>> getSoilFactors();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SoilFactorsModel soilFactorsModel);

    @Query("DELETE FROM soilfactorsmodel WHERE id IS :id")
    void delete(String id);


    //    @Query("SELECT * FROM usersresponse WHERE login IS :login")
//    Single<UsersResponse> getUser(String login);
//        @Update
//    void update(SoilFactorsModel user);
}
