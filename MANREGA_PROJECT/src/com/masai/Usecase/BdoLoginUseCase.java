package com.masai.Usecase;

import java.util.Scanner;

import com.masai.Design.*;
import com.masai.dao.*;

import com.masai.exception.*;

public class BdoLoginUseCase {
	
	public static boolean bdoLogin() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("|-- Enter Username-: ---|");
		String username = sc.next();
		System.out.println("|-- Enter Password-: ---|");
		String password = sc.next();
		
		
		BdoDao dao = new BdoImplementation();
		
		String res;
		
		try {
			res = dao.bdologin(username, password);
			System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.BLACK_BOLD+ConsoleColors.TEXT_BACKGROUND + res + ConsoleColors.RESET);
			return true;
			
			
			
		} catch (CredentialException e) {
			res = e.getMessage();
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLACK_BOLD+ConsoleColors.TEXT_BACKGROUND+ res + ConsoleColors.RESET);
			return false;
		}
		
		
				
		
	}
	

}

