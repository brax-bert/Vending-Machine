package com.techelevator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.math.BigDecimal;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest1 {


	@Test
	public void testIsValidSelectionFalse() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		Inventory inventory = new Inventory(logger);
		boolean expected = false;
		boolean actual = inventory.isValidSelection("Z1");

		assertEquals(expected, actual);
	}
	@Test
	public void testIsValidSelectionTrue() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		Inventory inventory = new Inventory(logger);
		boolean expected = true;
		boolean actual = inventory.isValidSelection("A1");

		assertEquals(expected, actual);
	}
	@Test
	public void testAdd1() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		TransactionHandler handler = new TransactionHandler(logger);
		handler.add1();
		BigDecimal expected = new BigDecimal(1);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}
	@Test
	public void testAdd5() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		TransactionHandler handler = new TransactionHandler(logger);
		handler.add5();
		BigDecimal expected = new BigDecimal(5);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}
	@Test
	public void testAdd10() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		TransactionHandler handler = new TransactionHandler(logger);
		handler.add10();
		BigDecimal expected = new BigDecimal(10);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}

	@Test
	public void testPayForItem() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		TransactionHandler handler = new TransactionHandler(logger);
		BigDecimal price = new BigDecimal(2.25);
		BigDecimal expected = new BigDecimal(2.75);
		handler.add5();
		handler.payForItem(price);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}

	@Test
	public void testHaveEnoughMoneyTrue() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		TransactionHandler handler = new TransactionHandler(logger);
		BigDecimal price = new BigDecimal(4.00);
		handler.add5();
		boolean expected = true;
		boolean actual = handler.haveEnoughMoney(price);

		assertEquals(expected, actual);
	}
	@Test
	public void testHaveEnoughMoneyFalse() {
		File file = new File("test.txt");
		PurchaseLogger logger = new PurchaseLogger(file);
		TransactionHandler handler = new TransactionHandler(logger);
		BigDecimal price = new BigDecimal(4.00);
		handler.add1();
		boolean expected = false;
		boolean actual = handler.haveEnoughMoney(price);

		assertEquals(expected, actual);
	}

}
