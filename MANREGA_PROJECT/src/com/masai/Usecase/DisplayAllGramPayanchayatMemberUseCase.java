package com.masai.Usecase;

import java.util.List;

import com.masai.Design.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class DisplayAllGramPayanchayatMemberUseCase {
	
	
	public static void displayAllGPM() {
//	public static void main(String[] args) {
		
	
		
		BdoDao dao = new BdoImplementation();
		
		try {
			List<GramPanchayat> gpmList = dao.displayAllGramPayanchayatMember();
			
			
			System.out.println("------------" + ConsoleColors.PURPLE_BACKGROUND+ConsoleColors.YELLOW_BOLD_BRIGHT +"----Table of all Gram Panchayat Member Present----" + ConsoleColors.RESET+ "---------------");
			
			System.out.println("---------------------------------------------------------------------");
			
			System.out.println();
						
			System.out.println();
			for(GramPanchayat g : gpmList) {
				
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"GPID - "+g.getGpid()+ConsoleColors.RESET);

				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"NAME - "+g.getGname()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"ADDRESS - "+g.getAddress()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"GMAIL - "+g.getGmail()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"PHONE - "+g.getGphone()+ConsoleColors.RESET);
				System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD+"PASSWORD - "+g.getPassword()+ConsoleColors.RESET);
				
				System.out.println();
				System.out.println("======================================");
			}
			
			System.out.println("---------------------------------------------------------------------");
		} catch (GramPanchayatException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.BLUE_BOLD + e.getMessage() + ConsoleColors.RESET);
		}
		
		
	}

}
