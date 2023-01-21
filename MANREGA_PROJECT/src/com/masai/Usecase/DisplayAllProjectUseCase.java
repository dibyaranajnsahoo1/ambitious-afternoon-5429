package com.masai.Usecase;

import java.util.List;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class DisplayAllProjectUseCase {
	
	public static void displayProject() {
//	public static void main(String[] args) {
		
	
		
		BdoDao dao = new BdoImplementation();
		
		try {
			List<Project> projects = dao.displayAllProject();
			
			System.out.println("||-------------" + ConsoleColors.CYAN_BACKGROUND_BRIGHT+ConsoleColors.RED_BOLD_BRIGHT +" All the Projects" + ConsoleColors.RESET+ "-------------------||");
			
			System.out.println("---------------------------------------------------------------------");
			
			System.out.printf("%7s  %16s %15s %17s",ConsoleColors.RED_BACKGROUND_BRIGHT+ ConsoleColors.BLACK_BOLD + "PID", "NAME", "COST", "DURATION" + ConsoleColors.RESET);
			System.out.println();
			
			System.out.println();
			for(Project p: projects) {
				
				
				
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"PID - "+p.getPid()+ConsoleColors.RESET);

				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"NAME - "+p.getPname()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"COST - "+p.getPcost()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"DURATION - "+p.getDuration()+ConsoleColors.RESET);
				
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------");
	
		} catch (ProjectException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
	}

}
