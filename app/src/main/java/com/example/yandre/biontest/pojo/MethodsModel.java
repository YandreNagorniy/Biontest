package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

// Методики
@Entity
public class MethodsModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @Embedded
    private Method1Model K2O;
    @Embedded
    private Method1Model P2O5;
    @Embedded
    private Method2Model N;

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

    public MethodsModel(long id, Method1Model k2O, Method1Model p2O5, Method2Model n) {
        this.id = id;
        K2O = k2O;
        P2O5 = p2O5;
        N = n;
    }
}
