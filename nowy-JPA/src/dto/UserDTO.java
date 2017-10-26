package dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -6844060306089737800L;
	private Long id;
	private String login;
	private String pass;
	private String email;
	
	public UserDTO(){
	}
	
	public UserDTO(Long id, String login, String pass, String email) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
