package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.PropositionFormation;



public interface PropositionFormationService {
	  PropositionFormation savePropositionFormation(PropositionFormation propositionFormation);
	    List<PropositionFormation> findAllPropositionFormations();
	    PropositionFormation findByIdProposition(Long idProposition);
	    void deletePropositionFormation(Long idProposition);
	    PropositionFormation updatePropositionFormation(PropositionFormation propositionFormation); 
	}