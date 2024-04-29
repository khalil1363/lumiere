package com.supportportal.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStage;
    private String theme;
    private String encadreure;
    private String departement;
    private String site;
    private int duree; // Consider using a Duration object for more precise duration handling
    private Date dateDebut;
    private Date dateFin;
    private String bilan;
    
    
    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL, orphanRemoval = true) // OneToMany relationship with Stagier
    private Set<Stagier> stagiaires;
    
	public Long getIdStage() {
		return idStage;
	}
	public void setIdStage(Long idStage) {
		this.idStage = idStage;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getEncadreure() {
		return encadreure;
	}
	public void setEncadreure(String encadreure) {
		this.encadreure = encadreure;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getBilan() {
		return bilan;
	}
	public void setBilan(String bilan) {
		this.bilan = bilan;
	}
	public Stage(Long idStage, String theme, String encadreure, String departement, String site, int duree,
			Date dateDebut, Date dateFin, String bilan) {
		super();
		this.idStage = idStage;
		this.theme = theme;
		this.encadreure = encadreure;
		this.departement = departement;
		this.site = site;
		this.duree = duree;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.bilan = bilan;
	}
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}