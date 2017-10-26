package dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -6844060306089737800L;
	private Long id;
	private String login;
	private String pass;
	
	public UserDTO(){
	}
	
	public UserDTO(Long id, String login, String pass) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
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
	
}
