package com.journaldev.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.TransactionDAO;
import com.journaldev.spring.model.Transaction;

public class TransactionServiceImpl implements TransactionService {
	
	private TransactionDAO transactionDAO;

	public void setTransactionDAO(TransactionDAO TransactionDAO) {
		this.transactionDAO = TransactionDAO;
	}

	@Override
	@Transactional
	public void addTransaction(Transaction p) {
		this.transactionDAO.addTransaction(p);
	}

	@Override
	@Transactional
	public void updateTransaction(Transaction p) {
		this.transactionDAO.updateTransaction(p);
	}

	@Override
	@Transactional
	public List<Transaction> listTransactions() {
		return this.transactionDAO.listTransactions();
	}

	@Override
	@Transactional
	public Transaction getTransactionById(int id) {
		return this.transactionDAO.getTransactionById(id);
	}

	@Override
	@Transactional
	public void removeTransaction(int id) {
		this.transactionDAO.removeTransaction(id);
	}

}
