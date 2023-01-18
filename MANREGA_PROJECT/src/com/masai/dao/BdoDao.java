package com.masai.dao;

import java.util.List;

import com.masai.exception.*;

import com.masai.model.*;

import com.masai.model.Employee;
import com.masai.model.GramPanchayat;
import com.masai.model.Project;

public interface BdoDao {
	
	//BDO USERNAME AND PASSWORD------------------------
	public final String username = "dibya";
	public final String password = "123";
	
	
	// Login int thire account-----------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String bdologin(String username, String password) throws CredentialException;
	
	
	
	// Create a project -----------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String createProject(Project p) throws ProjectException;
	
	
	
	//View List Of Project---------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<Project> displayAllProject() throws ProjectException;
	
	
	
	//Create new Gram Panchayat Member(GPM)----------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String createGramPanchayatMember(GramPanchayat g) throws GramPanchayatException;
	
	
	
	//View List Of Gram Panchayat Member(GPM)--------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<GramPanchayat> displayAllGramPayanchayatMember() throws GramPanchayatException;
	
	
	
	//Allocate  Project to GPM-----------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public String allocateProjectToGPM(int gpmid, int pid) throws ProjectException, GramPanchayatException, BdoException;
	
	
	
	//Employee On a project--------------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public List<Employee> employeeOnAProject(int pid) throws ProjectException, EmployeeException, BdoException;
	
	
	
	
}
