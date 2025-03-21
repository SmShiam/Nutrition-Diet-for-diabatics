package com.example.szs.bp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface BpDao {

    @Insert
    void insert(Bp bp);

    @Delete
    void delete(Bp bp);

    @Update
    void update(Bp bp);

    @Query("select * from  Bp order by id ASC ")
    List<Bp> GetAllBp();

    @Query("Delete from Bp")
    void deleteall();
}
