package com.example.yandre.biontest.data.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//pH

@Entity
public class PHModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private double ph;
    private double N;
    private double P;
    private double K;
    private double Ca;
    private double Mg;
    private double S;
    private double Zn;
    private double Mo;
    private double Cu;
    private double Mn;
    private double Co;
    private double B;
    private double Fe;


    public PHModel(double ph, double N, double P, double K, double Ca, double Mg, double S,
                   double Zn, double Mo, double Cu, double Mn, double Co, double B, double Fe) {
        this.ph = ph;
        this.N = N;
        this.P = P;
        this.K = K;
        this.Ca = Ca;
        this.Mg = Mg;
        this.S = S;
        this.Zn = Zn;
        this.Mo = Mo;
        this.Cu = Cu;
        this.Mn = Mn;
        this.Co = Co;
        this.B = B;
        this.Fe = Fe;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
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

    public double getP() {
        return P;
    }

    public void setP(double P) {
        this.P = P;
    }

    public double getK() {
        return K;
    }

    public void setK(double K) {
        this.K = K;
    }

    public double getCa() {
        return Ca;
    }

    public void setCa(double Ca) {
        this.Ca = Ca;
    }

    public double getMg() {
        return Mg;
    }

    public void setMg(double Mg) {
        this.Mg = Mg;
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
