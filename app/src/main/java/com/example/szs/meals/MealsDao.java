package com.example.szs.meals;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface MealsDao {

    @Insert
    void insert(Meals meals);

    @Delete
    void delete(Meals meals);

    @Update
    void update(Meals meals);

    @Query("select * from  Meals order by id ASC ")
    List<Meals> GetAllMeals();

    @Query("Delete from Meals")
    void deleteall();
}
