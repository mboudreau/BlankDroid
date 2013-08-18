package com.michelboudreau.sample.providers.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class SleepHelper extends SQLiteOpenHelper  {
	// If you change the database schema, you must increment the database version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "sleep.db";

	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
			"CREATE TABLE " + SleepEntry.TABLE_NAME + " (" +
					SleepEntry._ID + " INTEGER PRIMARY KEY," +
					SleepEntry.START_TIME + INTEGER_TYPE + COMMA_SEP +
					SleepEntry.END_TIME + INTEGER_TYPE +
					" )";
	private static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + SleepEntry.TABLE_NAME;

	/* Inner class that defines the table contents */
	public static abstract class SleepEntry implements BaseColumns {
		public static final String TABLE_NAME = "sleep";
		public static final String START_TIME = "starttime";
		public static final String END_TIME = "endtime";
	}

	public SleepHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// This database is only a cache for online data, so its upgrade policy is
		// to simply to discard the data and start over
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onUpgrade(db, oldVersion, newVersion);
	}
}