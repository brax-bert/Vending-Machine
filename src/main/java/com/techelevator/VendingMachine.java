package com.techelevator;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class VendingMachine {

	public static void main(String[] args) {
		String filePath = "log.txt";
		File log = new File(filePath);
		try{
			log.createNewFile();
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		PurchaseLogger logger = new PurchaseLogger(log);
		Inventory inv = new Inventory();
		VendingMachineCLI ui = new VendingMachineCLI(inv);
		ui.mainMenu();
	}
}
