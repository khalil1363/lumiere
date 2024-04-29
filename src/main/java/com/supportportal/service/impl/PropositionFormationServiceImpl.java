package com.supportportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.entity.PropositionFormation;
import com.supportportal.repository.PropositionFormationRepository;
import com.supportportal.service.PropositionFormationService;



@Service
public class PropositionFormationServiceImpl implements PropositionFormationService {

    @Autowired
    private PropositionFormationRepository propositionFormationRepository;

    @Override
    public PropositionFormation savePropositionFormation(PropositionFormation propositionFormation) {
        return propositionFormationRepository.save(propositionFormation);
    }

    @Override
    public List<PropositionFormation> findAllPropositionFormations() {
        return propositionFormationRepository.findAll();
    }

    @Override
    public PropositionFormation findByIdProposition(Long idProposition) {
        return propositionFormationRepository.findById(idProposition).orElse(null);
    }

    @Override
    public void deletePropositionFormation(Long idProposition) {
        propositionFormationRepository.deleteById(idProposition);
    }

    @Override
    public PropositionFormation updatePropositionFormation(PropositionFormation propositionFormation) {
        PropositionFormation existingPropositionFormation = propositionFormationRepository.findById(propositionFormation.getIdProposition()).orElse(null);

        if (existingPropositionFormation != null) {
            // Update properties from the provided propositionFormation object
            existingPropositionFormation.setModule(propositionFormation.getModule());
            existingPropositionFormation.setType(propositionFormation.getType());
            existingPropositionFormation.setDuree(propositionFormation.getDuree());
            existingPropositionFormation.setDescription(propositionFormation.getDescription());

            return propositionFormationRepository.save(existingPropositionFormation);
        } else {
            throw new RuntimeException("PropositionFormation with ID " + propositionFormation.getIdProposition() + " not found for update.");
        }
    }
}