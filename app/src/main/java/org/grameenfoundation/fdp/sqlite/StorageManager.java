package org.grameenfoundation.fdp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import org.grameenfoundation.fdp.ApplicationRegistry;
import org.grameenfoundation.fdp.sqlite.Search.Search;

/**
 * Created by julian_Gf on 5/20/2016.
 * A Facade that handles data storage operations like storage, retrieval etc.
 * It abstracts the underlying data store from the callers and provides methods that
 * can be called to perform necessary operations.
 */

public class StorageManager {
    private FDPBD databaseHelper;
    private SQLiteDatabase database;
    private final Context context;
    private SQLiteSearchProcessor sqLiteSearchProcessor;
    private static final StorageManager instance = new StorageManager();

    private StorageManager() {
        this.context = ApplicationRegistry.getApplicationContext();
        this.databaseHelper = new FDPBD(this.context);
        this.database = databaseHelper.getWritableDatabase();

        this.sqLiteSearchProcessor = new SQLiteSearchProcessor(this.database);
    }

    //gets the singleton instance of the storage manager
    public static StorageManager getInstance() {
        return instance;
    }

    //closes the datastore
    public void close() {
        if (this.database.inTransaction()) {
            database.setTransactionSuccessful();
            database.endTransaction();
        }
        databaseHelper.close();
    }

    //checks whether the data store is open.

    public boolean isOpen() {
        return database.isOpen();
    }

    //searches the datastore with the given sql query
    public Cursor sqlSearch(String query) {
        return database.rawQuery(query, null);
    }

    //deletes all the records in the given table
    public int deleteAll(String table) {
        return database.delete(table, null, null);
    }

    public void execSql(String sql) {
        database.execSQL(sql);
    }

    //inserts the given content values into the given table

    public boolean insert(String table, ContentValues contentValues) {
        return database.insert(table, null, contentValues) > 0;
    }

    //inserts the given list of content values into the data store within a transaction.
    public boolean insert(String table, ContentValues... contentValueList) {
        try {
            database.beginTransaction();
            for (ContentValues contentValues : contentValueList) {
                database.insert(table, null, contentValues);
            }
            database.setTransactionSuccessful();
            database.endTransaction();
            return true;
        } finally {
            database.endTransaction();
        }
    }

    //replaces the given content values in the given table
    public boolean replace(String table, ContentValues contentValues) {
        return database.replace(table, null, contentValues) > 0;
    }

    //replaces the given list of content values into the data store within a transaction.
    public boolean replace(String table, ContentValues... contentValueList) {
        try {
            database.beginTransaction();

            for (ContentValues contentValues : contentValueList) {
                database.replace(table, null, contentValues);
            }

            database.setTransactionSuccessful();
            return true;
        } finally {
            database.endTransaction();
        }
    }

    //updates the given content values in the given table
    public boolean update(String table, ContentValues contentValues) {
        return database.replace(table, null, contentValues) > 0;
    }

    //updates the given list of content values into the data store within a transaction.
    public boolean update(String table, ContentValues... contentValueList) {
        try {
            database.beginTransaction();
            for (ContentValues contentValues : contentValueList) {
                database.replace(table, null, contentValues);
            }
            database.setTransactionSuccessful();
            return true;
        } finally {
            database.endTransaction();
        }
    }

    //gets the total number of records in the given table
    public int recordCount(String tableName) {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) as total FROM " + tableName, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count;
    }

    //gets all the records in a particular table.

    public Cursor getAllRecords(String tableName) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ");
        queryBuilder.append(tableName);
        return sqlSearch(queryBuilder.toString());
    }

    //gets a Cursor for the records in the given search.
    public Cursor getRecords(Search search) {
        String query = this.sqLiteSearchProcessor.generateQuery(search);
        return database.rawQuery(query, null);
    }

    //gets the record count for the results that are returned in the given search.

    public int recordCount(Search search) {
        String query = this.sqLiteSearchProcessor.generateRowCountQuery(search);
        Cursor cursor = database.rawQuery(query, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count;
    }
}
