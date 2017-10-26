package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import enums.RodzajNadwozia;
import enums.RodzajNapedu;
import enums.RodzajPaliwa;

@Entity
public class Samochod implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5284985387282645218L;

	@Id
	@GeneratedValue
	private long id;
	
	private String marka;
	private String model;
	private String wersja;
	private Integer rocznik;
	private String vin;
	private Date dataZakupu;
	@Enumerated(EnumType.STRING)
	private RodzajNadwozia rodzajNadwozia;
	@Enumerated(EnumType.STRING)
	private RodzajPaliwa rodzajPaliwa;
	@Enumerated(EnumType.STRING)
	private RodzajNapedu rodzajNapedu;
	private Double pojemnosc;
	private Long przebieg;
	private String nrRej;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="osoba_id" ) 
	private Osoba osoba;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMarka() {
		return marka.substring(0, 1).toUpperCase() + marka.substring(1);
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model.substring(0, 1).toUpperCase() + model.substring(1);
	}
	public void setModel(String model) {
		this.model = model;
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
	public RodzajNadwozia getRodzajNadwozia() {
		return rodzajNadwozia;
	}
	public void setRodzajNadwozia(RodzajNadwozia rodzajNadwozia) {
		this.rodzajNadwozia = rodzajNadwozia;
	}
	public RodzajPaliwa getRodzajPaliwa() {
		return rodzajPaliwa;
	}
	public void setRodzajPaliwa(RodzajPaliwa rodzajPaliwa) {
		this.rodzajPaliwa = rodzajPaliwa;
	}
	public RodzajNapedu getRodzajNapedu() {
		return rodzajNapedu;
	}
	public void setRodzajNapedu(RodzajNapedu rodzajNapedu) {
		this.rodzajNapedu = rodzajNapedu;
	}
	public Double getPojemnosc() {
		return pojemnosc;
	}
	public void setPojemnosc(Double pojemnosc) {
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
	public Osoba getOsoba() {
		return osoba;
	}
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	public String getWersja() {
		return wersja;
	}
	public void setWersja(String wersja) {
		this.wersja = wersja;
	}
	
}
