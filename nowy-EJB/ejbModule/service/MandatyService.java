package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import dto.MandatDTO;
import dto.OsobaDTO;

@Remote
public interface MandatyService {

	List<MandatDTO> pobierzMandatyOsoby(OsobaDTO dto);

	void zapiszMandat(String miasto, String rodzajWykroczenia, Date dataOtrzymania, 
			int otrzymanePkt, double kwota,	Long samochodId);
//	void zapiszPrzeglad(String opisStacji, Date dataPrzegladu, Date dataWaznosci, String uwagi, SamochodDTO samochodDTO);
}
