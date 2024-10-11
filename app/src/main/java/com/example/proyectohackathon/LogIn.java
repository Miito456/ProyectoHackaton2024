package com.example.proyectohackathon;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in); // Tu layout para la ventana de login


    }

    // Este método podría ser llamado después de una validación exitosa
    public void goToMainActivity() {
        Intent intent = new Intent(LogIn.this, VentanaPrincipal.class);
        startActivity(intent);
        finish();  // Esto cierra la actividad de login para que el usuario no pueda regresar a ella
    }
}
