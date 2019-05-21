package com.ceva.appnotepad.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ceva.appnotepad.R;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // creamos un archivo xml en el telefono con nuestras preferencias
        SharedPreferences sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("usuario", "ed");
        editor.putString("password", "ed");
        editor.commit();

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this, "Hiciste Click", Toast.LENGTH_SHORT).show();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                SharedPreferences preferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
                if(user.equals(preferences.getString("usuario", "x")))
                {
                    if(pass.equals(preferences.getString("password", "x")))
                    {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // una vez hecho el login ya no se necesita la activity login
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "wrong Password", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "wrong Username", Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
