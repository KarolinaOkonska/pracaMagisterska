package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import enums.Wojewodztwo;

@Entity
public class Osoba implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9209537302011763199L;

	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	private Wojewodztwo wojewodztwo;
	private String miasto;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="osoba", cascade=CascadeType.ALL)
	private User user;
	
	private String email;
	private String nazwisko;
	private String lol;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Wojewodztwo getWojewodztwo() {
		return wojewodztwo;
	}
	public void setWojewodztwo(Wojewodztwo wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	
}
