package com.masai.Usecase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class CreateProjectUseCase {
	
	public static void createProject() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			
			System.out.println("Enter Project Name : ");
			String name = sc.nextLine();
			System.out.println("Enter Project Cost : ");
			int cost = sc.nextInt();
			System.out.println("Enter Project Duration :");
			int duration = sc.nextInt();
			
			Project p = new Project();
			p.setPname(name);
			p.setPcost(cost);
			p.setDuration(duration);
			
			BdoDao dao = new BdoImplementation();
			String result;
			
			try {
				result = dao.createProject(p);
				System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);

			} catch (ProjectException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
			
			}
			
		} catch (InputMismatchException i) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + "Invalid Input Data Type" + ConsoleColors.RESET);
		}
		

		
		
		
	}
	
	
	

}
