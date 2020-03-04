package webServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import models.LeaveManager;
import org.codehaus.jettison.json.JSONObject;
import com.google.gson.Gson;
import objects.LeaveObjects.LeaveObj;

@Path("/LeaveWS")

public class LeaveWS {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	@GET
	@Path("/createLeaveType")
	@Produces("application/json")
	public JSONObject createLeaveType(@QueryParam("TypeName") String TypeName, @QueryParam("Actor") String Actor, @QueryParam("App") String App)
	{	
		String response = null;
		JSONObject JSONobj = null;
		
		try
		{
			System.out.println(df.format(dateobj)+" We are creating leave type, TypeName: "+TypeName+", Actor:"+Actor+", App:"+App);
			
			ArrayList<LeaveObj> Obj = null;
			LeaveManager leaveManager = new LeaveManager();
			Obj  = leaveManager.createLeaveType(TypeName, Actor);
			
			Gson gson = new Gson();
			response = gson.toJson(Obj);
			
			JSONObject json = new JSONObject();
			json.put("jsonResult", response);
			
			//Remove all slash characters in string 
			response = json.toString().replace("\\", "");
			
			if(response.length() > 10)
			{
				int m = 15;
				int n = response.length()-2;
				
				response = response.substring(0, m-1)+response.substring(m);
				response = response.substring(0, n-1)+response.substring(n);
			}
			
			JSONobj = new JSONObject(response);
			
		}	
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveWS: createLeaveType " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getLeaveType")
	@Produces("application/json")
	public JSONObject getLeaveType(@QueryParam("Actor") String Actor, @QueryParam("App") String App)
	{	
		String response = null;
		JSONObject JSONobj = null;
		
		try
		{
			System.out.println(df.format(dateobj)+" We are getting leave type Actor:"+Actor+", App:"+App);
			
			ArrayList<LeaveObj> Obj = null;
			LeaveManager leaveManager = new LeaveManager();
			Obj  = leaveManager.getLeaveType();
			
			Gson gson = new Gson();
			response = gson.toJson(Obj);
			
			JSONObject json = new JSONObject();
			json.put("jsonResult", response);
			
			//Remove all slash characters in string 
			response = json.toString().replace("\\", "");
			
			if(response.length() > 10)
			{
				int m = 15;
				int n = response.length()-2;
				
				response = response.substring(0, m-1)+response.substring(m);
				response = response.substring(0, n-1)+response.substring(n);
			}
			
			JSONobj = new JSONObject(response);
		}	
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveWS: getLeaveType " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/createLeave")
	@Produces("application/json")
	public JSONObject createLeave(@QueryParam("EmpNO") String EmpNO, @QueryParam("TypeName") String TypeName,
			@QueryParam("StartDate") String StartDate, @QueryParam("EndDate") String EndDate,
			@QueryParam("LeaveDays") String LeaveDays, @QueryParam("Remarks") String Remarks,
			@QueryParam("Actor") String Actor, @QueryParam("App") String App)
	{	
		String response = null;
		JSONObject JSONobj = null;
		
		try
		{
			System.out.println(df.format(dateobj)+" We are creating leave, TypeName: "+TypeName+", Actor:"+Actor+"App:"+App);
			
			ArrayList<LeaveObj> Obj = null;
			LeaveManager leaveManager = new LeaveManager();
			Obj  = leaveManager.createLeave(EmpNO, TypeName, StartDate, EndDate, LeaveDays, Remarks, Actor);
			
			Gson gson = new Gson();
			response = gson.toJson(Obj);
			
			JSONObject json = new JSONObject();
			json.put("jsonResult", response);
			
			//Remove all slash characters in string 
			response = json.toString().replace("\\", "");
			
			if(response.length() > 10)
			{
				int m = 15;
				int n = response.length()-2;
				
				response = response.substring(0, m-1)+response.substring(m);
				response = response.substring(0, n-1)+response.substring(n);
			}
			
			JSONobj = new JSONObject(response);
		}	
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveWS: createLeaveType " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getLeave")
	@Produces("application/json")
	public JSONObject getLeave(@QueryParam("Actor") String Actor, @QueryParam("App") String App)
	{	
		String response = null;
		JSONObject JSONobj = null;
		
		try
		{
			System.out.println(df.format(dateobj)+" We are getting leave Actor:"+Actor+", App:"+App);
			
			ArrayList<LeaveObj> Obj = null;
			LeaveManager leaveManager = new LeaveManager();
			Obj  = leaveManager.getLeave();
			
			Gson gson = new Gson();
			response = gson.toJson(Obj);
			
			JSONObject json = new JSONObject();
			json.put("jsonResult", response);
			
			//Remove all slash characters in string 
			response = json.toString().replace("\\", "");
			
			if(response.length() > 10)
			{
				int m = 15;
				int n = response.length()-2;
				
				response = response.substring(0, m-1)+response.substring(m);
				response = response.substring(0, n-1)+response.substring(n);
			}
			
			JSONobj = new JSONObject(response);
		}	
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveWS: getLeave " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getLeaveUtitlty")
	@Produces("application/json")
	public JSONObject getLeaveUtitlty(@QueryParam("Actor") String Actor, @QueryParam("App") String App)
	{	
		String response = null;
		JSONObject JSONobj = null;
		
		try
		{
			System.out.println(df.format(dateobj)+" We are getting leave utilization Actor:"+Actor+", App:"+App);
			
			ArrayList<LeaveObj> Obj = null;
			LeaveManager leaveManager = new LeaveManager();
			Obj  = leaveManager.getLeaveUtitlty();
			
			Gson gson = new Gson();
			response = gson.toJson(Obj);
			
			JSONObject json = new JSONObject();
			json.put("jsonResult", response);
			
			//Remove all slash characters in string 
			response = json.toString().replace("\\", "");
			
			if(response.length() > 10)
			{
				int m = 15;
				int n = response.length()-2;
				
				response = response.substring(0, m-1)+response.substring(m);
				response = response.substring(0, n-1)+response.substring(n);
			}
			
			JSONobj = new JSONObject(response);
		}	
		catch (Exception e)
		{
			System.out.println(df.format(dateobj)+" Exception Error at LeaveWS: getLeaveUtitlty " + e.getMessage());
		}
		return JSONobj;
	}
	
	
}
