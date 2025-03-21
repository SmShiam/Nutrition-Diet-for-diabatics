package com.example.szs;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.szs.activity.Activity;
import com.example.szs.activity.ActivityDao;
import com.example.szs.bp.Bp;
import com.example.szs.bp.BpDao;
import com.example.szs.gulcose.Glucose;
import com.example.szs.gulcose.GlucoseDao;
import com.example.szs.meals.Meals;
import com.example.szs.meals.MealsDao;
import com.example.szs.medicine.Medicine;
import com.example.szs.medicine.MedicineDao;

@Database(entities = {Activity.class, Bp.class, Medicine.class, Meals.class, Glucose.class}, version = 5, exportSchema = false)
public abstract class Nutrition_Database extends RoomDatabase {

    public static volatile Nutrition_Database INSTANCE;

    static Nutrition_Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Nutrition_Database.class,
                            "Nutrition_Database").fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract ActivityDao getActivityDao();

    public abstract BpDao getBpDao();

    public abstract MedicineDao getMedicineDao();

    public abstract MealsDao getMealsDao();

    public abstract GlucoseDao GetGlucoseDao();

}
