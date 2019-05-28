package com.ceva.mod3sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * SharedPreference es un archivo xml generado por Android que utiliza la estructura MAP es decir
 * clave - valor
 */
public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.texto);
        button = (Button)findViewById(R.id.shared);

        /**
         * Recuperamos el archivo alumnos.xml que es un SharedPreference. Si no existe podra el texto hard coded: no data
         */
        SharedPreferences preferences = getSharedPreferences("alumnos", Context.MODE_PRIVATE);
        editText.setText(preferences.getString("nombre", "no data"));

        /**
         * Guardar informacion en el SharedPreference
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                //Context.MODE_PRIVATE indica que ninguna otra persona podra acceder al shared[reference
                SharedPreferences sharedPreferences = getSharedPreferences("alumnos", Context.MODE_PRIVATE);
                //editamos el sharedpreference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nombre", data);
                editor.commit();
            }
        });



    }
}
