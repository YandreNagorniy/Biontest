package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Method2Model {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String grade;
    private double tyrinMin;
    private double tyrinMax;
    private double kornfildMin;
    private double kornfildMax;
    private double mineralMin;
    private double mineralMax;
    private double kTyrin;
    private double kKornfild;

    public Method2Model(long id, String grade, double tyrinMin, double tyrinMax, double kornfildMin, double kornfildMax, double mineralMin, double mineralMax, double kTyrin, double kKornfild) {
        this.id = id;
        this.grade = grade;
        this.tyrinMin = tyrinMin;
        this.tyrinMax = tyrinMax;
        this.kornfildMin = kornfildMin;
        this.kornfildMax = kornfildMax;
        this.mineralMin = mineralMin;
        this.mineralMax = mineralMax;
        this.kTyrin = kTyrin;
        this.kKornfild = kKornfild;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getTyrinMin() {
        return tyrinMin;
    }

    public void setTyrinMin(double tyrinMin) {
        this.tyrinMin = tyrinMin;
    }

    public double getTyrinMax() {
        return tyrinMax;
    }

    public void setTyrinMax(double tyrinMax) {
        this.tyrinMax = tyrinMax;
    }

    public double getKornfildMin() {
        return kornfildMin;
    }

    public void setKornfildMin(double kornfildMin) {
        this.kornfildMin = kornfildMin;
    }

    public double getKornfildMax() {
        return kornfildMax;
    }

    public void setKornfildMax(double kornfildMax) {
        this.kornfildMax = kornfildMax;
    }

    public double getMineralMin() {
        return mineralMin;
    }

    public void setMineralMin(double mineralMin) {
        this.mineralMin = mineralMin;
    }

    public double getMineralMax() {
        return mineralMax;
    }

    public void setMineralMax(double mineralMax) {
        this.mineralMax = mineralMax;
    }

    public double getkTyrin() {
        return kTyrin;
    }

    public void setkTyrin(double kTyrin) {
        this.kTyrin = kTyrin;
    }

    public double getkKornfild() {
        return kKornfild;
    }

    public void setkKornfild(double kKornfild) {
        this.kKornfild = kKornfild;
    }
}
