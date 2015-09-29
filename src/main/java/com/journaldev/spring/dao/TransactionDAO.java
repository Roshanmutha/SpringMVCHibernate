package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Transaction;

public interface TransactionDAO {

	public void addTransaction(Transaction p);

	public void updateTransaction(Transaction p);

	public List<Transaction> listTransactions();

	public Transaction getTransactionById(int id);

	public void removeTransaction(int id);
	
	
}
