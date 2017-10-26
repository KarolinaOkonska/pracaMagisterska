package enums;

public enum Wojewodztwo {

    dolnoslaskie("Dolnoœl¹skie"),
    kujPomor("Kujawsko-pomorskie"),
    lubelskie("Lubelskie"),
    lubuskie("Lubuskie"),
    lodzkie("£ódzkie"),
    malopolskie("Ma³opolskie"),
    mazowieckie("Mazowieckie"),
    opolskie("Opolskie"),
    podkarpackie("Podkarpackie"),
    podlaskie("Podlaskie"),
    pomorskie("Pomorskie"),
    slaskie("Œl¹skie"),
    swietokrzyskie("Œwiêtokrzyskie"),
    warmMaz("Warmiñsko-mazurskie"),
    wielkopolskie("Wielkopolskie"),
    zachodniopomorskie("Zachodniopomorskie");

    private String nazwa;
    
    Wojewodztwo(String nazwa){
    	this.nazwa = nazwa;
    }
	
    public String getNazwa() {
		return nazwa;
	}
}
