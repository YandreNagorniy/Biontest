package com.example.yandre.biontest.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Коэффициенты усвояемости
@Entity
public class KUsvModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String culture;
    @ColumnInfo(name = "kusv_N")
    private double N;
    private double P2O5;
    private double K2O;
    private double Ca;
    private double MgO;
    private double S;
    private double Zn;
    private double Mo;
    private double Cu;
    private double Mn;
    private double Co;
    private double B;
    private double Fe;

    public KUsvModel(String culture, double N, double P2O5, double K2O, double Ca, double MgO,
                     double S, double Zn, double Mo, double Cu, double Mn, double Co, double B, double Fe) {
        this.culture = culture;
        this.N = N;
        this.P2O5 = P2O5;
        this.K2O = K2O;
        this.Ca = Ca;
        this.MgO = MgO;
        this.S = S;
        this.Zn = Zn;
        this.Mo = Mo;
        this.Cu = Cu;
        this.Mn = Mn;
        this.Co = Co;
        this.B = B;
        this.Fe = Fe;
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

    public double getCa() {
        return Ca;
    }

    public void setCa(double Ca) {
        this.Ca = Ca;
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

    public double getZn() {
        return Zn;
    }

    public void setZn(double Zn) {
        this.Zn = Zn;
    }

    public double getMo() {
        return Mo;
    }

    public void setMo(double Mo) {
        this.Mo = Mo;
    }

    public double getCu() {
        return Cu;
    }

    public void setCu(double Cu) {
        this.Cu = Cu;
    }

    public double getMn() {
        return Mn;
    }

    public void setMn(double Mn) {
        this.Mn = Mn;
    }

    public double getCo() {
        return Co;
    }

    public void setCo(double Co) {
        this.Co = Co;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getFe() {
        return Fe;
    }

    public void setFe(double Fe) {
        this.Fe = Fe;
    }
}