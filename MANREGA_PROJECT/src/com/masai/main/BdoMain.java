package com.masai.main;

import com.masai.Design.*;
import com.masai.Usecase.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class BdoMain {
	
	public static Boolean bdoLogin() {
		BdoLoginUseCase login = new BdoLoginUseCase();
		Boolean result = login.bdoLogin();
		return result;	
	}
	
	public static void bdoHomeWndow() {
		System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to BDO Home Window : "+ ConsoleColors.RESET);
		System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Create a Project." + ConsoleColors.RESET);
		System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View List of all Projects." + ConsoleColors.RESET);
		System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Create a Gram Panchayat Member." + ConsoleColors.RESET);
		System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT+" View List of all Gram Panchayat Members ." + ConsoleColors.RESET);
		System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Allocate Project to Gram Panchayat Member." + ConsoleColors.RESET);
		System.out.println("Press 6 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" See the List of Employee working on a project" + ConsoleColors.RESET);
		System.out.println("Press 7 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);	
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
