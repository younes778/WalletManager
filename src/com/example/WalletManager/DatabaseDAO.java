package com.example.WalletManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DatabaseDAO {
	

		
		// Le nom du fichier qui représente ma base
		protected static final String DATABASE_NAME = "WalletManagerDB.db";
		protected static final int DATABASE_VERSION = 1 ; 
		
		protected SQLiteDatabase database = null;
		
		protected DatabaseHandler handler = null;
		public DatabaseDAO(Context Context) {
		this.handler = new DatabaseHandler(Context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		public SQLiteDatabase open() {

		database = handler.getWritableDatabase();
		return database;
		}
		public void close() {
		database.close();
		}
		public SQLiteDatabase getDb() {
		return database;
		}
		

}
