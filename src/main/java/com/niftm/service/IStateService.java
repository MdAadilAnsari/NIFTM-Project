
package com.niftm.service;

import java.util.List;
import java.util.Optional;

import com.niftm.dto.StateRequest;
import com.niftm.entity.State;

public interface IStateService {

	public State saveStateName(StateRequest state);

	public List<State> getAllState();

	public Boolean deleteStateById(Long id);
	
	public Optional<State> getStateById(Long id);
	
	public State updateStateDetails(State stateDetails);
}
