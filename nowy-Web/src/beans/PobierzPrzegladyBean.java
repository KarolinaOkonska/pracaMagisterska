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

import dto.PrzegladDTO;
import service.PrzegladyService;

@ManagedBean
@ViewScoped
public class PobierzPrzegladyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7575466033825172885L;
	
	@EJB
	PrzegladyService service;
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	private List<PrzegladDTO> przeglady;
	
	private String opisStacji;
	private Date dataPrzegladu;
	private Date dataWaznosci;
	private String uwagi;
	
	@PostConstruct
	public void init(){
		opisStacji = "";
		uwagi = "";
		pobierzPrzegladyOsoby();
	}
	
	public String zapiszPrzeglad(){
		if(!(opisStacji.equals("")) && !(dataPrzegladu ==null) && !(dataWaznosci== null) && !(uwagi.equals(""))){
			service.zapiszPrzeglad(opisStacji, dataPrzegladu, dataWaznosci, uwagi, loginBean.getSamochodKontekstowy());
	        pobierzPrzegladyOsoby();
	        wyczyscPola();
		}
		return "";
	}

	private void wyczyscPola() {
		setOpisStacji("");
		setDataPrzegladu(null);
		setDataWaznosci(null);
		setUwagi("");
		
	}

	public void pobierzPrzegladyOsoby(){
		przeglady = service.pobierzPrzegladyOsoby(loginBean.getSamochodKontekstowy());
	}
	
	public void updOpisStacji(AjaxBehaviorEvent  event){
		setOpisStacji((String) ((UIOutput)event.getSource()).getValue());
	}
	
	public void updUwagi(AjaxBehaviorEvent  event){
		setUwagi((String) ((UIOutput)event.getSource()).getValue());
	}
	
	public void updateDataPrzegladu(SelectEvent event){
		setDataPrzegladu((Date) event.getObject());
	}
	
	public void updateDataWaznosci(SelectEvent event){
		setDataWaznosci((Date) event.getObject());
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<PrzegladDTO> getPrzeglady() {
		return przeglady;
	}

	public void setPrzeglady(List<PrzegladDTO> przeglady) {
		this.przeglady = przeglady;
	}

	public String getOpisStacji() {
		return opisStacji;
	}

	public void setOpisStacji(String opisStacji) {
		this.opisStacji = opisStacji;
	}

	public Date getDataPrzegladu() {
		return dataPrzegladu;
	}

	public void setDataPrzegladu(Date dataPrzegladu) {
		this.dataPrzegladu = dataPrzegladu;
	}

	public Date getDataWaznosci() {
		return dataWaznosci;
	}

	public void setDataWaznosci(Date dataWaznosci) {
		this.dataWaznosci = dataWaznosci;
	}

	public String getUwagi() {
		return uwagi;
	}

	public void setUwagi(String uwagi) {
		this.uwagi = uwagi;
	}

}
