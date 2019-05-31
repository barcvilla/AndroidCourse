package com.recipeapp.ceva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.recipeapp.ceva.domain.Recipe;

public class AddRecipeActivity extends AppCompatActivity {
    EditText id;
    EditText nombre;
    EditText personas;
    EditText descripcion;
    EditText preparacion;
    EditText fav;
    Button add;

    Recipe recipe;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        id = (EditText)findViewById(R.id.id);
        nombre = (EditText)findViewById(R.id.nombre);
        personas = (EditText)findViewById(R.id.personas);
        descripcion = (EditText)findViewById(R.id.descripcion);
        preparacion = (EditText)findViewById(R.id.preparacion);
        fav = (EditText)findViewById(R.id.fav);
        add = (Button)findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipe = new Recipe(
                        id.getText().toString(),
                        nombre.getText().toString(),
                        Integer.valueOf(personas.getText().toString()),
                        descripcion.getText().toString(),
                        preparacion.getText().toString(),
                        "image.png",
                        Integer.valueOf(fav.getText().toString()));
                dataBase = new DataBase(getApplicationContext());
                dataBase.open();
                dataBase.insertRecipe(recipe);
                Toast.makeText(getApplicationContext(), "Se agrego la receta", Toast.LENGTH_LONG).show();
                //cerramos esta vista y regresamos a la lista de recetas
                finish();
            }
        });
    }
}
