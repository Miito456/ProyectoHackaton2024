package com.example.proyectohackathon.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private  static  final String DATABASE_NOMBRE = "BaseDatosHackaton.db";
    public  static  final String TABLE_CLIENTES = "Clientes";
    public static  final String TABLE_EMPRESAS = "Empresas";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CLIENTES+" (" +
                "idClientes INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "User TEXT NOT NULL," +
                "Password TEXT NOT NULL," +
                "Nombre TEXT NOT NULL," +
                "Nivel INTEGER NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_EMPRESAS+" (" +
                "idEmpresa INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Nombre TEXT NOT NULL," +
                "Descripción TEXT NOT NULL," +
                "Ubicacion NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CLIENTES);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_EMPRESAS);
        onCreate(sqLiteDatabase);
    }
}
