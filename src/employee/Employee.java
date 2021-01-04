package employee;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Employee {
	public static void main(String[] args) {
		
		String name; // employee name // 
		int hrsWorked; // number of hours worked // 
		int overtimeHrs; // overtime hours // 
		int overtimeHrs2; // second overtime // 
		int dependents; //  number of dependent // 
		double pay = 17.25; // normal pay 40 or below // 
		double overtimePay = 12.34; // overtime pay over 40 but less than or equal 60 // 
		double overtimePay2 = 14.34; // overtime pay over 60 but less than 80 // 
		double overtimePay3 = 16.00; // overtime pay over 80 
		double grossPay; // gross before withheld // 
		double federalWithheld = 0.14; // federal withheld // 
		double stateWithheld = 0.05; // state withheld // 
		double netPay; // net pay // 
		int coverage = 80; // insurance for worker and 2 dependents // 
		int coverage2 = 0;
		double amountHeldState; // amount took from state taxes // 
		double amountHeldFederal; // amount took from federal taxes // 
		
	System.out.println("Net PayCheck Calculator");
	
	
	
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter employee name.");

		    name = myObj.nextLine();  // Read user input
		
			Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter number of hours worked");

		    hrsWorked = myObj1.nextInt();  // Read user input
		    
			Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter number of dependents");

		    dependents = myObj2.nextInt();  // Read user input
		    
	// calculate pay based on the number of hours worked in one week // 
		    
			if (hrsWorked <= 40) // 40 hours or below // 
			{
				System.out.println("Regular Hours");
				
				overtimeHrs = 0;
				grossPay = hrsWorked * pay; // gross pay // 
				amountHeldState = grossPay * stateWithheld; 
				amountHeldFederal = grossPay * federalWithheld;
				netPay = grossPay - (federalWithheld + stateWithheld); // net pay // 
				
				
			}
			else if (hrsWorked > 40 && hrsWorked <= 60) // over 40 hours but less than 60 hours // 
			{
				System.out.println("Overtime");
				
				overtimeHrs = hrsWorked - 40;
				grossPay = (40 * pay) + (overtimePay * overtimeHrs);
				amountHeldState = grossPay * stateWithheld; 
				amountHeldFederal = grossPay * federalWithheld;
				netPay = grossPay - (amountHeldState + amountHeldFederal); 
			}
			else if (hrsWorked > 60 && hrsWorked < 80) // over 60 hours but less than 80 hours // 
			{
				System.out.println("Overtime 2");
				
				overtimeHrs2 = hrsWorked - 60;
				overtimeHrs = hrsWorked - 40;
				overtimeHrs = overtimeHrs - overtimeHrs2;
				grossPay = (40 * pay) + (overtimePay * overtimeHrs) + (overtimePay2 * overtimeHrs2); // gross pay // 
				amountHeldState = grossPay * stateWithheld; 
				amountHeldFederal = grossPay * federalWithheld;
				netPay = grossPay - (amountHeldState + amountHeldFederal); // net pay // 
			}
			else 
			{
				System.out.println("Overtime 3"); // over 80 hours //
				
				overtimeHrs = hrsWorked - 40;
				grossPay = (40 * pay) + (overtimePay3 * overtimeHrs); // gross pay // 
				amountHeldState = grossPay * stateWithheld; 
				amountHeldFederal = grossPay * federalWithheld;
				netPay = grossPay - (amountHeldState + amountHeldFederal);  // net pay // 
			}
			
			// decide coverage amount based on number of dependents // 
			
				if (dependents <= 2) {
					coverage2 = 0;
					netPay = netPay - coverage;
				}
				else if (dependents > 2 ) {
					coverage2 = 25 * (dependents - 2);
					netPay = netPay - (coverage + coverage2);
				}
					
					
			
			// set number to two decimal places // 

			String grosspay = String.format("%.2f", grossPay);
			String statetax = String.format("%.2f", amountHeldState);
			String federaltax = String.format("%.2f", amountHeldFederal);
			String net = String.format("%.2f", netPay);
			
		    // display information on screen // 
			
			System.out.println("----------------------------------------------------------------");
			
			System.out.println("Employee: " + name);
			System.out.println("Hours Worked: " + hrsWorked);
			System.out.println("Number of Dependents: " + dependents);
			System.out.println("Overtime Hours: " + overtimeHrs);
			System.out.println("Gross Income:" + grosspay);
			System.out.println("State Tax Withheld @ 5%: " + statetax);
			System.out.println("Federal Tax Withheld @ 14%: " + federaltax);
			System.out.println("Workers and Two Dependents Insurrance: " + coverage);
			System.out.println("Additional dependents Insurrance: "+ coverage2);
			
			System.out.println("----------------------------------------------------------------");
			System.out.println("Net Pay: " + net);

	
	
	}
}
