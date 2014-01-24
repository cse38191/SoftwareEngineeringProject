package helper;

public class Praxi {
	
	int id;
	String kaek;
	String eponimo;
	String onoma;
	String patronimo;
	String address;
	String adt;
	String ekdarxi;
	String arpraxis;
	String hmerominia;
	String symvolaiografos;
	String phone;
	
	public Praxi(int id, String kaek, String eponimo, String onoma,
			String patronimo, String address, String adt, String ekdarxi,
			String arpraxis, String hmerominia, String symvolaiografos,
			String phone) {
		this.id = id;
		this.kaek = kaek;
		this.eponimo = eponimo;
		this.onoma = onoma;
		this.patronimo = patronimo;
		this.address = address;
		this.adt = adt;
		this.ekdarxi = ekdarxi;
		this.arpraxis = arpraxis;
		this.hmerominia = hmerominia;
		this.symvolaiografos = symvolaiografos;
		this.phone = phone;
	}
	
	public Praxi() {
		this.id = 0;
		this.kaek = "";
		this.eponimo = "";
		this.onoma = "";
		this.patronimo = "";
		this.address = "";
		this.adt = "";
		this.ekdarxi = "";
		this.arpraxis = "";
		this.hmerominia = "";
		this.symvolaiografos = "";
		this.phone = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKaek() {
		return kaek;
	}

	public void setKaek(String kaek) {
		this.kaek = kaek;
	}

	public String getEponimo() {
		return eponimo;
	}

	public void setEponimo(String eponimo) {
		this.eponimo = eponimo;
	}

	public String getOnoma() {
		return onoma;
	}

	public void setOnoma(String onoma) {
		this.onoma = onoma;
	}

	public String getPatronimo() {
		return patronimo;
	}

	public void setPatronimo(String patronimo) {
		this.patronimo = patronimo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdt() {
		return adt;
	}

	public void setAdt(String adt) {
		this.adt = adt;
	}

	public String getEkdarxi() {
		return ekdarxi;
	}

	public void setEkdarxi(String ekdarxi) {
		this.ekdarxi = ekdarxi;
	}

	public String getArpraxis() {
		return arpraxis;
	}

	public void setArpraxis(String arpraxis) {
		this.arpraxis = arpraxis;
	}

	public String getHmerominia() {
		return hmerominia;
	}

	public void setHmerominia(String hmerominia) {
		this.hmerominia = hmerominia;
	}

	public String getSymvolaiografos() {
		return symvolaiografos;
	}

	public void setSymvolaiografos(String symvolaiografos) {
		this.symvolaiografos = symvolaiografos;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
