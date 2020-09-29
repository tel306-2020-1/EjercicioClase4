package com.example.clase05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textViewEnlace);
        textView.setText(Html.fromHtml("<a href='#'>Crear una nueva cuenta</a>"));

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextUsuario = findViewById(R.id.editTextUsuario);
                EditText editTextPassword = findViewById(R.id.editTextPassword);

                String usuario = editTextUsuario.getText().toString();
                String password = editTextPassword.getText().toString();

                if (usuario.isEmpty()) {
                    editTextUsuario.setError("No puede ser vacio");
                }

                if (password.isEmpty()) {
                    editTextPassword.setError("No puede ser vacio");
                }

                if (!usuario.isEmpty() && !password.isEmpty() &&
                        usuario.equalsIgnoreCase("Juan") &&
                        password.equalsIgnoreCase("123")) {
                    Toast.makeText(MainActivity.this, "Ingreso exitoso", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,NoticiasActivity.class));
                    finish();
                } else {
                    TextView textView1 = findViewById(R.id.textViewError);
                    textView1.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    public void abrirRegistroActivity(View view) {
        startActivity(new Intent(this, RegistroActivity.class));
    }

}