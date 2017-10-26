package dto;

import java.io.Serializable;
import java.util.Date;

import entity.Samochod;

public class MandatDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520094037718400527L;

	private Long id;
	private String miasto;
	private String rodzajWykroczenia;
	private Date dataOtrzymania;
	private int otrzymanePkt;
	private double kwota;
	private SamochodDTO samochod;

	public MandatDTO(){
	}

	public MandatDTO(Long id, String miasto, String rodzajWykroczenia, Date dataOtrzymania, int otrzymanePkt,
			double kwota, Long samochodId) {
		super();
		this.id = id;
		this.miasto = miasto;
		this.rodzajWykroczenia = rodzajWykroczenia;
		this.dataOtrzymania = dataOtrzymania;
		this.otrzymanePkt = otrzymanePkt;
		this.kwota = kwota;
		this.samochod = new SamochodDTO(samochodId);
	}

	public MandatDTO(Long id, String miasto, String rodzajWykroczenia, Date dataOtrzymania, int otrzymanePkt,
			double kwota, Long samochodId, String samochodNazwa) {
		super();
		this.id = id;
		this.miasto = miasto;
		this.rodzajWykroczenia = rodzajWykroczenia;
		this.dataOtrzymania = dataOtrzymania;
		this.otrzymanePkt = otrzymanePkt;
		this.kwota = kwota;
		this.samochod = new SamochodDTO(samochodId, samochodNazwa);
	}
	
	public SamochodDTO getSamochod() {
		return samochod;
	}
	
	public void setSamochod(SamochodDTO samochod) {
		this.samochod = samochod;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataOtrzymania() {
		return dataOtrzymania;
	}

	public void setDataOtrzymania(Date dataOtrzymania) {
		this.dataOtrzymania = dataOtrzymania;
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

}
