/**
 * 
 */
package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Transaction;

/**
 * @author roshankumarm
 *
 */
@Repository
public class TransactioDAOImpl implements TransactionDAO {

	private static final Logger logger = LoggerFactory.getLogger(TransactioDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	/**
	 * 
	 */
	public TransactioDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.TransactionDAO#addTransaction(com.journaldev.spring.model.Transaction)
	 */
	@Override
	public void addTransaction(Transaction p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Transaction saved successfully, Transaction Details="+p);
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.TransactionDAO#updateTransaction(com.journaldev.spring.model.Transaction)
	 */
	@Override
	public void updateTransaction(Transaction p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Transaction updated successfully, Transaction Details="+p);

	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.TransactionDAO#listTransactions()
	 */
	@Override
	public List<Transaction> listTransactions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Transaction> transactionList = session.createQuery("from Transaction").list();
		for(Transaction p : transactionList){
			logger.info("Transaction List::"+p);
		}
		return transactionList;
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.TransactionDAO#getTransactionById(int)
	 */
	@Override
	public Transaction getTransactionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Transaction p = (Transaction) session.load(Transaction.class, new Integer(id));
		logger.info("Transaction loaded successfully, Transaction details="+p);
		return p;
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.TransactionDAO#removeTransaction(int)
	 */
	@Override
	public void removeTransaction(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction p = (Transaction) session.load(Transaction.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);

	}

}
