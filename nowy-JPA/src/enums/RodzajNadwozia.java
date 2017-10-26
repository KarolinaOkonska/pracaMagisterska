package enums;

public enum RodzajNadwozia {

    hatchback("Hatchback"),
    sedan("Sedan/Limuzyna"),
    kombi("Kombi"),
    minivan("Minivan"),
    pickUp("Pick-up"),
    kabriolet("Kabriolet"),
    sportowy("Sportowy/Coupe"),
    suv("SUV"),
    terenowy("Terenowy"),
    van("Van (minibus)");
	
	private String nazwa;
	
	private RodzajNadwozia(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public String getNazwa() {
		return nazwa;
	}
}
