package dto;

import java.io.Serializable;

import enums.Wojewodztwo;

public class OsobaDTO extends UserDTO implements Serializable {
	
	private static final long serialVersionUID = -6844060306089737800L;

	private String imie;
	private String nazwisko;
	
	public OsobaDTO() {
	}

	public OsobaDTO(String imie, String nazwisko) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	
	public OsobaDTO(Long id, String login, String pass, String imie, String nazwisko) {
		super(id, login, pass);
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

}
