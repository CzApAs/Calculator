package com.example.calculator;

import android.provider.BaseColumns;

public final class HistoryDatabaseContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private HistoryDatabaseContract() {}

    /* Inner class that defines the table contents */
    public static class HistoryDatabase implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_STRING = "storedString";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + HistoryDatabase.TABLE_NAME + " (" +
                        HistoryDatabase._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                        HistoryDatabase.COLUMN_NAME_STRING + " TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + HistoryDatabase.TABLE_NAME;
    }
}