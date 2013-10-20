package com.example.WalletManager;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class RentreesDAO extends DatabaseDAO {
	
	public static final String RENTREES_KEY = "_id";
	public static final String RENTREES_MONTANT = "montant";
	public static final String RENTREES_DATE = "date";
	public static final String RENTREES_NOTE = "note";
	
	public static final String RENTREES_TABLE = "rentrees";
	public static final String RENTREES_TABLE_CREATE =
			"CREATE TABLE "+ RENTREES_TABLE + " ("+
					RENTREES_KEY + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
					RENTREES_MONTANT + " REAL NOT NULL CHECK ("+RENTREES_MONTANT+" > 0.0 ), "+
					RENTREES_DATE + " TEXT NOT NULL, "+
					RENTREES_NOTE + " TEXT);" ;

	public RentreesDAO(Context Context) {
		super(Context);
		// TODO Auto-generated constructor stub
	}
	
	public void ajouterRentree(Rentree rentree){
		ContentValues valeur = new ContentValues();
		valeur.put(RENTREES_DATE, rentree.getDate().toString());
		valeur.put(RENTREES_MONTANT, rentree.getMontant());
		valeur.put(RENTREES_NOTE, rentree.getNote());
		database.insert(RENTREES_TABLE, null, valeur);
	}
	
	public void supprimerRentreeByID(int id){
		database.delete(RENTREES_TABLE, RENTREES_KEY+" = ? ", new String[]{String.valueOf(id)});		
	}
	
	public void modifierRentree(int ancienne_id, Rentree nouvelle){
		ContentValues valeur = new ContentValues();
		valeur.put(RENTREES_DATE, nouvelle.getDate().toString());
		valeur.put(RENTREES_MONTANT, nouvelle.getMontant());
		valeur.put(RENTREES_NOTE, nouvelle.getNote());
		
		database.update(RENTREES_TABLE, valeur, RENTREES_KEY+" = ? ",  new String[]{String.valueOf(ancienne_id)});
		
	}
	
	public Rentree cursorToRentrees(Cursor c){
		
		String[] date = c.getString(c.getColumnIndex(RENTREES_DATE)).split(" ");
		String note = c.getString(c.getColumnIndex(RENTREES_NOTE));
		float montant = c.getFloat(c.getColumnIndex(RENTREES_MONTANT));
		long id = c.getLong(c.getColumnIndex(RENTREES_KEY));
		
		return new Rentree(id, montant,new Date(date[0],date[1],date[2]), note);
		
	}
	
	public ArrayList <Rentree> selectALL(){
		Cursor c = database.rawQuery("SELECT * FROM "+RENTREES_TABLE,null);
		ArrayList <Rentree> tab = new ArrayList<Rentree>();
		
		while (c.moveToNext()){
			tab.add(cursorToRentrees(c));
		}
		c.close();
		return tab;
	}
	
	public Rentree selectByID(long id){
		Cursor c = database.rawQuery("SELECT * FROM "+RENTREES_TABLE+" WHERE "+RENTREES_KEY+" = ? ",new String[]{String.valueOf(id)} );
		Rentree ren = cursorToRentrees(c);
		c.close();
		return ren;
	}
	
	
	public ArrayList<Rentree> selectByDate(String day, String month, String year){
		Cursor c = database.rawQuery("SELECT * FROM "+RENTREES_TABLE+" WHERE "+RENTREES_DATE+" = '"+month+" "+day+" "+year+"'",null);
		ArrayList <Rentree> tab = new ArrayList<Rentree>();
		
		while (c.moveToNext()){
			tab.add(cursorToRentrees(c));
		}
		c.close();
		return tab;
	}
	
	public ArrayList<Rentree> selectByDate( String month, String year){
		Cursor c = database.rawQuery("SELECT * FROM "+RENTREES_TABLE+" WHERE "+RENTREES_DATE+" LIKE '"+month+"%"+year+"'",null);
		ArrayList <Rentree> tab = new ArrayList<Rentree>();
		
		while (c.moveToNext()){
			tab.add(cursorToRentrees(c));
		}
		c.close();
		return tab;
	}
	
	public ArrayList<Rentree> selectByDate(String year){
		Cursor c = database.rawQuery("SELECT * FROM "+RENTREES_TABLE+" WHERE "+RENTREES_DATE+" LIKE '%"+year+"'",null);
		ArrayList <Rentree> tab = new ArrayList<Rentree>();
		
		while (c.moveToNext()){
			tab.add(cursorToRentrees(c));
		}
		
		c.close();
		
		return tab;
	}
	

}
