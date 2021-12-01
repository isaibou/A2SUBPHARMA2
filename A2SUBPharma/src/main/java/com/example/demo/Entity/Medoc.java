package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Medoc implements Serializable {

	@Id
	private Long CIP ;
	private String Nom ; 
	private String Code_remb ;
	private String Princip_actif;
	private Long Prix;

	public Long getCIP() {
		return CIP;
	}
	public void setCIP(Long cIP) {
		CIP = cIP;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getCode_remb() {
		return Code_remb;
	}
	public void setCode_remb(String code_remb) {
		Code_remb = code_remb;
	}
	public String getPrincip_actif() {
		return Princip_actif;
	}
	public void setPrincip_actif(String princip_actif) {
		Princip_actif = princip_actif;
	}
	public Long getPrix() {
		return Prix;
	}
	public void setPrix(Long prix) {
		Prix = prix;
	} 
	
	
	
	
}
