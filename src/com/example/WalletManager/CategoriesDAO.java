package com.example.WalletManager;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CategoriesDAO extends DatabaseDAO {
	
	
	public static final String CATEGORIES_KEY = "id";
	public static final String CATEGORIES_COLOR = "couleur";
	
	public static final String CATEGORIES_TABLE = "categories";
	public static final String CATEGORIES_TABLE_CREATE = 
			"CREATE TABLE "+ CATEGORIES_TABLE + " ("+
					CATEGORIES_KEY + " TEXT NOT NULL PRIMARY KEY, "+
					CATEGORIES_COLOR + " TEXT NOT NULL );" ;
	
	public static final String CATEGORIES_TABLE_FILL =
			"INSERT INTO "+ CATEGORIES_TABLE +"( "+CATEGORIES_KEY+" , "+CATEGORIES_COLOR+") "+
			"VALUES "+
			"('Divers', '#111111'),"+
			"('Nourriture', '#222222'),"+
			"('Boissons', '#333333'),"+
			"('Transport','#444444' ),"+
			"('Santé', '#555555'),"+
			"('Loisirs', '#666666');";

	public CategoriesDAO(Context Context) {
		super(Context);
		// TODO Auto-generated constructor stub
	}
	
	public void ajouterCategorie(Categorie categorie){
		ContentValues valeur = new ContentValues();
		valeur.put(CATEGORIES_KEY, categorie.getId());
		valeur.put(CATEGORIES_COLOR, categorie.getCouleur());
		
		database.insert(CATEGORIES_TABLE, null, valeur);
	}
	
	public void supprimerCategorie(String id){
		database.delete(CATEGORIES_TABLE, CATEGORIES_KEY+" = ? ", new String[]{id});		
	}
	
	public void modifierRentree(String ancienne_id, Categorie nouvelle){
		supprimerCategorie(ancienne_id);
		ContentValues valeur = new ContentValues();
		valeur.put(CATEGORIES_KEY, nouvelle.getId());
		valeur.put(CATEGORIES_COLOR, nouvelle.getCouleur());
		
		database.insert(CATEGORIES_TABLE, null, valeur);
		
	}
	
	public Categorie cursorToCategorie(Cursor c){
		

		String id = c.getString(c.getColumnIndex(CATEGORIES_KEY));
		String couleur = c.getString(c.getColumnIndex(CATEGORIES_COLOR)); 
		
		return new Categorie(id, couleur);
		
	}
	
	public ArrayList <Categorie> selectALL(){
		Cursor c = database.rawQuery("SELECT * FROM "+CATEGORIES_TABLE,null);
		ArrayList <Categorie> tab = new ArrayList<Categorie>();
		
		while (c.moveToNext()){
			tab.add(cursorToCategorie(c));
		}
		c.close();
		return tab;
	}
	
	public Categorie selectByID(String id){
		Cursor c = database.rawQuery("SELECT * FROM "+CATEGORIES_TABLE+" WHERE "+CATEGORIES_KEY+" = ? ",new String[]{id} );
		Categorie cat = cursorToCategorie(c);
		c.close();
		return cat;
	}


}
