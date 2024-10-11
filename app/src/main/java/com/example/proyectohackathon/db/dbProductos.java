package com.example.proyectohackathon.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.proyectohackathon.Entidades.Clientes;
import com.example.proyectohackathon.Entidades.Productos;

import java.util.ArrayList;

public class dbProductos extends DbHelper{
    Context context;


    public dbProductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProductos(int idEmpresa, String Nombre, String Talla, String Color,int Costo, int Nivel, String Personalizable){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("idEmpresa", idEmpresa);
            values.put("Nombre", Nombre);
            values.put("Talla", Talla);
            values.put("Color", Color);
            values.put("Costo", Costo);
            values.put("Nivel", Nivel);
            values.put("Personalizable", Personalizable);

            id = db.insert(TABLE_PRODUCTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Productos> ObtenerProductos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos Producto = null;
        Cursor cursorProductos = null;

        cursorProductos = db.rawQuery("SELECT * FROM "+TABLE_PRODUCTOS, null);

        if(cursorProductos.moveToFirst()){
            do{
                Producto = new Productos();
                Producto.setIdEmpresa(cursorProductos.getInt(0));
                Producto.setNombre(cursorProductos.getString(1));
                Producto.setTalla(cursorProductos.getString(2));
                Producto.setColor(cursorProductos.getString(3));
                Producto.setCosto(cursorProductos.getInt(4));
                Producto.setNivel(cursorProductos.getInt(5));
                Producto.setPersonalizable(cursorProductos.getString(6));



                listaProductos.add(Producto);
            }while(cursorProductos.moveToNext());
        }
        cursorProductos.close();
        return listaProductos;
    }

//    public ArrayList<Productos> ObtenerProductosPorId(int i){
//        DbHelper dbHelper = new DbHelper(context);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        ArrayList<Productos> listaProductos = new ArrayList<>();
//        Productos Producto = null;
//        Cursor cursorProductos = null;
//
//        cursorProductos = db.rawQuery("SELECT * FROM "+TABLE_PRODUCTOS+" WHERE idProducto = "+i+" ", null);
//
//        if(cursorProductos.moveToFirst()){
//            do{
//                Producto = new Productos();
//                Producto.setIdProducto(cursorProductos.getInt(0));
//                Producto.setNombre(cursorProductos.getString(1));
//                Producto.setTalla(cursorProductos.getString(2));
//                Producto.setColor(cursorProductos.getString(3));
//                Producto.setCosto(cursorProductos.getInt(4));
//                Producto.setNivel(cursorProductos.getInt(5));
//                Producto.setPersonalizable(cursorProductos.getString(6));
//
//
//
//                listaProductos.add(Producto);
//            }while(cursorProductos.moveToNext());
//        }
//        cursorProductos.close();
//        return listaProductos;
//    }

    public ArrayList<Productos> ObtenerProductosPorId(int i) {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos producto = null;

        // Usa una consulta preparada para evitar inyecciones SQL
        String query = "SELECT * FROM " + TABLE_PRODUCTOS + " WHERE idProducto = ?";
        Cursor cursorProductos = db.rawQuery(query, new String[]{String.valueOf(i)});

        if (cursorProductos.moveToFirst()) {
            do {
                producto = new Productos();
                producto.setIdProducto(cursorProductos.getInt(0));
                producto.setIdEmpresa(cursorProductos.getInt(1));
                producto.setNombre(cursorProductos.getString(2));
                producto.setTalla(cursorProductos.getString(3));
                producto.setColor(cursorProductos.getString(4));
                producto.setCosto(cursorProductos.getInt(5));
                producto.setNivel(cursorProductos.getInt(6));
                producto.setPersonalizable(cursorProductos.getString(7));

                listaProductos.add(producto);
            } while (cursorProductos.moveToNext());
        }

        cursorProductos.close();
        return listaProductos;
    }
}
