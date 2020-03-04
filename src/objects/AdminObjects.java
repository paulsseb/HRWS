package objects;

public class AdminObjects {

	//1. PAYHEAD DETAILS TABLE
	public static class PayHeadDtlsObj{
		
		private String EmpSalryID;
		private String EmpNO;
		private String EmpName;
		private String DR;
		private String CR;
		private String Frequency;
		private String PayHCode;
		private String PayHName;
		private String PayHTypCode;
		private String PayHSubTypCode;
		private String PayHTypName;
		private String PayHSubTypName;
		private String Variant;
		private String TransDt;
		private String CreateBy;
		private String Success;
		private String Msg;
		
		public String getPayHCode() {
			return PayHCode;
		}
		public void setPayHCode(String payHCode) {
			PayHCode = payHCode;
		}
		public String getPayHName() {
			return PayHName;
		}
		public void setPayHName(String payHName) {
			PayHName = payHName;
		}
		public String getPayHTypCode() {
			return PayHTypCode;
		}
		public void setPayHTypCode(String payHTypCode) {
			PayHTypCode = payHTypCode;
		}
		public String getPayHSubTypCode() {
			return PayHSubTypCode;
		}
		public void setPayHSubTypCode(String payHSubTypCode) {
			PayHSubTypCode = payHSubTypCode;
		}
		public String getVariant() {
			return Variant;
		}
		public void setVariant(String variant) {
			Variant = variant;
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
		public String getPayHTypName() {
			return PayHTypName;
		}
		public void setPayHTypName(String payHTypName) {
			PayHTypName = payHTypName;
		}
		public String getPayHSubTypName() {
			return PayHSubTypName;
		}
		public void setPayHSubTypName(String payHSubTypName) {
			PayHSubTypName = payHSubTypName;
		}
		public String getEmpNO() {
			return EmpNO;
		}
		public void setEmpNO(String empNO) {
			EmpNO = empNO;
		}
		public String getEmpSalryID() {
			return EmpSalryID;
		}
		public void setEmpSalryID(String empSalryID) {
			EmpSalryID = empSalryID;
		}
		public String getDR() {
			return DR;
		}
		public void setDR(String dR) {
			DR = dR;
		}
		public String getCR() {
			return CR;
		}
		public void setCR(String cR) {
			CR = cR;
		}
		public String getFrequency() {
			return Frequency;
		}
		public void setFrequency(String frequency) {
			Frequency = frequency;
		}
		public String getEmpName() {
			return EmpName;
		}
		public void setEmpName(String empName) {
			EmpName = empName;
		}
	}
	
	//2. PAYHEAD SUBTYPE 
	public static class PayHeadSubTypObj{
		
		private String ID;
		private String PayHSubTypCode;
		private String PayHSubTypNme;
		private String PayHTypCode;
		private String TransDt;
		private String CreateBy;
		private String Success;
		private String Msg;
		
		public String getPayHSubTypCode() {
			return PayHSubTypCode;
		}
		public void setPayHSubTypCode(String payHSubTypCode) {
			PayHSubTypCode = payHSubTypCode;
		}
		public String getPayHSubTypNme() {
			return PayHSubTypNme;
		}
		public void setPayHSubTypNme(String payHSubTypNme) {
			PayHSubTypNme = payHSubTypNme;
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
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getTransDt() {
			return TransDt;
		}
		public void setTransDt(String transDt) {
			TransDt = transDt;
		}
		
	}
	
	//3. PAYHEAD TYPE
	public static class PayHeadTypObj{
		
		private String PayHTypCode;
		private String PayHTypNme;
		private String TransDt;
		private String CreateBy;
		private String Success;
		private String Msg;
		
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
		public String getPayHTypCode() {
			return PayHTypCode;
		}
		public void setPayHTypCode(String payHTypCode) {
			PayHTypCode = payHTypCode;
		}
		public String getPayHTypNme() {
			return PayHTypNme;
		}
		public void setPayHTypNme(String payHTypNme) {
			PayHTypNme = payHTypNme;
		}
		
	}

	//4. EMPLOYEE TYPE
	public static class EmployeeTypeObj{
				
				private String ID;
				private String TypeName;
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
				public String getTypeName() {
					return TypeName;
				}
				public void setTypeName(String typeName) {
					TypeName = typeName;
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
			}
	
	//5. EMPLOYEE POSITION
	public static class PositionObj{
				
				private String PostCode;
				private String PostName;
				private String TransDt;
				private String CreateBy;
				private String Success;
				private String Msg;
				
				public String getPostCode() {
					return PostCode;
				}
				public void setPostCode(String postCode) {
					PostCode = postCode;
				}
				public String getPostName() {
					return PostName;
				}
				public void setPostName(String postName) {
					PostName = postName;
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
			}
			
	//6. DEPARTMENT
	public static class DepartmentObj{
				
				private String DeptCode;
				private String DeptName;
				private String DeptDesc;
				private String Manager;
				private String TransDt;
				private String CreateBy;
				private String Success;
				private String Msg;
				
				public String getDeptCode() {
					return DeptCode;
				}
				public void setDeptCode(String deptCode) {
					DeptCode = deptCode;
				}
				public String getDeptName() {
					return DeptName;
				}
				public void setDeptName(String deptName) {
					DeptName = deptName;
				}
				public String getDeptDesc() {
					return DeptDesc;
				}
				public void setDeptDesc(String deptDesc) {
					DeptDesc = deptDesc;
				}
				public String getManager() {
					return Manager;
				}
				public void setManager(String manager) {
					Manager = manager;
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
			}

	//7. BRANCH
	public static class BranchObj {
		private String BCode;
		private String BName;
		private String BTasks;
		private String IsActive;
		private String Msg;
		private String Success;
		
		public String getMsg() {
			return Msg;
		}
		public void setMsg(String msg) {
			Msg = msg;
		}
		public String getSuccess() {
			return Success;
		}
		public void setSuccess(String success) {
			Success = success;
		}
		public String getIsActive() {
			return IsActive;
		}
		public void setIsActive(String isActive) {
			IsActive = isActive;
		}
		public String getBCode() {
			return BCode;
		}
		public void setBCode(String bCode) {
			BCode = bCode;
		}
		public String getBName() {
			return BName;
		}
		public void setBName(String bName) {
			BName = bName;
		}
		public String getBTasks() {
			return BTasks;
		}
		public void setBTasks(String bTasks) {
			BTasks = bTasks;
		}
	}
	
	//8. SEQUENCE NUMBER
	public static class DocSeqObj {

		private String DocCode;
		private String SeqNo;
		
		public String getDocCode() {
			return DocCode;
		}
		public void setDocCode(String docCode) {
			DocCode = docCode;
		}
		public String getSeqNo() {
			return SeqNo;
		}
		public void setSeqNo(String seqNo) {
			SeqNo = seqNo;
		}
	}
}
