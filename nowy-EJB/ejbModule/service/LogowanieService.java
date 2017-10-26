package service;

import javax.ejb.Local;

@Local
public interface LogowanieService {

	public Long pobierzIdOsoby(String login, String password);
}
