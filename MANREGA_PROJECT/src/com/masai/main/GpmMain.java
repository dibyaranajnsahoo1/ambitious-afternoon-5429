package com.masai.main;

import com.masai.Design.*;
import com.masai.Usecase.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class GPMMain {
	
	//login-------------------------------------------
	public static boolean GpmLogin() {
		GPMLoginUseCase login = new GPMLoginUseCase();
		boolean result =login.gpmLogin();
		return result;	
	}
	
	//grampachayantWindow------------------------------
	public static void gpmWindow() {
		
		
		System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"+-----------+-------------+------+-----+---------+----------------+\r\n"
				+ "|       ||---Welcome to Gram Panchayat Member Home ---|||         |\r\n"
				+ "+   +======================================================+      +\r\n"
				+ "|                                                                 |\r\n"
				+ "|  Press 1 to Create a new Employee                               |\r\n"
				+ "|                                                                 |\r\n"
				+ "|  Press 2 to  Display Employee                                   |\r\n"
				+ "|                                                                 |\r\n"
				+ "|  Press 3 to Assign Employee to a Project                        |\r\n"
				+ "|  Press 4 to Total Day/wage                                      |\r\n"
				+ "|  Press 5 to LOGOUT / RETURN TO HOMEPAGE                         |\r\n"
				+ "|                                                                 |\r\n"
				+ "+-----------+-------------+------+-----+---------+----------------+"+ConsoleColors.RESET);
	}
	
	
	
	public static void createEmployee() {
		CreateEmployeeUseCase createEmp = new CreateEmployeeUseCase();
		createEmp.createEmployee();
	}
	
	public static void displayEmployee() {
		DisplayAllEmployeeUseCase displayEmp = new DisplayAllEmployeeUseCase();
		displayEmp.displayEmployee();	
	}
	
	public static void assignEmployee() {
		AssignEmployeeToProjectUseCase assignEmployee = new AssignEmployeeToProjectUseCase();
		assignEmployee.assignEmployeeToProject();
	}
	
	public static void dayWageTotal() {
		EmployeedaysAndWageUseCase dayWage = new EmployeedaysAndWageUseCase();
		dayWage.employeedaysAndWage();
	}
		

}
