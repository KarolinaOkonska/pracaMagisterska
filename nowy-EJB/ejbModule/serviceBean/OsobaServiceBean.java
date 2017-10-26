package serviceBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.User;
import service.OsobaService;

@Stateless
//@WebService(name = "OsobaWebService", serviceName = "OsobaService", portName = "OsobaServicePort")
public class OsobaServiceBean implements OsobaService{

	@PersistenceContext
	private EntityManager em;

	@Override
	public void zarejestrujOsobe(User u) {
		em.persist(u);
	}

}
