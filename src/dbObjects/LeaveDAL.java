package dbObjects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import objects.LeaveObjects.LeaveObj;

public class LeaveDAL {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	public ArrayList<LeaveObj> createLeaveType(Connection connection, String TypeName, String Actor) throws SQLException, Exception
	{
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		
		try
		{
			String query = "{call createHRLeaveType(?,?)}";
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1, TypeName);
			stmt.setString(2, Actor);
			
			int records = stmt.executeUpdate();
			
			if(records > 0)
			{
				LeaveObj obj = new LeaveObj();
				obj.setSuccess("Y");
				obj.setMsg("Leave Type Created Successfully!!!");
				leave.add(obj);
			}
			else
			{
				LeaveObj obj = new LeaveObj();
				obj.setSuccess("N");
				obj.setMsg("Record Not Saved!!!");
				leave.add(obj);
			}
		}
		catch(SQLException sqle)
		{
			System.out.println(df.format(dateobj) + " Error at LeaveDAL: createLeaveType Exception " + sqle.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(df.format(dateobj) + " Error at LeaveDAL: createLeaveType Exception " + e.getMessage());
		}
		finally 
		{
			connection.close();
		}
		return leave;
	}
	
public ArrayList<LeaveObj> getLeaveType(Connection connection) throws Exception{
		
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		try
		{
			String query = "{call getHRLeaveType()}";
			CallableStatement stmt = connection.prepareCall(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				LeaveObj obj = new LeaveObj();
				obj.setID(rs.getString("MYID"));
				obj.setTypeName(rs.getString("LTYPNME"));
				obj.setCreateDt(rs.getString("CREATEDT"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				leave.add(obj);
			}
			
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at LeaveDAL: getHRLeaveType Exception " + e.getMessage());
		}
		return leave;
	}

	public ArrayList<LeaveObj> createLeave(Connection connection, String EmpNO, String TypeName, String StartDate, String EndDate, String LeaveDays, String Remarks, String Actor) throws SQLException, Exception
	{
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		
		try
		{
			String query = "{call createHRLeave(?,?,?,?,?,?,?)}";
			CallableStatement stmt = connection.prepareCall(query);
			stmt.setString(1, EmpNO);
			stmt.setString(2, TypeName);
			stmt.setString(3, StartDate);
			stmt.setString(4, EndDate);
			stmt.setString(5, LeaveDays);
			stmt.setString(6, Remarks);
			stmt.setString(7, Actor);
			
			int records = stmt.executeUpdate();
			
			if(records > 0)
			{
				LeaveObj obj = new LeaveObj();
				obj.setSuccess("Y");
				obj.setMsg("Leave Created Successfully!!!");
				leave.add(obj);
			}
			else
			{
				LeaveObj obj = new LeaveObj();
				obj.setSuccess("N");
				obj.setMsg("Record Not Saved!!!");
				leave.add(obj);
			}
		}
		catch(SQLException sqle)
		{
			System.out.println(df.format(dateobj) + " Error at LeaveDAL: createLeave Exception " + sqle.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(df.format(dateobj) + " Error at LeaveDAL: createLeave Exception " + e.getMessage());
		}
		finally 
		{
			connection.close();
		}
		return leave;
	}
	
public ArrayList<LeaveObj> getLeave(Connection connection) throws Exception{
		
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		try
		{
			String query = "{call getHRLeave()}";
			CallableStatement stmt = connection.prepareCall(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				LeaveObj obj = new LeaveObj();
				obj.setID(rs.getString("MYID"));
				obj.setEmpNO(rs.getString("EMPNO"));
				obj.setTypeName(rs.getString("TYPMNE"));
				obj.setStartDate(rs.getString("STARTDT"));
				obj.setEndDate(rs.getString("ENDDT"));
				obj.setLeaveDays(rs.getString("NODAYS"));
				obj.setRemarks(rs.getString("REMARKS"));
				obj.setStatus(rs.getString("STATUS"));
				obj.setCreateDt(rs.getString("CREATEDT"));
				obj.setCreateBy(rs.getString("CREATEBY"));
				obj.setEmpName(rs.getString("EPNME"));
				obj.setEmpEmail(rs.getString("EPEMAIL"));
				obj.setPosition(rs.getString("POSTN"));
				obj.setAppointDate(rs.getString("DATEOFJOIN"));
				obj.setWrkPhone(rs.getString("WRKPHONE"));
				obj.setLeaveRate(rs.getString("LEAVERATE"));
				leave.add(obj);
			}
			
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Error at LeaveDAL: getHRLeave Exception " + e.getMessage());
		}
		return leave;
	}

public ArrayList<LeaveObj> getLeaveUtitlty(Connection connection) throws Exception{
	
	ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
	try
	{
		String query = "{call getHRLeaveUtility()}";
		CallableStatement stmt = connection.prepareCall(query);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			LeaveObj obj = new LeaveObj();
			obj.setDepartment(rs.getString("DEPT"));
			obj.setEmpNO(rs.getString("EPNO"));
			obj.setEmpName(rs.getString("EPNME"));
			obj.setLeaveEarned(rs.getString("LEAVEEARNED"));
			obj.setLeaveTaken(rs.getString("LEAVETAKEN"));
			leave.add(obj);
		}
		
	} catch (Exception e) {
		System.out.println(df.format(dateobj) + " Error at LeaveDAL: getHRLeaveUtility Exception " + e.getMessage());
	}
	return leave;
}
}
