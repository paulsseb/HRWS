package models;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dbObjects.LeaveDAL;
import dbObjects.dbCon;
import objects.LeaveObjects.LeaveObj;

public class LeaveManager {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	public ArrayList<LeaveObj> createLeaveType(String TypeName, String Actor)
	{
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			LeaveDAL dal = new LeaveDAL();
			leave = dal.createLeaveType(connection, TypeName, Actor);
		}
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveManager, createLeaveType "+ e.getMessage());
		}
		return leave;
	}
	
	public ArrayList<LeaveObj> getLeaveType()
	{
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			LeaveDAL dal = new LeaveDAL();
			leave = dal.getLeaveType(connection);
		}
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveManager, getLeaveType "+ e.getMessage());
		}
		return leave;
	}
	
	public ArrayList<LeaveObj> createLeave(String EmpNO, String TypeName, String StartDate, String EndDate, String LeaveDays, String Remarks, String Actor)
	{
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			LeaveDAL dal = new LeaveDAL();
			leave = dal.createLeave(connection, EmpNO, TypeName, StartDate, EndDate, LeaveDays, Remarks, Actor);
		}
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveManager, createLeave "+ e.getMessage());
		}
		return leave;
	}
	
	public ArrayList<LeaveObj> getLeave()
	{
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			LeaveDAL dal = new LeaveDAL();
			leave = dal.getLeave(connection);
		}
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveManager, getLeave "+ e.getMessage());
		}
		return leave;
	}
	
	public ArrayList<LeaveObj> getLeaveUtitlty()
	{
		ArrayList<LeaveObj> leave = new ArrayList<LeaveObj>();
		try
		{
			dbCon database = new dbCon();
			Connection connection = database.Get_Conn_1();
			
			LeaveDAL dal = new LeaveDAL();
			leave = dal.getLeaveUtitlty(connection);
		}
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveManager, getLeaveUtitlty "+ e.getMessage());
		}
		return leave;
	}
}
