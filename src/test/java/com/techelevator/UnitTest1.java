package com.techelevator;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest1 {


	@Test
	public void testIsValidSelectionFalse() {
		Inventory inventory = new Inventory();
		boolean expected = false;
		boolean actual = inventory.isValidSelection("Z1");

		assertEquals(expected, actual);
	}
	@Test
	public void testIsValidSelectionTrue() {
		Inventory inventory = new Inventory();
		boolean expected = true;
		boolean actual = inventory.isValidSelection("A1");

		assertEquals(expected, actual);
	}
	@Test
	public void testAdd1() {
		TransactionHandler handler = new TransactionHandler();
		handler.add1();
		BigDecimal expected = new BigDecimal(1);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}
	@Test
	public void testAdd5() {
		TransactionHandler handler = new TransactionHandler();
		handler.add5();
		BigDecimal expected = new BigDecimal(5);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}
	@Test
	public void testAdd10() {
		TransactionHandler handler = new TransactionHandler();
		handler.add10();
		BigDecimal expected = new BigDecimal(10);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}

	@Test
	public void testPayForItem() {
		TransactionHandler handler = new TransactionHandler();
		BigDecimal price = new BigDecimal(2.25);
		BigDecimal expected = new BigDecimal(2.75);
		handler.add5();
		handler.payForItem(price);
		BigDecimal actual = handler.getBalance();

		assertEquals(expected, actual);
	}

	@Test
	public void testHaveEnoughMoneyTrue() {
		TransactionHandler handler = new TransactionHandler();
		BigDecimal price = new BigDecimal(4.00);
		handler.add5();
		boolean expected = true;
		boolean actual = handler.haveEnoughMoney(price);

		assertEquals(expected, actual);
	}

}
