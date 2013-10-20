package com.example.WalletManager;

import java.util.ArrayList;
import java.util.Calendar;


public class StatisticsUtil {
	
	public static float moyenneDepensesJournalieresMois(String month, String year){
		float nbJours;

		if ( (month.equalsIgnoreCase(Date.Mois.FEVRIER.toString())) 
				&& (Integer.parseInt(year) % 4 != 0) ) nbJours = 28;
		
		else if ( (month.equalsIgnoreCase(Date.Mois.FEVRIER.toString())) 
				     && (Integer.parseInt(year) % 4 == 0) ) nbJours = 29;
		
		
		else if ((month.equalsIgnoreCase(Date.Mois.JANVIER.toString())) 
				|| (month.equalsIgnoreCase(Date.Mois.MARS.toString())) 
				  || (month.equalsIgnoreCase(Date.Mois.MAI.toString())) 
				    || (month.equalsIgnoreCase(Date.Mois.JUILLET.toString())) 
				      || (month.equalsIgnoreCase(Date.Mois.AOUT.toString())) 
				        || (month.equalsIgnoreCase(Date.Mois.OCTOBRE.toString())) 
				          || (month.equalsIgnoreCase(Date.Mois.DECEMBRE.toString()))) nbJours = 31;
		else nbJours = 30;
		
		DepensesDAO db = new DepensesDAO(null);
		db.open();
		ArrayList<Depense> tab = db.selectByDate(month, year);
		db.close();
		
		float moyenne = 0;
		
		for (Depense dep : tab) moyenne += dep.getMontant();
		
		moyenne = moyenne / nbJours;
		
		return moyenne;
		
	}
	
	public static float moyenneDepensesJournalieresAn(String year){
		 float moyenne = 0;
		
		 if (year.matches(""+Calendar.getInstance().get(Calendar.YEAR))){
			 float tmp;
			 float nbmois=1;
			 for ( Date.Mois month : Date.Mois.values()){
				 tmp = moyenneDepensesJournalieresMois(month.toString(), year);
				 if (tmp != 0){
					 moyenne += tmp;
					 nbmois = month.ordinal()+1;
				 }
			 }
			 moyenne = moyenne / nbmois;
			 
		 }
		 else{
			 for ( Date.Mois month : Date.Mois.values()){

					 moyenne +=  moyenneDepensesJournalieresMois(month.toString(), year);
			 }
			 moyenne = moyenne / 12.f ;
		 }
		 
		 return moyenne;
	 }

	public static float moyenneDepensesMensuels(String year){
		float moyenne = totalDepensesAn(year);
		 if (year.matches(""+Calendar.getInstance().get(Calendar.YEAR))){

			 moyenne = moyenne / ( Calendar.getInstance().get(Calendar.MONTH)+1 );
			 
		 }
		 else moyenne = moyenne / 12.f ;
		 
		 
		 return moyenne;
		
	}
	
	public static float totalDepensesJour(String day, String month, String year){
		float total=0;
		DepensesDAO db = new DepensesDAO(null);
		db.open();
		
		ArrayList<Depense> tab = db.selectByDate(day,month, year);
		db.close();
		
		for (Depense dep : tab) total += dep.getMontant();

		
		
		return total;
	}

	public static float totalDepensesMois(String month, String year){
		float total=0;
		DepensesDAO db = new DepensesDAO(null);
		db.open();
		
		ArrayList<Depense> tab = db.selectByDate(month, year);
		db.close();
		
		for (Depense dep : tab) total += dep.getMontant();

		
		
		return total;
		
	}
	
	public static float totalDepensesAn(String year){
		float total=0;
		DepensesDAO db = new DepensesDAO(null);
		db.open();
		
		ArrayList<Depense> tab = db.selectByDate( year);
		db.close();
		
		for (Depense dep : tab) total += dep.getMontant();

		
		
		return total;
		
	}
	
	 
}
