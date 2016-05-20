package org.grameenfoundation.fdp.sqlite;

/**
 * Created by julian on 12/05/2016.
 * Clase que administra la conexión de la base de datos y su estructuración
 * Class responsible for initializing and upgrading the database
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;
import android.util.Log;


public class FDPBD extends SQLiteOpenHelper{

    public FDPBD (Context context) {
        super(context, FDPMetadata.DATABASE_NAME, null, FDPMetadata.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        createDatabaseTables(database);
    }

    private void createDatabaseTables(SQLiteDatabase database) {
        // Create Farmer Table
        database.execSQL(getFarmerTableInitializationSql());

        // Create Country Table
        database.execSQL(getCountryTableInitializationSql());

        // Create FarmerBL Table
        database.execSQL(getFarmerBLInitializationSql());

        // Create Farm Table
        database.execSQL(getFarmTableInitializationSql());

        // Create FarmBL Table
        database.execSQL(getFarmBLTableInitializationSql());
        // Create FarmBL Table
        database.execSQL(getFarmBLTableInitializationSql());
    }






    interface Referencias {

        String ID_FARMER = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.FARMER, Farmer.ID);

        String ID_COUNTRY = String.format("REFERENCES %s(%s)",
                Tablas.COUNTRY, Country.ID);

        String ID_FARM = String.format("REFERENCES %s(%s)",
                Tablas.FARM, Farm.ID);

        String ID_PLOT = String.format("REFERENCES %s(%s)",
                Tablas.PLOT, Plot.ID);

        String ID_FDPPRACTICESN  = String.format("REFERENCES %s(%s)",
                Tablas.FDPPRACTICESN , FDPPractices.ID);

        String ID_COSTCOMPONENTS = String.format("REFERENCES %s(%s)",
                Tablas.COSTCOMPONENTS, CostComponents.ID);

        String ID_FDPDIAGNOSTIC = String.format("REFERENCES %s(%s)",
                Tablas.FDPDIAGNOSTIC, FDPDiagnostic.ID);
    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY NOT NULL," +
                        " %s DATE NOT NULL,"+"%s TEXT UNIQUE NOT NULL,"+"%s TEXT,"+"%s TEXT," +"%s TEXT NOT NULL"+
                        "%s TEXT NOT NULL %s)",
                Tablas.FARMER, BaseColumns._ID,
                Farmer.BDAY, Farmer.BDAY,
                Farmer.NATIONALID, Farmer.NATIONALID,
                Farmer.REGION, Farmer.REGION,
                Farmer.MUNICIPALITY, Farmer.MUNICIPALITY,
                Farmer.COUNTRYID, Referencias.ID_COUNTRY,
                Farmer.CONTACTID, Referencias.ID_FARMER));

        db.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY NOT NULL," +
                        "%s TEXT NOT NULL %s)",
                Tablas.COUNTRY, BaseColumns._ID,
                Country.NOMBRE, Country.NOMBRE));


        db.execSQL(String.format("CREATE TABLE %s ( %s TEXT PRIMARY KEY NOT NULL," +
                        "%s INTEGER NOT NULL CHECK(%s>=0),"+"%s TEXT NOT NULL,"+"%s INTEGER NOT NULL CHECK(%s>=0)," +
                        "%s TEXT NOT NULL )",
                Tablas.FARMERBL, BaseColumns._ID,
                FarmerBL.HOUSEHOLDINCOME, FarmerBL.HOUSEHOLDINCOME,
                FarmerBL.INCOMESOURCE, FarmerBL.INCOMESOURCE,
                FarmerBL.PERCENTINCOMECACAO, FarmerBL.PERCENTINCOMECACAO,
                FarmerBL.FARMERID, Referencias.ID_FARMER));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.FARMER);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.COUNTRY);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.FARMERBL);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.FARM);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PLOT);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.FDPPRACTICESN );
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.COSTCOMPONENTS);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.FDPDIAGNOSTIC);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.FDPFOLLOWUP);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PL);

        onCreate(db);
    }
}
