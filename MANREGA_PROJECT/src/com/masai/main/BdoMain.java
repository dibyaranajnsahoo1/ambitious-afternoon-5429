package com.masai.main;

import com.masai.Design.*;
import com.masai.Usecase.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class BDOMain {
	
	
	//BDO login--------------------------------------
	public static Boolean bdoLogin() {
		BdoLoginUseCase Login = new BdoLoginUseCase();
		Boolean result = Login.bdoLogin();
		return result;	
	}
	
	
	//BDO Home---------------------------------------- 
	public static void bdoHomeWndow() {
		System.out.println(ConsoleColors.BLACK_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"||--- Welcome to BDO Home ---|| "+ ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.YELLOW_BACKGROUND+ConsoleColors.BLACK_BOLD+"+-----------+-------------+------+-----+---------+----------------+\r\n"
				+ "| Press 1 to Create a new Project                                 |\r\n"
				+ "|                                                                 |\r\n"
				+ "| Press 2 to View the List of all Projects                        |\r\n"
				+ "|                                                                 |\r\n"
				+ "| Press 3 to Create a Gram Panchayat Member                       |\r\n"
				+ "|                                                                 |\r\n"
				+ " Press 4 to View List of all Gram Panchayat Member               |\r\n"
				+ "|                                                                 |\r\n"
				+ " Press 5 to Allocate Project to Gram Panchayat Member            |\r\n"
				+ "|                                                                 |\r\n"
				+ " Press 6 to See the List of Employee working on a project        |\r\n"
				+ "|                                                                 |\r\n"
				+ " Press 7 to LOGOUT AND RETURN TO HOMEPAGE                        |\r\n"
				+ "                                                                | |\r\n"
				+ "+                                                                 +\r\n"
				+ "|                                                                 |\r\n"
				+ "|                                                                 | \r\n"
				+ "+-----------+-------------+------+-----+---------+----------------+"+ConsoleColors.RESET);
		
		
		
		
	}
	
	public static void createProject() {
		CreateProjectUseCase createProject = new CreateProjectUseCase();
		createProject.createProject();
	}
	
	public static void viewListOfProject() {
		DisplayAllProjectUseCase projects = new DisplayAllProjectUseCase();
		projects.displayProject();
	}
	
	public static void createGPM() {
		CreateGramPanchayatMemberUseCase createGPM = new CreateGramPanchayatMemberUseCase();
		createGPM.createGramPanchayatMember();
	}
	
	public static void viewListOfGPM() {
		DisplayAllGramPayanchayatMemberUseCase gpmList = new DisplayAllGramPayanchayatMemberUseCase();
		gpmList.displayAllGPM();
	}
	
	public static void allocateProjectToGPM() {
		AllocateProjectToGPMUseCase allocate = new AllocateProjectToGPMUseCase();
		allocate.allocateProjectToGPM();
	}
	
	public static void listOfEmployee() {
		EmployeeOnAProjectUseCase emp = new EmployeeOnAProjectUseCase();
		emp.employeeOnAProject();
	}
	

}
