package com.example.proyectohackathon;

import static com.example.proyectohackathon.db.DbHelper.TABLE_CLIENTES;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.proyectohackathon.Entidades.Clientes;
import com.example.proyectohackathon.Entidades.Productos;
import com.example.proyectohackathon.db.DbHelper;
import com.example.proyectohackathon.db.dbProductos;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.proyectohackathon.LogIn.*;

import java.util.ArrayList;

public class VentanaPrincipal extends AppCompatActivity {
//X
TextView productTit1,productDes1,productPrice1,productTit2,productPrice2,saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);

        productTit1 = (TextView) findViewById(R.id.productTitle1);
        productDes1 = (TextView) findViewById(R.id.productDescription1);
        productPrice1 = (TextView) findViewById(R.id.productPrice1);
        productTit2 = (TextView) findViewById(R.id.productTitle2);
        productPrice2 = (TextView) findViewById(R.id.productPrice2);
        saludo = (TextView) findViewById(R.id.greetingTextView);
        //Insert();
        LeerProducto1();
        LeerProducto2();

        saludo.setText("Hola, Caro");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_home) {
                    // Navegar a HomeActivity
                    Intent intentHome = new Intent(VentanaPrincipal.this, VentanaPrincipal.class);
                    startActivity(intentHome);
                    return true;
                } else if (item.getItemId() == R.id.item_search) {
                    // Navegar a SearchActivity
                    Intent intentSearch = new Intent(VentanaPrincipal.this, SearchActivity.class);
                    startActivity(intentSearch);
                    return true;
                } else if (item.getItemId() == R.id.item_profile) {
                    // Navegar a ProfileActivity
                    Intent intentProfile = new Intent(VentanaPrincipal.this, ProfileActivity.class);
                    startActivity(intentProfile);
                    return true;
                }
                return false;
            }
        });
    }

    public void LeerProducto1(){
        dbProductos cp1 = new dbProductos(VentanaPrincipal.this);
        ArrayList<Productos> aProductos = cp1.ObtenerProductosPorId(1);
        for (Productos producto: aProductos) {
            //Toast.makeText(VentanaPrincipal.this, producto.getNombre(), Toast.LENGTH_LONG).show();

            productTit1.setText(producto.getNombre());
            productPrice1.setText("$"+String.valueOf(producto.getCosto()));
        }
    }

    public void LeerProducto2(){
        dbProductos cp1 = new dbProductos(VentanaPrincipal.this);
        ArrayList<Productos> aProductos = cp1.ObtenerProductosPorId(2);
        for (Productos producto: aProductos) {
            // Toast.makeText(VentanaPrincipal.this, producto.getNombre(), Toast.LENGTH_LONG).show();

            productTit2.setText(producto.getNombre());
            productPrice2.setText("$"+String.valueOf(producto.getCosto()));
        }
    }
}