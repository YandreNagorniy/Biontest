package com.example.yandre.biontest.database.model;

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


    public CalculatorModel(long id, double N, double P2O5, double K2O, double CaO, double MgO,
                           double S, double H20, double seasonPrecipitation, double zpv) {
        this.id = id;
        this.N = N;
        this.P2O5 = P2O5;
        this.K2O = K2O;
        this.CaO = CaO;
        this.MgO = MgO;
        this.S = S;
        this.H20 = H20;
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

    public void setN(double N) {
        this.N = N;
    }

    public double getP2O5() {
        return P2O5;
    }

    public void setP2O5(double P2O5) {
        this.P2O5 = P2O5;
    }

    public double getK2O() {
        return K2O;
    }

    public void setK2O(double K2O) {
        this.K2O = K2O;
    }

    public double getCaO() {
        return CaO;
    }

    public void setCaO(double CaO) {
        this.CaO = CaO;
    }

    public double getMgO() {
        return MgO;
    }

    public void setMgO(double MgO) {
        this.MgO = MgO;
    }

    public double getS() {
        return S;
    }

    public void setS(double S) {
        this.S = S;
    }

    public double getH20() {
        return H20;
    }

    public void setH20(double H20) {
        this.H20 = H20;
    }

    public double getSeasonPrecipitation() {
        return seasonPrecipitation;
    }

    public void setSeasonPrecipitation(double seasonPrecipitation) {
        this.seasonPrecipitation = seasonPrecipitation;
    }

    public double getZpv() {
        return zpv;
    }

    public void setZpv(double zpv) {
        this.zpv = zpv;
    }
}
