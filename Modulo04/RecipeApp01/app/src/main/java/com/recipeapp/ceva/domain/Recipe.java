package com.recipeapp.ceva.domain;

import android.content.ContentValues;

import com.recipeapp.ceva.SQLConstants;

public class Recipe
{
    private String id;
    private String nombre;
    private int personas;
    private String descripcion;
    private String preparacion;
    private String image;
    private int favorito; // 1 == favorito / 0 == not favorito

    public Recipe(){}

    public Recipe(String id, String nombre, int personas, String descripcion, String preparacion, String image, int favorito) {
        this.id = id;
        this.nombre = nombre;
        this.personas = personas;
        this.descripcion = descripcion;
        this.preparacion = preparacion;
        this.image = image;
        this.favorito = favorito;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    //Construimos el contenedor de valores
    public ContentValues toValues()
    {
        ContentValues contentValues = new ContentValues(7); //colocamos el numero de atributos de la clase
        contentValues.put(SQLConstants.COLUMN_ID, getId());
        contentValues.put(SQLConstants.COLUMN_NOMBRE, getNombre());
        contentValues.put(SQLConstants.COLUMN_PERSONAS, getPersonas());
        contentValues.put(SQLConstants.COLUMN_DESCRIPCION, getDescripcion());
        contentValues.put(SQLConstants.COLUMN_PREPARACION, getPreparacion());
        contentValues.put(SQLConstants.COLUMN_IMAGE, getImage());
        contentValues.put(SQLConstants.COLUMN_FAV, getFavorito());

        return contentValues;
    }
}
