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
    public static final String TABLE_PRODUCTOS = "Productos";
    public static final String TABLE_CLIENTETIPOS = "ClienteTipos";
    public static final String TABLE_PRODUCTOTIPOS = "ProductoTipos";
    public static final String TABLE_FORO = "Foro";
    public static final String TABLE_CARRITO = "Carrito";

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


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTOS + " (" +
                "idProducto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idEmpresa INTEGER NOT NULL, " +
                "Nombre TEXT NOT NULL, " +
                "Talla TEXT, " +
                "Color TEXT, " +
                "Costo NUMERIC NOT NULL, " +
                "Nivel INTEGER NOT NULL, " +
                "Personalizable TEXT NOT NULL, " +
                "FOREIGN KEY(idEmpresa) REFERENCES " + TABLE_EMPRESAS + "(idEmpresa), " +
                "CHECK(Talla IN ('XS', 'S', 'M', 'L', 'XL')), " +
                "CHECK(Personalizable IN ('Si', 'No')))");


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CLIENTETIPOS + "(" +
                "idClienteTipos INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "idCliente INTEGER NOT NULL, "+
                "Tipo TEXT NOT NULL, "+
                "FOREIGN KEY(idCliente) REFERENCES " + TABLE_CLIENTES + "(idCliente), " +
                "CHECK(Tipo IN('Ropa', 'Accesorios', 'Tecnologia', 'Anime', 'Deportes', 'Comida', 'Personalizables', 'Decoracion', 'Papeleria', 'Musica')))");



        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_PRODUCTOTIPOS +"(" +
                "idProductoTipos INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "idProducto INTEGER NOT NULL, "+
                "Tipo TEXT NOT NULL, "+
                "FOREIGN KEY(idProducto) REFERENCES "+ TABLE_PRODUCTOS +"(idProducto), "+
                "CHECK(Tipo IN('Ropa', 'Accesorios', 'Tecnologia', 'Anime', 'Deportes', 'Comida', 'Personalizables', 'Decoracion', 'Papeleria', 'Musica')))");

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_FORO +"(" +
                "idForo INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "idProducto INTEGER NOT NULL, "+
                "idCliente INTEGER NOT NULL, "+
                "Calificacion INTEGER NOT NULL, "+
                "FOREIGN KEY(idProducto) REFERENCES "+ TABLE_PRODUCTOS +"(idProducto), " +
                "FOREIGN KEY(idCliente) REFERENCES "+ TABLE_CLIENTES +"(idCliente))");


        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_CARRITO +"(" +
                "idCarrito INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "idCliente INTEGER NOT NULL, "+
                "idProducto INTEGER NOT NULL, "+
                "Personalizacion TEXT, "+
                "Color TEXT, "+
                "FOREIGN KEY(idCliente) REFERENCES "+ TABLE_CLIENTES +"(idCliente), "+
                "FOREIGN KEY(idProducto) REFERENCES "+ TABLE_PRODUCTOS +"(idProducto))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CLIENTES);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_EMPRESAS);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_PRODUCTOS);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CLIENTETIPOS);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_PRODUCTOTIPOS);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_FORO);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CARRITO);
        onCreate(sqLiteDatabase);
    }
}
