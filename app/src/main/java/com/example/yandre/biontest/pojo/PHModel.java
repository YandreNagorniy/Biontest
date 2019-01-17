package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//pH
@Entity
public class PHModel {

    public PHModel(long id, double pH, double n, double p, double k, double ca, double mgO, double s, double zn, double mo, double cu, double mn, double co, double b, double fe) {
        this.id = id;
        this.pH = pH;
        N = n;
        P = p;
        K = k;
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

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    public double getP() {
        return P;
    }

    public void setP(double p) {
        P = p;
    }

    public double getK() {
        return K;
    }

    public void setK(double k) {
        K = k;
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

    @PrimaryKey(autoGenerate = true)
    private long id;
    private double pH;
    private double N;
    private double P;
    private double K;
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
}
