package com.masai.Usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;

import com.masai.exception.*;
import com.masai.model.*;

public class CreateEmployeeUseCase {

	public static void createEmployee() {
//	public static void main(String[] args) {
		
	
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Enter Employee Name -");
			String name = sc.nextLine();
			
			System.out.println("Enter Employee Address -");
			String address = sc.nextLine();
			System.out.println("Enter Employee Wage/day -");
			int wage = sc.nextInt();
			
			Employee e = new Employee();
			e.setEgpid(GpmDaoImpl.PutGpmID);
			e.setEaddress(address);
			e.setEname(name);
			e.setEwage(wage);
			GPMInterface dao = new GpmDaoImpl();
			String result;
			
			try {
				result = dao.createEmployee(e);
				System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);

			} catch (EmployeeException emp) {
				result = emp.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
			
			}
			
		} catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + "Invalid Input Data Type" + ConsoleColors.RESET);
		}
		

		
		
	}

}
