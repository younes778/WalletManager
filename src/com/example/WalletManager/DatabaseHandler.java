package com.example.WalletManager;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DatabaseHandler extends SQLiteOpenHelper {
	

	public DatabaseHandler(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DepensesDAO.DEPENSES_TABLE_CREATE); // creation de la table dépenses
		db.execSQL(RentreesDAO.RENTREES_TABLE_CREATE); // creation de la table Rentrees
		db.execSQL(CategoriesDAO.CATEGORIES_TABLE_CREATE); // creation de la table categories
		db.execSQL(CategoriesDAO.CATEGORIES_TABLE_FILL); // remplissage de la table catégories

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
