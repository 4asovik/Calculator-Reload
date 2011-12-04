/* 
 * Calculator is the main class of a program
 * It creates menus and menu items and than run main menu
 */
package com.luxoft.train.AnotherCalculator;

public class Calculator {

	// help to run menu item by enter it's title
	private static MenuSelector selector = new MenuSelector();
    
	// block of menu items which define math and other operations  
	private static MenuItem manualEnter = new MenuItem("Enter the operation " +
    		"manually.", false, selector);

	private static MenuItem opPlus = new MenuItem("+", new Operation(2) {
    	// This method use to run selected menu item 
        public void run() {
        	readOperands();
        	showResult(operands[0] + operands[1], "+");
        }
    });
 
    private static MenuItem opMinus = new MenuItem("-", new Operation(2) {
        public void run() {
        	readOperands();
        	showResult(operands[0] - operands[1], "-");
        }
    });

    private static MenuItem opMult = new MenuItem("*", new Operation(2) {
        public void run() {
        	readOperands();
        	showResult(operands[0] * operands[1], "*");
        }
    });

    private static MenuItem opDiv = new MenuItem("/", new Operation(2) {
        public void run() {
        	readOperands();
        	showResult(operands[0] / operands[1], "/");
        }
    });
    
    private static MenuItem opSqrt = new MenuItem("sqrt", new Operation(1) {
        public void run() {
        	readOperands();
        	showResult(Math.sqrt(operands[0]), "sqrt");
        }
    });
    
    private static MenuItem opPow = new MenuItem("pow", new Operation(2) {
        public void run() {
        	readOperands();
        	showResult(Math.pow(operands[0], operands[1]), "pow");
        }
    });
    
    private static MenuItem opSin = new MenuItem("sin", new Operation(1) {
        public void run() {
        	readOperands();
        	showResult(Math.sin(operands[0]), "sin");
        }
    });
    
    private static MenuItem opCos = new MenuItem("cos", new Operation(1) {
        public void run() {
        	readOperands();
        	showResult(Math.cos(operands[0]), "cos");
        }
    });

    private static MenuItem opTg = new MenuItem("tg", new Operation(1) {
        public void run() {
        	readOperands();
        	showResult(Math.tan(operands[0]), "tg");
        }
    });

    private static MenuItem opCtg = new MenuItem("ctg", new Operation(1) {
        public void run() {
        	readOperands();
        	showResult(1.0 / Math.tan(operands[0]), "ctg");
        }
    });
    
    // menu with math operations
    private static Menu operationMenu= new Menu("Choose an operation from the" +
    		" list.", "Choose one of the following operations:", true, false, 
    		opPlus, opMinus, opMult, opDiv, opSqrt, opPow,opSin, opCos, opTg, 
    		opCtg);
    // main menu
    private static Menu topMenu= new Menu("top menu", "What would you like to" +
    		" do (enter the number)?:", false, true, operationMenu, manualEnter);

    public static void main(String[] args) {
 		System.out.println("Hello! I’m a Java:Reload calc.");
 		
    	// set menu to manual enter the operation
 		selector.setMainMenu(operationMenu);
 		// run main menu
    	topMenu.run();
	}
}
