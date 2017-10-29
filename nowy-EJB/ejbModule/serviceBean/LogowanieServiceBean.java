package serviceBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import service.LogowanieService;

@Stateless
public class LogowanieServiceBean implements LogowanieService {

	@PersistenceContext
	private EntityManager em;

	public Long pobierzIdOsoby(String login, String password) {
		Long id = -1L;
		Long count = (Long) em
				.createQuery("SELECT count(u) FROM User u WHERE u.login like :login and u.pass like :password")
				.setParameter("login", login)
				.setParameter("password", password)
				.getSingleResult();

		if (count > 0) {
			id = (Long) em
					.createQuery("SELECT u.osoba.id FROM User u WHERE u.login like :login and u.pass like :password")
					.setParameter("login", login)
					.setParameter("password", password)
					.getSingleResult();
		}

		return id;
	}
}