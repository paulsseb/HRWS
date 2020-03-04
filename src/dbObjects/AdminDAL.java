package dbObjects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.sql.PreparedStatement;

import objects.AdminObjects.DepartmentObj;
import objects.AdminObjects.DocSeqObj;
import objects.AdminObjects.EmployeeTypeObj;
import objects.AdminObjects.PayHeadDtlsObj;
import objects.AdminObjects.PayHeadSubTypObj;
import objects.AdminObjects.PayHeadTypObj;
import objects.AdminObjects.PositionObj;
import objects.AdminObjects.BranchObj;

public class AdminDAL {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. PAY HEAD TYPE
	public ArrayList<PayHeadTypObj> createPayHeadType(Connection connection, String PayHTypCode, String PayHTypName, String Actor)
			throws SQLException, Exception
	{
		ArrayList<PayHeadTypObj> payHObj = new ArrayList<PayHeadTypObj>();
	try
	{
		String query = "{call createHRPayHeadType(?,?,?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setString(1,PayHTypCode);
		stmt.setString(2,PayHTypName);
		stmt.setString(3,Actor);
		
		int records = stmt.executeUpdate();
		
		if(records > 0)
		{
			PayHeadTypObj obj = new PayHeadTypObj();
			obj.setSuccess("Y");
			obj.setMsg("Pay Head Type Created Successfully!!!");
			payHObj.add(obj);
		}
		else
		{
			PayHeadTypObj obj = new PayHeadTypObj();
			obj.setSuccess("N");
			obj.setMsg("RECORD NOT CREATED!!!");
			payHObj.add(obj);
		}
	} catch (SQLException sqle) {
		System.out.println(
				df.format(dateobj) + " Error at AdminDAL: createPayHeadType SQLException " + sqle.getMessage());
	} catch (Exception e) {
		System.out.println(df.format(dateobj) + " Error at AdminDAL: createPayHeadType Exception " + e.getMessage());
	} finally {
		connection.close();
	}
		return payHObj;
	}
	
	public ArrayList<PayHeadTypObj> getPayHeadType(Connection connection) throws Exception{
		
		ArrayList<PayHeadTypObj> payHObj = new ArrayList<PayHeadTypObj>();
		try
		{
			String query = "{call getHRPayHeadType()}";
			CallableStatement stmt = connection.prepareCall(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				PayHeadTypObj obj = new PayHeadTypObj();
				obj.setPayHTypCode(rs.getString("PAYHTYPCD"));
				obj.setPayHTypNme(rs.getString("PAYHTYPNME"));
				obj.setTransDt(rs.getString("CREATEDT"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				payHObj.add(obj);
			}
			
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: getPayHeadType Exception " + e.getMessage());
		}
		return payHObj;
	}
	//*******************END PAY HEAD TYPE**********************************
	
	//2. PAY HEAD SUB TYPE
	public ArrayList<PayHeadSubTypObj> createPayHeadSubType(Connection connection, String PayHSubTypCode, String PayHSubTypName, 
			String PayHTypode, String Actor)
			throws SQLException, Exception
	{
		ArrayList<PayHeadSubTypObj> payHObj = new ArrayList<PayHeadSubTypObj>();
	try
	{
		String query = "{call createHRPayHeadSubType(?,?,?,?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setString(1,PayHSubTypCode);
		stmt.setString(2,PayHSubTypName);
		stmt.setString(3,PayHTypode);
		stmt.setString(4,Actor);
		
		int records = stmt.executeUpdate();
		
		if(records > 0)
		{
			PayHeadSubTypObj obj = new PayHeadSubTypObj();
			obj.setSuccess("Y");
			obj.setMsg("Pay Head Sub Type Created Successfully!!!");
			payHObj.add(obj);
		}
		else
		{
			PayHeadSubTypObj obj = new PayHeadSubTypObj();
			obj.setSuccess("N");
			obj.setMsg("RECORD NOT CREATED!!!");
			payHObj.add(obj);
		}
	} catch (SQLException sqle) {
		System.out.println(
				df.format(dateobj) + " Error at AdminDAL: createPayHeadSubType SQLException " + sqle.getMessage());
	} catch (Exception e) {
		System.out.println(df.format(dateobj) + " Error at AdminDAL: createPayHeadSubType Exception " + e.getMessage());
	} finally {
		connection.close();
	}
		return payHObj;
	}
	
	public ArrayList<PayHeadSubTypObj> getPayHeadSubType(Connection connection) throws Exception{
		
		ArrayList<PayHeadSubTypObj> payHObj = new ArrayList<PayHeadSubTypObj>();
		try
		{
			String query = "{call getHRPayHeadSubType()}";
			CallableStatement stmt = connection.prepareCall(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				PayHeadSubTypObj obj = new PayHeadSubTypObj();
				obj.setID(rs.getString("MYID"));
				obj.setPayHSubTypCode(rs.getString("PAYHSUBTYPCD"));
				obj.setPayHSubTypNme(rs.getString("PAYHSUBTYPNME"));
				obj.setPayHTypCode(rs.getString("PAYHTYPCD"));
				obj.setTransDt(rs.getString("CREATEDT"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				payHObj.add(obj);
			}
			
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: getPayHeadSubType Exception " + e.getMessage());
		}
		return payHObj;
	}
	//*****************END PAY HEAD SUB TYPE********************************
	
	//3. PAY HEAD DETAILS
	public ArrayList<PayHeadDtlsObj> createPayHeadDtls(Connection connection, String PayHName, 
			String PayHTypCode, String PayHSubTypCode, String Variant, String Actor)
			throws SQLException, Exception
	{
		ArrayList<PayHeadDtlsObj> payHObj = new ArrayList<PayHeadDtlsObj>();
	try
	{
		String query = "{call createHRPayHeadDtls(?,?,?,?,?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setString(1,PayHName);
		stmt.setString(2,PayHTypCode);
		stmt.setString(3,PayHSubTypCode);
		stmt.setString(4,Variant);
		stmt.setString(5,Actor);
		
		int records = stmt.executeUpdate();
		
		if(records > 0)
		{
			PayHeadDtlsObj obj = new PayHeadDtlsObj();
			obj.setSuccess("Y");
			obj.setMsg("Pay Head Details Created Successfully!!!");
			payHObj.add(obj);
		}
		else
		{
			PayHeadDtlsObj obj = new PayHeadDtlsObj();
			obj.setSuccess("N");
			obj.setMsg("RECORD NOT CREATED!!!");
			payHObj.add(obj);
		}
	} catch (SQLException sqle) {
		System.out.println(
				df.format(dateobj) + " Error at AdminDAL: createPayHeadDtls SQLException " + sqle.getMessage());
	} catch (Exception e) {
		System.out.println(df.format(dateobj) + " Error at AdminDAL: createPayHeadDtls Exception " + e.getMessage());
	} finally {
		connection.close();
	}
		return payHObj;
	}
	
	public ArrayList<PayHeadDtlsObj> getPayHeadDtls(Connection connection) throws Exception{
		
		ArrayList<PayHeadDtlsObj> payHObj = new ArrayList<PayHeadDtlsObj>();
		try
		{
			String query = "{call getHRPayHeadDtls()}";
			CallableStatement stmt = connection.prepareCall(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				PayHeadDtlsObj obj = new PayHeadDtlsObj();
				obj.setPayHCode(rs.getString("MYID"));
				obj.setPayHName(rs.getString("PAYHNME"));
				obj.setPayHTypCode(rs.getString("PAYHTYPCD"));
				obj.setPayHSubTypCode(rs.getString("PAYHSUBTYPCD"));
				obj.setVariant(rs.getString("VARIANT"));
				obj.setTransDt(rs.getString("CREATEDT"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				obj.setPayHTypName(rs.getString("PAYHTYPNME"));
				obj.setPayHSubTypName(rs.getString("PAYHSUBTYPNME"));
				payHObj.add(obj);
			}
			
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: getPayHeadDtls Exception " + e.getMessage());
		}
		return payHObj;
	}
	//*****************END PAY HEAD DETAILS*********************************
	
	//4. EMPLOYEE TYPE
	public ArrayList<EmployeeTypeObj> createEmployeeType(Connection connection, String TypeName, String Actor)
					throws SQLException, Exception
			{
				ArrayList<EmployeeTypeObj> employObj = new ArrayList<EmployeeTypeObj>();
			try
			{
				String query = "{call createHREmployeeType(?,?)}";
				CallableStatement stmt = connection.prepareCall(query);
				stmt.setString(1,TypeName);
				stmt.setString(2,Actor);
				
				int records = stmt.executeUpdate();
				
				if(records > 0)
				{
					EmployeeTypeObj depObj = new EmployeeTypeObj();
					depObj.setSuccess("Y");
					depObj.setMsg("Employee Type Created Successfully!!!");
					employObj.add(depObj);
				}
				else
				{
					EmployeeTypeObj depObj = new EmployeeTypeObj();
					depObj.setSuccess("N");
					depObj.setMsg("RECORD NOT CREATED!!!");
					employObj.add(depObj);
				}
			} catch (SQLException sqle) {
				System.out.println(
						df.format(dateobj) + " Error at AdminDAL: createEmployeeType SQLException " + sqle.getMessage());
			} catch (Exception e) {
				System.out.println(df.format(dateobj) + " Error at AdminDAL: createEmployeeType Exception " + e.getMessage());
			} finally {
				connection.close();
			}
				return employObj;
			}
			
	public ArrayList<EmployeeTypeObj> getEmployeeType(Connection connection) throws Exception{
				
				ArrayList<EmployeeTypeObj> employObj = new ArrayList<EmployeeTypeObj>();
				try
				{
					String query = "{call getHREmployeeType()}";
					CallableStatement stmt = connection.prepareCall(query);
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()){
						EmployeeTypeObj obj = new EmployeeTypeObj();
						obj.setID(rs.getString("MYID"));
						obj.setTypeName(rs.getString("ETYPNME"));
						obj.setTransDt(rs.getString("CREATEDT"));
						obj.setCreateBy(rs.getString("CREATEBY"));
						employObj.add(obj);
					}
					
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Error at AdminDAL: getEmployeeType Exception " + e.getMessage());
				}
				return employObj;
			}
			//********************END EMPLOYEE TYPE*********************************
			
	//5. POSITION
	public ArrayList<PositionObj> createPosition(Connection connection, String PositonName, String Actor)
					throws SQLException, Exception
			{
				ArrayList<PositionObj> departObj = new ArrayList<PositionObj>();
			try
			{
				String query = "{call createHREmpPosition(?,?)}";
				CallableStatement stmt = connection.prepareCall(query);
				stmt.setString(1,PositonName);
				stmt.setString(2,Actor);
				
				int records = stmt.executeUpdate();
				
				if(records > 0)
				{
					PositionObj depObj = new PositionObj();
					depObj.setSuccess("Y");
					depObj.setMsg("Position Created Successfully!!!");
					departObj.add(depObj);
				}
				else
				{
					PositionObj depObj = new PositionObj();
					depObj.setSuccess("N");
					depObj.setMsg("RECORD NOT CREATED!!!");
					departObj.add(depObj);
				}
			} catch (SQLException sqle) {
				System.out.println(
						df.format(dateobj) + " Error at AdminDAL: createPosition SQLException " + sqle.getMessage());
			} catch (Exception e) {
				System.out.println(df.format(dateobj) + " Error at AdminDAL: createPosition Exception " + e.getMessage());
			} finally {
				connection.close();
			}
				return departObj;
			}
			
	public ArrayList<PositionObj> getPosition(Connection connection) throws Exception{
				
				ArrayList<PositionObj> postObj = new ArrayList<PositionObj>();
				try
				{
					String query = "{call getHREmpPosition()}";
					CallableStatement stmt = connection.prepareCall(query);
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()){
						PositionObj obj = new PositionObj();
						obj.setPostCode(rs.getString("POSTNCD"));
						obj.setPostName(rs.getString("POSTNME"));
						obj.setTransDt(rs.getString("CREATEDT"));
						obj.setCreateBy(rs.getString("CREATEBY"));
						postObj.add(obj);
					}
					
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Error at AdminDAL: getPosition Exception " + e.getMessage());
				}
				return postObj;
			}
			//********************END POSITION***************************************	

	//6. DEPARTMENT
	public ArrayList<DepartmentObj> createDepartment(Connection connection, String DeptName,
					String DeptDesc, String Manager, String Actor)
					throws SQLException, Exception
			{
				ArrayList<DepartmentObj> departObj = new ArrayList<DepartmentObj>();
			try
			{
				String query = "{call createHRDepartment(?,?,?,?)}";
				CallableStatement stmt = connection.prepareCall(query);
				stmt.setString(1,DeptName);
				stmt.setString(2,DeptDesc);
				stmt.setString(3,Manager);
				stmt.setString(4,Actor);
				
				int records = stmt.executeUpdate();
				
				if(records > 0)
				{
					DepartmentObj depObj = new DepartmentObj();
					depObj.setSuccess("Y");
					depObj.setMsg("Department Created Successfully!!!");
					departObj.add(depObj);
				}
				else
				{
					DepartmentObj depObj = new DepartmentObj();
					depObj.setSuccess("N");
					depObj.setMsg("RECORD NOT CREATED!!!");
					departObj.add(depObj);
				}
			} catch (SQLException sqle) {
				System.out.println(
						df.format(dateobj) + " Error at AdminDAL: createDepartment SQLException " + sqle.getMessage());
			} catch (Exception e) {
				System.out.println(df.format(dateobj) + " Error at AdminDAL: createDepartment Exception " + e.getMessage());
			} finally {
				connection.close();
			}
				return departObj;
			}
			
	public ArrayList<DepartmentObj> getDepartment(Connection connection) throws Exception{
				
				ArrayList<DepartmentObj> departObj = new ArrayList<DepartmentObj>();
				try
				{
					String query = "{call getHRDepartment()}";
					CallableStatement stmt = connection.prepareCall(query);
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()){
						DepartmentObj obj = new DepartmentObj();
						obj.setDeptCode(rs.getString("DEPTCD"));
						obj.setDeptName(rs.getString("DEPTNME"));
						obj.setDeptDesc(rs.getString("DEPTDESC"));
						obj.setManager(rs.getString("MANAGER"));
						obj.setTransDt(rs.getString("CREATEDT"));
						obj.setCreateBy(rs.getString("CREATEBY"));
						departObj.add(obj);
					}
					
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Error at AdminDAL: getDepartment Exception " + e.getMessage());
				}
				return departObj;
			}
			//******************************END DEPARTMENT**************************
		
	//7. BRANCH
	public ArrayList<BranchObj> createBranch(Connection connection, String bcode, String bname,
			String btasks, String actor) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ArrayList<BranchObj> userData = new ArrayList<BranchObj>();
		try {
			
			String query = "{call createBranch(?,?,?,?)}";
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1, bcode);
			stmt.setString(2, bname);
			stmt.setString(3, btasks);
			stmt.setString(4, actor);

			int records = stmt.executeUpdate();
			if (records > 0) {
				BranchObj inqobj = new BranchObj();
				inqobj.setSuccess("Y");
				inqobj.setMsg("Branch Created Successfully!!! ");
				userData.add(inqobj);
			} else {
				BranchObj inqobj = new BranchObj();
				inqobj.setSuccess("N");
				inqobj.setMsg("Record NOT Created");
				userData.add(inqobj);
			}
		} catch (SQLException sqle) {
			System.out
					.println(df.format(dateobj) + " Error at CompanyDAL: createBranch SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at CompanyDAL: createBranch Exception " + e.getMessage());
		} finally {
			connection.close();
		}
		return userData;
	}
	
	public ArrayList<BranchObj> getBranch(Connection connection, String Actor, String App) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ArrayList<BranchObj> branchData = new ArrayList<BranchObj>();
		try {
			String query = "{ call getBranch()}";
			CallableStatement stmt = connection.prepareCall(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				BranchObj userObj = new BranchObj();
				userObj.setBCode(rs.getString("BCD"));
				userObj.setBName(rs.getString("BNAME"));
				userObj.setBTasks(rs.getString("BTASKS"));
				userObj.setIsActive(rs.getString("ISACTIVE"));

				branchData.add(userObj);
			}
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Exception Error at CompanyDAL, getBranch " + e.getMessage());
		} finally {
			connection.close();
		}
		return branchData;
	}
	//********************END BRANCH************************************************

	//8. SEQUENCE NUMBER
	public ArrayList<DocSeqObj> getSeqNumber(Connection connection, String DocCode) throws SQLException, Exception {

		ArrayList<DocSeqObj> docData = new ArrayList<DocSeqObj>();
		try {
			//update and select the next sequence
			String sqQuery = "{call getSeqNo(?,?)}";
			CallableStatement sqstmt = connection.prepareCall(sqQuery);
			sqstmt.setString(1, DocCode);
			sqstmt.setString(2, currentYear.format(dateobj));
			
			ResultSet rs = sqstmt.executeQuery();
			while (rs.next()) {
				DocSeqObj obj = new DocSeqObj();
				obj.setSeqNo(rs.getString("NEXTSQ"));
				docData.add(obj);
			}
			
		} catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at AdminDAL: getSeqNumber SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: getSeqNumber Exception " + e.getMessage());
		} finally {
			connection.close();
		}
		return docData;
	}
	//******************END SEQUENCE NUMBER*********************
	
	//9. EMPLOYEE SALARY
	public ArrayList<PayHeadDtlsObj> createEmployeeSalary(Connection connection, String EmpNO, String PayHName,
			String Dr, String Cr, String Frequency, String Actor) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ArrayList<PayHeadDtlsObj> userData = new ArrayList<PayHeadDtlsObj>();
		try {
			
			String EmpNumber = "";
			String PayHeadName = "";
			CallableStatement stmt = null;
			int records = 0;
			
			//1. GET RECORDS FROM THE DATABASE
			PreparedStatement pr = null;
			pr = connection.prepareStatement("SELECT * FROM `hr_empsalry_t` WHERE EMPNO = '"+EmpNO+"' AND PAYHNME = '"+PayHName+"'");
			
			ResultSet rsBal = pr.executeQuery();
			
			while (rsBal.next()) {
				EmpNumber = rsBal.getString("EMPNO");
				PayHeadName = rsBal.getString("PAYHNME");
			}
			//2. IF FOUND
			 if(EmpNumber.contains(EmpNO) && PayHeadName.contains(PayHName))
			 {
				 //THEN IT SHOULD JUST UPDATE THE EXISTING RECORDS
				 pr = null;
				 pr = connection.prepareStatement("UPDATE `pmaccounting`.`hr_empsalry_t` SET DR = ?, CR = ?, `FREQNCY` = ?, ISACTIVE = 'Y', UPDATEBY = ? WHERE EMPNO = ? AND PAYHNME = ?;");
				  pr.setString(1, Dr);
				  pr.setString(2, Cr);
				  pr.setString(3, Frequency);
				  pr.setString(4, Actor);
				  pr.setString(5, EmpNO);
				  pr.setString(6, PayHName);
				  pr.executeUpdate();
				  
				  records = pr.executeUpdate();
			 }
			//3. IF NOT FOUND
			 else
			 {
				 //THEN IT SHOULD ADD NEW
				String query = "{call createHREmpSalary(?,?,?,?,?,?)}";
				stmt = connection.prepareCall(query);
				stmt.setString(1, EmpNO);
				stmt.setString(2, PayHName);
				stmt.setString(3, Dr);
				stmt.setString(4, Cr);
				stmt.setString(5, Frequency);
				stmt.setString(6, Actor);
				
				records = stmt.executeUpdate();
			 }
			 
			if (records > 0) {
				PayHeadDtlsObj inqobj = new PayHeadDtlsObj();
				inqobj.setSuccess("Y");
				inqobj.setMsg("Employee Salary Created Successfully!!! ");
				userData.add(inqobj);
			} else {
				PayHeadDtlsObj inqobj = new PayHeadDtlsObj();
				inqobj.setSuccess("N");
				inqobj.setMsg("Record NOT Created");
				userData.add(inqobj);
			}
		} catch (SQLException sqle) {
			System.out
					.println(df.format(dateobj) + " Error at AdminDAL: createEmployeeSalary SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: createEmployeeSalary Exception " + e.getMessage());
		} finally {
			connection.close();
		}
		return userData;
	}
	public ArrayList<PayHeadDtlsObj> getEmployeeSalary(Connection connection, String EmpNO) throws SQLException, Exception {

		ArrayList<PayHeadDtlsObj> docData = new ArrayList<PayHeadDtlsObj>();
		try {
			//update and select the next sequence
			String sqQuery = "{call getHREmpSalary(?)}";
			CallableStatement sqstmt = connection.prepareCall(sqQuery);
			sqstmt.setString(1, EmpNO);
			
			ResultSet rs = sqstmt.executeQuery();
			while (rs.next()) {
				PayHeadDtlsObj obj = new PayHeadDtlsObj();
				obj.setEmpSalryID(rs.getString("MYID"));
				obj.setEmpNO(rs.getString("EMPNO"));
				obj.setPayHName(rs.getString("PAYHNME"));
				obj.setDR(rs.getString("DR"));
				obj.setCR(rs.getString("CR"));
				obj.setFrequency(rs.getString("FREQNCY"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				obj.setPayHTypCode(rs.getString("PAYHTYPCD"));
				obj.setEmpName(rs.getString("EPNME"));
				docData.add(obj);
			}
			
		} catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at AdminDAL: getEmployeeSalary SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: getEmployeeSalary Exception " + e.getMessage());
		} finally {
			connection.close();
		}
		return docData;
	}
	
	public ArrayList<PayHeadDtlsObj> updateEmployeeSalary(Connection connection, String EmpSalryID, String Dr, String Cr, String Frequency, String Status, String Actor) throws SQLException, Exception {

		ArrayList<PayHeadDtlsObj> userData = new ArrayList<PayHeadDtlsObj>();
		try {
			//update and select the next sequence
			String sqQuery = "{call updateHREmpSalary(?,?,?,?,?,?)}";
			CallableStatement stmt = connection.prepareCall(sqQuery);
			stmt.setString(1, EmpSalryID);
			stmt.setString(2, Dr);
			stmt.setString(3, Cr);
			stmt.setString(4, Frequency); 
			stmt.setString(5, Status);
			stmt.setString(6, Actor);
			
			int records = stmt.executeUpdate();
			if (records > 0) {
				PayHeadDtlsObj inqobj = new PayHeadDtlsObj();
				inqobj.setSuccess("Y");
				inqobj.setMsg("Employee Salary Updated Successfully!!! ");
				userData.add(inqobj);
			} else {
				PayHeadDtlsObj inqobj = new PayHeadDtlsObj();
				inqobj.setSuccess("N");
				inqobj.setMsg("Record NOT Created");
				userData.add(inqobj);
			}
			
		} catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at AdminDAL: updateEmployeeSalary SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: updateEmployeeSalary Exception " + e.getMessage());
		} finally {
			connection.close();
		}
		return userData;
	}
	//**************EMPLOYEE SALARY********************************
}
