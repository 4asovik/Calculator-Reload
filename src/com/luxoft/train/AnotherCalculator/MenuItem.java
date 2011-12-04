/*
 * The MenuItem class stores one item from menu
 * and runnable object is needed to run
 * when user will select this menu item  
 */
package com.luxoft.train.AnotherCalculator;

public class MenuItem implements Runnable {

    private String title;
    private Runnable action;
    // is we need to print prompt before action
    private boolean needPrintPrompt;
 
    public MenuItem(String title) { 
    	this(title, false, null); 
    }

    public MenuItem(String title, Runnable action) {
    	this(title, true, action); 
    	
    }
    		
    public MenuItem(String title, boolean needPrintPrompt, Runnable action) {
        this.title = title;
        this.action = action;
        this.needPrintPrompt = needPrintPrompt;
   }
     
    public String getTitle() { 
    	return title; 
    }
     
    public boolean hasAction() { 
    	return action != null; 
    }
     
    protected void setAction(Runnable action) { 
    	this.action= action; 
    }

    // run action object
    public void run() {
    	if (needPrintPrompt) {
    		System.out.println("Operation is “" + title + "”");
    	}

    	try {
        	action.run();
        }
        catch (Throwable e) {
            e.printStackTrace(System.err);
        }
    	System.out.println("");    	
    }
}