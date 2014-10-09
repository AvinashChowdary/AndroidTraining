package com.pcs.provider;

import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class ContactProvider extends ContentProvider {

	public static final String ID = "_id";
	public static final String NAME = "_name";
	public static final String EMAIL = "_email";
	public static final String NUMBER = "_phone";
	public static final String HOME = "_home";

	private static HashMap<String, String> values;

	static final String PROVIDER_NAME = "com.pcs.provider.ContactProvider";
	static final String URL = "content://" + PROVIDER_NAME + "/contact";
	public static final Uri CONTENT_URI = Uri.parse(URL);

	private SQLiteDatabase db;
	static final String DATABASE_NAME = "contacts.db";
	static final String CONTACTS_TABLE_NAME = "contact";

	static final int DATABASE_VERSION = 2;
	static final String CREATE_DB_TABLE = " CREATE TABLE "
			+ CONTACTS_TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ NAME + " TEXT NOT NULL, " + EMAIL + " TEXT NOT NULL," + NUMBER
			+ " NUMBER NOT NULL," + HOME + " TEXT NOT NULL);";

	static final int CONTACT = 1;

	static final UriMatcher uriMatcher;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "contact", CONTACT);
		uriMatcher.addURI(PROVIDER_NAME, "contact/*", CONTACT);

	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_DB_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + CONTACTS_TABLE_NAME);
			onCreate(db);
		}
	}

	@Override
	public boolean onCreate() {

		Context context = getContext();
		DatabaseHelper dbHelper = new DatabaseHelper(context);

		db = dbHelper.getWritableDatabase();
		return (db == null) ? false : true;

	}

	@Override
	public String getType(Uri uri) {

		switch (uriMatcher.match(uri)) {

		case CONTACT:
			return "vnd.android.cursor.dir/contacts";

		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}

	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long rowID = db.insert(CONTACTS_TABLE_NAME, "", values);

		if (rowID > 0) {
			Uri mUri = ContentUris.withAppendedId(CONTENT_URI, rowID);
			getContext().getContentResolver().notifyChange(mUri, null);
			return mUri;
		}
		throw new SQLException("Failed to add a record into " + uri);

	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		int count = 0;

		switch (uriMatcher.match(uri)) {
		case CONTACT:
			count = db.delete(CONTACTS_TABLE_NAME, selection, selectionArgs);
			break;

		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);
		return count;

	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(CONTACTS_TABLE_NAME);

		switch (uriMatcher.match(uri)) {
		case CONTACT:
			qb.setProjectionMap(values);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		if (sortOrder == null || sortOrder == "") {
			sortOrder = NAME;
		}
		Cursor cursor = qb.query(db, projection, selection, selectionArgs,
				null, null, sortOrder);
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count = 0;
		switch (uriMatcher.match(uri)) {
		case CONTACT:
			count = db.update(CONTACTS_TABLE_NAME, values, selection,
					selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

}
