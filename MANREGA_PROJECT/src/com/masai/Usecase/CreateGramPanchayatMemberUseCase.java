package com.masai.Usecase;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;

import com.masai.exception.*;
import com.masai.model.*;

public class CreateGramPanchayatMemberUseCase {
	
	public static boolean flag = false;
	
	public static void createGramPanchayatMember()  {

		
	
		
		Scanner sc = new Scanner(System.in);
		
		
		
		try {
			
			
			System.out.println("Enter Gram Panchayat Member Name : ");
			String name = sc.nextLine();
			System.out.println("Enter Gram Panchayat Member Address : ");
			String address = sc.nextLine();
			System.out.println("Enter Gram panchayat Member Email");
			String mail =sc.next();
			System.out.println("Enter Gram Panchayat Member Phone Number : ");
			long phNumber = sc.nextLong();
			sc.nextLine();
			String phone = Long.toString(phNumber);
			System.out.println("Enter Gram Panchayat Member Password : ");
			System.out.println(ConsoleColors.RED_ITALIC+"(Password must contain 8 characters , Have 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			boolean flag = false;
			String password = null;
			while(!flag) {
				password = sc.nextLine();
				flag = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
				
				if(flag) {
					break;
				}
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Invalid Password Pattern" + ConsoleColors.RESET);
				System.out.println(ConsoleColors.RED_ITALIC+"(Password must contain 8 characters and should have atleast 1 Upper Case, 1 Small Case, 1 Number and 1 Special Character)"+ ConsoleColors.RESET);
			}
			
			
			
			GramPanchayat g = new GramPanchayat();
			g.setGname(name);
			g.setAddress(address);
			g.setGmail(mail);
			g.setGphone(phone);
			
			g.setPassword(password);
			
			BdoDao dao = new BdoImplementation();
			String result;
			
			
			try {
				result = dao.createGramPanchayatMember(g);
				System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			} catch (GramPanchayatException e) {
				result = e.getMessage();
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			}	
			
		} catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Exception : Invalid Input Data Type" + ConsoleColors.RESET);
		}
		
		
		
		
		
	}

}
