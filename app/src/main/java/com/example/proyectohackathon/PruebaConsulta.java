package com.example.proyectohackathon;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class PruebaConsulta extends AppCompatActivity {

    private static final String DATABASE_NAME = "Hackaton.db";
            TextView tvUser, tvPass, tvNombre, tvNivel;
    Button btnConsulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prueba_consulta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        tvUser = findViewById(R.id.tvUser);
        tvPass = findViewById(R.id.tvPass);
        tvNombre = findViewById(R.id.tvNombre);
        tvNivel = findViewById(R.id.tvNivel);

        btnConsulta = findViewById(R.id.btnConsulta);


        String databasePath = getApplicationContext().getDatabasePath(DATABASE_NAME).getPath();

        // Verificar si la base de datos existe
        File dbFile = getApplicationContext().getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists()) {
            Toast.makeText(PruebaConsulta.this, "Base de datos no encontrada", Toast.LENGTH_LONG).show();
            return;
        }

        // Abrir la base de datos existente y realizar consultas
        SQLiteDatabase db = null;
        try {
            // Abrir la base de datos en modo solo lectura
            db = SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.OPEN_READONLY);

            // Realizar una consulta
            Cursor cursor = db.rawQuery("SELECT * FROM Clientes", null);

            String User = "", Pass = "", Nombre = "";
            int Nivel = 0;

            if (cursor.moveToFirst()) {
                do {
                    User = cursor.getString(cursor.getColumnIndexOrThrow("User"));
                    Pass = cursor.getString(cursor.getColumnIndexOrThrow("Password"));
                    Nombre = cursor.getString(cursor.getColumnIndexOrThrow("Nombre"));
                    Nivel = cursor.getInt(cursor.getColumnIndexOrThrow("Nivel"));  // Corrección aquí
                } while (cursor.moveToNext());
            }

            tvUser.setText(User);
            tvPass.setText(Pass);
            tvNombre.setText(Nombre);

            cursor.close();

        } catch (SQLiteException e) {
            e.printStackTrace();
            Toast.makeText(PruebaConsulta.this, "Error de lectura", Toast.LENGTH_LONG).show();  // Corrección aquí
        } finally {
            if (db != null) {
                db.close();
            }

        }

    }
}