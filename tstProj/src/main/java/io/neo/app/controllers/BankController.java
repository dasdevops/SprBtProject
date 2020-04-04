package io.neo.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import io.neo.app.entities.Bank;
import io.neo.app.exception.EntityExistsException;
import io.neo.app.exception.IdNotFoundException;
import io.neo.app.exception.ABCOrgException;
import io.neo.app.services.BankService;

@RestController
public class BankController {

	@Autowired
	private BankService bankService;

	@RequestMapping(method = RequestMethod.GET, value = "/banks", produces = "application/json")
	public ResponseEntity<Object> getAllBanks() throws ABCOrgException {

		List<Bank> lstBanks = bankService.getAllBanks();

		if (lstBanks.isEmpty()) {
			throw new ABCOrgException("There is no list of banks.");
		}
		return new ResponseEntity<>(lstBanks, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/banks/{id}", produces = "application/json")
	public ResponseEntity<Object> getBankById(@PathVariable("id") int bId)
			throws IdNotFoundException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException {

		try {
			if (bankService.findByBankId(bId).size() > 0) {
				Bank bnk = bankService.getBankById(bId);
				return new ResponseEntity<>(bnk, HttpStatus.OK);
			} else {
				throw new IdNotFoundException(bId);
			}

		} catch (HttpMessageNotWritableException e) {
			throw new HttpMessageNotWritableException(e.getMessage());
		} catch (MethodArgumentTypeMismatchException e) {
			throw new MethodArgumentTypeMismatchException(e.getValue(), e.getRequiredType(), e.getName(),
					e.getParameter(), e.getCause());
		} 
//		catch (Exception e) {
//			return new ResponseEntity<>("Request is not valid.", HttpStatus.BAD_REQUEST);
//		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/bank", consumes = "application/json")
	public ResponseEntity<Object> addBank(@Valid @RequestBody Bank bank)
			throws EntityExistsException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException {

		try {
			if (bankService.findByBankCountry(bank.getBankCountry()).size() > 0
					&& bankService.findByBankName(bank.getBankName()).size() > 0
					|| bankService.findByBankId(bank.getBankId()).size() > 0) {

				throw new EntityExistsException("Bank is already exist in the list.");

			} else {
				bankService.addBank(bank);
				return new ResponseEntity<>("Bank is created.", HttpStatus.CREATED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Bank is not created.", HttpStatus.BAD_REQUEST);
		}
	}

}
