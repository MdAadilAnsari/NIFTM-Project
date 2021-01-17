package com.niftm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.niftm.dto.StateRequest;
import com.niftm.entity.State;
import com.niftm.service.IStateService;

@RestController
@RequestMapping("/api/state")
public class StateController {

	@Autowired
	private IStateService stateService;

	@PostMapping("/save")
	public ResponseEntity<State> createOrUpdateCity(@RequestBody StateRequest state) {

		State saveStateName = stateService.saveStateName(state);

		return new ResponseEntity<State>(saveStateName, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<State> getAllState(){
		List<State> allState = stateService.getAllState();
		System.out.println("Get all state==== "+allState);
		return allState;
	}
	
	@GetMapping("/getState/{id}")
	public Optional<State> getStateById(@PathVariable("id")Long id){
		return stateService.getStateById(id);
	}
	
	@DeleteMapping("/deletestate/{id}")
	public String deleteStateById(@PathVariable("id") Long id) {
		stateService.deleteStateById(id);
		return "record deleted!! "+id;
	}
	
	@PutMapping("/updatestate")
	public State updateStateDetails(@RequestBody State sttDetails) {
		return stateService.updateStateDetails(sttDetails);
	}
}
