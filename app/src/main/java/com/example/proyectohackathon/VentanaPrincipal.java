package com.example.proyectohackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectohackathon.Entidades.Productos;
import com.example.proyectohackathon.db.dbProductos;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class VentanaPrincipal extends AppCompatActivity {
    TextView productTit1, productDes1, productPrice1, productTit2, productPrice2,productPrice3,productTit3,
            productTit4,productTit5,productPrice4,productPrice5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);

        // Inicializar vistas de productos
        productTit1 = findViewById(R.id.productTitle1);
        productDes1 = findViewById(R.id.productDescription1);
        productPrice1 = findViewById(R.id.productPrice1);
        productTit2 = findViewById(R.id.productTitle2);
        productPrice2 = findViewById(R.id.productPrice2);
        productTit3 = findViewById(R.id.productTitle3);
        productPrice3 = findViewById(R.id.productPrice3);
        productTit4 = findViewById(R.id.productTitle4);
        productPrice4 = findViewById(R.id.productPrice4);
        productTit5 = findViewById(R.id.productTitle5);
        productPrice5 = findViewById(R.id.productPrice5);

        // Cargar información de los productos
        LeerProducto1();
        LeerProducto2();
        LeerProducto3();
        LeerProducto4();
        LeerProducto5();

        // Inicializar barra de navegación inferior
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

    // Método para leer el producto con ID 1
    public void LeerProducto1() {
        dbProductos db = new dbProductos(VentanaPrincipal.this);
        ArrayList<Productos> productos = db.ObtenerProductosPorId(1);
        for (Productos producto : productos) {
            productTit1.setText(producto.getNombre());
            productPrice1.setText("$" + producto.getCosto());
        }
    }

    // Método para leer el producto con ID 2
    public void LeerProducto2() {
        dbProductos db = new dbProductos(VentanaPrincipal.this);
        ArrayList<Productos> productos = db.ObtenerProductosPorId(2);
        for (Productos producto : productos) {
            productTit2.setText(producto.getNombre());
            productPrice2.setText("$" + producto.getCosto());
        }
    }

    public void LeerProducto3() {
        dbProductos db = new dbProductos(VentanaPrincipal.this);
        ArrayList<Productos> productos = db.ObtenerProductosPorId(3);
        for (Productos producto : productos) {
            productTit2.setText(producto.getNombre());
            productPrice2.setText("$" + producto.getCosto());
        }
    }


    public void LeerProducto4() {
        dbProductos db = new dbProductos(VentanaPrincipal.this);
        ArrayList<Productos> productos = db.ObtenerProductosPorId(4);
        for (Productos producto : productos) {
            productTit2.setText(producto.getNombre());
            productPrice2.setText("$" + producto.getCosto());
        }
    }
    public void LeerProducto5() {
        dbProductos db = new dbProductos(VentanaPrincipal.this);
        ArrayList<Productos> productos = db.ObtenerProductosPorId(5);
        for (Productos producto : productos) {
            productTit2.setText(producto.getNombre());
            productPrice2.setText("$" + producto.getCosto());
        }
    }
}
