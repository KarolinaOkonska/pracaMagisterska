package serviceBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.OsobaDTO;
import dto.SamochodDTO;
import entity.Osoba;
import entity.Samochod;
import service.SamochodService;

@Stateless
public class SamochodServiceBean implements SamochodService {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Samochod> pobierzSamochodyOsoby(Osoba osoba) {
		List<Samochod> lista = (List<Samochod>) em
				.createQuery("select s from Samochod s where s.osoba = :osoba order by s.dataZakupu desc")
				.setParameter("osoba", osoba).getResultList();
		return lista;
	}

	@Override
	public void zapiszSamochodOsobie(Osoba osoba, Samochod samochod) {
		samochod.setOsoba(osoba);
		em.persist(samochod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> pobierzMarki() {
		List<String> resultList = new ArrayList<>();
		resultList = (List<String>) em.createNativeQuery("select distinct marka from markamodel order by 1")
				.getResultList();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> pobierzModele(String marka) {
		List<String> resultList = new ArrayList<>();
		resultList = (List<String>) em
				.createNativeQuery("select distinct model from markamodel where marka like :marka order by 1")
				.setParameter("marka", marka).getResultList();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> pobierzWersje(String marka, String model) {
		String result = "";
		List<String> listaWersji = new ArrayList<>();
		result = (String) em
				.createNativeQuery("select distinct " + " wersja " + " from markamodel " + " where marka like :marka "
						+ " and model like :model ")
				.setParameter("marka", marka).setParameter("model", model).getSingleResult();

		if (!result.isEmpty()) {
			String[] split = result.split(",");
			listaWersji = new ArrayList<String>(Arrays.asList(split));
		}
		return listaWersji;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SamochodDTO> pobierzSamochodyCombo(OsobaDTO osoba) {
		String myslnik = "/' - /'";
		List<SamochodDTO> resultList = em
				.createQuery("Select new dto.SamochodDTO(s.id, concat(s.marka, '-' , s.model, '-' ,s.rocznik)) "
						+ "from Samochod s " + "where s.osoba.id = :osobaId " + "order by s.dataZakupu desc")
				.setParameter("osobaId", osoba.getId()).getResultList();
		return resultList;
	}

	@Override
	public SamochodDTO pobierzSamochodPoId(Long id) {
		SamochodDTO result = (SamochodDTO) em
				.createQuery("Select new dto.SamochodDTO(s.id, concat(s.marka, '-' , s.model, '-' ,s.rocznik)) "
						+ "from Samochod s where s.id = :id ")
				.setParameter("id", id).getSingleResult();
		return result;
	}
}
