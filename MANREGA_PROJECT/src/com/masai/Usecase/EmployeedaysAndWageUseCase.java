package com.masai.Usecase;

import java.util.List;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class EmployeedaysAndWageUseCase {
	
	public static void employeedaysAndWage() {
		
		
		GPMInterface dao = new GpmDaoImpl();
		
		try {
			List<Employee_Wage_Oper> empWage =  dao.employeedaysAndWage();
			
			
			System.out.println("---------------------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee, Wage, days, Total Amount" + ConsoleColors.RESET+ "-------------------------------------");
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			
			System.out.printf("%7s %10s %11s %17s %22s %17s %13s %21s",ConsoleColors.BLACK_BOLD + "EID", "ENAME", "PID", "PNAME", "DATE_JOINED", "TOTAL DAYS", "WAGE/DAY", "TOTAL_AMOUNT" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("-------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println();
			for(Employee_Wage_Oper e : empWage) {
				
				System.out.format("%2s %12s %9s %22s %17s %14s %14s %18s",e.getEid(),e.getName(), e.getProjectID(),e.getProjectName(),e.getDate_joined(),e.getNoOfDays(),e.getWage(),e.getTotalAmount());
				System.out.println();
			}
			
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			
			
			
			
			
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
		
		
	}

}
