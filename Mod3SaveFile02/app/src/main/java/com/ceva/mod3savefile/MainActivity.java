package com.ceva.mod3savefile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "MyFile";
    TextView archivo;
    Button save;
    Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button)findViewById(R.id.save);
        read = (Button)findViewById(R.id.read);
        archivo = (TextView)findViewById(R.id.texto);

        /**
         * Metodo para guardar informacion en un archivo
         */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String content = "Juan 3:16 - porque de tal manera amo Dios al mundo que ha dado " +
                        "su Hijo Unigenito para que todo aquel en El cree no se pierda mas tenga vida eterna";

                //clase que nos permite manejar la informacion
                FileOutputStream outputStream = null;
                try
                {
                    outputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                    outputStream.write(content.getBytes());
                    outputStream.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    FileInputStream inputStream = getApplicationContext().openFileInput(FILE_NAME);
                    InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8"); // recibimos el archivo
                    BufferedReader bufferedReader = new BufferedReader(isr); // permite manejar el archivo como buffer
                    StringBuilder sb = new StringBuilder(); //manejamos las cadenas modificables
                    String line = "";
                    while((line = bufferedReader.readLine()) != null)
                    {
                        sb.append(line).append("\n");
                    }

                    archivo.setText(sb.toString());
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }
}
