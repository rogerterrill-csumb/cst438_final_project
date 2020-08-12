package cst438_FinalProject.domain;


public class LoginUser {
		  private String fname;
		  private String lname;
		  private String email;


		  public LoginUser() {}


		public LoginUser(String fname, String lname, String email) {
			super();
			this.fname = fname;
			this.lname = lname;
			this.email = email;
		}


		public String getFname() {
			return fname;
		}


		public void setFname(String fname) {
			this.fname = fname;
		}


		public String getLname() {
			return lname;
		}


		public void setLname(String lname) {
			this.lname = lname;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		@Override
		public String toString() {
			return "LoginUser [fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
		}
		
		
}
