package service;

import javax.ejb.Remote;

import entity.Osoba;
import entity.User;

@Remote
public interface OsobaService {

	void zarejestrujOsobe(User u);
}
