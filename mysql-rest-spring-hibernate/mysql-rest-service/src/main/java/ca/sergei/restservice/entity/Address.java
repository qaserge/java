package ca.sergei.restservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "address")
public class Address {

	private long id;
	private String number;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	 
	private Set<Passenger> passenger ;
	
	public Address() {
		super();
	}
	
	
	
	public Address(long id, String number, String streetAddress, String city, String state, String country,
			String zipcode, Set<Passenger> passenger) {
		super();
		this.id = id;
		this.number = number;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.passenger = passenger;
	}


	@JsonIgnore
	@OneToMany(mappedBy="address",cascade = CascadeType.ALL)	  
	public Set<Passenger> getPassenger() {
		return passenger;
	}



	public void setPassenger(Set<Passenger> passenger) {
		this.passenger = passenger;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "number", nullable = false)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name = "street_address", nullable = false)
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "state", nullable = false)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name = "country", nullable = false)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name = "zip_code", nullable = false)
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
 
