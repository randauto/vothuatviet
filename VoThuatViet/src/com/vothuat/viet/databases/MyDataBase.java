package com.vothuat.viet.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.vothuat.viet.data.MContent;

public class MyDataBase extends SQLiteAssetHelper {
	private static final String DATABASE_NAME = "vothuatviet";
	private static final int DATABASE_VERSION = 1;

	/** Chapter table. */
	public static final String CHAPTER_TABLE = "tblChapter";
	public static final String CHAPTER_ID = "id";
	public static final String CHAPTER_CONTENT = "content";

	/** Content table. */
	public static final String CONTENT_TABLE = "tblContent";
	public static final String CONTENT_ID = "id";
	public static final String CONTENT_PARENT_ID = "parentid";
	public static final String CONTENT_TITLE = "title";
	public static final String CONTENT_URL_IMAGE = "image";
	public static final String CONTENT_SUMMARY = "summary";
	public static final String CONTENT_FILE_NAME = "filename";

	private SQLiteDatabase db;

	private final String[] comlumnsContent = { CONTENT_ID, CONTENT_PARENT_ID,
			CONTENT_TITLE, CONTENT_URL_IMAGE, CONTENT_SUMMARY,
			CONTENT_FILE_NAME };

	public MyDataBase(Context paramContext) {
		super(paramContext, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * Method used to get all chapter.
	 * 
	 * @return
	 */
	public Cursor getAllChapterFromDb() {
		SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
		SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
		String[] arrayOfString = { CHAPTER_ID, CHAPTER_CONTENT };
		localSQLiteQueryBuilder.setTables(CHAPTER_TABLE);
		Cursor localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase,
				arrayOfString, null, null, null, null, null);
		localCursor.moveToFirst();
		return localCursor;
	}

	/**
	 * Method used to get all chapter.
	 * 
	 * @return
	 */
	public Cursor getAllContentFromDb() {
		SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
		SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
		localSQLiteQueryBuilder.setTables(CONTENT_TABLE);
		Cursor localCursor = localSQLiteQueryBuilder.query(localSQLiteDatabase,
				comlumnsContent, null, null, null, null, null);
		localCursor.moveToFirst();
		return localCursor;
	}

	public void close() {
		if (db != null) {
			db.close();
		}
	}

	public void openWrite() {
		if (db == null) {
			db = getWritableDatabase();
		}
	}

	/**
	 * Insert new content to database.
	 * 
	 * @param content
	 * @return
	 */
	public long insertContentToDb(MContent content) {
		ContentValues values = new ContentValues();
		values.put(CONTENT_PARENT_ID, content.getParentid());
		values.put(CONTENT_TITLE, content.getTitle());
		values.put(CONTENT_URL_IMAGE, content.getImage());
		values.put(CONTENT_SUMMARY, content.getSummary());
		values.put(CONTENT_FILE_NAME, content.getFileName());
		long rowId = db.insert(CONTENT_TABLE, null, values);
		return rowId;
	}
}
