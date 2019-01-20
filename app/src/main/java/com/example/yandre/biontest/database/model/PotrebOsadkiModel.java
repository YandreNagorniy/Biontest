package com.example.yandre.biontest.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Расчет потребности в осадках
@Entity
public class PotrebOsadkiModel {
    public PotrebOsadkiModel(long id, String culture, int value) {
        this.id = id;
        this.culture = culture;
        this.value = value;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String culture;
    private int value;

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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
