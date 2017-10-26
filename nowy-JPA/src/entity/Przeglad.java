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
public class Przeglad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 765512657804141098L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String opisStacji;
	
	@Temporal(TemporalType.DATE)
	private Date dataPrzegladu;
	
	@Temporal(TemporalType.DATE)
	private Date dataWaznosci;
	
	private String uwagi;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="samochod_id" ) 
	private Samochod samochod;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Samochod getSamochod() {
		return samochod;
	}

	public void setSamochod(Samochod samochod) {
		this.samochod = samochod;
	}
	
}
