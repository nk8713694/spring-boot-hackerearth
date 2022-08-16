package com.verifone.springbootverifone.service;

import com.verifone.springbootverifone.exception.ResourceNotFoundException;
import com.verifone.springbootverifone.model.Sim_card_no;

import java.util.List;

public interface Sim_card_noService {

    public Sim_card_no createSim_card_no(Sim_card_no s);
    public Sim_card_no updateSim_card_no(Long mobno,Sim_card_no mobNo) throws ResourceNotFoundException;
    public void deleteSim_card_no(Long mobNo) throws ResourceNotFoundException;
    public List<Sim_card_no> getAllSim_card_nos();

    List<Sim_card_no> getAllSim_card_nos_expiringNext30Days();
}
