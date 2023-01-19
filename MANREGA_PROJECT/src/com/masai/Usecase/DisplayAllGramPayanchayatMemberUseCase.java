package com.masai.Usecase;

import java.util.List;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class DisplayAllGramPayanchayatMemberUseCase {
	
	
	public static void displayAllGPM() {
		
		BdoDao dao = new BdoImplementation();
		
		try {
			List<GramPanchayat> gpmList = dao.displayAllGramPayanchayatMember();
			
			
			System.out.println("------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"Table of all Gram Panchayat Member Present" + ConsoleColors.RESET+ "---------------");
			
			System.out.println("---------------------------------------------------------------------");
			
			System.out.printf("%7s %12s %16s %12.5s %19s",ConsoleColors.BLACK_BOLD + "GPID", "NAME", "ADDRESS", "PHONE", "PASSWORD" + ConsoleColors.RESET);
			System.out.println();
			System.out.print("---------------------------------------------------------------------");
			
			System.out.println();
			for(GramPanchayat g : gpmList) {
				
				System.out.format("%2s %15s %14s %15s %14s",g.getGpid(),g.getGname(),g.getAddress(),g.getGphone(),g.getPassword());
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------------------------");
		} catch (GramPanchayatException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
		}
		
		
	}

}
