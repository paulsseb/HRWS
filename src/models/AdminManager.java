package models;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dbObjects.AdminDAL;
import dbObjects.dbCon;
import objects.AdminObjects.DepartmentObj;
import objects.AdminObjects.DocSeqObj;
import objects.AdminObjects.EmployeeTypeObj;
import objects.AdminObjects.PayHeadDtlsObj;
import objects.AdminObjects.PayHeadSubTypObj;
import objects.AdminObjects.PayHeadTypObj;
import objects.AdminObjects.PositionObj;
import objects.AdminObjects.BranchObj;

public class AdminManager {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. PAY HEAD TYPE
	public ArrayList<PayHeadTypObj> createPayHeadType(String PayHTypCode, String PayHTypName, String Actor) throws Exception{
		
		ArrayList<PayHeadTypObj> typeObj = new ArrayList<PayHeadTypObj>();
		
		try{
			
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			AdminDAL admin = new AdminDAL();
			typeObj = admin.createPayHeadType(connection, PayHTypCode, PayHTypName, Actor);
		}
	 catch (Exception e) {
		System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createPayHeadType " + e.getMessage());
		throw e;
		}
		return typeObj;
	}
	
	public ArrayList<PayHeadTypObj> getPayHeadType() throws Exception{
	
		ArrayList<PayHeadTypObj> typeObj = new ArrayList<PayHeadTypObj>();
		
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			AdminDAL admin = new AdminDAL();
			typeObj = admin.getPayHeadType(connection);
		}
		 catch (Exception e) 
		 {
			System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getPayHeadType " + e.getMessage());
			throw e;
		}
		return typeObj;
	}
	//*******************END PAY HEAD TYPE**********************************
	
	//2. PAY HEAD SUB TYPE
	public ArrayList<PayHeadSubTypObj> createPayHeadSubType(String PayHSubTypCode, String PayHSubTypName, 
			String PayHTypode, String Actor) throws Exception{
		
		ArrayList<PayHeadSubTypObj> typeObj = new ArrayList<PayHeadSubTypObj>();
		
		try{
			
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			AdminDAL admin = new AdminDAL();
			typeObj = admin.createPayHeadSubType(connection, PayHSubTypCode, PayHSubTypName, PayHTypode, Actor);
		}
	 catch (Exception e) {
		System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createPayHeadSubType " + e.getMessage());
		throw e;
		}
		return typeObj;
	}
	
	public ArrayList<PayHeadSubTypObj> getPayHeadSubType() throws Exception{
	
		ArrayList<PayHeadSubTypObj> typeObj = new ArrayList<PayHeadSubTypObj>();
		
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			AdminDAL admin = new AdminDAL();
			typeObj = admin.getPayHeadSubType(connection);
		}
		 catch (Exception e) 
		 {
			System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getPayHeadSubType " + e.getMessage());
			throw e;
		}
		return typeObj;
	}
	//*****************END PAY HEAD SUB TYPE********************************
	
	//3. PAY HEAD DETAILS
	public ArrayList<PayHeadDtlsObj> createPayHeadDtls(String PayHName, 
			String PayHTypCode, String PayHSubTypCode, String Variant, String Actor) throws Exception{
		
		ArrayList<PayHeadDtlsObj> typeObj = new ArrayList<PayHeadDtlsObj>();
		
		try{
			
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			AdminDAL admin = new AdminDAL();
			typeObj = admin.createPayHeadDtls(connection, PayHName, PayHTypCode, PayHSubTypCode, Variant, Actor);
		}
	 catch (Exception e) {
		System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createPayHeadSubType " + e.getMessage());
		throw e;
		}
		return typeObj;
	}
	
	public ArrayList<PayHeadDtlsObj> getPayHeadDtls() throws Exception{
	
		ArrayList<PayHeadDtlsObj> typeObj = new ArrayList<PayHeadDtlsObj>();
		
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			AdminDAL admin = new AdminDAL();
			typeObj = admin.getPayHeadDtls(connection);
		}
		 catch (Exception e) 
		 {
			System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getPayHeadDtls " + e.getMessage());
			throw e;
		}
		return typeObj;
	}
	//*****************END PAY HEAD DETAILS*********************************
	
	//4. DEPARTMENT
			public ArrayList<DepartmentObj> createDeaprtment(String DeptName,
					String DeptDesc, String Manager, String Actor) throws Exception{
				
				ArrayList<DepartmentObj> departObj = new ArrayList<DepartmentObj>();
				
				try{
					
					dbCon database = new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL admin = new AdminDAL();
					departObj = admin.createDepartment(connection, DeptName, DeptDesc, Manager, Actor);
				}
			 catch (Exception e) {
				System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createDeaprtment " + e.getMessage());
				throw e;
				}
				return departObj;
			}
			
			public ArrayList<DepartmentObj> getDepartment() throws Exception{
			
				ArrayList<DepartmentObj> departObj = new ArrayList<DepartmentObj>();
				
				try
				{
					dbCon database = new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL admin = new AdminDAL();
					departObj = admin.getDepartment(connection);
				}
				 catch (Exception e) 
				 {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getDepartment " + e.getMessage());
					throw e;
				}
				return departObj;
			}
			//*************************END DEPARTMENT*************************************
			
			//5. EMPLOYEE TYPE
			public ArrayList<EmployeeTypeObj> createEmployeeType(String TypeName, String Actor) throws Exception{
				
				ArrayList<EmployeeTypeObj> typeObj = new ArrayList<EmployeeTypeObj>();
				
				try{
					
					dbCon database = new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL admin = new AdminDAL();
					typeObj = admin.createEmployeeType(connection, TypeName, Actor);
				}
			 catch (Exception e) {
				System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createEmployeeType " + e.getMessage());
				throw e;
				}
				return typeObj;
			}
			
			public ArrayList<EmployeeTypeObj> getEmployeeType() throws Exception{
			
				ArrayList<EmployeeTypeObj> typeObj = new ArrayList<EmployeeTypeObj>();
				
				try
				{
					dbCon database = new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL admin = new AdminDAL();
					typeObj = admin.getEmployeeType(connection);
				}
				 catch (Exception e) 
				 {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getEmployeeType " + e.getMessage());
					throw e;
				}
				return typeObj;
			}
			//********************END EMPLOYEE TYPE*********************************
			
			//6. POSITION
			public ArrayList<PositionObj> createPosition(String PositonName,
					String Actor) throws Exception{
				
				ArrayList<PositionObj> postObj = new ArrayList<PositionObj>();
				
				try{
					
					dbCon database = new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL admin = new AdminDAL();
					postObj = admin.createPosition(connection, PositonName, Actor);
				}
			 catch (Exception e) {
				System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createPosition " + e.getMessage());
				throw e;
				}
				return postObj;
			}
			
			public ArrayList<PositionObj> getPosition() throws Exception{
			
				ArrayList<PositionObj> postObj = new ArrayList<PositionObj>();
				
				try
				{
					dbCon database = new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL admin = new AdminDAL();
					postObj = admin.getPosition(connection);
				}
				 catch (Exception e) 
				 {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getPosition " + e.getMessage());
					throw e;
				}
				return postObj;
			}
			//********************END POSITION***************************************
			
		//7. BRANCH
			public ArrayList<BranchObj> createBranch(String bcode, String bname, String btasks, String actor) throws Exception {
				ArrayList<BranchObj> adminObj = null;
				try {
					dbCon database= new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL adminDAL = new AdminDAL();
					adminObj=adminDAL.createBranch(connection, bcode, bname, btasks, actor);
				}
				catch (Exception e) {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createBranch "+ e.getMessage());
				throw e;
				}
				return adminObj;
			}
			
			public ArrayList<BranchObj> getBranch(String Actor, String App) throws Exception {
				ArrayList<BranchObj> adminObj = null;
				try {
					dbCon database= new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL adminDAL = new AdminDAL();
					adminObj=adminDAL.getBranch(connection, Actor, App);
				}
				catch (Exception e) {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getBranch "+ e.getMessage());
				throw e;
				}
				return adminObj;
			}
			
		//8. SEQUENCE NUMBER
			public ArrayList<DocSeqObj> getSeqNumber(String DocCode)
					throws Exception {

				ArrayList<DocSeqObj> receiptDetails = null;
				try {
					dbCon database = new dbCon();
					Connection connection = database.Get_Conn_1();

					AdminDAL inquiryDal = new AdminDAL();
					receiptDetails = inquiryDal.getSeqNumber(connection, DocCode);
				} catch (Exception e) {
					System.out.println("Exception Error at AdminManager, getSeqNumber " + e.getMessage());
					throw e;
				}
				return receiptDetails;
			}
			
	//9. EMPLOYEE SALARY 
			public ArrayList<PayHeadDtlsObj> createEmployeeSalary(String EmpNO, String PayHName,
					String Dr, String Cr, String Frequency, String Actor) throws Exception {
				ArrayList<PayHeadDtlsObj> adminObj = null;
				try {
					dbCon database= new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL adminDAL = new AdminDAL();
					adminObj=adminDAL.createEmployeeSalary(connection, EmpNO, PayHName, Dr, Cr, Frequency, Actor);
				}
				catch (Exception e) {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, createEmployeeSalary "+ e.getMessage());
				throw e;
				}
				return adminObj;
			}
			
			public ArrayList<PayHeadDtlsObj> getEmployeeSalary(String EmpNO) throws Exception {
				ArrayList<PayHeadDtlsObj> adminObj = null;
				try {
					dbCon database= new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL adminDAL = new AdminDAL();
					adminObj=adminDAL.getEmployeeSalary(connection, EmpNO);
				}
				catch (Exception e) {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, getEmployeeSalary "+ e.getMessage());
				throw e;
				}
				return adminObj;
			}
			
			public ArrayList<PayHeadDtlsObj> updateEmployeeSalary(String EmpSalryID, String Dr, String Cr, String Frequency, String Status, String Actor) throws Exception {
				ArrayList<PayHeadDtlsObj> adminObj = null;
				try {
					dbCon database= new dbCon();
					Connection connection = database.Get_Conn_1();
					
					AdminDAL adminDAL = new AdminDAL();
					adminObj=adminDAL.updateEmployeeSalary(connection, EmpSalryID, Dr, Cr, Frequency, Status, Actor);
				}
				catch (Exception e) {
					System.out.println(df.format(dateobj)+" Exception Error at AdminManager, updateEmployeeSalary "+ e.getMessage());
				throw e;
				}
				return adminObj;
			}
			
}
