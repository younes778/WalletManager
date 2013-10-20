package com.example.WalletManager;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class DepensesDAO extends DatabaseDAO {
	
	public static final String DEPENSES_KEY = "_id";
	public static final String DEPENSES_CATEGORIE = "id_categorie";
	public static final String DEPENSES_MONTANT = "montant";
	public static final String DEPENSES_DATE = "date";
	public static final String DEPENSES_NOTE = "note";
	
	public static final String DEPENSES_TABLE= "depenses";
	public static final String DEPENSES_TABLE_CREATE=
			"CREATE TABLE "+ DEPENSES_TABLE + " ("+
			 DEPENSES_KEY + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
			 DEPENSES_CATEGORIE + " TEXT NOT NULL, "+
			 DEPENSES_MONTANT + " REAL NOT NULL CHECK ("+DEPENSES_MONTANT+" > 0.0 ), "+
			 DEPENSES_DATE + " TEXT NOT NULL, "+
			 DEPENSES_NOTE + " TEXT);" ;

	public DepensesDAO(Context Context) {
		super(Context);
		// TODO Auto-generated constructor stub
	}
	
	
	public void ajouterDepense(Depense depense){
		ContentValues valeur = new ContentValues();
		valeur.put(DEPENSES_CATEGORIE, depense.getId_categorie());
		valeur.put(DEPENSES_DATE, depense.getDate().toString());
		valeur.put(DEPENSES_MONTANT, depense.getMontant());
		valeur.put(DEPENSES_NOTE, depense.getNote());
		database.insert(DEPENSES_TABLE, null, valeur);
	}
	
	public void supprimerDepenseByID(int id){
		database.delete(DEPENSES_TABLE, DEPENSES_KEY+" = ? ", new String[]{String.valueOf(id)});		
	}
	
	public void modifierDepense(int ancienne_id, Depense nouvelle){
		ContentValues valeur = new ContentValues();
		valeur.put(DEPENSES_CATEGORIE, nouvelle.getId_categorie());
		valeur.put(DEPENSES_DATE, nouvelle.getDate().toString());
		valeur.put(DEPENSES_MONTANT, nouvelle.getMontant());
		valeur.put(DEPENSES_NOTE, nouvelle.getNote());
		
		database.update(DEPENSES_TABLE, valeur, DEPENSES_KEY+" = ? ",  new String[]{String.valueOf(ancienne_id)});
		
	}
	
	public Depense cursorToDepense(Cursor c){
		
		String id_categorie = c.getString(c.getColumnIndex(DEPENSES_CATEGORIE));
		String[] date = c.getString(c.getColumnIndex(DEPENSES_DATE)).split(" ");
		String note = c.getString(c.getColumnIndex(DEPENSES_NOTE));
		float montant = c.getFloat(c.getColumnIndex(DEPENSES_MONTANT));
		long id = c.getLong(c.getColumnIndex(DEPENSES_KEY));
		
		return new Depense(id,id_categorie, montant,new Date(date[0],date[1],date[2]), note);
		
	}
	
	public ArrayList <Depense> selectALL(){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE,null);
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		c.close();
		return tab;
	}
	
	public Depense selectByID(long id){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_KEY+" = ? ",new String[]{String.valueOf(id)} );
		Depense dep = cursorToDepense(c);
		c.close();
		return dep;
	}
	
	public ArrayList<Depense> selectByCategorie(String id_categorie){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_CATEGORIE+" = '"+id_categorie+"'",null );
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		c.close();
		return tab;
	}
	
	public ArrayList<Depense> selectByDate(String day, String month, String year){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_DATE+" = '"+month+" "+day+" "+year+"'",null);
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		c.close();
		return tab;
	}
	
	public ArrayList<Depense> selectByDate( String month, String year){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_DATE+" LIKE '"+month+"%"+year+"'",null);
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		c.close();
		return tab;
	}
	
	public ArrayList<Depense> selectByDate(String year){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_DATE+" LIKE '%"+year+"'",null);
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		
		c.close();
		
		return tab;
	}
	
	public ArrayList<Depense> selectByCategorieAndDate(String id_categorie,String day, String month, String year){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_DATE+" = '"+month+" "+day+" "+year+"' AND "+DEPENSES_CATEGORIE+" = '"+id_categorie+"'",null);
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		c.close();
		return tab;
	}
	
	public ArrayList<Depense> selectByCategorieAndDate(String id_categorie, String month, String year){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_DATE+" LIKE '"+month+"%"+year+"' AND "+DEPENSES_CATEGORIE+" = '"+id_categorie+"'",null);
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		c.close();
		return tab;
	}
	
	public ArrayList<Depense> selectByCategorieAndDate(String id_categorie, String year){
		Cursor c = database.rawQuery("SELECT * FROM "+DEPENSES_TABLE+" WHERE "+DEPENSES_DATE+" LIKE '%"+year+"' AND "+DEPENSES_CATEGORIE+" = '"+id_categorie+"'",null);
		ArrayList <Depense> tab = new ArrayList<Depense>();
		
		while (c.moveToNext()){
			tab.add(cursorToDepense(c));
		}
		
		c.close();
		
		return tab;
	}
	

}
