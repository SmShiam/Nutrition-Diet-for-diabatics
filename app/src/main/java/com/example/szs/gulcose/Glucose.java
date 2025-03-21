package com.example.szs.gulcose;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Glucose {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String name, date, time;

    public Glucose(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
