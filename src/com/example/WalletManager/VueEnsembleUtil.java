package com.example.WalletManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class VueEnsembleUtil {
	
	public static HashMap<Categorie,Float> getDepensesAujourdHui(){
		String day = new String(""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		String month = new String(""+Calendar.getInstance().get(Calendar.MONTH));
		String year = new String(""+Calendar.getInstance().get(Calendar.YEAR));
		
		CategoriesDAO categoriesTable = new CategoriesDAO(null);
		categoriesTable.open();
		
		ArrayList<Categorie> categories = categoriesTable.selectALL(); 
		
		categoriesTable.close();
		categoriesTable = null;
		
		DepensesDAO depensesTable = new DepensesDAO(null);
		depensesTable.open();
		
		
		HashMap<Categorie,Float> res = new HashMap<Categorie,Float>();
		ArrayList<Depense> depenses = null;
		float total = 0;
		
		for (Categorie cat : categories){
			total = 0;
			depenses = depensesTable.selectByCategorieAndDate(cat.getId(), day, month, year);
			for(Depense dep : depenses) total+= dep.getMontant();
			res.put(cat, total);
		}
		depensesTable.close();
		
		return res;
		
	}
	
	
	public static HashMap<Categorie,Float> getDepensesSemaine(){
		String day;
		String month;
		String year;
			
		Calendar cal = Calendar.getInstance();
		
		CategoriesDAO categoriesTable = new CategoriesDAO(null);
		categoriesTable.open();
		
		ArrayList<Categorie> categories = categoriesTable.selectALL(); 
		
		categoriesTable.close();
		categoriesTable = null;
		
		DepensesDAO depensesTable = new DepensesDAO(null);
		depensesTable.open();
		
		
		HashMap<Categorie,Float> res = new HashMap<Categorie,Float>();
		ArrayList<Depense> depenses = null;
		float total = 0;
		int i;
		
		for (Categorie cat : categories){
			cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
			total = 0;
			
			for ( i = 0; i<7 ; i++){
				day = new String(""+cal.get(Calendar.DAY_OF_MONTH));
				month = new String(""+cal.get(Calendar.DAY_OF_MONTH));
				year = new String(""+cal.get(Calendar.DAY_OF_MONTH));
				
				depenses = depensesTable.selectByCategorieAndDate(cat.getId(), day, month, year);
				for(Depense dep : depenses) total+= dep.getMontant();
				
				cal.add(Calendar.DAY_OF_WEEK, 1);			
			}
			
			res.put(cat, total);
		}
		depensesTable.close();
		return res;
		
	}


	public static HashMap<Categorie,Float> getDepensesMois(){
		String month = new String(""+Calendar.getInstance().get(Calendar.MONTH));
		String year = new String(""+Calendar.getInstance().get(Calendar.YEAR));
		
		CategoriesDAO categoriesTable = new CategoriesDAO(null);
		categoriesTable.open();
		
		ArrayList<Categorie> categories = categoriesTable.selectALL(); 
		
		categoriesTable.close();
		categoriesTable = null;
		
		DepensesDAO depensesTable = new DepensesDAO(null);
		depensesTable.open();
		
		
		HashMap<Categorie,Float> res = new HashMap<Categorie,Float>();
		ArrayList<Depense> depenses = null;
		float total = 0;
		
		for (Categorie cat : categories){
			total = 0;
			depenses = depensesTable.selectByCategorieAndDate(cat.getId(), month, year);
			for(Depense dep : depenses) total+= dep.getMontant();
			res.put(cat, total);
		}
		depensesTable.close();
		
		return res;
		
	}
}
