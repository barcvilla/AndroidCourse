package com.ceva.mod3savefileinsd;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Para guardar informacion en la SD se debe modificar el archivo AndroidManifiest.xml para adicionar los permisos
 */
public class MainActivity extends AppCompatActivity {
    public static final String FILE_NAME = "/sdcard/mysdfile.txt";
    Button save;
    Button read;
    TextView archivo;
    private static final int MY_PERMISSION_REQUEST_WRITE_EXTERNAL = 1;
    private static final int MY_PERMISSION_REQUEST_READ_EXTERNAL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkedPermission();
        save = (Button)findViewById(R.id.save);
        read = (Button)findViewById(R.id.read);
        archivo = (TextView)findViewById(R.id.texto);

        /**
         * Guardar un archivo en la memoria SD
         */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFile();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFile();
            }
        });
    }

    /**
     * Metodo para crear un archivo
     */
    public void createFile()
    {
        try
        {
            // creamos un archivo en el SD Card
            File myFile = new File(FILE_NAME);
            myFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(myFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream); //permite manejar gran tamano memoria
            outputStreamWriter.append("Este es para el archivo SD que creamos");
            outputStreamWriter.close();
            fileOutputStream.close();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void readFile()
    {
        try
        {
            File myFile = new File(FILE_NAME);
            FileInputStream fileInputStream = new FileInputStream(myFile);
            //leer el archivo
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            // definimos como leer el archivo
            String aDataRow = "";
            String abuffer = "";
            while((aDataRow = bufferedReader.readLine()) != null)
            {
                abuffer += aDataRow;
            }
            archivo.setText(abuffer.toString());

            fileInputStream.close();
            bufferedReader.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void checkedPermission()
    {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {
                // Explicamos al usuario porque necesitamos el permiso

            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_WRITE_EXTERNAL);
            }
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE))
            {
                // Explicamos al usuario porque necesitamos el permiso

            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_READ_EXTERNAL);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case MY_PERMISSION_REQUEST_WRITE_EXTERNAL:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //permiso garantizado
                }
                break;

            case MY_PERMISSION_REQUEST_READ_EXTERNAL:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                //permiso garantizado
            }
            break;
        }
    }
}
