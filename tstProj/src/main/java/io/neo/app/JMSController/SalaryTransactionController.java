package io.neo.app.JMSController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.neo.app.entities.SalaryTransaction;
import io.neo.app.exception.ABCOrgException;


@RestController
@RequestMapping("/salary/transaction")
public class SalaryTransactionController {
	@Autowired
	private JmsTemplate jmsTemplate;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(path="/send", consumes = "application/json", produces = "application/json")
	public ResponseEntity send(@RequestBody SalaryTransaction transaction) throws ABCOrgException {
		System.out.println("Sending........");

		try {
			jmsTemplate.convertAndSend("SalaryTransactionQueue", transaction);
			return new ResponseEntity("Transaction has done.", HttpStatus.OK);
		} catch (Exception e) {
			throw new ABCOrgException("Please strat ActiveMQ Server.");
		}
		
	}
}
