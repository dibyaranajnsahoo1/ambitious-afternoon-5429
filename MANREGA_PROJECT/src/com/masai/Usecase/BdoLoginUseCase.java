package com.masai.Usecase;

import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;

import com.masai.exception.*;

public class BdoLoginUseCase {
	
	public static boolean bdoLogin() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("-- Enter Username : ");
		String username = sc.next();
		System.out.println("-- Enter Password : ");
		String password = sc.next();
		
		BdoDao dao = new BdoImplementation();
		
		String result;
		
		try {
			result = dao.bdologin(username, password);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return true;
			
			
		} catch (CredentialException e) {
			result = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + result + ConsoleColors.RESET);
			return false;
		}
		
		
				
		
	}

}
