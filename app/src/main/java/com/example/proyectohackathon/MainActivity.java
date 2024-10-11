package com.example.proyectohackathon;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectohackathon.db.DbHelper;
import com.example.proyectohackathon.db.dbClientes;
import com.example.proyectohackathon.db.dbProductos;

public class MainActivity extends AppCompatActivity {
    Button btnCrear, btnInsert, btnSelect, btnPrincipal;
    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializa los botones
        btnIniciar = findViewById(R.id.btnIniciar);
        btnCrear = findViewById(R.id.btnCrear);
        btnPrincipal = findViewById(R.id.btnPrincipal);

        // Ajusta los márgenes para el diseño EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configura el OnClickListener de btnIniciar
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2 = new Intent(MainActivity.this, LogIn.class);
                startActivity(in2);
            }
        });

        // Llama al método para insertar registros
        Inserts();
        Inserts2();

        // Configura el OnClickListener de btnPrincipal
        btnPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, VentanaPrincipal.class);
                startActivity(in);
            }
        });

        // Configura el OnClickListener de btnCrear
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error al crear", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Método Inserts para insertar clientes
//    public void Inserts() {
//        dbClientes inC1 = new dbClientes(MainActivity.this);
//        Long id = inC1.insertarClientes("caroalvarado", "Greenbay12", "Caro Alvarado", 1);
//        if (id > 0) {
//            Toast.makeText(MainActivity.this, "Registro Guardado", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(MainActivity.this, "Error al guardar", Toast.LENGTH_LONG).show();
//        }
//    }

      public void Inserts(){
        dbProductos inP1 = new dbProductos(MainActivity.this);
        Long id = inP1.insertarProducto("Audifonos","Bods color negro",500);
        if(id >0){
            Toast.makeText(MainActivity.this, "Registro Guradado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Error al guardar", Toast.LENGTH_LONG).show();
        }

    }

    public void Inserts2(){
        dbProductos inP1 = new dbProductos(MainActivity.this);
        Long id = inP1.insertarProducto("Television","Television 40 pulgadas",7500);
        if(id >0){
            Toast.makeText(MainActivity.this, "Registro Guradado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Error al guardar", Toast.LENGTH_LONG).show();
        }

    }
}
