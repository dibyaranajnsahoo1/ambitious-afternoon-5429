package com.masai.Usecase;

import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;

import com.masai.exception.*;
import com.masai.exception.GramPanchayatException;
import com.masai.exception.ProjectException;

public class AssignEmployeeToProjectUseCase {
	
	public static void assignEmployeeToProject() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PID to assign - ");
		int pid = sc.nextInt();
		System.out.println("Enter EID to assign : ");
		int eid = sc.nextInt();
		
		
		GPMInterface dao = new GpmDaoImpl();
		String result;
		
		try {
			result = dao.assignEmployeeToProject(pid, eid);
			System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
		} catch (EmployeeException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
		} catch (ProjectException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
		} catch (GramPanchayatException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
		}
		
		sc.close();
		
		
	}
	
	
	

}
