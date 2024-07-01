package boundary_of_law.models;


import javax.validation.constraints.NotEmpty;

public class Login {
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	
	public Login() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}