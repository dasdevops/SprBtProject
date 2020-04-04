package io.neo.app.dao;

import java.util.List;

import io.neo.app.entities.Transaction;

public interface TransactionDao {
	
	public List<Transaction> getAllTransaction();

	public Transaction getTransactionByID(Integer tId);

	public Transaction addTransaction(Transaction transaction);
	
	public List<Transaction> findByTransactionAccountNo(String transactionaccountno);
	
	public List<Transaction> findByTransactionId(Integer transactionid);


}
