package com.example.yandre.biontest.pojo;

import android.arch.persistence.room.ColumnInfo;

public class SettingsValue {
    @ColumnInfo(name = "soil_value")
    public int value;
}
