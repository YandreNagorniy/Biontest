package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.ColumnInfo;

public class CalculateP2O5 {
    @ColumnInfo(name = "vinos_P2O5")
    public double vinos_P2O5;
    public double productive;
    @ColumnInfo(name = "soil_value")
    public double value;
    @ColumnInfo(name = "kusv_P2O5")
    public double kusv_P2O5;

}