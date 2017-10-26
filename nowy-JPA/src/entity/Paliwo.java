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
public class Paliwo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2999570668340661518L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String rodzPaliwa;
	private double iloscPaliwa;
	private double cenaZaLitr;
	@Temporal(TemporalType.DATE)
	private Date dataTankowania;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="samochod_id" ) 
	private Samochod samochod;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Samochod getSamochod() {
		return samochod;
	}

	public void setSamochod(Samochod samochod) {
		this.samochod = samochod;
	}

}
