package com.example.yandre.biontest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.yandre.biontest.pojo.SoilFactorsModel;

@Database(entities = {SoilFactorsModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SoilFactorsDao soilFactorsDao();
}
