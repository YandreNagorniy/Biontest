package com.example.yandre.biontest.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class P2O5MethodsModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String grade;
    private double kirsanovMin;
    private double kirsanovMax;
    private double chirikovMin;
    private double chirikovMax;
    private double machiginMin;
    private double machiginMax;
    private double indexKirsanov;
    private double indexChirikov;

    public P2O5MethodsModel(String grade, double kirsanovMin , double kirsanovMax, double chirikovMin, double chirikovMax, double machiginMin, double machiginMax, double indexKirsanov, double indexChirikov) {
        this.grade = grade;
        this.kirsanovMin = kirsanovMin;
        this.kirsanovMax = kirsanovMax;
        this.chirikovMin = chirikovMin;
        this.chirikovMax = chirikovMax;
        this.machiginMin = machiginMin;
        this.machiginMax = machiginMax;
        this.indexKirsanov = indexKirsanov;
        this.indexChirikov = indexChirikov;
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

    public double getKirsanovMin() {
        return kirsanovMin;
    }

    public void setKirsanovMin(double kirsanovMin) {
        this.kirsanovMin = kirsanovMin;
    }

    public double getKirsanovMax() {
        return kirsanovMax;
    }

    public void setKirsanovMax(double kirsanovMax) {
        this.kirsanovMax = kirsanovMax;
    }

    public double getChirikovMin() {
        return chirikovMin;
    }

    public void setChirikovMin(double chirikovMin) {
        this.chirikovMin = chirikovMin;
    }

    public double getChirikovMax() {
        return chirikovMax;
    }

    public void setChirikovMax(double chirikovMax) {
        this.chirikovMax = chirikovMax;
    }

    public double getMachiginMin() {
        return machiginMin;
    }

    public void setMachiginMin(double machiginMin) {
        this.machiginMin = machiginMin;
    }

    public double getMachiginMax() {
        return machiginMax;
    }

    public void setMachiginMax(double machiginMax) {
        this.machiginMax = machiginMax;
    }
    public double getIndexChirikov() {
        return indexChirikov;
    }

    public void setIndexChirikov(double indexChirikov) {
        this.indexChirikov = indexChirikov;
    }

    public double getIndexKirsanov() {
        return indexKirsanov;
    }

    public void setIndexKirsanov(double indexKirsanov) {
        this.indexKirsanov = indexKirsanov;
    }
}
