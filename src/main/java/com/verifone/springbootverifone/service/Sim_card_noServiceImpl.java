package com.verifone.springbootverifone.service;

import com.verifone.springbootverifone.exception.ResourceNotFoundException;
import com.verifone.springbootverifone.model.Sim_card_no;
import com.verifone.springbootverifone.repository.Sim_card_noRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class Sim_card_noServiceImpl implements  Sim_card_noService{

    @Autowired
    Sim_card_noRepository sim_card_noRepository;

    @Override
    public Sim_card_no createSim_card_no(Sim_card_no s) {
        return sim_card_noRepository.save(s);
    }

    @Override
    public Sim_card_no updateSim_card_no(Long mobno,Sim_card_no sim_card_noDetails) throws ResourceNotFoundException {
        Sim_card_no sim_card_no = sim_card_noRepository.findById(mobno)
                .orElseThrow(() -> new ResourceNotFoundException("Sim_card_no not found for this mobile number :: " + mobno));

        sim_card_no.setExpiry_date(sim_card_noDetails.getExpiry_date());
        sim_card_no.setFull_name(sim_card_noDetails.getFull_name());
        sim_card_no.setKyc(sim_card_noDetails.getKyc());
        sim_card_no.setMobile_No(sim_card_noDetails.getMobile_No());
        sim_card_no.setTelecom_provider(sim_card_noDetails.getTelecom_provider());
        sim_card_no.setState_of_registration(sim_card_noDetails.getState_of_registration());
        sim_card_no.setStatus(sim_card_noDetails.getStatus());
        return sim_card_no;
    }

    @Override
    public void deleteSim_card_no(Long mobile_No) throws ResourceNotFoundException {
        Sim_card_no Sim_card_no = sim_card_noRepository.findById(mobile_No)
                .orElseThrow(() -> new ResourceNotFoundException("Sim_card_no not found for this mobile number :: " + mobile_No));
         sim_card_noRepository.delete(Sim_card_no);
    }

    @Override
    public List<Sim_card_no> getAllSim_card_nos() {
        return sim_card_noRepository.findAll();
    }

    @Override
    public List<Sim_card_no> getAllSim_card_nos_expiringNext30Days() {
        Timestamp old = Timestamp.from(Instant.now());
        ZonedDateTime zonedDateTime = old.toInstant().atZone(ZoneId.of("UTC"));
        Timestamp tt = Timestamp.from(zonedDateTime.plus(30, ChronoUnit.DAYS).toInstant());

        return sim_card_noRepository.findByExpiry_DateLessThanEqual(tt);
    }
}
