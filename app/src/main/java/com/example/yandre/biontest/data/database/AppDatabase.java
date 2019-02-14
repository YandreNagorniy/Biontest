package com.example.yandre.biontest.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.yandre.biontest.data.database.dao.CalculatorDao;
import com.example.yandre.biontest.data.database.dao.KUsvDao;
import com.example.yandre.biontest.data.database.dao.MethodsK2ODao;
import com.example.yandre.biontest.data.database.dao.MethodsNDao;
import com.example.yandre.biontest.data.database.dao.MethodsP2O5Dao;
import com.example.yandre.biontest.data.database.dao.PHDao;
import com.example.yandre.biontest.data.database.dao.PhasesDao;
import com.example.yandre.biontest.data.database.dao.PotrebOsadkiDao;
import com.example.yandre.biontest.data.database.dao.SoilFactorsDao;
import com.example.yandre.biontest.data.database.dao.VinosDao;
import com.example.yandre.biontest.data.database.dao.VodopotrebDao;
import com.example.yandre.biontest.data.database.model.CalculatorModel;
import com.example.yandre.biontest.data.database.model.KUsvModel;
import com.example.yandre.biontest.data.database.model.MethodsK2OModel;
import com.example.yandre.biontest.data.database.model.MethodsNModel;
import com.example.yandre.biontest.data.database.model.MethodsP2O5Model;
import com.example.yandre.biontest.data.database.model.PHModel;
import com.example.yandre.biontest.data.database.model.PhasesModel;
import com.example.yandre.biontest.data.database.model.PotrebOsadkiModel;
import com.example.yandre.biontest.data.database.model.SoilFactorsModel;
import com.example.yandre.biontest.data.database.model.VinosModel;
import com.example.yandre.biontest.data.database.model.VodopotrebModel;

//@Database(entities = {SoilFactorsModel.class, CalculatorModel.class, KUsvModel.class, Method1Model.class,
//        Method2Model.class, MethodsModel.class, PhasesModel.class, PHModel.class, PhasesModel.class, PotrebOsadkiModel.class,
//        VinosModel.class, VodopotrebModel.class}, version = 1)

@Database(entities = {SoilFactorsModel.class, KUsvModel.class, CalculatorModel.class,
        PhasesModel.class, PHModel.class, PotrebOsadkiModel.class, VinosModel.class,
        VodopotrebModel.class, MethodsP2O5Model.class, MethodsK2OModel.class, MethodsNModel.class /**Method1Model.class, Method2Model.class, MethodsModel.class**/}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SoilFactorsDao soilFactorsDao();

    public abstract KUsvDao kUsvDao();

    public abstract CalculatorDao calculatorDao();

    public abstract PhasesDao phasesDao();

    public abstract PHDao phDao();

    public abstract PotrebOsadkiDao potrebOsadkiDao();

    public abstract VinosDao vinosDao();

    public abstract VodopotrebDao vodopotrebDao();

//    public abstract Method1Dao method1Dao();
//
//    public abstract Method2Dao method2Dao();
//
//    public abstract MethodsDao methodsDao();

    public abstract MethodsNDao methodsNDao();

    public abstract MethodsP2O5Dao methodsP2O5Dao();

    public abstract MethodsK2ODao methodsK2ODao();

}