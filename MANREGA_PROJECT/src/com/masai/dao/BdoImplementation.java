package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.masai.exception.BdoException;
import com.masai.exception.CredentialException;
import com.masai.exception.EmployeeException;
import com.masai.exception.GramPanchayatException;
import com.masai.exception.ProjectException;
import com.masai.model.Employee;
import com.masai.model.GramPanchayat;
import com.masai.model.Project;
import com.masai.utilty.DBUtility;

public class BdoImplementation implements BdoDao {
	
	// 1-- Login into their account =======================================================$$$$

	@Override
	public String bdologin(String username, String password) throws CredentialException {
		
		String result = "|------Invalid Username or Password. Enter Right Details.!-------|";
		
		if (username.equals(BdoDao.username) && password.equals(BdoDao.password)) {
			 result = "|------Bdo Account Login Successful!----------|";
		}else {
			throw new CredentialException(result);
		}
		return result;	
	}
	
	
	
	
	
	 // 2-- Create a project =========================================================================$$$$
	
	@Override
	public String createProject(Project p) throws ProjectException {
		
		String result ="---Project Not Created Somthing Wrong plz Try Once More---";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Project (pname,pcost,pduration) values(?,?,?)");

			
			ps.setString(1, p.getPname());
			ps.setInt(2, p.getPcost());
			ps.setInt(3, p.getDuration());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "---Project Created Succsessfully---.";
			}else {
				throw new ProjectException(result);
			}
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		return result;
	}

	
	
	
	
	
   // 3-- View List Of Project =======================================================================$$$$

	@Override
	public List<Project> displayAllProject() throws ProjectException {
		
		List<Project> projectList = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from project");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int pid = rs.getInt("pid");
				int pgpid = rs.getInt("pgpid");
				String name = rs.getString("pname");
				int cost = rs.getInt("pcost");
				int duration = rs.getInt("pduration");
				
				Project p = new Project(pid, pgpid, name, cost, duration);
				projectList.add(p);
			}
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(projectList.size() ==0) {
			throw new ProjectException("---Have No Project Found---");
		}
		
		return projectList;
	}
	
	
	
	
	
	
	//4-- Create new Gram Panchayat Member(GPM) ====================================================$$$$

	@Override
	public String createGramPanchayatMember(GramPanchayat g) throws GramPanchayatException {
		String result ="GPM Data Not Inserted Plz Insert Again";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into grampanchayat (gname,gaddress,gmail,gphone,gpassword) values(?,?,?,?,?)");
			
			ps.setString(1, g.getGname());
			ps.setString(2, g.getAddress());
			ps.setString(3, g.getGmail());
			ps.setString(4, g.getGphone());
			ps.setString(5, g.getPassword());
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "GPM Data Inserted Sucsessfully";
			}else {
				throw new GramPanchayatException(result);
			}
			
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
		
		return result;
	}

	
	
	
	//5-- View List Of Gram Panchayat Member(GPM)========================================$$$$

	@Override
	public List<GramPanchayat> displayAllGramPayanchayatMember() throws GramPanchayatException {
		List<GramPanchayat> GpmList = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayat");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int gpid = rs.getInt("gpid");
				String name = rs.getString("gname");
				String address = rs.getString("gaddress");
				String mail = rs.getString("gmail");
				String phone = rs.getString("gphone");
				String password = rs.getString("gpassword");
				
				
				GramPanchayat gpmlist = new GramPanchayat(gpid, name,mail, address, phone, password);
				GpmList.add(gpmlist);
			}
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
		
		if(GpmList.size() ==0) {
			throw new GramPanchayatException("No Gram Panchayat Member Found Plz Try Again");
		}
		
		return GpmList;
		
		
	}


	
	
	
	//6--  Allocate  Project to GPM ===============================================================$$$$
	
	@Override
	public String allocateProjectToGPM(int gpmid, int pid) throws ProjectException, GramPanchayatException, BdoException {
		String result = "Not allocated ooppss!";
		
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayat where GPID = ?");
			ps.setInt(1, gpmid);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps1 = conn.prepareStatement("select * from project where pid = ?");
				ps1.setInt(1,pid);
				
				ResultSet rs1 = ps1.executeQuery();
				
				if(rs1.next()) {
					
					PreparedStatement ps2 = conn.prepareStatement("update project set pgpid = ? where pid = ?");
					ps2.setInt(1, gpmid);
					ps2.setInt(2, pid);
					
					int x = ps2.executeUpdate();
					
					if(x > 0) {
						result = "Project with PID ID : " + pid +" Allocated to GPM with GPM ID : " +gpmid ;
						return result;
					}
	
				}else {
					throw new ProjectException("Project don't exist with PID : " + pid);	
				}
				
			}else {
				throw new GramPanchayatException("Gram Panchyat Member don't exist with GPID :" + gpmid);
			}
			
		
		} catch (SQLException e) {
			throw new BdoException(e.getMessage());
		}

		return result;
	}

	
	
	
	 //7-- Employee On a project =====================================================================$$$$
	
	@Override
	public List<Employee> employeeOnAProject(int pid) throws ProjectException, EmployeeException, BdoException {
		
		List<Employee> empList = new ArrayList<>();
		
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from project where pid =?");
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps1 = conn.prepareStatement("select * from Employee e inner join project p on e.epid = p.pid where p.pid = ?");
				ps1.setInt(1, pid);
				
				ResultSet rs2 = ps1.executeQuery();
				
				while(rs2.next()) {

					int eid = rs2.getInt("eid");
					int egpid = rs2.getInt("egpid");
					int epid = rs2.getInt("epid");
					String name = rs2.getString("ename");
					String address = rs2.getString("eaddress");
					Date date = rs2.getDate("edate_joined");
					int wage = rs2.getInt("ewage");
					
					
					Employee e = new Employee(eid, egpid, epid, name, address, date, wage);
					empList.add(e);
		
				}
				
			}else {
				throw new ProjectException("No Project found. Enter right PID " );
			}
		
		} catch (SQLException e) {
			throw new BdoException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException(" No Employee Found. Enter right PID ");
		}
			
		return empList;
	}
	
	
	
	
	
	
	
}
	


