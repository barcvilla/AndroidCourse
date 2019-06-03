package com.recipeapp.ceva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recipeapp.ceva.domain.Recipe;
import com.recipeapp.ceva.helpers.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Todos los datos que va a manejar nuestra App seran manejados desde este clase.
 */
public class DataBase
{
    // definimos los las 3 clases que nos permiten manipular los datos
    Context context; //nos permite rastrear el contexto de la activity
    SQLiteDatabase sqLiteDatabase; //nos permite manipular la BD
    SQLiteOpenHelper sqLiteOpenHelper; //nos permite acceder a los elementos de la BD

    public DataBase(Context context)
    {
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase(); // indicamos abrir la BD en modo escritura
    }

    public long getItemsCounts()
    {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstants.TABLE_RECETAS);
    }

    public void open()
    {
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close()
    {
        sqLiteOpenHelper.close();
    }

    public void insertRecipe(Recipe recipe)
    {
        try
        {
            ContentValues contentValues = recipe.toValues();
            sqLiteDatabase.insert(SQLConstants.TABLE_RECETAS, null, contentValues);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void insertBulkRecipes(List<Recipe> recipes)
    {
        long size = getItemsCounts();
        if(size == 0)
        {
            for(Recipe recipe : recipes)
            {
                insertRecipe(recipe);
            }
        }
    }

    public List<Recipe> getAllRecipe()
    {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Cursor cursor = sqLiteDatabase.query(SQLConstants.TABLE_RECETAS, SQLConstants.ALL_COLUMNS,
                null, null, null, null, null);
        while (cursor.moveToNext())
        {
            Recipe recipe = new Recipe();
            recipe.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            recipe.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            recipe.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            recipe.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            recipe.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            recipe.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            recipe.setFavorito(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recipes.add(recipe);
        }
        return  recipes;
    }

    /**
     * Traemos todas las recetas cuyo favorito = 1
     */
    public List<Recipe> getRecipeFavs()
    {
        List<Recipe> recipeFavs = new ArrayList<Recipe>();
        String[] whereArgs = new String[] {String.valueOf(1)};
        Cursor cursor = sqLiteDatabase.query(SQLConstants.TABLE_RECETAS, SQLConstants.ALL_COLUMNS,
                SQLConstants.WHERE_CLAUSE_FAV, whereArgs, null, null, null);

        while (cursor.moveToNext())
        {
            Recipe recipe = new Recipe();
            recipe.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            recipe.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            recipe.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            recipe.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            recipe.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            recipe.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            recipe.setFavorito(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recipeFavs.add(recipe);
        }
        return recipeFavs;

    }

    /**
     * Traemos todas las recetas cuyo # de personas = ?
     */
    public List<Recipe> getRecipeByPersonas(int personasQuantity)
    {
        List<Recipe> recipes = new ArrayList<Recipe>();
        String[] whereArgs = new String[] {String.valueOf(personasQuantity)};
        Cursor cursor = sqLiteDatabase.query(SQLConstants.TABLE_RECETAS, SQLConstants.ALL_COLUMNS,
                SQLConstants.WHERE_CLAUSE_PERSONAS, whereArgs, null, null, null);

        while (cursor.moveToNext())
        {
            Recipe recipe = new Recipe();
            recipe.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            recipe.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            recipe.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            recipe.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            recipe.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            recipe.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            recipe.setFavorito(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recipes.add(recipe);
        }
        return recipes;

    }


    public void deleteRecipe(String nombre)
    {
        String[] whereArgs = new String[]{String.valueOf(nombre)};
        sqLiteDatabase.delete(SQLConstants.TABLE_RECETAS, SQLConstants.WHERE_CLAUSE_NOMBRE, whereArgs);
    }
}
