package com.example.proyectohackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VentanaPrincipal extends AppCompatActivity {
//X
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_principal);

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
}