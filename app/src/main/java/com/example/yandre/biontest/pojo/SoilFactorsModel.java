package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class SoilFactorsModel {

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String subTitle;
    private String value;

    public SoilFactorsModel(String title, String subTitle, String value) {
        this.title = title;
        this.subTitle = subTitle;
        this.value = value;
    }

}
