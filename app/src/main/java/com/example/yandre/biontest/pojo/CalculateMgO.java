package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.ColumnInfo;

public class CalculateMgO {
    @ColumnInfo(name = "vinos_MgO")
    public double vinos_MgO;
    public double productive;
    @ColumnInfo(name = "soil_value")
    public double value;
    @ColumnInfo(name = "kusv_MgO")
    public double kusv_MgO;

}