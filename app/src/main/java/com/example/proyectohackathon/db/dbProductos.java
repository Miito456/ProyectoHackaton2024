package com.example.proyectohackathon.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectohackathon.Entidades.Productos;

import java.util.ArrayList;

public class dbProductos extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "productosDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PRODUCTOS = "productos";

    public dbProductos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla productos
        db.execSQL("CREATE TABLE " + TABLE_PRODUCTOS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL, " +
                "descripcion TEXT, " +
                "costo REAL NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTOS);
        onCreate(db);
    }

    // Método para insertar productos
    public long insertarProducto(String nombre, String descripcion, double costo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("costo", costo);

        return db.insert(TABLE_PRODUCTOS, null, values);
    }

    // Método para obtener productos por ID
    public ArrayList<Productos> ObtenerProductosPorId(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Productos> productos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PRODUCTOS + " WHERE id = ?", new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()) {
            do {
                Productos producto = new Productos();
                producto.setId(cursor.getInt(0));
                producto.setNombre(cursor.getString(1));
                producto.setDescripcion(cursor.getString(2));
                producto.setCosto(cursor.getDouble(3));
                productos.add(producto);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return productos;
    }
}
