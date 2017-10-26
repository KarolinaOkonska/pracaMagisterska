package beans;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

import service.PaliwoService;

@ViewScoped
@ManagedBean
public class ZapiszPaliwoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4243280646082709193L;

	@EJB
	PaliwoService paliwoService;

	private String rodzPaliwa = "Pb 95";
	private double iloscPaliwa;
	private double cenaZaLitr;
	private Date dataTankowania;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	@ManagedProperty(value = "#{pobierzPaliwoBean}")
	private PobierzPaliwoBean pobierzPaliwoBean;
	
	public String zapiszPaliwo(){
		if(!(iloscPaliwa==0) && !(cenaZaLitr ==0) && !rodzPaliwa.equals("") && !(dataTankowania == null)){
			paliwoService.zapiszDane(rodzPaliwa, iloscPaliwa, cenaZaLitr, dataTankowania, loginBean.getSamochodKontekstowy());
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Dodano tankowanie :D" );
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        czyscPola();
	        pobierzPaliwoBean.pobierzPaliwaOsoby();
		}
		return "";
	}
	
	private void czyscPola() {
		setRodzPaliwa("");
        setIloscPaliwa(0);
        setCenaZaLitr(0);
        setDataTankowania(null);
	}
	
	public void updateRodzPaliwa(AjaxBehaviorEvent  event){
		setRodzPaliwa((String) ((UIOutput)event.getSource()).getValue());
	}
	
	public void updateIlPal(AjaxBehaviorEvent  event){
		setIloscPaliwa((Double) ((UIOutput)event.getSource()).getValue());
	}
	
	public void updateCena(AjaxBehaviorEvent  event){
		setCenaZaLitr((Double) ((UIOutput)event.getSource()).getValue());
	}

	public void updateData(SelectEvent event){
		setDataTankowania((Date) event.getObject());
	}
	
	public String getRodzPaliwa() {
		return rodzPaliwa;
	}
	public void setRodzPaliwa(String rodzPaliwa) {
		this.rodzPaliwa = rodzPaliwa;
	}
	public double getIloscPaliwa() {
		return iloscPaliwa;
	}
	public void setIloscPaliwa(double iloscPaliwa) {
		this.iloscPaliwa = iloscPaliwa;
	}
	public double getCenaZaLitr() {
		return cenaZaLitr;
	}
	public void setCenaZaLitr(double cenaZaLitr) {
		this.cenaZaLitr = cenaZaLitr;
	}
	public Date getDataTankowania() {
		return dataTankowania;
	}
	public void setDataTankowania(Date dataTankowania) {
		this.dataTankowania = dataTankowania;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public PobierzPaliwoBean getPobierzPaliwoBean() {
		return pobierzPaliwoBean;
	}

	public void setPobierzPaliwoBean(PobierzPaliwoBean pobierzPaliwoBean) {
		this.pobierzPaliwoBean = pobierzPaliwoBean;
	}

}
