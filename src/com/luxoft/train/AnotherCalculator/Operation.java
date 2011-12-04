/*
 * The MenuItem class is an abstraction of
 * some operation with operands. It's abstract
 * and it needs to be clarified by specific operation   
 */
package com.luxoft.train.AnotherCalculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class Operation implements Runnable{
	// string constants to make prompts
	final String queryOperand1p = "Please, enter the ";
	final String queryOperand2p = "operand: ";
	final String[] operandNumbers = {"first ", "second "};
	
	// count of operands of current operation
	int operandsCount;
	// operands of current operation
	Double[] operands;
	
	public Operation(int operandsCount) throws IndexOutOfBoundsException {
		if (operandsCount < 1) {
			throw new IndexOutOfBoundsException("Count of operands cannot be " +
					"less than 1");
		}
		if (operandNumbers.length < operandsCount)
			throw new IndexOutOfBoundsException("Count of operands is more " +
					"than size of operandNumbers");
		
		this.operandsCount = operandsCount;
		this.operands = new Double[operandsCount];
	}
	
	// reading number from console until the number will be entered correctly
	public Double readOperand(String invite) {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		boolean enterFinished = false;
		Double answer = 0.0;

		while (!enterFinished) { 
			try {
				System.out.println(invite);
				System.out.print("> ");
				answer = Double.parseDouble(br.readLine());
				enterFinished = true;
			} catch (Exception e) {
				System.err.println("You have entered wrong number. Try again.");
				System.err.flush();
			}
		}
		return answer;
	}
	
	// get all operands for this operation from user
	public void readOperands() {
		// prompts for one and many operands are different
		if (operandsCount == 1) {
			operands[0]=readOperand(queryOperand1p+queryOperand2p);
		} else if (operandsCount > 1) {
			for (int i=0; i<operandsCount; i++) {
				String queryString = queryOperand1p + operandNumbers[i] + 
					queryOperand2p;
				operands[i] = readOperand(queryString);
			}
		// count of operand cannot be less then 1 
		} else {
			System.err.println("Wrong number of operands");
			System.err.flush();
		}
	}
	
	// print result of operation to console
	public void showResult(Double res, String operation) {
		// format for one and many operands are different
    	switch (operandsCount) {
    		case 1:
    			System.out.printf("%s(%g)=%g", operation, operands[0], res);
    			break;
    		case 2:
    			System.out.printf("%g %s %g=%g", operands[0], operation, 
    					operands[1], res);
    			break;
    		// other formats are not implemented yet
    		default:
    			System.err.println("Incorrect count of operands.");
    			break;
    	}
	}
}
