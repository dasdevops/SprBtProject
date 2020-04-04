package io.neo.app.services;

import java.util.List;

import io.neo.app.entities.Transaction;
import io.neo.app.entities.TransactionByAccount;

public interface TransactionService {
	
	public List<Transaction> getAllTransaction();

	public Transaction getTransactionById(Integer tId);

	public Transaction addTransaction(Transaction transaction);
	
	public List<TransactionByAccount> findByTransactionAccountNo(String transactionaccountno);
	
	public List<Transaction> findByTransactionId(Integer transactionid);

}
