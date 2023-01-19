package com.masai.Usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;

import com.masai.exception.*;
import com.masai.model.*;

public class CreateEmployeeUseCase {
/
	public static void createEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Enter Employee Name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter Employee Address : ");
			String address = sc.nextLine();
			System.out.println("Enter Employee Wage/day : ");
			int wage = sc.nextInt();
			
			Employee e = new Employee();
			e.setEgpid(GpmDaoImpl.PutGpmID);
			e.setEaddress(address);
			e.setEname(name);
			e.setEwage(wage);
			//System.out.println(e);
			GPMInterface dao = new GpmDaoImpl();
			String result;
			
			try {
				result = dao.createEmployee(e);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);

			} catch (EmployeeException emp) {
				result = emp.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			
			}
			
		} catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
		

		
		
	}

}
