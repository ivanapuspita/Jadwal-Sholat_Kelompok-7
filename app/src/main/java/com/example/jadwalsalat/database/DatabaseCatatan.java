package com.example.jadwalsalat.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CatatanModel.class}, version = 1)
public abstract class DatabaseCatatan extends RoomDatabase {

    private static DatabaseCatatan databaseCatatan;

    public abstract DbCatatanDAO catatanDAO();

    public static DatabaseCatatan initDbs(Context context) {
        if (databaseCatatan == null){
            databaseCatatan = Room.databaseBuilder(
                    context,
                    DatabaseCatatan.class,
                    "catatan"
            ).allowMainThreadQueries().build();
        }

        return databaseCatatan;
    }

}
