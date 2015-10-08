package com.journaldev.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Item;
import com.journaldev.spring.model.ItemListContainer;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Transaction;
import com.journaldev.spring.service.ItemService;
import com.journaldev.spring.service.PersonService;
import com.journaldev.spring.service.TransactionService;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {

	private PersonService personService;

	private ItemListContainer getDummyItemListContainer() {
		List<Item> itemList = new ArrayList<Item>();
		for (int i = 0; i < 5; i++) {
			itemList.add(new Item());
		}
		return new ItemListContainer(itemList);
	}

	@Autowired(required = true)
	@Qualifier(value = "personService")
	public void setPersonService(PersonService ps) {
		this.personService = ps;
	}

	private TransactionService transactionService;

	@Autowired(required = true)
	@Qualifier(value = "transactionService")
	public void setTransactionService(TransactionService ps) {
		this.transactionService = ps;
	}

	private ItemService itemService;

	@Autowired(required = true)
	@Qualifier(value = "itemService")
	public void setItemService(ItemService ps) {
		this.itemService = ps;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("itemListContainer", getDummyItemListContainer());
		//model.addAttribute("cp", .getContextPath());
		//testTransaction();
		return "transaction";
	}

	private void testTransaction() {
		// TODO Auto-generated method stub
		Transaction transaction = new Transaction();
		transaction.setArea("Dhanori");
		transaction.setMobile("9552807811");
		transaction.setCreatedDate(new Date());
		transaction.setName("RoshanKumar Mutha");
		transaction.setModifiedDate(new Date());
		transactionService.addTransaction(transaction);
		Item item = new Item();
		item.setName("Sadi");
		item.setPrice(1000);
		item.setCreatedDate(new Date());
		item.setModifiedDate(new Date());
		item.setTransactionRef(transaction.getId());
		Item item2 = new Item();
		item2.setName("Dress");
		item2.setPrice(2500);
		item2.setCreatedDate(new Date());
		item2.setModifiedDate(new Date());
		item2.setTransactionRef(transaction.getId());
		itemService.addItem(item);
		itemService.addItem(item2);
	}

	// For add and update person both
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p) {

		if (p.getId() == 0) {
			// new person, add it
			this.personService.addPerson(p);
		} else {
			// existing person, call update
			this.personService.updatePerson(p);
		}

		return "redirect:/persons";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.personService.removePerson(id);
		return "redirect:/persons";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

}
