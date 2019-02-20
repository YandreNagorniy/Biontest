package com.example.yandre.biontest.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Почвенные факторы
@Entity
public class SoilFactorsModel {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String subTitle;
    @ColumnInfo(name = "soil_value")
    private double value;

    public SoilFactorsModel(String title, String subTitle, double value) {
        this.title = title;
        this.subTitle = subTitle;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
