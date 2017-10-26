package enums;

public enum RodzajNapedu {

	wd4("4x4"),
	przod("Przedni"),
	tyl("Tylni");
	
	private String nazwa;
	
	private RodzajNapedu(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
}
