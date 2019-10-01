package ca.sergei.restservice.controller;

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
@RequestMapping(path = "/address")
public class AddressController {
	
	@Autowired
	private AddressRepository addressrepository;
	
	@GetMapping
	public Iterable<Address> findAll() {
		return addressrepository.findAll();
	}	

	@PostMapping(consumes = "application/json")
	public Address create(@Valid @RequestBody Address address) {
		//System.out.println("testing post passenger ");
		//System.out.println(passenger);
		return addressrepository.save(address);
	}
	/*
	@PostMapping(consumes = "application/json")
	public Passenger create(@RequestBody Passenger passenger) {
		System.out.println("testing post passenger ");
		System.out.println(passenger);
		return repository.save(passenger);
	}
	@PostMapping(path = "/address", consumes = "application/json")
	public Address create(@RequestBody Address address) {
		
		System.out.println("testing post address");
		System.out.println(address);
		return addressrepository.save(address);
	}
/*
	@DeleteMapping(path = "/{login}")
	public void delete(@PathVariable("login") String login) {
		repository.delete(login);
	}
*/	
	/*
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.delete(id);
	}
*/
	/*
	@PutMapping(path = "/{login}")
	public Passenger update(@PathVariable("login") String login, @RequestBody Passenger passenger) throws BadHttpRequest {
		if (repository.exists(login)) {
			passenger.setLogin(login);					
			return repository.save(passenger);
		} else {
			throw new BadHttpRequest();
		}
	}
	*/
	//test
	/*
	@PutMapping(path = "/{login}")
	public Passenger update(@PathVariable("login") String login, @RequestBody Passenger passenger, @RequestBody Address address) throws BadHttpRequest {
		if (repository.exists(login)) {
			passenger.setLogin(login);					
			return repository.save(passenger);
		} else {
			throw new BadHttpRequest();
		}
	}
	
	*/
	
	
	
	/*
	@PutMapping(path = "/{id}")
	public Passenger update(@PathVariable("id") Long id, @RequestBody Passenger passenger) throws BadHttpRequest {
		if (repository.exists(id)) {
			passenger.setId(id);
			return repository.save(passenger);
		} else {
			throw new BadHttpRequest();
		}
	}
*/
}
