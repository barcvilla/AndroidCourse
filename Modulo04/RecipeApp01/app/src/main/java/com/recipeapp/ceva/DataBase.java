package com.recipeapp.ceva;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recipeapp.ceva.domain.Recipe;
import com.recipeapp.ceva.helpers.DBHelper;

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
}
