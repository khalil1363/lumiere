package com.supportportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.entity.PropositionFormation;
import com.supportportal.service.PropositionFormationService;


@RestController
@RequestMapping("/propositionsformations")
public class PropositionFormationController {

    @Autowired
    private PropositionFormationService propositionFormationService;

    @PostMapping("/add")
    public ResponseEntity<PropositionFormation> createPropositionFormation(@Validated @RequestBody PropositionFormation propositionFormation) {
        PropositionFormation savedPropositionFormation = propositionFormationService.savePropositionFormation(propositionFormation);
        return new ResponseEntity<>(savedPropositionFormation, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<PropositionFormation>> getAllPropositionFormations() {
        List<PropositionFormation> propositionFormations = propositionFormationService.findAllPropositionFormations();
        return new ResponseEntity<>(propositionFormations, HttpStatus.OK);
    }

    @GetMapping("getone/{id}")
    public ResponseEntity<PropositionFormation> getPropositionFormationById(@PathVariable Long id) {
        PropositionFormation propositionFormation = propositionFormationService.findByIdProposition(id);
        if (propositionFormation != null) {
            return new ResponseEntity<>(propositionFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PropositionFormation> updatePropositionFormation(@PathVariable Long id, @Validated @RequestBody PropositionFormation propositionFormation) {
        if (!id.equals(propositionFormation.getIdProposition())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // IDs don't match
        }

        PropositionFormation updatedPropositionFormation = propositionFormationService.updatePropositionFormation(propositionFormation);
        if (updatedPropositionFormation != null) {
            return new ResponseEntity<>(updatedPropositionFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePropositionFormation(@PathVariable Long id) {
        propositionFormationService.deletePropositionFormation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}