package io.neo.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.neo.app.entities.Bank;
import java.lang.String;
import java.util.List;
import java.lang.Integer;

@RepositoryRestResource(collectionResourceRel = "bank", path = "bank")
public interface BankRepository extends JpaRepository<Bank, Integer> {

	Bank findOne(int bId);
		
	List<Bank> findByBankCountry(String bankcountry);
	
	List<Bank> findByBankName(String bankcountry);
	
	List<Bank> findByBankId(Integer bankid);

}
