package com.example.proyectohackathon;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectohackathon.Entidades.Productos;
import com.example.proyectohackathon.db.dbEmpresas;
import com.example.proyectohackathon.db.dbProductos;

import java.util.ArrayList;

public class VentanaPrincipal extends AppCompatActivity {
    TextView productTit1,productDes1,productPrice1,productTit2,productPrice2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);
        productTit1 = (TextView) findViewById(R.id.productTitle1);
        productDes1 = (TextView) findViewById(R.id.productDescription1);
        productPrice1 = (TextView) findViewById(R.id.productPrice1);
        productTit2 = (TextView) findViewById(R.id.productTitle2);
        productPrice2 = (TextView) findViewById(R.id.productPrice2);
        //Insert();
        LeerProducto1();
        LeerProducto2();
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

//    public void Insert(){
//        dbProductos inP1 = new dbProductos(VentanaPrincipal.this);
//        Long id = inP1.insertarProductos("Teclado Mecánico",null,"Negro",1500,1,"No");
//        if(id >0){
//            Toast.makeText(VentanaPrincipal.this, "Registro Guradado", Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(VentanaPrincipal.this, "Error al guardar", Toast.LENGTH_LONG).show();
//        }
//    }
}
