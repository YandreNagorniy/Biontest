package com.example.yandre.biontest.database.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

// Методики
@Entity
public class MethodsModel {

    @PrimaryKey(autoGenerate = true)
    public long id;
    @Embedded(prefix = "K2O")
    public Method1Model K2O;
    @Embedded(prefix = "P2O5")
    public Method1Model P2O5;
    @Embedded(prefix = "N")
    public Method2Model N;

    public MethodsModel(long id, Method1Model K2O, Method1Model P2O5, Method2Model N) {
        this.id = id;
        this.K2O = K2O;
        this.P2O5 = P2O5;
        this.N = N;
    }
}
