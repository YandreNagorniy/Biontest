package com.example.yandre.biontest.pojo;
//Вынос

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class VinosModel {
    public VinosModel(long id, String culture, double n, double p2O5, double k2O, double ca, double mgO, double s) {
        this.id = id;
        this.culture = culture;
        N = n;
        P2O5 = p2O5;
        K2O = k2O;
        Ca = ca;
        MgO = mgO;
        S = s;
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

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String culture;
    private double N;
    private double P2O5;
    private double K2O;
    private double Ca;
    private double MgO;
    private double S;
}
