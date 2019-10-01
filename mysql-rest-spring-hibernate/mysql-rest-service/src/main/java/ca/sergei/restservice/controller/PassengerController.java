package ca.sergei.restservice.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sergei.restservice.entity.Address;
import ca.sergei.restservice.entity.Passenger;
import ca.sergei.restservice.repository.AddressRepository;
import ca.sergei.restservice.repository.PassengerRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/passengers")
public class PassengerController {

	@Autowired
	private PassengerRepository repository;
	
	
	@GetMapping
	public Iterable<Passenger> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Passenger> find(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	
	@PostMapping(consumes = "application/json")
	public Passenger create(@Valid @RequestBody Passenger passenger) {		
		return repository.save(passenger);
	}
	
		
	@PutMapping(path = "/{id}")
	public Passenger update(@PathVariable("id") Long id, @RequestBody Passenger passenger) throws BadHttpRequest {
		if (repository.existsById(id)) {
			passenger.setId(id);					
			return repository.save(passenger);
		} else {
			throw new BadHttpRequest();
		}
	}		
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long id) throws BadHttpRequest {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new BadHttpRequest();
		}
	}
	
}
