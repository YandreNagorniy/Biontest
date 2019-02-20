package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Relation;

import com.example.yandre.biontest.database.model.SoilFactorsModel;

import java.util.List;

public class CalculateN {
    @ColumnInfo(name = "vinos_N")
    public double vinos_N;
    public double productive;
    @ColumnInfo(name = "soil_value")
    public double value;
    @ColumnInfo(name = "kusv_N")
    public double kusv_N;

//    public String subTitle;
//    @Relation(parentColumn = "subTitle", entityColumn = "subTitle", entity = SoilFactorsModel.class,
//            projection = {"value"})
//    public List<Integer> settingsValues;

}