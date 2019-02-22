package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.ColumnInfo;

public class CalculateS {
    @ColumnInfo(name = "vinos_S")
    public double vinos_S;
    public double productive;
    @ColumnInfo(name = "soil_value")
    public double value;
    @ColumnInfo(name = "kusv_S")
    public double kusv_S;

}