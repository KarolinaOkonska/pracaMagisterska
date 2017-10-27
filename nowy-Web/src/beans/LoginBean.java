package beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;

import dto.OsobaDTO;
import dto.SamochodDTO;
import service.LogowanieService;
import service.SamochodService;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6955508471291131930L;

	private String name;
	private String pass;
	private OsobaDTO osoba;
	private List<SamochodDTO> samochodyOsoby;
	private SamochodDTO samochodKontekstowy;
	private boolean zalogowany = false;
	private boolean wylaczMenu = false;
	private String email;
	
	@ManagedProperty(value = "#{naviBean}")
	private NaviBean naviBean;

	@EJB
	LogowanieService logowanieService;
	@EJB
	SamochodService samochodService;

	public String zaloguj() {
		Long id = logowanieService.pobierzIdOsoby(name, pass);
		if (id.equals(-1L)) {
			wyczyscDaneLogowania();
		} else {
			zalogowany = true;
			pass = null;
			osoba = new OsobaDTO(id);
			
			 pobierzSamochodyOsoby();
			if(!samochodyOsoby.isEmpty()){
				samochodKontekstowy = samochodyOsoby.get(0);
				wylaczMenu = false;
			} else {
				wylaczMenu = true;
			}
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" );
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        
			return naviBean.toWelcome();
		}
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" );
        FacesContext.getCurrentInstance().addMessage(null, msg);

		return naviBean.toLogin();
	}
	
	public void pobierzSamochodyOsoby(){
		samochodyOsoby = samochodService.pobierzSamochodyCombo(osoba);
	}
	
	public String idzDoRejestracji(){
		return naviBean.toRegistration();
	}
	
	public SamochodDTO pobierzSamochodPoId(Long id){
		return samochodService.pobierzSamochodPoId(id);
	}
	
	public String wyloguj() {
		wyczyscDaneLogowania();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "wylogowanoooo",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
		return naviBean.toLogin();
	}
	
	private void wyczyscDaneLogowania() {
		zalogowany = false;
		name = null;
		pass = null;
		osoba = null;
		samochodyOsoby = null;
		samochodKontekstowy = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isZalogowany() {
		return zalogowany;
	}

	public void setZalogowany(boolean zalogowany) {
		this.zalogowany = zalogowany;
	}

	public NaviBean getNaviBean() {
		return naviBean;
	}

	public void setNaviBean(NaviBean naviBean) {
		this.naviBean = naviBean;
	}

	public OsobaDTO getOsoba() {
		return osoba;
	}

	public void setOsoba(OsobaDTO osoba) {
		this.osoba = osoba;
	}

	public List<SamochodDTO> getSamochodyOsoby() {
		return samochodyOsoby;
	}

	public void setSamochodyOsoby(List<SamochodDTO> samochodyOsoby) {
		this.samochodyOsoby = samochodyOsoby;
	}

	public SamochodDTO getSamochodKontekstowy() {
		return samochodKontekstowy;
	}

	public void setSamochodKontekstowy(SamochodDTO samochodKontekstowy) {
		this.samochodKontekstowy = samochodKontekstowy;
	}

	public boolean isWylaczMenu() {
		return wylaczMenu;
	}

	public void setWylaczMenu(boolean wylaczMenu) {
		this.wylaczMenu = wylaczMenu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
