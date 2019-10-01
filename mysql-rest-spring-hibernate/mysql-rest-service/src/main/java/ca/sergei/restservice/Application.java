package ca.sergei.restservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ca.sergei.restservice.entity.Passenger;
import ca.sergei.restservice.repository.PassengerRepository;



import ca.sergei.restservice.entity.MyEnum;
import ca.sergei.restservice.entity.Address;
import ca.sergei.restservice.entity.Flight;
import ca.sergei.restservice.repository.AddressRepository;
import ca.sergei.restservice.repository.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Calendar;
import java.util.Date;



@SpringBootApplication
public class Application  {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}		
	
	@Bean
	protected CommandLineRunner init(final PassengerRepository passengerRepository) {
		return args -> {				        
	        Passenger passenger = new Passenger (Long.valueOf("1"), "admin", "admin", "AdminName", "AdminFamily", new Date(), "admin@email.ca", "514-111-1111", null, 
	        		new Address(1, "1A", "1e Avenue", "Montreal", "QC", "Canada", "A1A1A1", null), null, "M");  
	        passengerRepository.save(passenger);
		};		
	}
}
