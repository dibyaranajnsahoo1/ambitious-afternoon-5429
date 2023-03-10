package com.masai.Usecase;

import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class GPMLoginUseCase {
	
	//public static int gpmID=GPMImplementation.getGpmID();
	
	public static boolean gpmLogin() {
//	public static void main(String[] args) {
		
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Registered Phone Number to LogIn : ");
		String phone = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		GPMInterface dao = new GpmDaoImpl();
		 
		String result;
		
		try {
			result= dao.gmpLogin(phone, password);
			System.out.println(ConsoleColors.BANANA_YELLOW_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
			return true;
			
		} catch (CredentialException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
			return false;
		} catch (GramPanchayatException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + result + ConsoleColors.RESET);
			return false;
		}
		
		
	}

}