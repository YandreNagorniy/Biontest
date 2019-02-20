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

    private double humidityOfSoil;     //влажность почвы
    private double zpv;
    private double productive;   //урожайность

    public CalculatorModel(double N, double P2O5, double K2O, double CaO, double MgO,
                           double S, double H20, double humidityOfSoil, double zpv, double productive) {
        this.N = N;
        this.P2O5 = P2O5;
        this.K2O = K2O;
        this.CaO = CaO;
        this.MgO = MgO;
        this.S = S;
        this.H20 = H20;
        this.humidityOfSoil = humidityOfSoil;
        this.zpv = zpv;
        this.productive = productive;
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

    public double getHumidityOfSoil() {
        return humidityOfSoil;
    }

    public void setHumidityOfSoil(double humidityOfSoil) {
        this.humidityOfSoil = humidityOfSoil;
    }

    public double getZpv() {
        return zpv;
    }

    public void setZpv(double zpv) {
        this.zpv = zpv;
    }

    public double getProductive() {
        return productive;
    }

    public void setProductive(double productive) {
        this.productive = productive;
    }
}

