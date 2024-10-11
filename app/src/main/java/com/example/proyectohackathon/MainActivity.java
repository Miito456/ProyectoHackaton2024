package com.example.proyectohackathon;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectohackathon.Entidades.Clientes;
import com.example.proyectohackathon.db.DbHelper;
import com.example.proyectohackathon.db.dbClientes;
import com.example.proyectohackathon.db.dbEmpresas;
import com.example.proyectohackathon.db.dbProductos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCrear, btnInsert, btnSelect;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            //Comentario ejemeplo


        });

        Inserts();
        btnCrear =findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error al crear", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnInsert = (Button) findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Registro Guradado", Toast.LENGTH_LONG).show();
//                dbClientes insert = new dbClientes(MainActivity.this);
//                Long id = insert.insertarClientes("User", "User", "Prueba Hackaton", 1);
//                if(id >0){
//                    Toast.makeText(MainActivity.this, "Registro Guradado", Toast.LENGTH_LONG).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "Error al guardar", Toast.LENGTH_LONG).show();
//                }

            }
        });

        btnSelect = (Button) findViewById(R.id.btnSelect);

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbClientes select = new dbClientes(MainActivity.this);
                ArrayList<Clientes> clientes = select.ObtenerClientes();
                int i= 1;
                for(Clientes cliente : clientes){
                    Toast.makeText(MainActivity.this, "Leer", Toast.LENGTH_SHORT).show();
                    Log.i("Info Tag", ""+i);
                    Log.i("Info Tag","ID: "+cliente.getIdCliente());
                    Log.i("Info Tag","User: "+cliente.getUser());
                    Log.i("Info Tag","Password: "+cliente.getPassword());
                    Log.i("Info Tag","Nombre: "+cliente.getNivel());
                    Log.i("Info Tag","Nivel: "+cliente.getNivel());
                }

            }
        });


    }

    public void Inserts(){
        dbEmpresas inE1 = new dbEmpresas(MainActivity.this);
        Long id = inE1.insertarEmpresas("Los Canastos", "Venta a granel de productos naturales","Juarez #103");
        if(id >0){
                    Toast.makeText(MainActivity.this, "Registro Guradado", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error al guardar", Toast.LENGTH_LONG).show();
                }
//        dbProductos inP1 = new dbProductos(MainActivity.this);
//        inP1.insertarProductos();
    }


}