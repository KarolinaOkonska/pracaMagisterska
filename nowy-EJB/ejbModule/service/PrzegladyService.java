package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import dto.PrzegladDTO;
import dto.SamochodDTO;

@Remote
public interface PrzegladyService {

	List<PrzegladDTO> pobierzPrzegladyOsoby(SamochodDTO samochodDTO);

	void zapiszPrzeglad(String opisStacji, Date dataPrzegladu, Date dataWaznosci, String uwagi, SamochodDTO samochodDTO);
}
