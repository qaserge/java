package ca.sergei.restservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

enum CardType {
	Visa, MasterCard
}

@Entity
@Table(name = "payment")
public class Payment {
	private long id;
	private String cardNumber;
	private String cardType;

	public Payment() {
	}		

	public Payment(long id, String cardNumber, String cardType) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "card_number", nullable = false)
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Column(name = "card_type", nullable = false)
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
