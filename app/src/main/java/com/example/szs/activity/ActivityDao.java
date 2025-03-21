package com.example.szs.activity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface ActivityDao {

    @Insert
    void insert(Activity activity);

    @Delete
    void delete(Activity activity);

    @Update
    void update(Activity activity);

    @Query("select * from  Activity order by id ASC ")
    List<Activity> GetAllActivity();

    @Query("Delete from Activity")
    void deleteall();
}
