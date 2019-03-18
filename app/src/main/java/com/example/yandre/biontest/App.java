package com.example.yandre.biontest;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.crashlytics.android.Crashlytics;
import com.example.yandre.biontest.database.AppDatabase;

import io.fabric.sdk.android.Fabric;

public class App extends Application {
    public static App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "appDatabase")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
