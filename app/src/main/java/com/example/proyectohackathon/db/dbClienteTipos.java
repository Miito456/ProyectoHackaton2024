package com.example.proyectohackathon.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.proyectohackathon.Entidades.ClienteTipos;

import java.util.ArrayList;

public class dbClienteTipos extends DbHelper{
    Context context;


    public dbClienteTipos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarClienteTipos(int idCliente, String Tipo){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("idCliente", idCliente);
            values.put("Tipo", Tipo);


            id = db.insert(TABLE_CLIENTETIPOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<ClienteTipos> ObtenerClienteTipo{
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<ClienteTipos> listaClienteTipos = new ArrayList<>();
        ClienteTipos ClienteTipo = null;
        Cursor cursorClienteTipos = null;

        cursorClienteTipos = db.rawQuery("SELECT * FROM "+TABLE_CLIENTETIPOS, null);

        if(cursorClienteTipos.moveToFirst()){
            do{
                ClienteTipo = new ClienteTipos();
                ClienteTipo.setIdCliente(cursorClienteTipos.getInt(0));
                ClienteTipo.setTipo(cursorClienteTipos.getString(1));


                listaClienteTipos.add(ClienteTipo);
            }while(cursorClienteTipos.moveToNext());
        }
        cursorClienteTipos.close();

        return listaClienteTipos;
    }
}
