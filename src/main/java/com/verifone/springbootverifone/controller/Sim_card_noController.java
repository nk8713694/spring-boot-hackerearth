package com.verifone.springbootverifone.controller;



import com.verifone.springbootverifone.exception.ResourceNotFoundException;
import com.verifone.springbootverifone.model.Sim_card_no;
import com.verifone.springbootverifone.repository.Sim_card_noRepository;
import com.verifone.springbootverifone.service.Sim_card_noService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class Sim_card_noController {
	@Autowired
	private Sim_card_noRepository Sim_card_noRepository;
	// lets go for the coding in the selection

	@Autowired
	Sim_card_noService sim_card_noService;

	@GetMapping("/")
	public ResponseEntity<HttpStatus> getOkResponse() {
		log.info("default page");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/add")
	public Sim_card_no createSim_card_no(@Valid @RequestBody Sim_card_no sim_card_no) {
		return sim_card_noService.createSim_card_no(sim_card_no);
	}

	@GetMapping("/listall")
	public List<Sim_card_no> getAllSim_card_nos() {
		log.info("find all records");
		return sim_card_noService.getAllSim_card_nos();
	}

	@GetMapping("/renew")
	public List<Sim_card_no> getAllSim_card_nosinnext30days() {
		log.info("find all next 30days expiring records");
		return sim_card_noService.getAllSim_card_nos_expiringNext30Days();
	}

	@PutMapping("/renew/{id}")
	public Map<String, String> getAllSim_card_nosinnext30days(@PathVariable(value = "id") Long mobile_No,
															   @Valid @RequestBody Sim_card_no sim_card_noDetails) throws ResourceNotFoundException {
		log.info("update renew ones");

		Sim_card_no sim= sim_card_noService.updateSim_card_no(mobile_No,sim_card_noDetails);

		Map<String, String> response = new HashMap<>();
		response.put("dummylink", "https://thisisdummy.com");
		return response;

	}


	@PutMapping("/{id}")
	public ResponseEntity<Sim_card_no> updateSim_card_no(@PathVariable(value = "id") Long mobile_No,
			@Valid @RequestBody Sim_card_no sim_card_noDetails) throws ResourceNotFoundException {

				Sim_card_no sim= sim_card_noService.updateSim_card_no(mobile_No,sim_card_noDetails);
		return ResponseEntity.ok(sim);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteSim_card_no(@PathVariable(value = "id") Long mobile_No)
			throws ResourceNotFoundException {

		sim_card_noService.deleteSim_card_no(mobile_No);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}
