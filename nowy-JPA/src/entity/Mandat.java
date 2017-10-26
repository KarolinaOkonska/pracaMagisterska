package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Mandat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4406951514670618544L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataOtrzymania;
	
	private String miasto;
	
	private String rodzajWykroczenia;
	
	private int otrzymanePkt;
	
	private double kwota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="samochod_id" ) 
	private Samochod samochod;
	

	public Date getDataOtrzymania() {
		return dataOtrzymania;
	}

	public void setDataOtrzymania(Date dataOtrzymania) {
		this.dataOtrzymania = dataOtrzymania;
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Samochod getSamochod() {
		return samochod;
	}

	public void setSamochod(Samochod samochod) {
		this.samochod = samochod;
	}
	
}
