package org.grameenfoundation.fdp.sqlite;

/**
 * Created by julian on 12/05/2016.
 * Clase que administra la conexión de la base de datos y su estructuración
 * Class responsible for initializing and upgrading the database
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

        // Create Country Table
        database.execSQL(getCountryTableInitializationSql());

        // Create Farmer Table
        database.execSQL(getFarmerTableInitializationSql());

        // Create FarmerBL Table
        database.execSQL(getFarmerBLInitializationSql());

        // Create Farm Table
        database.execSQL(getFarmTableInitializationSql());

        // Create FarmBL Table
        database.execSQL(getFarmBLTableInitializationSql());

        // Create Plot Table
        database.execSQL(getPlotTableInitializationSql());

        // Create FDP Practices Table
        database.execSQL(getFDPPracticesTableInitializationSql());

        // Create Cost Components Table
        database.execSQL(getCostComponentTableInitializationSql());

        // Create FDP Diagnostic Table
        database.execSQL(getFDPDiagnosticTableInitializationSql());

        // Create FDP Follow Up Table
        database.execSQL(getFDPFollowUpTableInitializationSql());

        // Create PL Table
        database.execSQL(getPLTableInitializationSql());
    }

    // Creation Country Table
    private String getCountryTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand
                .append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.COUNTRY);
        sqlCommand.append(" (" + FDPMetadata.COUNTRY_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.COUNTRY_NAME  + " TEXT NOT NULL);");
        return sqlCommand.toString();
    }

    // Creation Farmer Table
    private String getFarmerTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.FARMER);
        sqlCommand.append(" (" + FDPMetadata.FARMER_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.FARMER_BDAY + " DATE NOT NULL,"
                + FDPMetadata.FARMER_NATIONAL_ID + " TEXT NOT NULL,"
                + FDPMetadata.FARMER_REGION + " TEXT,"
                + FDPMetadata.FARMER_MUNICIPALITY + " TEXT,"
                + FDPMetadata.FARMER_COUNTRY_ID  + " CHAR(16),");
        sqlCommand.append(" FOREIGN KEY(country_id) REFERENCES "
                + FDPMetadata.COUNTRY
                + "(country_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation Farmer BL Table
    private String getFarmerBLInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.FARMERBL);
        sqlCommand.append(" (" + FDPMetadata.FARMER_PARENT_ID + " CHAR(16), "
                + FDPMetadata.HOUSEHOLD_INCOME + " INTEGER NOT NULL,"
                + FDPMetadata.INCOME_SOURCE + " TEXT,"
                + FDPMetadata.PERCENT_INCOME_CACAO + " INTEGER NOT NULL,");
        sqlCommand.append(" FOREIGN KEY(farmer_parent_id) REFERENCES "
                + FDPMetadata.FARMER
                + "(farmer_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation Farm Table
    private String getFarmTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.FARM);
        sqlCommand.append(" (" + FDPMetadata.FARM_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.FARMER_OWNER_ID + " CHAR(16) NOT NULL,"
                + FDPMetadata.FARM_REGION + " TEXT,"
                + FDPMetadata.FARM_MUNICIPALITY + " TEXT,"
                + FDPMetadata.FARM_COUNTRY_ID + " CHAR(16),"
                + FDPMetadata.TOTAL_FARM_AREA + " INTEGER NOT NULL,"
                + FDPMetadata.FARM_AREA_UNITS + " TEXT NOT NULL, ");
        sqlCommand.append(" FOREIGN KEY(farmer_owner_id) REFERENCES "
                + FDPMetadata.FARMER
                + "(farmer_id) ON DELETE CASCADE, ");
        sqlCommand.append(" FOREIGN KEY(farm_country_id) REFERENCES "
                + FDPMetadata.COUNTRY
                + "(country_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation FarmBL Table
    private String getFarmBLTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.FARMBL);
        sqlCommand.append(" (" + FDPMetadata.FARM_OWNER_ID + " CHAR(16) NOT NULL, "
                + FDPMetadata.WATER_SOURCE + " TEXT,"
                + FDPMetadata.DISPONSAL_SYSTEM + " TEXT,"
                + FDPMetadata.FARM_MAP + " TEXT, "
                + FDPMetadata.BL_DATE + " DATE NOT NULL,");
        sqlCommand.append(" FOREIGN KEY(farm_owner_id) REFERENCES "
                + FDPMetadata.FARM
                + "(farm_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation Plot Table
    private String getPlotTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.PLOT);
        sqlCommand.append(" (" + FDPMetadata.PLOT_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.FARM_PARENT_ID + " CHAR(16) NOT NULL,"
                + FDPMetadata.TOTAL_PLOT_AREA + " INTEGER NOT NULL,"
                + FDPMetadata.PLOT_AREA_UNITS + " TEXT, "
                + FDPMetadata.NUMBER_OF_TREES + " INTEGER NOT NULL,");
        sqlCommand.append(" FOREIGN KEY(farm_parent_id) REFERENCES "
                + FDPMetadata.FARM
                + "(farm_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation FDP Practices Table
    private String getFDPPracticesTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.FDP_PRACTICES);
        sqlCommand.append(" (" + FDPMetadata.FDP_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.FDP_COUNTRY_ID  + " CHAR(16), "
                + FDPMetadata.PRACTICE_NAME + " TEXT NOT NULL");
        sqlCommand.append(" FOREIGN KEY(fdp_country_id) REFERENCES "
                + FDPMetadata.COUNTRY
                + "(country_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation FDP Practices Table
    private String getCostComponentTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.COST_COMPONENT);
        sqlCommand.append(" (" + FDPMetadata.COST_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.CC_COUNTRY_ID + " CHAR(16) NOT NULL,"
                + FDPMetadata.FDP_PARENT_ID + " CHAR(16) NOT NULL,"
                + FDPMetadata.COMPONENT_NAME + " TEXT NOT NULL,"
                + FDPMetadata.COMPONENT_COST + " INTEGER NOT NULL,"
                + FDPMetadata.YEAR_IMPLEMENT + " TEXT NOT NULL, ");
        sqlCommand.append(" FOREIGN KEY(fdp_practice_id) REFERENCES "
                + FDPMetadata.FDP_PRACTICES
                + "(fdp_id) ON DELETE CASCADE, ");
        sqlCommand.append(" FOREIGN KEY(cc_country_id) REFERENCES "
                + FDPMetadata.COUNTRY
                + "(country_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation FDP Diagnostic Table
    private String getFDPDiagnosticTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.FDP_DIAGNOSTIC);
        sqlCommand.append(" (" + FDPMetadata.FDPD_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.FDP_PLOT_ID + " CHAR(16) NOT NULL,"
                + FDPMetadata.FDP_PRACTICE_ID + " CHAR(16) NOT NULL,"
                + FDPMetadata.DIAGNOSTIC + " TEXT NOT NULL,"
                + FDPMetadata.FDP_DIAGNOSTIC_DATE + " DATE NOT NULL,");
        sqlCommand.append(" FOREIGN KEY(fdp_practice_id) REFERENCES "
                + FDPMetadata.FDP_PRACTICES
                + "(fdp_id) ON DELETE CASCADE, ");
        sqlCommand.append(" FOREIGN KEY(fdp_plot_id) REFERENCES "
                + FDPMetadata.PLOT
                + "(plot_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation FDP Follow Up Table
    private String getFDPFollowUpTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.FDP_FOLLOW_UP);
        sqlCommand.append(" (" + FDPMetadata.FDPF_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.FDPD_PARENT_ID + " CHAR(16), "
                + FDPMetadata.PRACTICE_DIAGNOSIS + " TEXT NOT NULL,"
                + FDPMetadata.FU_DATE + " DATE NOT NULL,");
        sqlCommand.append(" FOREIGN KEY(fdpd_parent_id) REFERENCES "
                + FDPMetadata.FDP_DIAGNOSTIC
                + "(fdpd_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    // Creation PL Table
    private String getPLTableInitializationSql() {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append("CREATE TABLE IF NOT EXISTS " + FDPMetadata.PL);
        sqlCommand.append(" (" + FDPMetadata.PL_ID + " CHAR(16) PRIMARY KEY, "
                + FDPMetadata.COST_COMPONENT_ID + " CHAR(16), "
                + FDPMetadata.FDP_DIAGNOSTIC_ID + " CHAR(16),"
                + FDPMetadata.PL_YEAR_IMPLEMENT + " TEXT NOT NULL,");
        sqlCommand.append(" FOREIGN KEY(cost_component_id) REFERENCES "
                + FDPMetadata.COST_COMPONENT
                + "(cost_id) ON DELETE CASCADE, ");
        sqlCommand.append(" FOREIGN KEY(fdp_diagnostic_id) REFERENCES "
                + FDPMetadata.FDP_DIAGNOSTIC
                + "(fdpd_id) ON DELETE CASCADE, ");
        sqlCommand.append(" );");
        return sqlCommand.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {
        Log.w("DatabaseHelper", "***Upgrading database from version*** "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");

        createDatabaseTables(database);
    }
}
