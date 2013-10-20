package com.example.WalletManager;

public class Rentree {
	
	private long id;
	private float montant;
	private Date date;
	private String note;
	
	public Rentree(long id, float montant, Date date,String note) {
		super();
		this.id = id;
		this.montant = montant;
		this.date = date;
		this.note = note;
	}
	
	public Rentree( float montant, Date date,String note) {
		super();
		this.id = 0;
		this.montant = montant;
		this.date = date;
		this.note = note;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getDate() {
		return date.toString();
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	

}
