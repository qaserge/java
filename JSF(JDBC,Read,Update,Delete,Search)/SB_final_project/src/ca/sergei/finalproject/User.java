package ca.sergei.finalproject;

import java.util.Arrays;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class User {

	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String email;
	private String username;
	private String password;	
	private String receiving;
	private String profileType;		
	
	private String  confirmProfile;

	public User() {
	}	

	public User(int id, String firstName, String lastName, String phone, String address, String email, String username,
			String password, String receiving, String profileType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.receiving = receiving;
		this.profileType = profileType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmProfile() {
		return confirmProfile;
	}

	public void setConfirmProfile(String confirmProfile) {
		this.confirmProfile = confirmProfile;
	}	

	public String getReceiving() {
		return receiving;
	}

	public void setReceiving(String receiving) {
		this.receiving = receiving;
	}

	public String getProfileType() {
		return profileType;
	}

	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", receiving=" + receiving + ", profileType=" + profileType + "]";
	}
	
	// Custom Validation method
	public void validateTheCourseCode(FacesContext context, 
									  UIComponent component, 
									  Object value)throws ValidatorException {
		if (value == null) { return; }
		String data = value.toString();
		
		// All usernames must start with IPD17 ... if not, throw exception
		if (!data.startsWith("IPD17")) {
			FacesMessage message = new FacesMessage("All usernames must start with IPD17");
			throw new ValidatorException(message);
		}
	}
	

}
