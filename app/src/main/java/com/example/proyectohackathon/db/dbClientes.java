package com.example.proyectohackathon.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbClientes extends DbHelper{
    Context context;


    public dbClientes(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarClientes(String User, String Password, String Nombre, int Nivel){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("User", User);
            values.put("Password", Password);
            values.put("Nombre", Nombre);
            values.put("Nivel", Nivel);

            id = db.insert(TABLE_CLIENTES, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
