package com.pcs.provider;

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
import android.text.TextUtils;

public class ContactProvider extends ContentProvider{

	public static final String ID="_id";
	public static final String NAME="_name";
	public static final String EMAIL="_email";
	public static final String NUMBER="_phone";
	public static final String HOME="_home";
	
	
	static final String PROVIDER_NAME = "com.pcs.provider.Contacts";
	   static final String URL = "content://" + PROVIDER_NAME + "/contacts";
	   public static final Uri CONTENT_URI = Uri.parse(URL);
	   
	   
	   private SQLiteDatabase db;
	   static final String DATABASE_NAME = "contacts";
	   static final String CONTACTS_TABLE_NAME = "contact";
	   static final int DATABASE_VERSION = 1;
	   static final String CREATE_DB_TABLE = 
	      " CREATE TABLE " + CONTACTS_TABLE_NAME +
	      " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
	      " name TEXT NOT NULL, " +
	      " phone TEXT NOT NULL);";
	   
	   
	   
	   static final int CONTACT = 1;
	   static final int CONTACTS = 2;

	   static final UriMatcher uriMatcher;
	   static{
	      uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	      uriMatcher.addURI(PROVIDER_NAME, "contact", CONTACT);
	      uriMatcher.addURI(PROVIDER_NAME, "contacts/#", CONTACTS);
	   }
	   
	   
	   
	   
	   private static class DatabaseHelper extends SQLiteOpenHelper {
	       DatabaseHelper(Context context){
	          super(context, DATABASE_NAME, null, DATABASE_VERSION);
	       }

	       @Override
	       public void onCreate(SQLiteDatabase db)
	       {
	          db.execSQL(CREATE_DB_TABLE);
	       }
	       
	       @Override
	       public void onUpgrade(SQLiteDatabase db, int oldVersion, 
	                             int newVersion) {
	          db.execSQL("DROP TABLE IF EXISTS " +  CONTACTS_TABLE_NAME);
	          onCreate(db);
	       }
	   }

	
	@Override
	public boolean onCreate() {
		
		Context context = getContext();
	      DatabaseHelper dbHelper = new DatabaseHelper(context);
	      
	      db = dbHelper.getWritableDatabase();
	      return (db == null)? false:true;
		
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		 SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	      qb.setTables(CONTACTS_TABLE_NAME);
	      
	      switch (uriMatcher.match(uri)) {
	     
	      case CONTACTS:
	         qb.appendWhere( ID + "=" + uri.getPathSegments().get(1));
	         break;
	      default:
	         throw new IllegalArgumentException("Unknown URI " + uri);
	      }
	      if (sortOrder == null || sortOrder == ""){
	         
	         sortOrder = NAME;
	      }
	      Cursor cursor = qb.query(db,	projection,	selection, selectionArgs, 
	                          null, null, sortOrder);
	     
	      cursor.setNotificationUri(getContext().getContentResolver(), uri);

	      return cursor;
		
		
	}

	@Override
	public String getType(Uri uri) {
		
		switch (uriMatcher.match(uri)){
	     
	      case CONTACT:
	         return "vnd.android.cursor.dir/vnd.pcs.contacts";
	      
	      case CONTACTS:
	         return "vnd.android.cursor.item/vnd.pcs.contacts";
	      default:
	         throw new IllegalArgumentException("Unsupported URI: " + uri);
	      }
		
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long rowID = db.insert(	CONTACTS_TABLE_NAME, "", values);
	    
	      if (rowID > 0)
	      {
	         Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
	         getContext().getContentResolver().notifyChange(_uri, null);
	         return _uri;
	      }
	      throw new SQLException("Failed to add a record into " + uri);
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		
		int count = 0;

	      switch (uriMatcher.match(uri)){
	      case CONTACT:
	         count = db.delete(CONTACTS_TABLE_NAME, selection, selectionArgs);
	         break;
	      case CONTACTS:
	         String id = uri.getPathSegments().get(1);
	         count = db.delete( CONTACTS_TABLE_NAME, ID +  " = " + id + 
	                (!TextUtils.isEmpty(selection) ? " AND (" + 
	                selection + ')' : ""), selectionArgs);
	         break;
	      default: 
	         throw new IllegalArgumentException("Unknown URI " + uri);
	      }
	      
	      getContext().getContentResolver().notifyChange(uri, null);
	      return count;
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		
		int count = 0;
	      
	      switch (uriMatcher.match(uri)){
	      case CONTACT:
	         count = db.update(CONTACTS_TABLE_NAME, values, 
	                 selection, selectionArgs);
	         break;
	      case CONTACTS:
	         count = db.update(CONTACTS_TABLE_NAME, values, ID + 
	                 " = " + uri.getPathSegments().get(1) + 
	                 (!TextUtils.isEmpty(selection) ? " AND (" +
	                 selection + ')' : ""), selectionArgs);
	         break;
	      default: 
	         throw new IllegalArgumentException("Unknown URI " + uri );
	      }
	      getContext().getContentResolver().notifyChange(uri, null);
	      return count;
		
	}

}
