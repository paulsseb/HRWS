package dbObjects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import objects.EmployeeObjects.EmployeeObj;

public class EmployeeDAL {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. EMPLOYEE
		public ArrayList<EmployeeObj> createEmployee(Connection connection, String EmpName,String EmpNumber,
				String Email,String NSSFNO,String Tin,String MobilePhone,String Address,String DateOfBirth,String Nationality,
				String MaritalStatus,String Gender,String NxtOfKin,String NxtOfKinContact,String NxtOfKinRelation,String Branch,
				String Department,String Position,String ReportTo,String DateOfJoin,String EmpTyp,String WorkPhone,String LeaveRate,
				String WorkStartDt,String WorkEndDt,String PayMode,String MMoneyPhone,String BankName,String BankBranch,
				String BankActNO,String Actor)
				throws SQLException, Exception
		{
			ArrayList<EmployeeObj> employeeObj = new ArrayList<EmployeeObj>();
		try
		{
			String query = "{call createHREmployee(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1,EmpName);
			stmt.setString(2,EmpNumber);
			stmt.setString(3,Email);
			stmt.setString(4,NSSFNO);
			stmt.setString(5,Tin);
			stmt.setString(6,MobilePhone);
			stmt.setString(7,Address);
			stmt.setString(8,DateOfBirth);
			stmt.setString(9,Nationality);
			stmt.setString(10,MaritalStatus);
			stmt.setString(11,Gender);
			stmt.setString(12,NxtOfKin);
			stmt.setString(13,NxtOfKinContact);
			stmt.setString(14,NxtOfKinRelation);
			stmt.setString(15,Branch);
			stmt.setString(16,Department);
			stmt.setString(17,Position);
			stmt.setString(18,ReportTo);
			stmt.setString(19,DateOfJoin);
			stmt.setString(20,EmpTyp);
			stmt.setString(21,WorkPhone);
			stmt.setString(22,LeaveRate);
			stmt.setString(23,WorkStartDt);
			stmt.setString(24,WorkEndDt);
			stmt.setString(25,PayMode);
			stmt.setString(26,MMoneyPhone);
			stmt.setString(27,BankName);
			stmt.setString(28,BankBranch);
			stmt.setString(29,BankActNO);
			stmt.setString(30,Actor);
			
			int records = stmt.executeUpdate();
			
			if(records > 0)
			{
				EmployeeObj obj = new EmployeeObj();
				obj.setSuccess("Y");
				obj.setMsg("Employee Created Successfully!!!");
				employeeObj.add(obj);
			}
			else
			{
				EmployeeObj obj = new EmployeeObj();
				obj.setSuccess("N");
				obj.setMsg("RECORD NOT CREATED!!!");
				employeeObj.add(obj);
			}
		} catch (SQLException sqle) {
			System.out.println(
					df.format(dateobj) + " Error at AdminDAL: createEmployee SQLException " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at AdminDAL: createEmployee Exception " + e.getMessage());
		} finally {
			connection.close();
		}
			return employeeObj;
		}
		
		public ArrayList<EmployeeObj> getEmployees(Connection connection) throws Exception{
			
			ArrayList<EmployeeObj> employeeObj = new ArrayList<EmployeeObj>();
			try
			{
				String query = "{call getHREmployees()}";
				CallableStatement stmt = connection.prepareCall(query);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					EmployeeObj obj = new EmployeeObj();
					obj.setEmpID(rs.getString("EPID"));
					obj.setEmpName(rs.getString("EPNME"));
					obj.setEmpNumber(rs.getString("EPNO"));
					obj.setEmail(rs.getString("EPEMAIL"));
					obj.setNSSFNO(rs.getString("NSSFNO"));
					obj.setTin(rs.getString("ETIN"));
					obj.setMobilePhone(rs.getString("MBPHONE"));
					obj.setAddress(rs.getString("EADDRESS"));
					obj.setDateOfBirth(rs.getString("DOB"));
					obj.setNationality(rs.getString("NATIONALITY"));
					obj.setMaritalStatus(rs.getString("MSTATUS"));
					obj.setGender(rs.getString("GENDER"));
					obj.setNxtOfKin(rs.getString("NXTKIN"));
					obj.setNxtOfKinContact(rs.getString("NXTKINCONTCT"));
					obj.setNxtOfKinRelation(rs.getString("NXTKINRELATN"));
					obj.setBranch(rs.getString("BRANCH"));
					obj.setDepartment(rs.getString("DEPT"));
					obj.setPosition(rs.getString("POSTN"));
					obj.setReportTo(rs.getString("REPORTTO"));
					obj.setDateOfJoin(rs.getString("DATEOFJOIN"));
					obj.setEmpTyp(rs.getString("ETYP"));
					obj.setWorkPhone(rs.getString("WRKPHONE"));
					obj.setLeaveRate(rs.getString("LEAVERATE"));
					obj.setWorkStartDt(rs.getString("WRKSTARTDT"));
					obj.setWorkEndDt(rs.getString("WRKENDDT"));
					obj.setPayMode(rs.getString("PAYMODE"));
					obj.setMMoneyPhone(rs.getString("MMPHONE"));
					obj.setBankName(rs.getString("BNKNME"));
					obj.setBankBranch(rs.getString("BNKBRANCH"));
					obj.setBankActNO(rs.getString("BNKACTNO"));
					obj.setTransDt(rs.getString("CREATEDT"));
					obj.setCreateBy(rs.getString("CREATEBY"));
					employeeObj.add(obj);
				}
				
			} catch (Exception e) {
				System.out.println(df.format(dateobj) + " Error at AdminDAL: getEmployees Exception " + e.getMessage());
			}
			return employeeObj;
		}
		//****************END EMPLOYEE******************************************
		
}
