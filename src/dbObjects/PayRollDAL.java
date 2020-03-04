package dbObjects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import objects.PayRollObjects.PayRollObj;
import objects.PayRollObjects.PaySlipObj;
import objects.PayRollObjects.PaySlipDtlsObj;

public class PayRollDAL {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. PAYSLIP
	public ArrayList<PaySlipObj> createPaySlip(Connection connection, String PaySlipCode, String Description,
			String DateFrom, String DateTo, String Amount, String ProllCode, String EmployID,
			String Actor) throws Exception{
		
		ArrayList<PaySlipObj> paySlipObj = new ArrayList<PaySlipObj>();
	
		try
		{
			String query = "{call createHRPaySlip(?,?,?,?,?,?,?,?)}";
			CallableStatement stmt = connection.prepareCall(query);
			
			stmt.setString(1, PaySlipCode);
			stmt.setString(2, Description);
			stmt.setString(3, DateFrom);
			stmt.setString(4, DateTo);
			stmt.setString(5, Amount);
			stmt.setString(6, ProllCode);
			stmt.setString(7, EmployID);
			stmt.setString(8, Actor);
			
			int records = stmt.executeUpdate();
			
			if(records > 0)
			{
				PaySlipObj obj = new PaySlipObj();
				obj.setSuccess("Y");
				obj.setMsg("PaySlip Created Successfully!!!");
				paySlipObj.add(obj);
			}
			else
			{
				PaySlipObj obj = new PaySlipObj();
				obj.setSuccess("N");
				obj.setMsg("PaySlip NOT CREATED!!!");
				paySlipObj.add(obj);
			}
		}catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at AdminDAL: createPaySlip SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: createPaySlip Exception " + e.getMessage());
		}finally{
			connection.close();
		}
		
		return paySlipObj;
	}
	
	public ArrayList<PaySlipObj> getPaySlip(Connection connection, String PayRollCd) throws Exception{
		
		ArrayList<PaySlipObj> paySlipObj = new ArrayList<PaySlipObj>();
		
		try
		{
			String query = "call getHRPaySlip(?)";
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1, PayRollCd);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				PaySlipObj obj = new PaySlipObj();
				obj.setPaySlipCode(rs.getString("PCD"));
				obj.setDescription(rs.getString("PDESC"));
				obj.setDateFrom(rs.getString("DATEFRM"));
				obj.setDateTo(rs.getString("DATETO"));
				obj.setAmount(rs.getString("AMT"));
				obj.setProllCode(rs.getString("PROLLCD"));
				obj.setEmpID(rs.getString("EMPID"));
				obj.setTransDt(rs.getString("CREATEDT"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				obj.setEmpName(rs.getString("EPNME"));
				
				paySlipObj.add(obj);
			}
			
		}
		catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at AdminDAL: getPaySlip SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: getPaySlip Exception " + e.getMessage());
		}finally{
			connection.close();
		}
	
		return paySlipObj;
	}
	//******************END PAYSLIP****************************
	
	//2. PAYSLIP DETAILS 
	public ArrayList<PaySlipDtlsObj> createPaySlipDtls(Connection connection, String PaySlipCode, String PayHeadName,
			String PayHeadCode, String PayHeadTypCode, String Amount, String Quantity, String Actor) throws Exception{
		
		ArrayList<PaySlipDtlsObj> paySlipObj = new ArrayList<PaySlipDtlsObj>();
	
		try
		{
			String query = "{call createHRPaySlipDtls(?,?,?,?,?,?,?)}";
			CallableStatement stmt = connection.prepareCall(query);
			
			stmt.setString(1, PaySlipCode);
			stmt.setString(2, PayHeadName);
			stmt.setString(3, PayHeadCode);
			stmt.setString(4, PayHeadTypCode);
			stmt.setString(5, Amount);
			stmt.setString(6, Quantity);
			stmt.setString(7, Actor);
			
			int records = stmt.executeUpdate();
			
			if(records > 0)
			{
				PaySlipDtlsObj obj = new PaySlipDtlsObj();
				obj.setSuccess("Y");
				obj.setMsg("PaySlip Details Created Successfully!!!");
				paySlipObj.add(obj);
			}
			else
			{
				PaySlipDtlsObj obj = new PaySlipDtlsObj();
				obj.setSuccess("N");
				obj.setMsg("PaySlip Details NOT CREATED!!!");
				paySlipObj.add(obj);
			}
		}catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at PayRollDAL: createPaySlipDtls SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at PayRollDAL: createPaySlipDtls Exception " + e.getMessage());
		}finally{
			connection.close();
		}
		
		return paySlipObj;
	}
	
	public ArrayList<PaySlipDtlsObj> getPaySlipDtls(Connection connection, String PaySlipCode) throws Exception{
		
		ArrayList<PaySlipDtlsObj> paySlipObj = new ArrayList<PaySlipDtlsObj>();
		
		try
		{
			String query = "call getHRPaySlipDtls(?)";
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1,PaySlipCode);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				PaySlipDtlsObj obj = new PaySlipDtlsObj();
				obj.setID(rs.getString("MYID"));
				obj.setPaySlipCode(rs.getString("PCD"));
				obj.setPayHName(rs.getString("PAYHNME"));
				obj.setPayHCode(rs.getString("PAYHCODE"));
				obj.setPayHTypCode(rs.getString("PAYHTYPCD"));
				obj.setAmount(rs.getString("AMT"));
				obj.setQuantity(rs.getString("QTY"));
				obj.setTransDt(rs.getString("CREATEDT"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				
				paySlipObj.add(obj);
			}
		}
		catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at AdminDAL: getPaySlipDtls SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: getPaySlipDtls Exception " + e.getMessage());
		}finally{
			connection.close();
		}
	
		return paySlipObj;
	}
	
	//*************************END PAYSLIP DETAILS**************
	
	//1. PAYROLL
		public ArrayList<PayRollObj> createPayRoll(Connection connection, String ProllCode, String PayHFreqncy, String StartDate,
				String EndDate, String EmpCount, String Amount, String PaymentDate, String Actor) throws Exception{
			
			ArrayList<PayRollObj> payRollObj = new ArrayList<PayRollObj>();
		
			try
			{
				String query = "{call createHRPayRoll(?,?,?,?,?,?,?,?)}";
				CallableStatement stmt = connection.prepareCall(query);
				
				stmt.setString(1, ProllCode);
				stmt.setString(2, PayHFreqncy);
				stmt.setString(3, StartDate);
				stmt.setString(4, EndDate);
				stmt.setString(5, EmpCount);
				stmt.setString(6, Amount);
				stmt.setString(7, PaymentDate);
				stmt.setString(8, Actor);
				
				int records = stmt.executeUpdate();
				
				if(records > 0)
				{
					PayRollObj obj = new PayRollObj();
					obj.setSuccess("Y");
					obj.setMsg("PayRoll Created Successfully!!!");
					payRollObj.add(obj);
				}
				else
				{
					PayRollObj obj = new PayRollObj();
					obj.setSuccess("N");
					obj.setMsg("PayRoll NOT CREATED!!!");
					payRollObj.add(obj);
				}
			}catch (SQLException sqle) {
				System.out.println(
						df.format(dateobj) + " Error at PayRollDAL: createPayRoll SQLException " + sqle.getMessage());
			} catch (Exception e) {
				System.out.println(df.format(dateobj) + " Error at PayRollDAL: createPayRoll Exception " + e.getMessage());
			}finally{
				connection.close();
			}
			
			return payRollObj;
		}
		
		public ArrayList<PayRollObj> getPayRoll(Connection connection) throws Exception{
			
			ArrayList<PayRollObj> payRollObj = new ArrayList<PayRollObj>();
			
			try
			{
				String query = "call getHRPayRoll()";
				CallableStatement stmt = connection.prepareCall(query);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					
					PayRollObj obj = new PayRollObj();
					obj.setPayRollCd(rs.getString("PROLLCD"));
					obj.setPayHFreqncy(rs.getString("PAYHFREQ"));
					obj.setStartDate(rs.getString("STARTDT"));
					obj.setEndDate(rs.getString("ENDDT"));
					obj.setEmpCount(rs.getString("EMPCOUNT"));
					obj.setAmount(rs.getString("AMOUNT"));
					obj.setPaymentDate(rs.getString("TRANSDT"));
					obj.setCreateBy(rs.getString("CREATEBY"));
					
					payRollObj.add(obj);
				}
				
			}
			catch (SQLException sqle) {
				System.out.println(
						df.format(dateobj) + " Error at AdminDAL: getPayRoll SQLException " + sqle.getMessage());
			} catch (Exception e) {
				System.out.println(df.format(dateobj) + " Error at AdminDAL: getPayRoll Exception " + e.getMessage());
			}finally{
				connection.close();
			}
		
			return payRollObj;
		}
		//******************END PAYROLL****************************
		
}
