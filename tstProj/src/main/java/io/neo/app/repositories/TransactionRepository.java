package io.neo.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.neo.app.entities.Transaction;
import java.lang.String;
import java.util.List;
import java.lang.Integer;


	@RepositoryRestResource(collectionResourceRel = "transaction", path = "transaction")
	public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

		public Transaction findOne(Integer tId);
		
		public List<Transaction> findByTransactionAccountNo(String transactionaccountno);
		
		public List<Transaction> findByTransactionId(Integer transactionid);

	}

