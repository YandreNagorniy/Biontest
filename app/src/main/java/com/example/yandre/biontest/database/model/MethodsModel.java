package com.example.yandre.biontest.database.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

// Методики
@Entity
public class MethodsModel {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Method1Model getK2O() {
        return K2O;
    }

    public void setK2O(Method1Model k2O) {
        K2O = k2O;
    }

    public Method1Model getP2O5() {
        return P2O5;
    }

    public void setP2O5(Method1Model p2O5) {
        P2O5 = p2O5;
    }

    public Method2Model getN() {
        return N;
    }

    public void setN(Method2Model n) {
        N = n;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    @Embedded(prefix = "K2O")
    private Method1Model K2O;
    @Embedded(prefix = "P2O5")
    private Method1Model P2O5;
    @Embedded(prefix = "N")
    private Method2Model N;

    public MethodsModel(long id, Method1Model K2O, Method1Model P2O5, Method2Model N) {
        this.id = id;
        this.K2O = K2O;
        this.P2O5 = P2O5;
        this.N = N;
    }
}
