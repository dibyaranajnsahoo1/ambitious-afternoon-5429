package com.masai.Usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class EmployeeOnAProjectUseCase {
	
	public static void employeeOnAProject() {
//	public static void main(String[] args) {
		
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Project ID to see the list of all employeein that project  ");
		int pid = sc.nextInt();
		
		
		BdoDao dao = new BdoImplementation();
		
		try {
			List<Employee> emp =  dao.employeeOnAProject(pid);
			
			System.out.println("--" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all the Employee Present in the PID : " +pid + ConsoleColors.RESET+ "----");
			
			System.out.println("-------------------------------------------------------------");
			
			System.out.println();
			
			System.out.println();
			for(Employee e : emp) {
				
				System.out.print(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"EID - "+e.getEid()+ConsoleColors.RESET);

				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"NAME - "+e.getEname()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"WAGE/DAY - "+e.getEwage()+ConsoleColors.RESET);
				
				
				System.out.println();
			}
			
			System.out.println("-------------------------------------------------------------");
			
			
		} catch (ProjectException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		} catch (BdoException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
		
		
		
		
	}

}
