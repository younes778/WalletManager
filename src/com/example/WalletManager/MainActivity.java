package com.example.WalletManager;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView hello = null;
	private TextView hello2 = null;
	private String string= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
//        DepensesDAO db = new DepensesDAO(this);
//        this.deleteDatabase(db.DATABASE_NAME);
//        db =  new DepensesDAO(this);
//        db.open();
//        
//        db.ajouterDepense(new Depense("Boisson", 11.f, new Date("October", "12", "2015"), "Ceci est un test"));
//        db.ajouterDepense(new Depense("Nourriture", 12.f, new Date("May", "14", "2013"), "Ceci est un test"));
//        db.ajouterDepense(new Depense("Nourriture", 14.f, new Date("May", "12", "2013"), "Ceci est un test"));
//
//        db.supprimerDepenseByID(2);
//        
//        for (Depense dep : db.selectALL()){
//        	string = string+
//        			"ID depense : "+dep.getId()+"\n"+
//        			"ID Categorie : "+dep.getId_categorie()+"\n"+
//        			"ID montant : "+dep.getMontant()+"\n"+
//        			"ID Date : "+dep.getDate().toString()+"\n"+
//        			"ID note : "+dep.getNote()+"\n\n\n";
//        			
//        }
//        
        hello = new TextView(this);
//        hello2 = new TextView(this);
        setContentView(R.layout.activity_main);
        hello = (TextView) findViewById(R.id.monText);
//        hello.setText(string);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 1);
        string = "" + cal.get(Calendar.DAY_OF_MONTH)+"-"+ (cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.YEAR);
        hello.setText(""+string);
  
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
