package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.CredentialException;
import com.masai.exception.EmployeeException;
import com.masai.exception.GramPanchayatException;
import com.masai.exception.ProjectException;
import com.masai.model.Employee;
import com.masai.model.Employee_Wage_Oper;
import com.masai.model.Project;
import com.masai.utilty.DBUtility;

public class GpmDaoImpl implements GPMInterface{
	
	public static int PutGpmID;
	
	
	//1-- Login thier Account============================================================$$$$
	@Override
	public String gmpLogin(String phone, String password) throws CredentialException, GramPanchayatException {
		String result = "|---Wrong Phone Number or Passaword Enter Corect Details---|";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayat");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String phoneNumber = rs.getString("gphone");
				String pass = rs.getString("gpassword");
				
				if(phoneNumber.equals(phone) && pass.equals(password)) {
					result = "|---LOGIN Sucessful---|";
					PutGpmID = rs.getInt("gpid");
					return result;
				}
					
					
			}
			result = "|---Wrong Details---|";
			throw new CredentialException(result);
			
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}		
		
		
	}

	
	
	
	
	
	
	//2-- Create Employee ================================================================$$$$
	
	
	@Override
	public String createEmployee(Employee e) throws EmployeeException {
		
		String result ="|---Employee is Not Create---|";
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee(egpid,ename,eaddress,edate_joined,ewage) values(?,?,?,curdate(),?)");
			ps.setInt(1, e.getEgpid());
			ps.setString(2, e.getEname());
			ps.setString(3, e.getEaddress());
			ps.setInt(4, e.getEwage());
			
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "|---Employee Created SucsessFully---|";
			}else {
				throw new EmployeeException(result);
			}
			
		} catch (SQLException s) {
			throw new EmployeeException(s.getMessage());
		}
		
		return result;
	}


	
	
	//3-- Viwe Details Of Employee ================================================$$$$


	@Override
	public List<Employee> displayAllEmployee() throws EmployeeException {
		List<Employee> EmpList = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				int egpid = rs.getInt("egpid");
				int epid = rs.getInt("epid");
				String name = rs.getString("ename");
				String address = rs.getString("eaddress");
				Date date = rs.getDate("edate_joined");
				int wage = rs.getInt("ewage");
				
				
				Employee e = new Employee(eid, egpid, epid, name, address, date, wage);
				EmpList.add(e);
			}
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(EmpList.size() ==0) {
			throw new EmployeeException("--No Employee Availbale--");
		}
		
		return EmpList;
	}


	
	
	//Assign Employee to Project======================================================$$$$


	@Override
	public String assignEmployeeToProject(int pid, int eid)throws EmployeeException, ProjectException, GramPanchayatException {
		String result = "|---Employee not able to assinged to project Try Again---|";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ? and egpid =?");
			ps.setInt(1, eid);
			ps.setInt(2, PutGpmID);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid = ? and pgpid =?");
				ps2.setInt(1, pid);
				ps2.setInt(2, PutGpmID);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()){
					
					PreparedStatement ps3 = conn.prepareStatement("update employee set epid = ? where eid =?");
					ps3.setInt(1, pid);
					ps3.setInt(2, eid);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						result = "|---Project PID ID : " + pid + " Add to employee with EID ID : " + eid +"Sucesessfully---|";
						return result;
					}
					
				}else {
					throw new ProjectException("|---Project doesn't exist ---|");
				}
				
				
			}else {
				throw new EmployeeException("|--- employee don't exist ---|");
			}
			
		
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
	
		return result;
	}


	
	

    //View total Number of days worked in a project and also their wags===============================$$$$

	@Override
	public List<Employee_Wage_Oper> employeedaysAndWage() throws EmployeeException {
		List<Employee_Wage_Oper> dayandWageList = new ArrayList<>();
		
		
		try (Connection conn = DBUtility.provideConnection()) {
//			String ss = "";
			PreparedStatement ps = conn.prepareStatement("select e.eid,e.ename,p.pid,p.pname,e.edate_joined,DATEDIFF(curdate(),edate_joined) days,e.ewage,DATEDIFF(curdate(),edate_joined)*e.ewage total from employee e inner join project p on e.epid = p.pid group by e.eid");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Date date = rs.getDate("edate_joined");
				int days = rs.getInt("days");
				int wage = rs.getInt("ewage");
				int total = rs.getInt("total");
				
				Employee_Wage_Oper empWageTotal = new Employee_Wage_Oper(eid, ename, pid, pname, date, days, wage, total);
				dayandWageList.add(empWageTotal);	
				
			}
				
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(dayandWageList.size() ==0) {
			throw new EmployeeException(" |---No employee Found---|");
		}
			
		return dayandWageList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	


