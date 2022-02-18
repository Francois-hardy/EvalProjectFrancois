package com.weather.weather.model;

public class Weather {

	public Weather() {
		
	}
	public Weather(String nom, String ZipCode, String Pays, String Temps) {
		super();
		this.nom = nom;
		this.zipCode = ZipCode;
		this.Pays = Pays;
		this.Temps = Temps;
	}

	private String nom;
	private String zipCode;
	private String Pays;
	private String Temps;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPays() {
		return Pays;
	}
	public void setPays(String Pays) {
		this.Pays = Pays;
	}

	public String getTemps() {
		return Temps;
	}
	public void setTemps(String Temps) {
		this.Temps = Temps;
	}

	@Override
	public String toString() {
		return "Weather [Nom=" + nom + ", ZipCode=" + zipCode
				+ ", Pays=" + Pays + ", Temps=" + Temps + "]";
	}
}
