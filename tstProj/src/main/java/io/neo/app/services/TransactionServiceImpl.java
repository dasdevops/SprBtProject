package io.neo.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.neo.app.dao.TransactionDao;
import io.neo.app.entities.Transaction;
import io.neo.app.entities.TransactionByAccount;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionDao transactionDao;
	
	public List<Transaction> getAllTransaction(){
		return (List<Transaction>) transactionDao.getAllTransaction();
	}

	@Override
	public Transaction getTransactionById(Integer tId) {
		return transactionDao.getTransactionByID(tId);
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionDao.addTransaction(transaction);
	}

	@Override
	public List<TransactionByAccount> findByTransactionAccountNo(String transactionaccountno) {
		
		List<Transaction> lcAc = transactionDao.findByTransactionAccountNo(transactionaccountno);
		
		List<TransactionByAccount> lsTrAc = new ArrayList<>();
		
		lcAc.stream().forEach(trAc -> {
			TransactionByAccount lsTr = new TransactionByAccount();
			lsTr.setTransactionId(trAc.getTransactionId());
			lsTr.setEmployeeName(trAc.getEmployee().getFirstName()+" "+trAc.getEmployee().getLastName());
			lsTr.setTransactionAccountNo(trAc.getTransactionAccountNo());
			lsTr.setTransactionByBank(trAc.getTransactionByBank().getBankName()+" - "+trAc.getTransactionByBank().getBankCountry());
			lsTr.setAmount(trAc.getAmount());
			lsTr.setTransactionType(trAc.getTransactionType());
			lsTrAc.add(lsTr);
		});		
		return lsTrAc;
	}

	@Override
	public List<Transaction> findByTransactionId(Integer transactionid) {
		
		return transactionDao.findByTransactionId(transactionid);
	}
	
	

}
