package tech.ojay.fleetms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ojay.fleetms.models.State;
import tech.ojay.fleetms.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	//Fetch list of states
	public List<State> fetchStates(){
		return stateRepository.findAll();
	}
	
	//Insert new state
	public void store(State state) {
		stateRepository.save(state);
	}
	
	//Fetch state by id
	public State fetchStateDetailsById(int id) {
		return stateRepository.findById(id).orElse(null);
	}

	public void delete(int id) {
		stateRepository.deleteById(id);	
	}
	
}
