package serviceBean;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import dto.SamochodDTO;
import entity.Osoba;
import entity.Paliwo;
import entity.Samochod;
import service.PaliwoService;

@Stateless
public class PaliwoServiceBean implements PaliwoService{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void zapiszDane(String rodzPaliwa, double iloscPaliwa, double cenaZaLitr, Date dataTankowania, SamochodDTO samochod) {
		Paliwo p = new Paliwo();
		p.setRodzPaliwa(rodzPaliwa);
		p.setIloscPaliwa(iloscPaliwa);
		p.setCenaZaLitr(cenaZaLitr);
		p.setDataTankowania(dataTankowania);
		Samochod s = new Samochod();
		s.setId(samochod.getId());
		p.setSamochod(s);
		em.persist(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paliwo> pobierzPaliwaOsoby(Long idAuta, Date dataOd, Date dataDo) {
		List<Paliwo> lista;
		try{
			lista = (List<Paliwo>) em.createQuery("SELECT p FROM Paliwo p where (:idAuta is null or p.samochod.id = :idAuta) and p.dataTankowania BETWEEN :dataOd AND :dataDo ORDER BY p.dataTankowania")
			.setParameter("idAuta", idAuta)
			.setParameter("dataOd", dataOd)
			.setParameter("dataDo", dataDo)
			.getResultList();
		} catch( NoResultException e){
			lista = null;
		}
		
		return lista;
	}

	@Override
	public void zaktualizujDane(List<Paliwo> paliwa) {
		for (Paliwo paliwo : paliwa) {
			em.merge(paliwo);
		}
	}
	
}
