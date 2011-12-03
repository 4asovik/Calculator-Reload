package com.luxoft.train.AnotherCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Menu extends MenuItem {
     
    private static final MenuItem exit= new MenuItem("Exit", null, new Runnable() {
        public void run() {
    		System.out.println("Thanks for using Java:Reload calc!");
            System.exit(0);
        }
    });
     
    private static final MenuItem back= new MenuItem("Back");
    List<MenuItem> items;
 
    public Menu(String title, MenuItem ... items) { this(title, false, true, items); }
 
    public Menu(String title, boolean addBack, boolean addQuit, MenuItem ... items) {
        super(title);
        setAction(this);
 
        initialize(addBack, addQuit, items);
    }
     
    private void initialize(boolean addBack, boolean addQuit, MenuItem ... items) {
        this.items= new ArrayList<MenuItem>(Arrays.asList(items));
        if (addBack) this.items.add(back);
        if (addQuit) this.items.add(exit);
    }
     
    private void display() {
        int option= 0;
        System.out.println(getTitle());
        for (MenuItem item : items) {
            System.out.println((option++) + ". " + item.getTitle());
        }
        System.out.print(">");
    }
     
    private MenuItem prompt() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        while (true) {
            display();
         
            answer = br.readLine();
            try {
                int option = Integer.parseInt(answer);
                if (option >= 0 && option < items.size())
                    return items.get(option);
            }
            catch (NumberFormatException e) { }
            System.out.println("not a valid menu option: " + answer);
        } 
    }
     
    public void run() {
     
        try {
            for (MenuItem item = prompt(); item.hasAction(); item = prompt())
                item.run();
        }
        catch (Throwable t) {
            t.printStackTrace(System.out);
        }
    }
}