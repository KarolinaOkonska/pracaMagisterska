package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import entity.Osoba;
import entity.Samochod;
import enums.RodzajNadwozia;
import enums.RodzajNapedu;
import enums.RodzajPaliwa;
import service.SamochodService;

@ViewScoped
@ManagedBean
public class PobierzSamochodyBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3062837373963073087L;
	
	@EJB
	private SamochodService service;
	
	private List<String> marki = new ArrayList<>();
	private List<String> modele = new ArrayList<>();
	private List<String> wersje = new ArrayList<>();
	
	private String marka, model, wersja, rodzajNadwozia, rodzajPaliwa, rodzajNapedu;
	private boolean czyWylaczonyModel = true;
	private boolean czyWylaczonaWersja = true;
	private Integer rocznik;
	private String vin;
	private Date dataZakupu;
	private Double pojemnosc = 0.0;
	private Long przebieg = 0L;
	private String nrRej;
	
	private List<Samochod> samochody = new ArrayList<>();
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;

	@PostConstruct
	public void init(){
		Osoba o = new Osoba();
		o.setId(loginBean.getOsoba().getId());
		setSamochody(service.pobierzSamochodyOsoby(o));
		setMarki(service.pobierzMarki());
		setModele(new ArrayList<>());
		setWersje(new ArrayList<>());
		marka = "";
		model = "";
		wersja = "";
		rocznik = null;
		vin = "";
		dataZakupu = null;
	}

	public void dajKomunikatBrakAut() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
    }
	
	public void pobierzModele(AjaxBehaviorEvent event){
		marka = ((String) ((UIOutput)event.getSource()).getValue());
		setModele(service.pobierzModele(marka));
		if(!getModele().isEmpty()){
			czyWylaczonyModel = false;
		} else {
			czyWylaczonyModel = true;
		}
		setWersje(new ArrayList<>());
		czyWylaczonaWersja = true;
	}
	
	public void pobierzWersje(AjaxBehaviorEvent event){
		model = ((String) ((UIOutput)event.getSource()).getValue());
		setWersje(service.pobierzWersje(marka,model ));
		if(!getWersje().isEmpty()){
			czyWylaczonaWersja = false;
		} else {
			czyWylaczonaWersja = true;
		}
	}
	
	public RodzajNadwozia[] getRodzajeNadwozia(){
		return RodzajNadwozia.values();
	}
	
	public RodzajPaliwa[] getRodzajePaliwa(){
		return RodzajPaliwa.values();
	}
	
	public RodzajNapedu[] getRodzajeNapedu(){
		return RodzajNapedu.values();
	}
	
	public void zapiszSamochod(ActionEvent e){
		Samochod s = new Samochod();
		s.setMarka(marka);
		s.setModel(model);
		s.setWersja(wersja);
		s.setRocznik(rocznik);
		s.setVin(vin);
		s.setDataZakupu(dataZakupu);
		s.setRodzajNadwozia(RodzajNadwozia.valueOf(rodzajNadwozia));
		s.setRodzajPaliwa(RodzajPaliwa.valueOf(rodzajPaliwa));
		s.setRodzajNapedu(RodzajNapedu.valueOf(rodzajNapedu));
		s.setPojemnosc(pojemnosc);
		s.setPrzebieg(przebieg);
		s.setNrRej(nrRej);
		Osoba o = new Osoba();
		o.setId(loginBean.getOsoba().getId());
		service.zapiszSamochodOsobie(o, s);
		setSamochody(service.pobierzSamochodyOsoby(o));
		loginBean.setWylaczMenu(false);
		loginBean.pobierzSamochodyOsoby();
	}
	
	public List<String> getMarki() {
		return marki;
	}

	public void setMarki(List<String> marki) {
		this.marki = marki;
	}

	public List<String> getModele() {
		return modele;
	}

	public void setModele(List<String> modele) {
		this.modele = modele;
	}

	public List<String> getWersje() {
		return wersje;
	}

	public void setWersje(List<String> wersje) {
		this.wersje = wersje;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWersja() {
		return wersja;
	}

	public void setWersja(String wersja) {
		this.wersja = wersja;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public boolean isCzyWylaczonyModel() {
		return czyWylaczonyModel;
	}

	public void setCzyWylaczonyModel(boolean czyWylaczonyModel) {
		this.czyWylaczonyModel = czyWylaczonyModel;
	}

	public boolean isCzyWylaczonaWersja() {
		return czyWylaczonaWersja;
	}

	public void setCzyWylaczonaWersja(boolean czyWylaczonaWersja) {
		this.czyWylaczonaWersja = czyWylaczonaWersja;
	}

	public Integer getRocznik() {
		return rocznik;
	}

	public void setRocznik(Integer rocznik) {
		this.rocznik = rocznik;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Date getDataZakupu() {
		return dataZakupu;
	}

	public void setDataZakupu(Date dataZakupu) {
		this.dataZakupu = dataZakupu;
	}

	public String getRodzajNadwozia() {
		return rodzajNadwozia;
	}

	public void setRodzajNadwozia(String rodzajNadwozia) {
		this.rodzajNadwozia = rodzajNadwozia;
	}

	public String getRodzajPaliwa() {
		return rodzajPaliwa;
	}

	public void setRodzajPaliwa(String rodzajPaliwa) {
		this.rodzajPaliwa = rodzajPaliwa;
	}

	public String getRodzajNapedu() {
		return rodzajNapedu;
	}

	public void setRodzajNapedu(String rodzajNapedu) {
		this.rodzajNapedu = rodzajNapedu;
	}

	public double getPojemnosc() {
		return pojemnosc;
	}

	public void setPojemnosc(double pojemnosc) {
		this.pojemnosc = pojemnosc;
	}

	public Long getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(Long przebieg) {
		this.przebieg = przebieg;
	}

	public String getNrRej() {
		return nrRej;
	}

	public void setNrRej(String nrRej) {
		this.nrRej = nrRej;
	}

	public void setPojemnosc(Double pojemnosc) {
		this.pojemnosc = pojemnosc;
	}

	public List<Samochod> getSamochody() {
		return samochody;
	}

	public void setSamochody(List<Samochod> samochody) {
		this.samochody = samochody;
	}
}
