
package io.neo.app.services;

import java.util.List;


import io.neo.app.entities.Bank;


public interface BankService {
		
	public List<Bank> getAllBanks();

	public Bank getBankById(int bId);

	public Bank addBank(Bank bank);
	
	public List<Bank> findByBankCountry(String bankcountry);
	
	public List<Bank> findByBankName(String bankcountry);
	
	public List<Bank> findByBankId(Integer bankid);

}
