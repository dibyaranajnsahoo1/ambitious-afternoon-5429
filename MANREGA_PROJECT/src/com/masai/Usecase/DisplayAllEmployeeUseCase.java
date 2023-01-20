package com.masai.Usecase;

import java.util.List;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class DisplayAllEmployeeUseCase {
	public static void displayEmployee() {
//	public static void main(String[] args) {
		
	

		GPMInterface dao =new GpmDaoImpl();
//		
		try {
			List<Employee> emp = dao.displayAllEmployee();
			
			System.out.println(  ConsoleColors.CYAN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD_BRIGHT +"||-----Table of all the Employee Present-----||" + ConsoleColors.RESET);
			
			System.out.println("---------------------------------------------------------------------------------");
			
			System.out.println();
			System.out.print("---------------------------------------------------------------------------------");
			
			System.out.println();
			for(Employee e : emp) {
			
				System.out.print(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"EID - "+e.getEid()+ConsoleColors.RESET);

				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"EGPMID - "+e.getEgpid()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"EPID - "+e.getEpid()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"NAME - "+e.getEname()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"ADDRESS - "+e.getEaddress()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"DATE JOINED - "+e.getEdate()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"WAGE/DAY - "+e.getEwage()+ConsoleColors.RESET);
//				
				System.out.println("========================================");
			}
			
			System.out.println("---------------------------------------------------------------------------------");
			
			
//       
	
		} catch (EmployeeException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
		
		
	}
}
