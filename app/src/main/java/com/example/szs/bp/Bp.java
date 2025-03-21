package com.example.szs.bp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bp {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo
    public String sys, dys, date, time;

    public Bp(String sys, String dys, String date, String time) {
        this.sys = sys;
        this.dys = dys;
        this.date = date;
        this.time = time;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getDys() {
        return dys;
    }

    public void setDys(String dys) {
        this.dys = dys;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}