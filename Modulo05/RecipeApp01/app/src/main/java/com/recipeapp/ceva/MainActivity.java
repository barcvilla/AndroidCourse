package com.recipeapp.ceva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.recipeapp.ceva.adapters.RecipeAdapter;
import com.recipeapp.ceva.domain.Recipe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerRecetas;
    List<Recipe> recetas;

    RecipeAdapter recipeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDomainObjects();

        recyclerRecetas = (RecyclerView)findViewById(R.id.recyclerrecetas);

        /**
         * Configuracion del Componente RecyclerView:
         * 1. LinearLayoutManager: nos permite administrar el acomodo de los datos pudiendo ser horizontal, vertical, custom
         * 2. SetOrientation del LinearLayoutManager
         * 3. Asignamos al RecyclerView el LinearLayoutManager creado
         * 4. Definir la obtencion de la informacion metodo createDomainObjects()
         * 5. Asignar la lista de Recipe creados al RecyclerView. Esto lo hacemos mediante Adapters (ver clase RecipeAdapter.java)
         * 6. Definir el Adapter creado
         * 7. Le decimos al recycler view que tenemos un adapter listo
         */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerRecetas.setLayoutManager(linearLayoutManager);
        // paso 6
        recipeAdapter = new RecipeAdapter(MainActivity.this, recetas);
        // paso 7
        recyclerRecetas.setAdapter(recipeAdapter);
    }

    public void createDomainObjects()
    {
        recetas = new ArrayList<Recipe>();
        recetas.add(new Recipe(
                "1",
                "Pancho",
                1,
                "Preparacion de un Pancho",
                "Colocar el hotdog en agua caliente, colocar la mayonesa en el pan y poner el hotdog",
                "htt://imagen.png",
                0));
        recetas.add(new Recipe(
                "2",
                "Omelette de verduras",
                2,
                "Preparacion del Omelette de verduras",
                "Picar una cebolla, picar un pimiento, picar cebollines. En una sarten con aceite caliente " +
                        "colocar los ingredientes picados, adicionar 4 huevos y mezcar los ingredientes",
                "htt://imagen2.png",
                1));
        recetas.add(new Recipe(
                "3",
                "Papas fritas",
                4,
                "Preparacion de papas fritas",
                "Lavar y pelar 4 papas medianas. Cortar en rodajas las papas y cortar en forma larga. " +
                        "En una sarte con mucho aceite bien caliente colocar las papas. Una vez fritas poner sal a gusto",
                "htt://imagen3.png",
                1));
        recetas.add(new Recipe(
                "4",
                "Pan frito",
                2,
                "Preparacion de Pan frito",
                "Cortar en rodajas el pan, untar con mantequilla adicionar organo al pan y en una sarten " +
                        "con poco aceite caliente y freir el pan de ambos lados",
                "htt://imagen.png",
                0));
        recetas.add(new Recipe(
                "5",
                "Arroz",
                4,
                "Preparacion de Arroz",
                "Lavar el arroz con agua fria y dejar remojando. Picar un diente de ajo finamente. " +
                        "En una olla colocar un poco de aceite, adicionar el ajo picado. Para una taza de arroz " +
                        "colocar 2 tazas de agua. Esperar que el agua empiece a hervir y adicionar el arroz lavado. " +
                        "adicionar sal al gusto",
                "htt://imagen.png",
                0));
        recetas.add(new Recipe(
                "6",
                "Pasta",
                4,
                "Preparacion de pasta",
                "En una olla con abundante agua, colocar sal al gusto y un poco de aceite. " +
                        "Dejar hasta que hierva, adicionar un paquete de fideos y controlar el fuego",
                "htt://imagen.png",
                0));
        recetas.add(new Recipe(
                "7",
                "Salsa de tomates",
                4,
                "Preparacion de salsa de tomates",
                "Colocar en una olla con agua al fuego 5 tomates para salsa. Una vez hervido " +
                        "retirar los tomates y quitarle la piel y las semillas. " +
                        "Colocar los tomates en la licuadora",
                "htt://imagen.png",
                0));
    }
}
