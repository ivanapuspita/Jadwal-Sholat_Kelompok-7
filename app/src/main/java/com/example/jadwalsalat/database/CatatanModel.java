package com.example.jadwalsalat.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "database_catatan")
public class CatatanModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "waktu")
    private String waktu;

    @ColumnInfo(name = "catatan")
    private String catatan;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaktu() {

        return waktu;
    }

    public void setWaktu(String waktu) {

        this.waktu = waktu;
    }

    public String getCatatan() {
        return catatan;}

    public void setCatatan(String catatan){
        this.catatan = catatan;}
}
