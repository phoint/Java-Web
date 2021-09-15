package model;

public class LoginForm {
	private String loginMail, pwd;
	private boolean isRemember;
	
	

	public LoginForm() {
	}

	public LoginForm(String email, String pwd, boolean isRemember) {
		this.loginMail = email;
		this.pwd = pwd;
		this.isRemember = isRemember;
	}

	public String getEmail() {
		return loginMail;
	}

	public void setEmail(String email) {
		this.loginMail = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isRemember() {
		return isRemember;
	}

	public void setRemember(boolean isRemember) {
		this.isRemember = isRemember;
	}

}
