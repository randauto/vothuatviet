package com.vothuat.viet.databases;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;

import com.vothuat.viet.data.MChapter;
import com.vothuat.viet.data.MContent;

public class DatabaseFactory {
	public static MyDataBase db;

	public static ArrayList<MContent> contents;
	public static ArrayList<MChapter> chapters;
	static {
		chapters = null;
		contents = null;
	}

	/**
	 * Method used to get all content.
	 * 
	 * @param context
	 * @return
	 */
	public static ArrayList<MContent> getAllContent(Context context) {
		contents = null;
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllContentFromDb();
		if (localCursor != null) {
			contents = new ArrayList<MContent>();
		}

		if (localCursor.moveToFirst()) {
			do {
				MContent mContent = new MContent(localCursor.getInt(localCursor
						.getColumnIndex(MyDataBase.CONTENT_ID)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CONTENT_TITLE)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CONTENT_URL_IMAGE)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CONTENT_SUMMARY)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CONTENT_FILE_NAME)));
				contents.add(mContent);
			} while (localCursor.moveToNext());
		}
		localCursor.close();
		db.close();

		return contents;
	}

	/**
	 * Method used to get all chapter.
	 * 
	 * @param context
	 * @return
	 */
	public static ArrayList<MChapter> getAllChapter(Context context) {
		chapters = null;
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllChapterFromDb();
		if (localCursor != null) {
			chapters = new ArrayList<MChapter>();
		}

		if (localCursor.moveToFirst()) {
			do {
				MChapter mChapter = new MChapter(localCursor.getInt(localCursor
						.getColumnIndex(MyDataBase.CHAPTER_ID)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CHAPTER_CONTENT)));
				chapters.add(mChapter);
			} while (localCursor.moveToNext());
		}
		localCursor.close();
		db.close();
		return chapters;
	}

}
