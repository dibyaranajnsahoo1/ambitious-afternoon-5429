package com.masai.dao;

import java.util.List;

import com.masai.exception.CredentialException;
import com.masai.exception.EmployeeException;
import com.masai.exception.GramPanchayatException;
import com.masai.exception.ProjectException;
import com.masai.model.Employee;
import com.masai.model.Employee_Wage_Oper;


public interface GPMInterface {
	
	
	//Login thier Account--------------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String gmpLogin(String phone, String password) throws CredentialException , GramPanchayatException;
	
	
	//Create Employee------------------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String createEmployee(Employee e) throws EmployeeException;
	
	
	//Viwe Details Of Employee----------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<Employee> displayAllEmployee() throws EmployeeException;
	
	
	//Assign Employee to Project--------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String assignEmployeeToProject(int pid, int eid) throws EmployeeException, ProjectException, GramPanchayatException;
	
	
	//View total Number of days worked in a project and also their wags-----!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<Employee_Wage_Oper> employeedaysAndWage() throws EmployeeException;
	
	

}
