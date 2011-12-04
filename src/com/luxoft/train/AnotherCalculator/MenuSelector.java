/* 
 * MenuSelector is the action which helps
 * to select menu item by entering it's title
 */
package com.luxoft.train.AnotherCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuSelector implements Runnable {
	// menu from which we need to make a choice
	Menu mainMenu = null;
	
	// get user input from the console
	private static String getUserAnswer() throws IOException  {
		System.out.print("> ");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		return br.readLine();		
	}

	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}
	
	// get user select and run selected menu item
	@Override
	public void run() {
		System.out.println("Enter the operation:");
		while (true) {
			try {
				String answer = getUserAnswer();
				MenuItem item = mainMenu.getItemByTitle(answer);
				item.run();
				return;
			} catch (Exception e) {
				System.err.println("You have entered wrong operator. Try again.");
				System.err.flush();
			}
		}
	}

}
