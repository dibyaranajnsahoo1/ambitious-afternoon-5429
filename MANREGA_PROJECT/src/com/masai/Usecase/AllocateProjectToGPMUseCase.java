package com.masai.Usecase;

import java.util.Scanner;

import com.masai.dao.BdoImplementation;
import com.masai.Design.ConsoleColors;
import com.masai.dao.BdoDao;
import com.masai.exception.BdoException;
import com.masai.exception.GramPanchayatException;
import com.masai.exception.ProjectException;



public class AllocateProjectToGPMUseCase {
	
	public static void allocateProjectToGPM() {
//	public static void main(String[] args) {
		
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PID to assign - ");
		int pid = sc.nextInt();
		System.out.println("Enter GpmID to assign - ");
		int gpid = sc.nextInt();
		
		BdoDao dao = new BdoImplementation();
		String result;
		
		try {
			result = dao.allocateProjectToGPM(gpid, pid);
			System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
		} catch (ProjectException e) {
			
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
			
		} catch (GramPanchayatException e) {
			
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
			
		} catch (BdoException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
		}
		
		
	
		
		
	}

}
