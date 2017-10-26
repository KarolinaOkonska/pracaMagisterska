package serviceBean;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dto.MandatDTO;
import dto.OsobaDTO;
import entity.Mandat;
import entity.Samochod;
import service.MandatyService;

@Stateless
public class MandatyServiceBean implements MandatyService{

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<MandatDTO> pobierzMandatyOsoby(OsobaDTO dto) {
		List<MandatDTO> lista = em.createQuery("SELECT new dto.MandatDTO(m.id, m.miasto, m.rodzajWykroczenia, m.dataOtrzymania, m.otrzymanePkt, m.kwota, m.samochod.id, "
				+ " concat(m.samochod.marka, '-', m.samochod.model, '-', m.samochod.rocznik) ) "
				+ " FROM Mandat m WHERE m.samochod.osoba.id = :osobaId ")
				.setParameter("osobaId", dto.getId())
				.getResultList();
		return lista;
	}

	@Override
	public void zapiszMandat(String miasto, String rodzajWykroczenia, Date dataOtrzymania, int otrzymanePkt,
			double kwota, Long samochodId) {
		Mandat m = new Mandat();
		m.setMiasto(miasto);
		m.setRodzajWykroczenia(rodzajWykroczenia);
		m.setDataOtrzymania(dataOtrzymania);
		m.setOtrzymanePkt(otrzymanePkt);
		m.setKwota(kwota);
		Samochod s = new Samochod();
		s.setId(samochodId);
		m.setSamochod(s);
		em.persist(m);
	}

}
