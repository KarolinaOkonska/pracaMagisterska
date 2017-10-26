package dto;

import java.io.Serializable;
import java.util.Date;

public class PrzegladDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4520094037718400527L;

	private Long id;
	private String opisStacji;
	private Date dataPrzegladu;
	private Date dataWaznosci;
	private String uwagi;
	private Long samochodId;
	
	public PrzegladDTO(){
	}
	
	public PrzegladDTO(Long id, String opisStacji, Date dataPrzegladu, Date dataWaznosci, String uwagi, Long samochodId) {
		super();
		this.id = id;
		this.opisStacji = opisStacji;
		this.dataPrzegladu = dataPrzegladu;
		this.dataWaznosci = dataWaznosci;
		this.uwagi = uwagi;
		this.samochodId = samochodId;
	}

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

	public Long getSamochodId() {
		return samochodId;
	}

	public void setSamochodId(Long samochodId) {
		this.samochodId = samochodId;
	}
	
}
