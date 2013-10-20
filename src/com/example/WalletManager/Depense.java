package com.example.WalletManager;

public class Depense {
	private long id;
	private String id_categorie;
	private float montant;
	private Date date;
	private String note;
	
	
	public Depense( String id_categorie, float montant, Date date,
			String note) {
		super();
		this.id = 0;
		this.id_categorie = id_categorie;
		this.montant = montant;
		this.date = date;
		this.note = note;
	}
	
	public Depense( long id,String id_categorie, float montant, Date date,
			String note) {
		super();
		this.id = id;
		this.id_categorie = id_categorie;
		this.montant = montant;
		this.date = date;
		this.note = note;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(String id_categorie) {
		this.id_categorie = id_categorie;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Date getDate() {
		return date;
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
