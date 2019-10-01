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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight")
public class Flight {

	private long id;
	private String fromCity;
	private Date departureDate;
	private String departureTime;
	private String toCity;
	private Date destinationDate;
	private String destinationTime;
	private Set<Passenger> passengers;

	public Flight() {

	}

	

	public Flight(long id, String fromCity, Date departureDate, String departureTime, String toCity,
			Date destinationDate, String destinationTime, Set<Passenger> passengers) {
		super();
		this.id = id;
		this.fromCity = fromCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.toCity = toCity;
		this.destinationDate = destinationDate;
		this.destinationTime = destinationTime;
		this.passengers = passengers;
	}


	@JsonFormat(pattern="HH:mm:ss")
	@Column(name = "departure_time", nullable = false)
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	@JsonFormat(pattern="HH:mm:ss")
	@Column(name = "destination_time", nullable = false)
	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

	@Column(name = "from_city")
	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	@Column(name = "to_city")
	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "departure_date", nullable = false)
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "destination_date", nullable = false)
	public Date getDestinationDate() {
		return destinationDate;
	}

	public void setDestinationDate(Date destinationDate) {
		this.destinationDate = destinationDate;
	}
	
	@JsonIgnore
	 @ManyToMany(fetch = FetchType.LAZY,
	            mappedBy = "flightList",  cascade = {CascadeType.ALL})
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

}
