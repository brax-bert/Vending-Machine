package com.techelevator;

import java.util.Map;

public class VendingMachine {

	public static void main(String[] args) {
		Inventory inv = new Inventory();

		VendingMachineCLI ui = new VendingMachineCLI(inv);
		ui.mainMenu();
	}
}
