package com.masai.main;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.masai.Design.*;
import com.masai.Usecase.*;
import com.masai.dao.*;
import com.masai.exception.*;
import com.masai.model.*;

public class Main {
	
	
public static void open() throws InputMismatchException  {
		

		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+ConsoleColors.BLACK_BOLD_BRIGHT+
					              "|||--- Welcome to GRAM MGNREGA Application ---|||"+ ConsoleColors.RESET);
			System.out.println(ConsoleColors.DARK_BLUE_BACKGROUND+ConsoleColors.WHITE_BOLD+"+-----------+-------------+------+-----+---------+----------------+\r\n"
					+ "|  Choose Any Option from Below According to your choice          |\r\n"
					+ "+ =============================================================   +\r\n"
					+ "|Press 1 to LOGIN as BDO                                          |\r\n"
					+ "|                                                                 |\r\n"
					+ "|Press 2 to LOGIN as Gram Panchayat Member (GPM)                  |\r\n"
					+ "|                                                                 |\r\n"
					+ "|Press 3 to EXIT.                                                 |\r\n"
					+ "|                        "
					+ "                                         |\r\n"
					+ "|                                                                 |\r\n"
					+ "|                                                                 |\r\n"
					+ "+-----------+-------------+------+-----+---------+----------------+"+ConsoleColors.RESET);
			String choice = sc.nextLine();
		
			if(choice.equals("1")) {
				
				BDOMain bmain = new BDOMain();
				Boolean result = bmain.bdoLogin();
				
				int count =1;
				
				while(!result) {
					count++;
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + (4-count) +" Times remaining []"+ ConsoleColors.RESET);
					result = bmain.bdoLogin();
					
					if(count == 3) {
						System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "You will cross your Attempts Try Again Later thank you"+ ConsoleColors.RESET);
						break;
						
					}
				}
				
				if(result) {
					
					while(true) {
						
						bmain.bdoHomeWndow();
						String choiceBdo = sc.nextLine();
						
						if(choiceBdo.equals("1")) bmain.createProject();
							
						else if(choiceBdo.equals("2")) bmain.viewListOfProject();
							
						else if (choiceBdo.equals("3")) bmain.createGPM();
							
						else if(choiceBdo.equals("4")) bmain.viewListOfGPM();
							
						else if(choiceBdo.equals("5")) bmain.allocateProjectToGPM();
							
						else if(choiceBdo.equals("6"))
							bmain.listOfEmployee();
						else if(choiceBdo.equals("7")){
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "--LOGOUT SUCCESSFUL THANK YOU --" + ConsoleColors.RESET);				
							break;
							
						}else {
							System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "--PLZ CHOOSE 1 TO 7--" + ConsoleColors.RESET);
						}							
					}
					open();
						
				}else {
					open();
				}
				
			}else if(choice.equals("2")) {
				GPMMain gpmMain = new GPMMain();
				Boolean resultg = gpmMain.GpmLogin();
				
				int countGpm=1;
				while(!resultg) {
					countGpm++;
					System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + (4-countGpm) +" Attempts remaining"+ ConsoleColors.RESET);
					resultg = gpmMain.GpmLogin();
					
					if(countGpm ==3 && resultg ==false) {
						System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "You attempt main times Try Again Later"+ ConsoleColors.RESET);
						break;
						
					}
				}
				
				if(resultg) {
					
					while(true) {
						
						gpmMain.gpmWindow();
						
						String choiceGpm = sc.nextLine();
						
						if(choiceGpm.equals("1")) gpmMain.createEmployee();
							
						else if(choiceGpm.equals("2")) gpmMain.displayEmployee();
							
						else if(choiceGpm.equals("3")) gpmMain.assignEmployee();
							
						else if(choiceGpm.equals("4")) gpmMain.dayWageTotal();
							
						else if(choiceGpm.equals("5")) {
							System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "--LOGOUT SUCCESSFUL --" + ConsoleColors.RESET);
							break;
						}else {
							System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "--CHOOSE 1 TO 5--" + ConsoleColors.RESET);
						}		
					}
					open();
					
				}else {
					open();
				}
				
				
			}else if(choice.equals("3")) {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "--CLOSED--" + ConsoleColors.RESET);
				System.exit(0);
				
			}else {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "--CHOOSE 1 TO 3--" + ConsoleColors.RESET);
				open();
				
			}
		
			}catch (InputMismatchException e){
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
			}catch (NoSuchElementException e) {
				System.out.println(ConsoleColors.RED_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + e.getMessage() + ConsoleColors.RESET);
			}
		
		
	}
	public static void main(String[] args) {
		open();	
		
	}
		
	


}
