package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class CalculatorModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private double N;
    private double P2O5;
    private double K2O;
    private double CaO;
    private double MgO;
    private double S;
    private double H20;
    //осадки за сезон
    private double seasonPrecipitation;
    private double zpv;


    public CalculatorModel(long id, double n, double p2O5, double k2O, double caO, double mgO, double s, double h20,double seasonPrecipitation, double zpv) {
        this.id = id;
        N = n;
        P2O5 = p2O5;
        K2O = k2O;
        CaO = caO;
        MgO = mgO;
        S = s;
        H20 = h20;
        this.seasonPrecipitation = seasonPrecipitation;
        this.zpv = zpv;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getCaO() {
        return CaO;
    }

    public void setCaO(double caO) {
        CaO = caO;
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
    public double getH20() {
        return H20;
    }

    public void setH20(double h20) {
        H20 = h20;
    }
}
