package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.hibernate.validator.constraints.Email;

import entity.Osoba;
import entity.User;
import enums.RodzajPaliwa;
import enums.Wojewodztwo;
import service.OsobaService;

@ViewScoped
@ManagedBean
public class RejestracjaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2055117893621920019L;

	@EJB
	OsobaService service;
	
	@ManagedProperty(value = "#{naviBean}")
	private NaviBean naviBean;
	
	private String login;
	private String imie;
	private Wojewodztwo woj;
	@Email(message = "niepoprawny adres email")
	private String mail;
	private String haslo;
	
	public String zarejestrujOsobe(){
		User u = new User();
		u.setLogin(login);
		u.setPass(haslo);
		
		Osoba o = new Osoba();
		o.setWojewodztwo(woj);
		o.setMail(mail);
		u.setOsoba(o);
		
		service.zarejestrujOsobe(u);
		wyczyscDane();
		return naviBean.toLogin();
	}
	
	private void wyczyscDane() {
		setLogin("");
		setHaslo("");
		setImie("");
		setWoj(null);
		setMail("");
	}

	public Wojewodztwo[] getWojewodztwa(){
		return Wojewodztwo.values();
	}

	public String idzDoLogowania(){
		return naviBean.toLogin();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public Wojewodztwo getWoj() {
		return woj;
	}
	public void setWoj(Wojewodztwo woj) {
		this.woj = woj;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public NaviBean getNaviBean() {
		return naviBean;
	}

	public void setNaviBean(NaviBean naviBean) {
		this.naviBean = naviBean;
	}
	
}
