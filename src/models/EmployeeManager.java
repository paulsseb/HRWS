package models;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import objects.EmployeeObjects.EmployeeObj;
import dbObjects.EmployeeDAL;
import dbObjects.dbCon;

public class EmployeeManager {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. EMPLOYEE
		public ArrayList<EmployeeObj> createEmployee(String EmpName,String EmpNumber,
				String Email,String NSSFNO,String Tin,String MobilePhone,String Address,String DateOfBirth,String Nationality,
				String MaritalStatus,String Gender,String NxtOfKin,String NxtOfKinContact,String NxtOfKinRelation,String Branch,
				String Department,String Position,String ReportTo,String DateOfJoin,String EmpTyp,String WorkPhone,String LeaveRate,
				String WorkStartDt,String WorkEndDt,String PayMode,String MMoneyPhone,String BankName,String BankBranch,
				String BankActNO,String Actor) throws Exception{
			
			ArrayList<EmployeeObj> typeObj = new ArrayList<EmployeeObj>();
			
			try{
				
				dbCon database = new dbCon();
				Connection connection = database.Get_Conn_1();
				
				EmployeeDAL employ = new EmployeeDAL();
				typeObj = employ.createEmployee(connection, EmpName, EmpNumber, Email, NSSFNO, Tin, MobilePhone, Address, DateOfBirth, Nationality, MaritalStatus, Gender, NxtOfKin, NxtOfKinContact, NxtOfKinRelation, Branch, Department, Position, ReportTo, DateOfJoin, EmpTyp, WorkPhone, LeaveRate, WorkStartDt, WorkEndDt, PayMode, MMoneyPhone, BankName, BankBranch, BankActNO, Actor);		
			}
		 catch (Exception e) {
			System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createEmployee " + e.getMessage());
			throw e;
			}
			return typeObj;
		}
		
		public ArrayList<EmployeeObj> getEmployees() throws Exception{
		
			ArrayList<EmployeeObj> typeObj = new ArrayList<EmployeeObj>();
			
			try
			{
				dbCon database = new dbCon();
				Connection connection = database.Get_Conn_1();
				
				EmployeeDAL employ = new EmployeeDAL();
				typeObj = employ.getEmployees(connection);
			}
			 catch (Exception e) 
			 {
				System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getEmployees " + e.getMessage());
				throw e;
			}
			return typeObj;
		}
		//****************END EMPLOYEE******************************************
		
}
