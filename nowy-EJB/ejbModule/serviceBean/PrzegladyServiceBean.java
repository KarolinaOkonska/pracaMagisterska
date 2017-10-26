package serviceBean;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dto.OsobaDTO;
import dto.PrzegladDTO;
import dto.SamochodDTO;
import entity.Przeglad;
import entity.Samochod;
import service.PrzegladyService;

@Stateless
public class PrzegladyServiceBean implements PrzegladyService{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void zapiszPrzeglad(String opisStacji, Date dataPrzegladu, Date dataWaznosci, String uwagi,
			SamochodDTO samochodDTO) {
		Przeglad p = new Przeglad();
		p.setOpisStacji(opisStacji);
		p.setDataPrzegladu(dataPrzegladu);
		p.setDataWaznosci(dataWaznosci);
		p.setUwagi(uwagi);
		Samochod s = new Samochod();
		s.setId(samochodDTO.getId());
		p.setSamochod(s);
		em.persist(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PrzegladDTO> pobierzPrzegladyOsoby(SamochodDTO samochodDTO) {
		List<PrzegladDTO> result =  em.createQuery("Select new dto.PrzegladDTO(p.id, p.opisStacji, p.dataPrzegladu, p.dataWaznosci, p.uwagi, p.samochod.id) "
						+ "from Przeglad p where p.samochod.id = :idSamochod ")
				.setParameter("idSamochod", samochodDTO.getId()).getResultList();
		return result;
	}


}
