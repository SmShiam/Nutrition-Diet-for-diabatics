package com.example.szs.medicine;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface MedicineDao {

    @Insert
    void insert(Medicine medicine);

    @Delete
    void delete(Medicine medicine);

    @Update
    void update(Medicine medicine);

    @Query("select * from  Medicine order by id ASC ")
    List<Medicine> GetAllMedicine();

    @Query("Delete from Medicine")
    void deleteall();
}
