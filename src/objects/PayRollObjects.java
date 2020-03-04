package objects;

public class PayRollObjects {

	//1. PAYSLIP
	public static class PaySlipObj{
				
				private String PaySlipCode;
				private String Description;
				private String DateFrom;
				private String DateTo;
				private String Amount;
				private String ProllCode;
				private String EmpID;
				private String EmpName;
				private String Position;
				private String Frequency;
				private String TransDt;
				private String CreateBy;
				private String Success;
				private String Msg;
				
				public String getPaySlipCode() {
					return PaySlipCode;
				}
				public void setPaySlipCode(String paySlipCode) {
					PaySlipCode = paySlipCode;
				}
				public String getDescription() {
					return Description;
				}
				public void setDescription(String description) {
					Description = description;
				}
				public String getDateFrom() {
					return DateFrom;
				}
				public void setDateFrom(String dateFrom) {
					DateFrom = dateFrom;
				}
				public String getDateTo() {
					return DateTo;
				}
				public void setDateTo(String dateTo) {
					DateTo = dateTo;
				}
				public String getAmount() {
					return Amount;
				}
				public void setAmount(String amount) {
					Amount = amount;
				}
				public String getEmpID() {
					return EmpID;
				}
				public void setEmpID(String empID) {
					EmpID = empID;
				}
				public String getPosition() {
					return Position;
				}
				public void setPosition(String position) {
					Position = position;
				}
				public String getFrequency() {
					return Frequency;
				}
				public void setFrequency(String frequency) {
					Frequency = frequency;
				}
				public String getCreateBy() {
					return CreateBy;
				}
				public void setCreateBy(String createBy) {
					CreateBy = createBy;
				}
				public String getSuccess() {
					return Success;
				}
				public void setSuccess(String success) {
					Success = success;
				}
				public String getMsg() {
					return Msg;
				}
				public void setMsg(String msg) {
					Msg = msg;
				}
				public String getTransDt() {
					return TransDt;
				}
				public void setTransDt(String transDt) {
					TransDt = transDt;
				}
				public String getEmpName() {
					return EmpName;
				}
				public void setEmpName(String empName) {
					EmpName = empName;
				}
				public String getProllCode() {
					return ProllCode;
				}
				public void setProllCode(String prollCode) {
					ProllCode = prollCode;
				}
			}
			
	//2. PAYSLIP DETAILS
	public static class PaySlipDtlsObj{
			
			private String ID;
			private String PaySlipCode;
			private String PayHName;
			private String PayHCode;
			private String PayHTypCode;
			private String Amount;
			private String Quantity;
			private String TransDt;
			private String CreateBy;
			private String Success;
			private String Msg;
			
			public String getID() {
				return ID;
			}
			public void setID(String iD) {
				ID = iD;
			}
			public String getPaySlipCode() {
				return PaySlipCode;
			}
			public void setPaySlipCode(String paySlipCode) {
				PaySlipCode = paySlipCode;
			}
			public String getPayHName() {
				return PayHName;
			}
			public void setPayHName(String payHName) {
				PayHName = payHName;
			}
			public String getPayHCode() {
				return PayHCode;
			}
			public void setPayHCode(String payHCode) {
				PayHCode = payHCode;
			}
			public String getPayHTypCode() {
				return PayHTypCode;
			}
			public void setPayHTypCode(String payHTypCode) {
				PayHTypCode = payHTypCode;
			}
			public String getCreateBy() {
				return CreateBy;
			}
			public void setCreateBy(String createBy) {
				CreateBy = createBy;
			}
			public String getSuccess() {
				return Success;
			}
			public void setSuccess(String success) {
				Success = success;
			}
			public String getMsg() {
				return Msg;
			}
			public void setMsg(String msg) {
				Msg = msg;
			}
			public String getTransDt() {
				return TransDt;
			}
			public void setTransDt(String transDt) {
				TransDt = transDt;
			}
			public String getAmount() {
				return Amount;
			}
			public void setAmount(String amount) {
				Amount = amount;
			}
			public String getQuantity() {
				return Quantity;
			}
			public void setQuantity(String quantity) {
				Quantity = quantity;
			}
		}

	//3. PAYROLL
	public static class PayRollObj{
		
		private String PayRollCd;
		private String PayHFreqncy;
		private String StartDate;
		private String EndDate;
		private String EmpCount;
		private String Amount;
		private String PaymentDate;
		private String CreateBy;
		private String Success;
		private String Msg;
		
		public String getPayRollCd() {
			return PayRollCd;
		}
		public void setPayRollCd(String payRollCd) {
			PayRollCd = payRollCd;
		}
		public String getStartDate() {
			return StartDate;
		}
		public void setStartDate(String startDate) {
			StartDate = startDate;
		}
		public String getEndDate() {
			return EndDate;
		}
		public void setEndDate(String endDate) {
			EndDate = endDate;
		}
		public String getAmount() {
			return Amount;
		}
		public void setAmount(String amount) {
			Amount = amount;
		}
		public String getPaymentDate() {
			return PaymentDate;
		}
		public void setPaymentDate(String paymentDate) {
			PaymentDate = paymentDate;
		}
		public String getCreateBy() {
			return CreateBy;
		}
		public void setCreateBy(String createBy) {
			CreateBy = createBy;
		}
		public String getSuccess() {
			return Success;
		}
		public void setSuccess(String success) {
			Success = success;
		}
		public String getMsg() {
			return Msg;
		}
		public void setMsg(String msg) {
			Msg = msg;
		}
		public String getEmpCount() {
			return EmpCount;
		}
		public void setEmpCount(String empCount) {
			EmpCount = empCount;
		}
		public String getPayHFreqncy() {
			return PayHFreqncy;
		}
		public void setPayHFreqncy(String payHFreqncy) {
			PayHFreqncy = payHFreqncy;
		}
	}
}
