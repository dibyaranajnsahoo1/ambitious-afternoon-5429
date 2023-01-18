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
		System.out.println("Enter Project ID to assign : ");
		int pid = sc.nextInt();
		System.out.println("Enter Employee ID to assign : ");
		int eid = sc.nextInt();
		
		
		GPMInterface dao = new GpmDaoImpl();
		String result;
		
		try {
			result = dao.assignEmployeeToProject(pid, eid);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (EmployeeException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (ProjectException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		} catch (GramPanchayatException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
		}
		
		//sc.close();
		
		
	}
	
	
	

}
