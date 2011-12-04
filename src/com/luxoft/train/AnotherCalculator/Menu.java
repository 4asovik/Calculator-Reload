/*
 * The Menu class stores menu attributes and items
 * It extends MenuItem class to makes it easy to embed
 * one menu into another through the same interface  
 */
package com.luxoft.train.AnotherCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Menu extends MenuItem {
    
	String prompt; //prompt before displaying menu 
	
    // menu item to exit from the program
	private static final MenuItem exit= new MenuItem("Exit", false, new Runnable() {
    	// This method use to run selected menu item 
        public void run() {
    		System.out.println("Thanks for using Java:Reload calc!");
            System.exit(0);
        }
    });
	// menu item to go back to previous menu 
    private static final MenuItem back= new MenuItem("Back");
    // all items of this menu
    private List<MenuItem> items;
 
    public Menu(String title, String prompt, boolean addBack, boolean addQuit, 
    		MenuItem ... items) {
        super(title);
        setAction(this);
        this.prompt = prompt;
        initialize(addBack, addQuit, items);
    }

    public MenuItem getItemByTitle(String title) {
        for (MenuItem item : items) {
        	if (title.equals(item.getTitle())) {
        		return item;
        	}
        }
        return null;
    }
    
    // fill the array by menu items
    private void initialize(boolean addBack, boolean addQuit, MenuItem ... items) {
        this.items= new ArrayList<MenuItem>(Arrays.asList(items));
        if (addBack) this.items.add(back);
        if (addQuit) this.items.add(exit);
    }
    
    // display menu
    private void display() {
        int option= 0;
        System.out.println(prompt);
        for (MenuItem item : items) {
            System.out.println((++option) + ". " + item.getTitle());
        }
        System.out.print("> ");
    }

    // display menu, prompt for user choice and return selected menu item
    private MenuItem prompt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        while (true) {
            display();

            answer = br.readLine();
            try {
                int option = Integer.parseInt(answer) - 1;
                if (option >= 0 && option < items.size())
                    return items.get(option);
            }
            catch (NumberFormatException e) { 
            	System.err.println("Not a valid menu option: " + answer);
            	System.err.flush();
            }
        } 
    }

    // prompting a user and executing his command while he select actions 
    public void run() {
        try {
            for (MenuItem item = prompt(); item.hasAction(); item = prompt()) {
                item.run();
            }
        }
        catch (Throwable t) {
            t.printStackTrace(System.out);
        }
    }
}