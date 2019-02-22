package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.ColumnInfo;

public class CalculateCaO {
    @ColumnInfo(name = "vinos_CaO")
    public double vinos_CaO;
    public double productive;
    @ColumnInfo(name = "soil_value")
    public double value;
    @ColumnInfo(name = "kusv_CaO")
    public double kusv_CaO;

}