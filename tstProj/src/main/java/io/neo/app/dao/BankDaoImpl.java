package io.neo.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.neo.app.entities.Bank;
import io.neo.app.repositories.BankRepository;

@Component
public class BankDaoImpl implements BankDao {
	
	@Autowired
	private BankRepository bankRepository;
	
	public List<Bank> getAllBanks(){
		return (List<Bank>) bankRepository.findAll();
	}

	@Override
	public Bank getBankById(int bId) {
			return bankRepository.findOne(bId);
		
	}

	@Override
	public Bank addBank(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public List<Bank> findByBankCountry(String bankcountry) {
		
		return bankRepository.findByBankCountry(bankcountry);
	}

	@Override
	public List<Bank> findByBankName(String bankcountry) {
		return bankRepository.findByBankName(bankcountry);
	}

	@Override
	public List<Bank> findByBankId(Integer bankid) {
		return bankRepository.findByBankId(bankid);
	}
	
	
	
	
	


}
