package io.neo.app.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name="account_no")
	private Integer account_no;
	
	@Column(name="account_holder")
	private String account_holder;
	
	@Enumerated(EnumType.STRING)
	private AccountType account_type;
	
	@Enumerated(EnumType.STRING)
	private AccountMode account_mode;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_employee", joinColumns = @JoinColumn(name = "account_no", referencedColumnName = "account_no"), 
    inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"))
    private Set<Employee> employees = new HashSet<>();

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "account_bank", joinColumns = @JoinColumn(name = "account_no", referencedColumnName = "account_no"), 
    inverseJoinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "bank_id"))
    private Set<Bank> banks = new HashSet<>();
	
	
	public Account() {
		super();
	}



	public Account(Integer account_no, String account_holder, AccountType account_type, AccountMode account_mode,
			Set<Employee> employees, Set<Bank> banks) {
		super();
		this.account_no = account_no;
		this.account_holder = account_holder;
		this.account_type = account_type;
		this.account_mode = account_mode;
		this.banks = banks;
		this.employees = employees;
	}



	public Integer getAccount_no() {
		return account_no;
	}



	public void setAccount_no(Integer account_no) {
		this.account_no = account_no;
	}



	public String getAccount_holder() {
		return account_holder;
	}



	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}



	public AccountType getAccount_type() {
		return account_type;
	}



	public void setAccount_type(AccountType account_type) {
		this.account_type = account_type;
	}



	public AccountMode getAccount_mode() {
		return account_mode;
	}



	public void setAccount_mode(AccountMode account_mode) {
		this.account_mode = account_mode;
	}



	public Set<Bank> getBanks() {
		return banks;
	}



	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}



	public Set<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
