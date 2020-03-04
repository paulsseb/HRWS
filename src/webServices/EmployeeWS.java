package webServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import models.EmployeeManager;
import objects.EmployeeObjects.EmployeeObj;

import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

@Path("/EmployeeWS")

public class EmployeeWS {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. EMPLOYEE
		@GET
		@Path("/createEmployee")
		@Produces("application/json")
		public JSONObject createEmployee(@QueryParam("EmpName") String EmpName, @QueryParam("EmpNumber") String EmpNumber,
				  @QueryParam("Email") String Email, @QueryParam("NSSFNO") String NSSFNO,  @QueryParam("Tin") String Tin,
				  @QueryParam("MobilePhone") String MobilePhone, @QueryParam("Address") String Address,
				 @QueryParam("DateOfBirth") String DateOfBirth, @QueryParam("Nationality") String Nationality, @QueryParam("MaritalStatus") String MaritalStatus,
				  @QueryParam("Gender") String Gender,  @QueryParam("NxtOfKin") String NxtOfKin, @QueryParam("NxtOfKinContact") String NxtOfKinContact,
				 @QueryParam("NxtOfKinRelation") String NxtOfKinRelation,  @QueryParam("Branch") String Branch,
				 @QueryParam("Department") String Department, @QueryParam("Position") String Position,@QueryParam("ReportTo") String ReportTo, 
				 @QueryParam("DateOfJoin") String DateOfJoin,
				@QueryParam("EmpTyp") String EmpTyp, @QueryParam("WorkPhone") String WorkPhone,@QueryParam("LeaveRate") String LeaveRate,@QueryParam("WorkStartDt") String WorkStartDt,
				@QueryParam("WorkEndDt") String WorkEndDt, @QueryParam("PayMode") String PayMode, @QueryParam("MMoneyPhone") String MMoneyPhone,
				@QueryParam("BankName") String BankName,
				@QueryParam("BankBranch") String BankBranch,@QueryParam("BankActNO") String BankActNO,@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
			String response = null;
			JSONObject JSONobj = null;
			try {
				System.out.println(df.format(dateobj) + " We are creating pay head sub type Actor: " + Actor
						+ " App: " + App);

				ArrayList<EmployeeObj> employObj = null;
				EmployeeManager employManager = new EmployeeManager();
				employObj = employManager.createEmployee(EmpName, EmpNumber, Email, NSSFNO, Tin, MobilePhone, Address, DateOfBirth, Nationality, 
						MaritalStatus, Gender, NxtOfKin, NxtOfKinContact, NxtOfKinRelation, Branch, Department, Position, ReportTo, DateOfJoin, 
						EmpTyp, WorkPhone, LeaveRate, WorkStartDt, WorkEndDt, PayMode, MMoneyPhone, BankName, BankBranch, BankActNO, Actor);

				Gson gson = new Gson();
				response = gson.toJson(employObj);

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
				System.out.println(df.format(dateobj) + " Exception Error at AdminWS: createEmployee " + e.getMessage());
			}
			return JSONobj;
		}
		
		@GET
		@Path("/getEmployees")
		@Produces("application/json")
		public JSONObject getEmployees(@QueryParam("Actor") String Actor,
				@QueryParam("App") String App) {
			String response = null;
			JSONObject JSONobj = null;
			try {
				System.out.println(df.format(dateobj) + " We are getting employees Actor: " + Actor
						+ " App: " + App);

				ArrayList<EmployeeObj> employObj = null;
				EmployeeManager employManager = new EmployeeManager();
				employObj = employManager.getEmployees();

				Gson gson = new Gson();
				response = gson.toJson(employObj);

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
				System.out.println(df.format(dateobj) + " Exception Error at AdminWS: getEmployees " + e.getMessage());
			}
			return JSONobj;
		}
		//****************END EMPLOYEE******************************************
}
