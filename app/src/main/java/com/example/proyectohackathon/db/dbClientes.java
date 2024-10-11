package com.example.proyectohackathon.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.proyectohackathon.Entidades.Clientes;

import java.util.ArrayList;

public class dbClientes extends DbHelper{
    Context context;



    public dbClientes(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarClientes(String User, String Password, String Nombre, int Nivel) {
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
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public ArrayList<Clientes> ObtenerClientes(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Clientes cliente = null;
        Cursor cursorClientes = null;

        cursorClientes = db.rawQuery("SELECT * FROM "+TABLE_CLIENTES, null);

        if(cursorClientes.moveToFirst()){
            do{
                cliente = new Clientes();
                cliente.setIdCliente(cursorClientes.getInt(0));
                cliente.setUser(cursorClientes.getString(1));
                cliente.setPassword(cursorClientes.getString(2));
                cliente.setNivel(cursorClientes.getInt(3));

                listaClientes.add(cliente);
            }while(cursorClientes.moveToNext());
        }
        cursorClientes.close();
        return listaClientes;
    }

}
