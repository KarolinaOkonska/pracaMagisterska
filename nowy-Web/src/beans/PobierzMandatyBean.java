package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;

import dto.MandatDTO;
import dto.PrzegladDTO;
import service.MandatyService;
import service.PrzegladyService;

@ManagedBean
@ViewScoped
public class PobierzMandatyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7575466033825172885L;
	
	@EJB
	MandatyService service;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	private List<MandatDTO> mandaty;
	
	private String miasto;
	private Date dataOtrzymania;
	private String rodzajWykroczenia;
	private int otrzymanePkt;
	private double kwota;
	
	@PostConstruct
	public void init(){
		wyczyscPola();
//		pobierzMandatyOsoby();
	}
	
	public String zapiszMandat(){
//		if(!(dataOtrzymania ==null) && !(miasto.equals("")) &&  && ){
		service.zapiszMandat(miasto, rodzajWykroczenia, dataOtrzymania, otrzymanePkt, kwota, loginBean.getSamochodKontekstowy().getId());			
		pobierzMandatyOsoby();
		wyczyscPola();
		
		return "";
	}
	
	private void wyczyscPola() {
		setMiasto("");
		setRodzajWykroczenia("");
		setDataOtrzymania(null);
		setOtrzymanePkt(0);
		setKwota(0);
		
	}
	
	public String pobierzMandatyOsoby(){
		mandaty = service.pobierzMandatyOsoby(loginBean.getOsoba());
		return "";
	}
	
	public List<MandatDTO> getMandaty() {
		return mandaty;
	}

	public void setMandaty(List<MandatDTO> mandaty) {
		this.mandaty = mandaty;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public Date getDataOtrzymania() {
		return dataOtrzymania;
	}

	public void setDataOtrzymania(Date dataOtrzymania) {
		this.dataOtrzymania = dataOtrzymania;
	}

	public String getRodzajWykroczenia() {
		return rodzajWykroczenia;
	}

	public void setRodzajWykroczenia(String rodzajWykroczenia) {
		this.rodzajWykroczenia = rodzajWykroczenia;
	}

	public int getOtrzymanePkt() {
		return otrzymanePkt;
	}

	public void setOtrzymanePkt(int otrzymanePkt) {
		this.otrzymanePkt = otrzymanePkt;
	}

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	
	public void updMiasto(AjaxBehaviorEvent  event){
		setMiasto((String) ((UIOutput)event.getSource()).getValue());
	}
	
	public void updRodzajWykroczenia(AjaxBehaviorEvent  event){
		setRodzajWykroczenia((String) ((UIOutput)event.getSource()).getValue());
	}
	
	public void updateDataOtrzymania(SelectEvent event){
		setDataOtrzymania((Date) event.getObject());
	}
	
	public void updOtrymanePkt(AjaxBehaviorEvent  event){
		setOtrzymanePkt((Integer) ((UIOutput)event.getSource()).getValue());
	}
	
	public void updKwota(AjaxBehaviorEvent  event){
		setKwota((Double) ((UIOutput)event.getSource()).getValue());
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	

}
