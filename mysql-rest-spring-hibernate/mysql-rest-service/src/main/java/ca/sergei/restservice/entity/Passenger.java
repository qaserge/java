package ca.sergei.restservice.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "passenger")

public class Passenger {

	private long id;
	private String login;
	private String password;
	private String name;
	private String family;
	private Date birthdate;
	private String email;
	private String phone;
	private Payment payment;
	private Address address;
	private Set<Flight> flightList;
	private String gender;

	public Passenger() {

	}

	public Passenger(long id, String login, String password, String name, String family, Date birthdate, String email, String phone, Payment payment,
			Address address, Set<Flight> flightList, String gender) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.family = family;
		this.birthdate = birthdate;
		this.email = email;
		this.phone = phone;
		this.payment = payment;
		this.address = address;
		this.flightList = flightList;
		this.gender = gender;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Column(name = "login", nullable = false)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "family", nullable = false)
	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birthdate", nullable = false)
	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "passenger_flight", joinColumns = {
			@JoinColumn(name = "passenger_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "flight_id", referencedColumnName = "id") })
	public Set<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(Set<Flight> flightList) {
		this.flightList = flightList;
	}

}
