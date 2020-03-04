package webServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import models.AdminManager;
import objects.AdminObjects.DepartmentObj;
import objects.AdminObjects.DocSeqObj;
import objects.AdminObjects.EmployeeTypeObj;
import objects.AdminObjects.PayHeadDtlsObj;
import objects.AdminObjects.PayHeadSubTypObj;
import objects.AdminObjects.PayHeadTypObj;
import objects.AdminObjects.PositionObj;
import objects.AdminObjects.BranchObj;

import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

@Path("/AdminWS")

public class AdminWS {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. PAY HEAD TYPE
	@GET
	@Path("/createPayHeadType")
	@Produces("application/json")
	public JSONObject createPayHeadType(@QueryParam("PayHTypCode") String PayHTypCode, @QueryParam("PayHTypName") String PayHTypName, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are creating pay head type Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadTypObj> typeObj = null;
			AdminManager adminManager = new AdminManager();
			typeObj = adminManager.createPayHeadType(PayHTypCode, PayHTypName, Actor);

			Gson gson = new Gson();
			response = gson.toJson(typeObj);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Exception Error at AdminWS: createPayHeadType " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getPayHeadType")
	@Produces("application/json")
	public JSONObject getPayHeadType(@QueryParam("Actor") String Actor,
			@QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are getting pay head type Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadTypObj> departObj = null;
			AdminManager adminManager = new AdminManager();
			departObj = adminManager.getPayHeadType();

			Gson gson = new Gson();
			response = gson.toJson(departObj);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Exception Error at AdminWS: getPayHeadType " + e.getMessage());
		}
		return JSONobj;
	}
	//*******************END PAY HEAD TYPE**********************************
	
	//2. PAY HEAD SUB TYPE
	@GET
	@Path("/createPayHeadSubType")
	@Produces("application/json")
	public JSONObject createPayHeadSubType(@QueryParam("PayHSubTypCode") String PayHSubTypCode, @QueryParam("PayHSubTypName") String PayHSubTypName, @QueryParam("PayHTypode") String PayHTypode, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are creating pay head sub type Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadSubTypObj> typeObj = null;
			AdminManager adminManager = new AdminManager();
			typeObj = adminManager.createPayHeadSubType(PayHSubTypCode, PayHSubTypName, PayHTypode, Actor);

			Gson gson = new Gson();
			response = gson.toJson(typeObj);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Exception Error at AdminWS: createPayHeadSubType " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getPayHeadSubType")
	@Produces("application/json")
	public JSONObject getPayHeadSubType(@QueryParam("Actor") String Actor,
			@QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are getting pay head sub type Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadSubTypObj> departObj = null;
			AdminManager adminManager = new AdminManager();
			departObj = adminManager.getPayHeadSubType();

			Gson gson = new Gson();
			response = gson.toJson(departObj);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Exception Error at AdminWS: getPayHeadType " + e.getMessage());
		}
		return JSONobj;
	}
	//*****************END PAY HEAD SUB TYPE********************************
	
	//3. PAY HEAD DETAILS
	@GET
	@Path("/createPayHeadDtls")
	@Produces("application/json")
	public JSONObject createPayHeadDtls(@QueryParam("PayHName") String PayHName, 
			@QueryParam("PayHTypCode") String PayHTypCode, @QueryParam("PayHSubTypCode") String PayHSubTypCode,
			@QueryParam("Variant") String Variant, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are creating pay head sub type Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadDtlsObj> typeObj = null;
			AdminManager adminManager = new AdminManager();
			typeObj = adminManager.createPayHeadDtls(PayHName, PayHTypCode, PayHSubTypCode, Variant, Actor);

			Gson gson = new Gson();
			response = gson.toJson(typeObj);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Exception Error at AdminWS: createPayHeadDtls " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getPayHeadDtls")
	@Produces("application/json")
	public JSONObject getPayHeadDtls(@QueryParam("Actor") String Actor,
			@QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are getting pay head details Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadDtlsObj> departObj = null;
			AdminManager adminManager = new AdminManager();
			departObj = adminManager.getPayHeadDtls();

			Gson gson = new Gson();
			response = gson.toJson(departObj);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out.println(df.format(dateobj) + " Exception Error at AdminWS: getPayHeadDtls " + e.getMessage());
		}
		return JSONobj;
	}
	//*****************END PAY HEAD DETAILS*********************************
	
	//4. EMPLOYEE TYPE
	@GET
	@Path("/createEmployeeType")
	@Produces("application/json")
	public JSONObject createEmployeeType(@QueryParam("TypeName") String TypeName, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
				String response = null;
				JSONObject JSONobj = null;
				try {
					System.out.println(df.format(dateobj) + " We are creating employee type Actor: " + Actor
							+ " App: " + App);

					ArrayList<EmployeeTypeObj> typeObj = null;
					AdminManager admin = new AdminManager();
					typeObj = admin.createEmployeeType(TypeName, Actor);

					Gson gson = new Gson();
					response = gson.toJson(typeObj);

					JSONObject json = new JSONObject();
					json.put("jsonResult", response);

					// Remove all slash characters in string
					response = json.toString().replace("\\", "");

					if (response.length() > 10) {
						int m = 15;
						int n = response.length() - 2;

						response = response.substring(0, m - 1) + response.substring(m);
						response = response.substring(0, n - 1) + response.substring(n);
					}

					JSONobj = new JSONObject(response);
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Exception Error at AdminWS: createEmployeeType " + e.getMessage());
				}
				return JSONobj;
			}
			
	@GET
	@Path("/getEmployeeType")
	@Produces("application/json")
	public JSONObject getEmployeeType(@QueryParam("Actor") String Actor,
					@QueryParam("App") String App) {
				String response = null;
				JSONObject JSONobj = null;
				try {
					System.out.println(df.format(dateobj) + " We are getting employee type Actor: " + Actor
							+ " App: " + App);

					ArrayList<EmployeeTypeObj> typeObj = null;
					AdminManager admin = new AdminManager();
					typeObj = admin.getEmployeeType();

					Gson gson = new Gson();
					response = gson.toJson(typeObj);

					JSONObject json = new JSONObject();
					json.put("jsonResult", response);

					// Remove all slash characters in string
					response = json.toString().replace("\\", "");

					if (response.length() > 10) {
						int m = 15;
						int n = response.length() - 2;

						response = response.substring(0, m - 1) + response.substring(m);
						response = response.substring(0, n - 1) + response.substring(n);
					}

					JSONobj = new JSONObject(response);
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Exception Error at AdminWS: getEmployeeType " + e.getMessage());
				}
				return JSONobj;
			}
			//********************END EMPLOYEE TYPE*********************************
			
	//5. POSITION
	@GET
	@Path("/createPosition")
	@Produces("application/json")
	public JSONObject createPosition(@QueryParam("PositonName") String PositonName,
					@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
				String response = null;
				JSONObject JSONobj = null;
				try {
					System.out.println(df.format(dateobj) + " We are creating position Actor: " + Actor
							+ " App: " + App);

					ArrayList<PositionObj> postObj = null;
					AdminManager admin = new AdminManager();
					postObj = admin.createPosition(PositonName, Actor);

					Gson gson = new Gson();
					response = gson.toJson(postObj);

					JSONObject json = new JSONObject();
					json.put("jsonResult", response);

					// Remove all slash characters in string
					response = json.toString().replace("\\", "");

					if (response.length() > 10) {
						int m = 15;
						int n = response.length() - 2;

						response = response.substring(0, m - 1) + response.substring(m);
						response = response.substring(0, n - 1) + response.substring(n);
					}

					JSONobj = new JSONObject(response);
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Exception Error at AdminWS: createPosition " + e.getMessage());
				}
				return JSONobj;
			}
			
	@GET
	@Path("/getPosition")
	@Produces("application/json")
	public JSONObject getPosition(@QueryParam("Actor") String Actor,
					@QueryParam("App") String App) {
				String response = null;
				JSONObject JSONobj = null;
				try {
					System.out.println(df.format(dateobj) + " We are getting position Actor: " + Actor
							+ " App: " + App);

					ArrayList<PositionObj> postObj = null;
					AdminManager admin = new AdminManager();
					postObj = admin.getPosition();

					Gson gson = new Gson();
					response = gson.toJson(postObj);

					JSONObject json = new JSONObject();
					json.put("jsonResult", response);

					// Remove all slash characters in string
					response = json.toString().replace("\\", "");

					if (response.length() > 10) {
						int m = 15;
						int n = response.length() - 2;

						response = response.substring(0, m - 1) + response.substring(m);
						response = response.substring(0, n - 1) + response.substring(n);
					}

					JSONobj = new JSONObject(response);
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Exception Error at AdminWS: getPosition " + e.getMessage());
				}
				return JSONobj;
			}
			//********************END POSITION***************************************
			
	//6. DEPARTMENT
	@GET
	@Path("/createDepartment")
	@Produces("application/json")
	public JSONObject createDepartment(@QueryParam("DeptName") String DeptName,
					@QueryParam("DeptDesc") String DeptDesc, @QueryParam("Manager") String Manager, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
				String response = null;
				JSONObject JSONobj = null;
				try {
					System.out.println(df.format(dateobj) + " We are creating department Actor: " + Actor
							+ " App: " + App);

					ArrayList<DepartmentObj> departObj = null;
					AdminManager admin = new AdminManager();
					departObj = admin.createDeaprtment(DeptName, DeptDesc, Manager, Actor);

					Gson gson = new Gson();
					response = gson.toJson(departObj);

					JSONObject json = new JSONObject();
					json.put("jsonResult", response);

					// Remove all slash characters in string
					response = json.toString().replace("\\", "");

					if (response.length() > 10) {
						int m = 15;
						int n = response.length() - 2;

						response = response.substring(0, m - 1) + response.substring(m);
						response = response.substring(0, n - 1) + response.substring(n);
					}

					JSONobj = new JSONObject(response);
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Exception Error at AdminWS: createDepartment " + e.getMessage());
				}
				return JSONobj;
			}
			
	@GET
	@Path("/getDepartment")
	@Produces("application/json")
	public JSONObject getDepartment(@QueryParam("Actor") String Actor,
					@QueryParam("App") String App) {
				String response = null;
				JSONObject JSONobj = null;
				try {
					System.out.println(df.format(dateobj) + " We are getting department Actor: " + Actor
							+ " App: " + App);

					ArrayList<DepartmentObj> departObj = null;
					AdminManager admin = new AdminManager();
					departObj = admin.getDepartment();

					Gson gson = new Gson();
					response = gson.toJson(departObj);

					JSONObject json = new JSONObject();
					json.put("jsonResult", response);

					// Remove all slash characters in string
					response = json.toString().replace("\\", "");

					if (response.length() > 10) {
						int m = 15;
						int n = response.length() - 2;

						response = response.substring(0, m - 1) + response.substring(m);
						response = response.substring(0, n - 1) + response.substring(n);
					}

					JSONobj = new JSONObject(response);
				} catch (Exception e) {
					System.out.println(df.format(dateobj) + " Exception Error at AdminWS: getDepartment " + e.getMessage());
				}
				return JSONobj;
			}
			//*******************END DEPARTMENT*************************		
//7. BRANCH
	@GET
	@Path("/createBranch")
	@Produces("application/json")
	public JSONObject createBranch(@QueryParam("BCode") String bcode,@QueryParam("BName") String bname, @QueryParam("BTasks") String btasks, @QueryParam("Actor") String actor, @QueryParam("App") String App)
	{	
		String response = null;
		JSONObject JSONobj = null;
		
		try
		{
			System.out.println(df.format(dateobj)+" We are creating a branch, bcode: "+bcode+", Actor:"+actor+"App:"+App);
			
			ArrayList<BranchObj> adminObj = null;
			AdminManager adminManager = new AdminManager();
			adminObj  = adminManager.createBranch(bcode, bname, btasks, actor);
			
			Gson gson = new Gson();
			response = gson.toJson(adminObj);
			
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
			System.out.println(df.format(dateobj)+" Exception Error at CompanyWS: createBranch " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getBranch")
	@Produces("application/json")
	public JSONObject getBranch(@QueryParam("Actor") String actor, @QueryParam("App") String App)
	{	
		String response = null;
		JSONObject JSONobj = null;
		
		try
		{
			System.out.println(df.format(dateobj)+" We are geting barnch, Actor:"+actor+"App:"+App);
			
			ArrayList<BranchObj> adminObj = null;
			AdminManager adminManager= new AdminManager();
			adminObj  = adminManager.getBranch(actor, App);
			
			Gson gson = new Gson();
			response = gson.toJson(adminObj);
			
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
			System.out.println(df.format(dateobj)+" Exception Error at CompanyWS: getBranch " + e.getMessage());
		}
		return JSONobj;
	}
	//***************************END BRANCH********************************

	//SEQUENCE NUMBER
	@GET
	@Path("/getSeqNumber")
	@Produces("application/json")
	public JSONObject getSeqNumber(@QueryParam("DocCode") String DocCode, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {

			System.out.println(df.format(dateobj) + " We are creating doc sequency: DocType...." + DocCode + " Actor: " + Actor
					+ " App: " + App);

			ArrayList<DocSeqObj> wsData = null;
			AdminManager adminManager = new AdminManager();
			wsData = adminManager.getSeqNumber(DocCode);

			Gson gson = new Gson();
			response = gson.toJson(wsData);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out
					.println(df.format(dateobj) + " Exception Error at AdminWS: getSeqNumber " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/createEmployeeSalary")
	@Produces("application/json")
	public JSONObject createEmployeeSalary(@QueryParam("EmpNO") String EmpNO, @QueryParam("PayHName") String PayHName,
			@QueryParam("Dr") String Dr, @QueryParam("Cr") String Cr, @QueryParam("Frequency") String Frequency,
			@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {

			System.out.println(df.format(dateobj) + " We are creating employee salary for: EmpNO...." + EmpNO + " Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadDtlsObj> wsData = null;
			AdminManager adminManager = new AdminManager();
			wsData = adminManager.createEmployeeSalary(EmpNO, PayHName, Dr, Cr, Frequency, Actor);

			Gson gson = new Gson();
			response = gson.toJson(wsData);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out
					.println(df.format(dateobj) + " Exception Error at AdminWS: createEmployeeSalary " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getEmployeeSalary")
	@Produces("application/json")
	public JSONObject getEmployeeSalary(@QueryParam("EmpNO") String EmpNO, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {

			System.out.println(df.format(dateobj) + " We are creating employee salary for: EmpNO...." + EmpNO + " Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadDtlsObj> wsData = null;
			AdminManager adminManager = new AdminManager();
			wsData = adminManager.getEmployeeSalary(EmpNO);

			Gson gson = new Gson();
			response = gson.toJson(wsData);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out
					.println(df.format(dateobj) + " Exception Error at AdminWS: getEmployeeSalary " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/updateEmployeeSalary")
	@Produces("application/json")
	public JSONObject updateEmployeeSalary(@QueryParam("EmpSalryID") String EmpSalryID,
			@QueryParam("Dr") String Dr, @QueryParam("Cr") String Cr, @QueryParam("Frequency") String Frequency,
			@QueryParam("Status") String Status, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {

			System.out.println(df.format(dateobj) + " We are updating employee salary for: EmpSalryID...." + EmpSalryID + " Actor: " + Actor
					+ " App: " + App);

			ArrayList<PayHeadDtlsObj> wsData = null;
			AdminManager adminManager = new AdminManager();
			wsData = adminManager.updateEmployeeSalary(EmpSalryID, Dr, Cr, Frequency, Status, Actor);

			Gson gson = new Gson();
			response = gson.toJson(wsData);

			JSONObject json = new JSONObject();
			json.put("jsonResult", response);

			// Remove all slash characters in string
			response = json.toString().replace("\\", "");

			if (response.length() > 10) {
				int m = 15;
				int n = response.length() - 2;

				response = response.substring(0, m - 1) + response.substring(m);
				response = response.substring(0, n - 1) + response.substring(n);
			}

			JSONobj = new JSONObject(response);
		} catch (Exception e) {
			System.out
					.println(df.format(dateobj) + " Exception Error at AdminWS: updateEmployeeSalary " + e.getMessage());
		}
		return JSONobj;
	}
	
}
