package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Meme {
	
	 @Id
	private Long CIP;
	private String nom;
	private String code;
	private String princip;
	private Long prix;
	private String mdpImport;
	
	
	public Meme() {
		super();
	}
	public Long getCIP() {
		return CIP;
	}
	public void setCIP(Long cIP) {
		CIP = cIP;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrincip() {
		return princip;
	}
	public void setPrincip(String princip) {
		this.princip = princip;
	}
	public Long getPrix() {
		return prix;
	}
	public void setPrix(Long prix) {
		this.prix = prix;
	}
	public String getMdpImport() {
		return mdpImport;
	}
	public void setMdpImport(String mdpImport) {
		this.mdpImport = mdpImport;
	}

	
	
}
