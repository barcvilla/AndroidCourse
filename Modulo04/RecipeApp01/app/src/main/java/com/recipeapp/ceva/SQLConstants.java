package com.recipeapp.ceva;

/**
 * Definimos las variables utilizable en el trabajo con BD
 */
public class SQLConstants
{
    //DB
    public static final String DB = "dbrecetas.db";

    //Tables
    public static final String TABLE_RECETAS = "recetas";

    //Colums
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_PERSONAS = "personas";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_PREPARACION = "preparacion";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_FAV = "fav";

    //Queries
    public static final String SQL_CREATE_TABLE_RECETAS =
            "CREATE TABLE " + TABLE_RECETAS +
            "(" +
                COLUMN_ID + " TEXT PRIMARY KEY," +
                COLUMN_NOMBRE + " TEXT," +
                COLUMN_PERSONAS + " INT," +
                COLUMN_DESCRIPCION + " TEXT," +
                COLUMN_PREPARACION + " TEXT," +
                COLUMN_IMAGE + " TEXT," +
                COLUMN_FAV + " INT" +
            ");";

    public static final String WHERE_CLAUSE_NOMBRE = "nombre=?";
    public static final String WHERE_CLAUSE_FAV = "fav=?";
    public static final String WHERE_CLAUSE_PERSONAS = "personas=?";

    public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_RECETAS;

    public  static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_NOMBRE, COLUMN_PERSONAS, COLUMN_DESCRIPCION, COLUMN_PREPARACION, COLUMN_IMAGE, COLUMN_FAV};
}
