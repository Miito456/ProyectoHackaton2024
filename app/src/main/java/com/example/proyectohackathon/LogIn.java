package com.example.proyectohackathon;

import static com.example.proyectohackathon.db.DbHelper.TABLE_CLIENTES;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectohackathon.Entidades.Clientes;
import com.example.proyectohackathon.db.DbHelper;

public class LogIn extends AppCompatActivity {
    private RelativeLayout btnIniciar;
    private TextView user;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in); // Tu layout para la ventana de login

        btnIniciar = (android.widget.RelativeLayout) findViewById(R.id.btnIniciar);
        user = (TextView) findViewById(R.id.user);
        password = (TextView) findViewById(R.id.password);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DbHelper dbHelper = new DbHelper(LogIn.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    Clientes cliente = null;
                    Cursor cursorClientes = null;

                    cursorClientes = db.rawQuery("SELECT * FROM "+TABLE_CLIENTES+" WHERE User = '"+user.getText()+"'", null);

                    if(cursorClientes.moveToFirst()){
                            if(cursorClientes.getString(2)== password.getText()){
                                Intent intent = new Intent(LogIn.this, VentanaPrincipal.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LogIn.this,"Contraseña Incorrecta, ¡Intenta de Nuevo!",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(LogIn.this, "Perfil no Registrado, ¡Intenta de Nuevo!", Toast.LENGTH_SHORT).show();


                        }}
        });
    }

    // Este método podría ser llamado después de una validación exitosa
    public void goToMainActivity() {
        Intent intent = new Intent(LogIn.this, VentanaPrincipal.class);
        startActivity(intent);
        finish();  // Esto cierra la actividad de login para que el usuario no pueda regresar a ella
    }
}
