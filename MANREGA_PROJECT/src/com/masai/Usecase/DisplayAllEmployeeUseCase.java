package com.masai.Usecase;

import java.util.List;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class DisplayAllEmployeeUseCase {
	public static void displayEmployee() {
		
		GPMInterface dao =new GpmDaoImpl();
		
		try {
			List<Employee> emp = dao.displayAllEmployee();
			
			System.out.println("---------------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee Present" + ConsoleColors.RESET+ "---------------------------");
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.printf("%7s %7.5s %8.5s %10s %15s %17s %16s",ConsoleColors.BLACK_BOLD + "EID", "EGPMID","EPID", "NAME", "ADDRESS", "DATE JOINED", "WAGE/DAY" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			for(Employee e : emp) {
				
				System.out.format("%2s %6s %8.5s %13s %14s %16s %10s",e.getEid(),e.getEgpid(),e.getEpid(),e.getEname(),e.getEaddress(),e.getEdate(),e.getEwage());
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------------------");
	
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
	}
}
