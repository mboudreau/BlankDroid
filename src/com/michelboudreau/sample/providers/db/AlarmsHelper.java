package com.michelboudreau.sample.providers.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class AlarmsHelper extends SQLiteOpenHelper  {
	// If you change the database schema, you must increment the database version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "alarms.db";

	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
			"CREATE TABLE " + AlarmEntry.TABLE_NAME + " (" +
					AlarmEntry._ID + " INTEGER PRIMARY KEY," +
					AlarmEntry.LABEL + TEXT_TYPE + COMMA_SEP +
					AlarmEntry.TIME + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.ENABLED + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT_MON + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT_TUE + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT_WED + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT_THU + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT_FRI + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT_SAT + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.REPEAT_SUN + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.VIBRATE + INTEGER_TYPE + COMMA_SEP +
					AlarmEntry.RINGTONE + TEXT_TYPE +
					" )";
	private static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + AlarmEntry.TABLE_NAME;

	/* Inner class that defines the table contents */
	public static abstract class AlarmEntry implements BaseColumns {
		public static final String TABLE_NAME = "alarms";
		public static final String LABEL = "label";
		public static final String TIME = "time";
		public static final String ENABLED = "enabled";
		public static final String REPEAT = "repeat";
		public static final String REPEAT_MON = "repeat_mon";
		public static final String REPEAT_TUE = "repeat_tue";
		public static final String REPEAT_WED = "repeat_wed";
		public static final String REPEAT_THU = "repeat_thu";
		public static final String REPEAT_FRI = "repeat_fri";
		public static final String REPEAT_SAT = "repeat_sat";
		public static final String REPEAT_SUN = "repeat_sun";
		public static final String VIBRATE = "vibrate";
		public static final String RINGTONE = "ringtone";
	}

	public AlarmsHelper(Context context) {
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