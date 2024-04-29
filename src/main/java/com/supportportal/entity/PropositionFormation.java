package com.supportportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "proposition_formation") // Adjust table name if needed
public class PropositionFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment
    private Long idProposition;
    private String module;
    private String type;
    private Integer duree;
    private String description;
	public Long getIdProposition() {
		return idProposition;
	}
	public void setIdProposition(Long idProposition) {
		this.idProposition = idProposition;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PropositionFormation(Long idProposition, String module, String type, Integer duree, String description) {
		super();
		this.idProposition = idProposition;
		this.module = module;
		this.type = type;
		this.duree = duree;
		this.description = description;
	}
	public PropositionFormation() {
		super();
		// TODO Auto-generated constructor stub
	}

  
}