package com.luxoft.train.AnotherCalculator;

public class MenuItem implements Runnable {
     
    private String title;
    private String mnemonic;
    private Runnable action;
 
    public MenuItem(String title) { this(title, null, null); }
    
    public MenuItem(String title, String mnemonic, Runnable exec) {
        this.title = title;
        this.action = exec;
        this.mnemonic = mnemonic; 
    }
     
    public String getTitle() { return title; }
     
    public boolean hasAction() { return action != null; }
     
    protected void setAction(Runnable action) { this.action= action; }
     
    public void run() {
        try {
        	action.run();
        }
        catch (Throwable t) {
            t.printStackTrace(System.err);
        }
    }
}