package io.neo.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {
	
	@Id
	@GeneratedValue
	@Column(name="bank_id")
	private Integer bankId;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="bank_country")
	private String bankCountry;

	
	public Bank() {
		super();
	}



	public Bank(String bName, String bankCountry) {
		super();
		this.bankName = bName;
		this.bankCountry = bankCountry;
	}


	public String getBankCountry() {
		return bankCountry;
	}

	public void setBankCountry(String bankCountry) {
		this.bankCountry = bankCountry;
	}

	public Integer getBankId() {
		return bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	




}
