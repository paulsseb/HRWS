package models;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dbObjects.PayRollDAL;
import dbObjects.dbCon;
import objects.PayRollObjects.PayRollObj;
import objects.PayRollObjects.PaySlipDtlsObj;
import objects.PayRollObjects.PaySlipObj;

public class PayRollManager {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. PAYSLIP
	public ArrayList<PaySlipObj> createPaySlip(String PaySlipCode, String Description,
			String DateFrom, String DateTo, String Amount, String ProllCode, String EmployID,
			String Actor) throws Exception{
		
		ArrayList<PaySlipObj> paySlipObj = new ArrayList<PaySlipObj>();
		
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			PayRollDAL payroll = new PayRollDAL();
			paySlipObj = payroll.createPaySlip(connection, PaySlipCode, Description, DateFrom, DateTo, Amount, ProllCode, EmployID, Actor);
		}
		catch(Exception e)
		{
			System.out.println("Exception Error at PayRollManager, createPaySlip " + e.getMessage());
			throw e;
		}
		
		return paySlipObj;
	}
	
	public ArrayList<PaySlipObj> getPaySlip(String PayRollCd) throws Exception{
		
		ArrayList<PaySlipObj> paySlipObj = new ArrayList<PaySlipObj>();
		
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			PayRollDAL payroll = new PayRollDAL();
			paySlipObj = payroll.getPaySlip(connection, PayRollCd);
		}
		catch(Exception e)
		{
			System.out.println("Exception Error at PayRollManager, getPaySlip " + e.getMessage());
			throw e;
		}
		
		return paySlipObj;
	}
	//*************END PAYSLIP***********************
	
	//2. PAYSLIP DETAILS
	public ArrayList<PaySlipDtlsObj> createPaySlipDtls(String PaySlipCode, String PayHeadName,
			String PayHeadCode, String PayHeadTypCode, String Amount, String Quantity, String Actor) throws Exception{
		
		ArrayList<PaySlipDtlsObj> paySlipObj = new ArrayList<PaySlipDtlsObj>();
		
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			PayRollDAL payroll = new PayRollDAL();
			paySlipObj = payroll.createPaySlipDtls(connection, PaySlipCode, PayHeadName, PayHeadCode, PayHeadTypCode, Amount, Quantity, Actor);
		}
		catch(Exception e)
		{
			System.out.println("Exception Error at PayRollManager, createPaySlip " + e.getMessage());
			throw e;
		}
		
		return paySlipObj;
	}
	
	public ArrayList<PaySlipDtlsObj> getPaySlipDtls(String PaySlipCode) throws Exception{
		
		ArrayList<PaySlipDtlsObj> paySlipObj = new ArrayList<PaySlipDtlsObj>();
		
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			PayRollDAL payroll = new PayRollDAL();
			paySlipObj = payroll.getPaySlipDtls(connection, PaySlipCode);
		}
		catch(Exception e)
		{
			System.out.println("Exception Error at PayRollManager, getPaySlipDtls " + e.getMessage());
			throw e;
		}
		
		return paySlipObj;
	}
	
	//**************END PAYSLIP DETAILS******************
	
	//3. PAYSLIP
		public ArrayList<PayRollObj> createPayRoll(String ProllCode, String PayHFreqncy, String StartDate,
				String EndDate, String EmpCount, String Amount, String PaymentDate, String Actor) throws Exception{
			
			ArrayList<PayRollObj> payRollObj = new ArrayList<PayRollObj>();
			
			try
			{
				dbCon database = new dbCon();
				Connection connection = database.Get_Conn_1();
				
				PayRollDAL payroll = new PayRollDAL();
				payRollObj = payroll.createPayRoll(connection, ProllCode, PayHFreqncy, StartDate, EndDate, EmpCount, Amount, PaymentDate, Actor);
			}
			catch(Exception e)
			{
				System.out.println("Exception Error at PayRollManager, createPayRoll " + e.getMessage());
				throw e;
			}
			
			return payRollObj;
		}
		
		public ArrayList<PayRollObj> getPayRoll() throws Exception{
			
			ArrayList<PayRollObj> payRollObj = new ArrayList<PayRollObj>();
			
			try
			{
				dbCon database = new dbCon();
				Connection connection = database.Get_Conn_1();
				
				PayRollDAL payroll = new PayRollDAL();
				payRollObj = payroll.getPayRoll(connection);
			}
			catch(Exception e)
			{
				System.out.println("Exception Error at PayRollManager, getPayRoll " + e.getMessage());
				throw e;
			}
			
			return payRollObj;
		}
		//*************END PAYSLIP***********************
		
}
