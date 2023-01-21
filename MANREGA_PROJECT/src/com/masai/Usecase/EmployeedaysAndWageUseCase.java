package com.masai.Usecase;

import java.util.List;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class EmployeedaysAndWageUseCase {
	
	public static void employeedaysAndWage() {
//	public static void main(String[] args) {
		
	
		
		
		GPMInterface dao = new GpmDaoImpl();
		
		try {
			List<Employee_Wage_Oper> empWage =  dao.employeedaysAndWage();
			
			
			System.out.println("---------------------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee, Wage, days, Total Amount" + ConsoleColors.RESET+ "-------------------------------------");
			
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println();
			
			System.out.println();
			for(Employee_Wage_Oper e : empWage) {
				
				
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"EID - "+e.getEid()+ConsoleColors.RESET);

				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"ENAME - "+e.getName()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"PID - "+e.getProjectID()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"PROJECTNAME - "+e.getProjectName()+ConsoleColors.RESET);

				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"DATE_JOINED - "+e.getDate_joined()+ConsoleColors.RESET);

				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"TOTAL DAYS - "+e.getNoOfDays()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"WAGE/DAY - "+e.getWage()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"TOTAL_AMOUNT - "+e.getTotalAmount()+ConsoleColors.RESET);
				
				System.out.println();
			}
			
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
			
			
			
			
			
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
		
		
	}

}
