package com.example.yandre.biontest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.yandre.biontest.database.dao.CalculatorDao;
import com.example.yandre.biontest.database.dao.CultureDao;
import com.example.yandre.biontest.database.dao.KUsvDao;
import com.example.yandre.biontest.database.dao.MethodsK2ODao;
import com.example.yandre.biontest.database.dao.MethodsNDao;
import com.example.yandre.biontest.database.dao.MethodsP2O5Dao;
import com.example.yandre.biontest.database.dao.PHDao;
import com.example.yandre.biontest.database.dao.PhasesDao;
import com.example.yandre.biontest.database.dao.PotrebOsadkiDao;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.dao.VinosDao;
import com.example.yandre.biontest.database.dao.VodopotrebDao;
import com.example.yandre.biontest.database.model.CalculatorModel;
import com.example.yandre.biontest.database.model.CultureModel;
import com.example.yandre.biontest.database.model.KUsvModel;
import com.example.yandre.biontest.database.model.MethodsK2OModel;
import com.example.yandre.biontest.database.model.MethodsNModel;
import com.example.yandre.biontest.database.model.MethodsP2O5Model;
import com.example.yandre.biontest.database.model.PHModel;
import com.example.yandre.biontest.database.model.PhasesModel;
import com.example.yandre.biontest.database.model.PotrebOsadkiModel;
import com.example.yandre.biontest.database.model.SoilFactorsModel;
import com.example.yandre.biontest.database.model.VinosModel;
import com.example.yandre.biontest.database.model.VodopotrebModel;

@Database(entities = {SoilFactorsModel.class, KUsvModel.class, CalculatorModel.class,
        PhasesModel.class, PHModel.class, PotrebOsadkiModel.class, VinosModel.class,
        VodopotrebModel.class, MethodsP2O5Model.class, MethodsK2OModel.class, MethodsNModel.class,
        CultureModel.class},
        version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SoilFactorsDao soilFactorsDao();

    public abstract KUsvDao kUsvDao();

    public abstract CalculatorDao calculatorDao();

    public abstract PhasesDao phasesDao();

    public abstract PHDao phDao();

    public abstract PotrebOsadkiDao potrebOsadkiDao();

    public abstract VinosDao vinosDao();

    public abstract VodopotrebDao vodopotrebDao();

    public abstract MethodsNDao methodsNDao();

    public abstract MethodsP2O5Dao methodsP2O5Dao();

    public abstract MethodsK2ODao methodsK2ODao();

    public abstract CultureDao cultureDao();

}
