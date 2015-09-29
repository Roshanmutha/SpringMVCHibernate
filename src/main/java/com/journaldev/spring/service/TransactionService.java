package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Transaction;

public interface TransactionService {




	public void addTransaction(Transaction p);
	public void updateTransaction(Transaction p);
	public List<Transaction> listTransactions();
	public Transaction getTransactionById(int id);
	public void removeTransaction(int id);
	


}
