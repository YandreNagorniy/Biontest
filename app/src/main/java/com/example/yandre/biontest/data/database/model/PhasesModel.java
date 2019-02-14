package com.example.yandre.biontest.data.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Фазы
@Entity
public class PhasesModel {

    public PhasesModel(long id, String culture, String name, int value) {
        this.id = id;
        this.culture = culture;
        this.name = name;
        this.value = value;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String culture;
    private String name;
    private int value;
}
