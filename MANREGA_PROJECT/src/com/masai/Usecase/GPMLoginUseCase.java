package com.masai.Usecase;

import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class GPMLoginUseCase {
	
	//public static int gpmID=GPMImplementation.getGpmID();
	
	public static boolean gpmLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Registered Phone Number to LogIn : ");
		String phone = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		//sc.close();
		GPMInterface dao = new GpmDaoImpl();
		 
		
		
		String result;
		
		try {
			result= dao.gmpLogin(phone, password);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return true;
			
		} catch (CredentialException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		} catch (GramPanchayatException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		}
		
		
	}

}