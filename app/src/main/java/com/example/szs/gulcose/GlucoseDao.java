package com.example.szs.gulcose;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface GlucoseDao {

    @Insert
    void insert(Glucose glucose);

    @Delete
    void delete(Glucose glucose);

    @Update
    void update(Glucose glucose);

    @Query("select * from  Glucose order by id ASC ")
    List<Glucose> GetAllGlucose();

    @Query("Delete from Glucose")
    void deleteall();
}
