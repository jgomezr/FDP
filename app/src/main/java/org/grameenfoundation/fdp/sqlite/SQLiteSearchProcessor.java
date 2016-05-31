package org.grameenfoundation.fdp.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import org.grameenfoundation.fdp.sqlite.Search.ColumnMetadata;
import org.grameenfoundation.fdp.sqlite.Search.MetadataProvider;
import org.grameenfoundation.fdp.sqlite.Search.StandardSqlSearchProcessor;
import org.grameenfoundation.fdp.sqlite.Search.TableMetadata;

/**
 * Created by julian_Gf on 5/20/2016.
 * Search Processor that generates sql queries for the SQLite Database Engine
 */
public class SQLiteSearchProcessor extends StandardSqlSearchProcessor {
    private SQLiteDatabase sqLiteDatabase;

    public SQLiteSearchProcessor(SQLiteDatabase database) {
        this.sqLiteDatabase = database;
        this.setMetadataProvider(new SQLiteMetadataProvider());
    }

    private class SQLiteMetadataProvider implements MetadataProvider {
        @Override
        public TableMetadata getTableMetadata(String tableName) {
            Cursor cursor = sqLiteDatabase.rawQuery("PRAGMA table_info(" + tableName + ");", null);
            try {
                TableMetadata tableMetadata = new TableMetadata();
                tableMetadata.setTableName(tableName);
                while (cursor.moveToNext()) {
                    ColumnMetadata columnMetadata = new ColumnMetadata();
                    columnMetadata.setColumnName(cursor.getString(cursor.getColumnIndex("name")));
                    columnMetadata.setType(resolveJavaType(cursor.getString(cursor.getColumnIndex("type"))));
                    columnMetadata.setNullable(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("notnull"))));
                    tableMetadata.addColumnMetadata(columnMetadata);
                }
                return tableMetadata;
            } finally {
                cursor.close();
            }
        }

        private Class resolveJavaType(String type) {
            if (type.equalsIgnoreCase("TEXT")
                    || type.startsWith("CHAR")) {
                return String.class;
            } else if (type.equalsIgnoreCase("INTEGER")) {
                return Integer.class;
            } else if (type.equalsIgnoreCase("BLOB")) {
                return new byte[]{}.getClass();
            }
            return null;
        }

        @Override
        public ColumnMetadata getColumnMetadata(String tableName, String columnName) {
            TableMetadata tableMetadata = getTableMetadata(tableName);
            return tableMetadata.getColumnMetadata(columnName);
        }

        @Override
        public Class<?> getJavaClass(String tableName, String column) {
            ColumnMetadata columnMetadata = getColumnMetadata(tableName, column);
            if (columnMetadata != null) {
                return columnMetadata.getType();
            }

            return null;
        }
    }
}
