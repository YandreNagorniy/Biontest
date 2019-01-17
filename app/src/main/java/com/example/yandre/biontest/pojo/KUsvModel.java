package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Коэффициенты усвояемости
@Entity
public class KUsvModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String culture;
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

    public KUsvModel(long id, String culture, double n, double p2O5, double k2O, double ca, double mgO, double s, double zn, double mo, double cu, double mn, double co, double b, double fe) {
        this.id = id;
        this.culture = culture;
        N = n;
        P2O5 = p2O5;
        K2O = k2O;
        Ca = ca;
        MgO = mgO;
        S = s;
        Zn = zn;
        Mo = mo;
        Cu = cu;
        Mn = mn;
        Co = co;
        B = b;
        Fe = fe;
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

    public double getZn() {
        return Zn;
    }

    public void setZn(double zn) {
        Zn = zn;
    }

    public double getMo() {
        return Mo;
    }

    public void setMo(double mo) {
        Mo = mo;
    }

    public double getCu() {
        return Cu;
    }

    public void setCu(double cu) {
        Cu = cu;
    }

    public double getMn() {
        return Mn;
    }

    public void setMn(double mn) {
        Mn = mn;
    }

    public double getCo() {
        return Co;
    }

    public void setCo(double co) {
        Co = co;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getFe() {
        return Fe;
    }

    public void setFe(double fe) {
        Fe = fe;
    }
}
