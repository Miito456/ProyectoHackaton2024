package com.example.proyectohackathon.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.proyectohackathon.Entidades.Clientes;
import com.example.proyectohackathon.Entidades.Empresas;

import java.sql.Blob;
import java.util.ArrayList;

public class dbEmpresas extends DbHelper{
    Context context;


    public dbEmpresas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarEmpresas(String Nombre, Byte Logo, String Descripcion, String Ubicacion){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Nombre", Nombre);
            values.put("Logo", Logo);
            values.put("Descripcion", Nombre);
            values.put("Ubicacion", Ubicacion);

            id = db.insert(TABLE_EMPRESAS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Empresas> ObtenerEmpresas(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Empresas> listaEmpresas = new ArrayList<>();
        Empresas Empresa = null;
        Cursor cursorEmpresas = null;

        cursorEmpresas = db.rawQuery("SELECT * FROM "+TABLE_EMPRESAS, null);

        if(cursorEmpresas.moveToFirst()){
            do{
                Empresa = new Empresas();
                Empresa.setIdEmpresa(cursorEmpresas.getInt(0));
                Empresa.setNombre(cursorEmpresas.getString(1));
                Empresa.setDescripcion(cursorEmpresas.getString(2));
                Empresa.setUbicacion(cursorEmpresas.getString(3));

                listaEmpresas.add(Empresa);
            }while(cursorEmpresas.moveToNext());
        }
        cursorEmpresas.close();
        return listaEmpresas;
    }
}
