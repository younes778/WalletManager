package com.example.WalletManager;

public class Categorie {
	private String id;
	private String couleur;
	public Categorie(String id, String couleur) {
		super();
		this.id = id;
		this.couleur = couleur;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	@Override
	public int hashCode() {

		return ((id == null) ? 0 : id.hashCode());
	}
	@Override
	public boolean equals(Object obj) {
		
		
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Categorie)) {
			return false;
		}
		Categorie other = (Categorie) obj;
		return this.id.equals(other.getId());
	}
	

	

	
	
	
	

}
