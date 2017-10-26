package service;

import java.util.List;

import javax.ejb.Remote;

import dto.OsobaDTO;
import dto.SamochodDTO;
import entity.Osoba;
import entity.Samochod;

@Remote
public interface SamochodService {
	
	public List<String> pobierzMarki();
	
	public List<Samochod> pobierzSamochodyOsoby(Osoba osoba);
	
	public void zapiszSamochodOsobie(Osoba osoba, Samochod samochod);

	public List<String> pobierzModele(String marka);

	public List<String> pobierzWersje(String marka, String model);
	
	public List<SamochodDTO> pobierzSamochodyCombo(OsobaDTO osoba);
	
	public SamochodDTO pobierzSamochodPoId(Long id);

}
