package com.recipeapp.ceva.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.recipeapp.ceva.R;
import com.recipeapp.ceva.domain.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>
{
    private Context context;
    public List<Recipe> recetas;

    // recibimos lo que nos llega al Adapter
    public RecipeAdapter(Context context, List<Recipe> recetas)
    {
        this.context = context;
        this.recetas = recetas;
    }

    /**
     * Paso 1. Definir un layout que sera una vista de nuestros objetos de dominio. El layout lo definimos en la carpeta res -> layout
     * Paso 2. Definimos la vista es decir un ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;
        private ImageView imageView;
        private TextView nombre, personas, descripcion, preparacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardview);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            personas = (TextView)itemView.findViewById(R.id.personas);
            descripcion = (TextView)itemView.findViewById(R.id.descripcion);
            preparacion = (TextView)itemView.findViewById(R.id.preparacion);
        }
    }

    /**
     * Empezamos a crear la Vista
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipeitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nombre.setText(recetas.get(i).getNombre());
        viewHolder.personas.setText("#Personas: " + String.valueOf(recetas.get(i).getPersonas()));
        viewHolder.descripcion.setText(recetas.get(i).getDescripcion());
        viewHolder.preparacion.setText(recetas.get(i).getPreparacion());
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }
}
