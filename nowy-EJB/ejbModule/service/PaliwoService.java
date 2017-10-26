package service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import dto.SamochodDTO;
import entity.Paliwo;

@Remote
public interface PaliwoService {

	public void zapiszDane(String rodzPaliwa, double iloscPaliwa, double cenaZaLitr, Date dataTankowania,SamochodDTO samochod);

	public List<Paliwo> pobierzPaliwaOsoby(Long idAuta, Date dataOd, Date dataDo);

	public void zaktualizujDane(List<Paliwo> paliwa);
}
