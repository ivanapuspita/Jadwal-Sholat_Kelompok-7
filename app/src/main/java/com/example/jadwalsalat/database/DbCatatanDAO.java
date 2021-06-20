package com.example.jadwalsalat.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DbCatatanDAO {

    @Insert
    long insertCatatan(CatatanModel catatanModel);

    @Delete
    int deleteCatatan(CatatanModel catatanModel);

    @Query("SELECT * FROM database_catatan")
    List<CatatanModel> getCatatancatatan();
}
