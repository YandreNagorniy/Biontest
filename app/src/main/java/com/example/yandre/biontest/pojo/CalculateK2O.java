package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.ColumnInfo;

public class CalculateK2O {
    @ColumnInfo(name = "vinos_K2O")
    public double vinos_K2O;
    public double productive;
    @ColumnInfo(name = "soil_value")
    public double value;
    @ColumnInfo(name = "kusv_K2O")
    public double kusv_K2O;

}