package enums;

public enum RodzajPaliwa {
	
	benzyna("Benzyna"),
	diesel("Diesel"),
	benzLPG("Benzyna+LPG"),
	beznCNG("Benzyna+CNG")
//	elektr("Elektrycznoœæ"),
//	etanol("Etanol"),
//	hybryda("Hybryda"),
//	wodor("Wodór")
	;
	
	private String nazwa;
	
	private RodzajPaliwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getNazwa() {
		return nazwa;
	}
}
