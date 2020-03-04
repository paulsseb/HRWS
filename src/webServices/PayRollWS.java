package webServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import models.PayRollManager;
import objects.PayRollObjects.PayRollObj;
import objects.PayRollObjects.PaySlipDtlsObj;
import objects.PayRollObjects.PaySlipObj;

import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;


@Path("/PayRollWS")

public class PayRollWS {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	DateFormat transDtDf = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat currentYear = new SimpleDateFormat("yyyy");
	Date dateobj = new Date();
	
	//1. PAYSLIP
	@GET
	@Path("/createPaySlip")
	@Produces("application/json")
	public JSONObject createPaySlip(@QueryParam("PaySlipCode") String PaySlipCode, @QueryParam("Description") String Description,
			@QueryParam("DateFrom") String DateFrom, @QueryParam("DateTo") String DateTo, 
			@QueryParam("Amount") String Amount, @QueryParam("ProllCode") String ProllCode, @QueryParam("EmployID") String EmployID, 
			@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are creating department Actor: " + Actor
					+ " App: " + App);

			ArrayList<PaySlipObj> paySlipObj = null;
			PayRollManager payRollManager = new PayRollManager();
			paySlipObj = payRollManager.createPaySlip(PaySlipCode, Description, DateFrom, DateTo, Amount, ProllCode, EmployID, Actor);

			Gson gson = new Gson();
			response = gson.toJson(paySlipObj);

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
			System.out.println(df.format(dateobj) + " Exception Error at PaySlipWS: createPaySlip " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getPaySlip")
	@Produces("application/json")
	public JSONObject getPaySlip(@QueryParam("PayRollCd") String PayRollCd,
			@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are getting pay slip Actor: " + Actor
					+ " App: " + App);

			ArrayList<PaySlipObj> paySlipObj = null;
			PayRollManager payRollManager = new PayRollManager();
			paySlipObj = payRollManager.getPaySlip(PayRollCd);

			Gson gson = new Gson();
			response = gson.toJson(paySlipObj);

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
			System.out.println(df.format(dateobj) + " Exception Error at PaySlipWS: getPaySlip " + e.getMessage());
		}
		return JSONobj;
	}
	
	//*************END PAYSLIP***********************
	
		//2. PAYSLIP DETAILS
	@GET
	@Path("/createPaySlipDtls")
	@Produces("application/json")
	public JSONObject createPaySlipDtls(@QueryParam("PaySlipCode") String PaySlipCode, @QueryParam("PayHeadName") String PayHeadName,
			@QueryParam("PayHeadCode") String PayHeadCode, @QueryParam("PayHeadTypCode") String PayHeadTypCode, 
			@QueryParam("Amount") String Amount, @QueryParam("Quantity") String Quantity, 
			@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are creating department Actor: " + Actor
					+ " App: " + App);

			ArrayList<PaySlipDtlsObj> paySlipObj = null;
			PayRollManager payRollManager = new PayRollManager();
			paySlipObj = payRollManager.createPaySlipDtls(PaySlipCode, PayHeadName, PayHeadCode, PayHeadTypCode, Amount, Quantity, Actor);
					
			Gson gson = new Gson();
			response = gson.toJson(paySlipObj);

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
			System.out.println(df.format(dateobj) + " Exception Error at PaySlipWS: createPaySlipDtls " + e.getMessage());
		}
		return JSONobj;
	}
	
	@GET
	@Path("/getPaySlipDtls")
	@Produces("application/json")
	public JSONObject getPaySlipDtls(@QueryParam("PaySlipCode") String PaySlipCode, @QueryParam("Actor") String Actor, @QueryParam("App") String App) {
		String response = null;
		JSONObject JSONobj = null;
		try {
			System.out.println(df.format(dateobj) + " We are getting pay slip details Actor: " + Actor
					+ " App: " + App);

			ArrayList<PaySlipDtlsObj> paySlipObj = null;
			PayRollManager payRollManager = new PayRollManager();
			paySlipObj = payRollManager.getPaySlipDtls(PaySlipCode);

			Gson gson = new Gson();
			response = gson.toJson(paySlipObj);

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
			System.out.println(df.format(dateobj) + " Exception Error at PaySlipWS: getPaySlipDtls " + e.getMessage());
		}
		return JSONobj;
	}
		
		//**************END PAYSLIP DETAILS******************
	
	//1. PAYROLL
		@GET
		@Path("/createPayRoll")
		@Produces("application/json")
		public JSONObject createPayRoll(@QueryParam("ProllCode") String ProllCode, @QueryParam("PayHFreqncy") String PayHFreqncy,
				@QueryParam("StartDate") String StartDate,
				@QueryParam("EndDate") String EndDate, @QueryParam("EmpCount") String EmpCount, @QueryParam("Amount") String Amount, 
				@QueryParam("PaymentDate") String PaymentDate,
				@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
			String response = null;
			JSONObject JSONobj = null;
			try {
				System.out.println(df.format(dateobj) + " We are creating department Actor: " + Actor
						+ " App: " + App);

				ArrayList<PayRollObj> payRollObj = null;
				PayRollManager payRollManager = new PayRollManager();
				payRollObj = payRollManager.createPayRoll(ProllCode, PayHFreqncy, StartDate, EndDate, EmpCount, Amount, PaymentDate, Actor);

				Gson gson = new Gson();
				response = gson.toJson(payRollObj);

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
				System.out.println(df.format(dateobj) + " Exception Error at PayRollWS: createPayRoll " + e.getMessage());
			}
			return JSONobj;
		}
		
		@GET
		@Path("/getPayRoll")
		@Produces("application/json")
		public JSONObject getPayRoll(@QueryParam("Actor") String Actor, @QueryParam("App") String App) {
			String response = null;
			JSONObject JSONobj = null;
			try {
				System.out.println(df.format(dateobj) + " We are getting pay roll Actor: " + Actor
						+ " App: " + App);

				ArrayList<PayRollObj> payRollObj = null;
				PayRollManager payRollManager = new PayRollManager();
				payRollObj = payRollManager.getPayRoll();

				Gson gson = new Gson();
				response = gson.toJson(payRollObj);

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
				System.out.println(df.format(dateobj) + " Exception Error at PayRollWS: getPayRoll " + e.getMessage());
			}
			return JSONobj;
		}
		
		//*************END PAYSLIP***********************
		
}
