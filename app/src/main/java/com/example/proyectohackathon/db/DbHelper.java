package com.example.proyectohackathon.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private  static  final String DATABASE_NOMBRE = "Hackaton.db";
    private  static  final String TABLE_USUARIOS = "Usuarios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_USUARIOS+" (" +
                "idUsuarios INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Nombre TEXT NOT NULL," +
                "Telefono TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_USUARIOS);
        onCreate(sqLiteDatabase);
    }
}
