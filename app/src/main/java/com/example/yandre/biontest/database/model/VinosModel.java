package com.example.yandre.biontest.database.model;
//Вынос

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class VinosModel {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String culture;
    @ColumnInfo(name = "vinos_N")
    private double N;
    private double P2O5;
    private double K2O;
    private double Ca;
    private double MgO;
    private double S;

    public VinosModel(String culture, double N, double P2O5, double K2O,
                      double Ca, double MgO, double S) {
        this.culture = culture;
        this.N = N;
        this.P2O5 = P2O5;
        this.K2O = K2O;
        this.Ca = Ca;
        this.MgO = MgO;
        this.S = S;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    public double getP2O5() {
        return P2O5;
    }

    public void setP2O5(double p2O5) {
        P2O5 = p2O5;
    }

    public double getK2O() {
        return K2O;
    }

    public void setK2O(double k2O) {
        K2O = k2O;
    }

    public double getCa() {
        return Ca;
    }

    public void setCa(double ca) {
        Ca = ca;
    }

    public double getMgO() {
        return MgO;
    }

    public void setMgO(double mgO) {
        MgO = mgO;
    }

    public double getS() {
        return S;
    }

    public void setS(double s) {
        S = s;
    }
}
