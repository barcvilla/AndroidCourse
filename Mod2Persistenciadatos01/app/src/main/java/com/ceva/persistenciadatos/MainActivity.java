package com.ceva.persistenciadatos;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText)findViewById(R.id.usuario);
    }

    /**
     * este metodo salva la instancia del activity y evita la perdida de informacion ingresada por el usuario en una activity
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("user", usuario.getText().toString());
    }

    /**
     * En la persistencia tenemos 2 parte: Guardar y Exponer
     */
    //recuperamos la info

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        usuario.setText(savedInstanceState.getString("user"));
    }
}
