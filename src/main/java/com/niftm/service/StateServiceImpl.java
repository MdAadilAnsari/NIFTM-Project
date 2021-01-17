package com.niftm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niftm.dto.StateRequest;
import com.niftm.entity.State;
import com.niftm.repository.StateRepo;

@Service
public class StateServiceImpl implements IStateService {
	
	@Autowired
	private StateRepo stateRepo;

	@Override
	public State saveStateName(StateRequest state) {
		State stt = new State();
		stt.setStateName(state.getStateName());
		return stateRepo.save(stt);
	}

	@Override
	public List<State> getAllState() {
		List<State> stateList = stateRepo.findAll();
		if(!stateList.isEmpty()) {
			return stateList;
		}else {
			return new ArrayList<State>();
		}
	}

	@Override
	public Boolean deleteStateById(Long id) {
		stateRepo.deleteById(id);
		return true;
	}

	@Override
	public Optional<State> getStateById(Long id) {
		Optional<State> findState = stateRepo.findById(id);
		return findState;
	}

	@Override
	public State updateStateDetails(State stateDetails) {
		
		State existingState = stateRepo.findById(stateDetails.getId()).orElse(null);
		existingState.setStateName(stateDetails.getStateName());
		return stateRepo.save(existingState);
		
	}
}