package com.example.proyectohackathon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_home) {
                    // Navegar a HomeActivity
                    Intent intentHome = new Intent(SearchActivity.this, VentanaPrincipal.class);
                    startActivity(intentHome);
                    return true;
                } else if (item.getItemId() == R.id.item_search) {
                    // Navegar a SearchActivity
                    Intent intentSearch = new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intentSearch);
                    return true;
                } else if (item.getItemId() == R.id.item_profile) {
                    // Navegar a ProfileActivity
                    Intent intentProfile = new Intent(SearchActivity.this, ProfileActivity.class);
                    startActivity(intentProfile);
                    return true;
                }
                return false;
            }
        });
    }
}