package com.example.proyectohackathon;



import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {

    private Button changeLanguageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_home) {
                    // Navegar a HomeActivity
                    Intent intentHome = new Intent(ProfileActivity.this, VentanaPrincipal.class);
                    startActivity(intentHome);
                    return true;
                } else if (item.getItemId() == R.id.item_search) {
                    // Navegar a SearchActivity
                    Intent intentSearch = new Intent(ProfileActivity.this, SearchActivity.class);
                    startActivity(intentSearch);
                    return true;
                } else if (item.getItemId() == R.id.item_profile) {
                    // Navegar a ProfileActivity
                    Intent intentProfile = new Intent(ProfileActivity.this, ProfileActivity.class);
                    startActivity(intentProfile);
                    return true;
                }
                return false;
            }
        });

        changeLanguageButton = findViewById(R.id.btnIdioma);

        // Listener para el botón de cambio de idioma
        changeLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar idioma a español (puedes cambiarlo por otro idioma)
                setLocale("en");
            }
        });
    }

    // Método para cambiar el idioma
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Reiniciar la actividad para aplicar los cambios
        Intent refresh = new Intent(this, ProfileActivity.class);
        startActivity(refresh);
        finish();
    }
}