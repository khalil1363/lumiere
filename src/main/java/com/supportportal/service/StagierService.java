package com.supportportal.service;

import java.util.List;

import com.supportportal.entity.Stagier;



public interface StagierService {

    List<Stagier> getAllStagiers();

    Stagier getStagierById(Long idStagier);

    Stagier saveStagier(Stagier stagier);

    void deleteStagier(Long idStagier);
}