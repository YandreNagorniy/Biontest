package com.example.yandre.biontest.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.yandre.biontest.database.dao.CalculatorDao;
import com.example.yandre.biontest.database.dao.KUsvDao;
import com.example.yandre.biontest.database.dao.Method1Dao;
import com.example.yandre.biontest.database.dao.Method2Dao;
import com.example.yandre.biontest.database.dao.MethodsDao;
import com.example.yandre.biontest.database.dao.PHDao;
import com.example.yandre.biontest.database.dao.PhasesDao;
import com.example.yandre.biontest.database.dao.PotrebOsadkiDao;
import com.example.yandre.biontest.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.database.dao.VinosDao;
import com.example.yandre.biontest.database.dao.VodopotrebDao;
import com.example.yandre.biontest.database.model.CalculatorModel;
import com.example.yandre.biontest.database.model.KUsvModel;
import com.example.yandre.biontest.database.model.Method1Model;
import com.example.yandre.biontest.database.model.Method2Model;
import com.example.yandre.biontest.database.model.MethodsModel;
import com.example.yandre.biontest.database.model.PHModel;
import com.example.yandre.biontest.database.model.PhasesModel;
import com.example.yandre.biontest.database.model.PotrebOsadkiModel;
import com.example.yandre.biontest.database.model.SoilFactorsModel;
import com.example.yandre.biontest.database.model.VinosModel;
import com.example.yandre.biontest.database.model.VodopotrebModel;

//@Database(entities = {SoilFactorsModel.class, CalculatorModel.class, KUsvModel.class, Method1Model.class,
//        Method2Model.class, MethodsModel.class, PhasesModel.class, PHModel.class, PhasesModel.class, PotrebOsadkiModel.class,
//        VinosModel.class, VodopotrebModel.class}, version = 1)

@Database(entities = {SoilFactorsModel.class, KUsvModel.class, CalculatorModel.class,
        PhasesModel.class, PHModel.class, PotrebOsadkiModel.class, VinosModel.class,
        VodopotrebModel.class, Method1Model.class, Method2Model.class, MethodsModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SoilFactorsDao soilFactorsDao();

    public abstract KUsvDao kUsvDao();

    public abstract CalculatorDao calculatorDao();

    public abstract PhasesDao phasesDao();

    public abstract PHDao phDao();

    public abstract PotrebOsadkiDao potrebOsadkiDao();

    public abstract VinosDao vinosDao();

    public abstract VodopotrebDao vodopotrebDao();

    public abstract Method1Dao method1Dao();

    public abstract Method2Dao method2Dao();

    public abstract MethodsDao methodsDao();
}
