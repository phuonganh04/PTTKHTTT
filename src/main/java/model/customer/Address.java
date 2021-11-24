package model.customer;

public class Address {
    private int id;
    private String city;
    private String district;
    private int noHome;
    private String street;
    private int customerid;

    public Address() {
    }

    public Address(int id, String city, String district, int noHome, String street, int customerid) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.noHome = noHome;
        this.street = street;
        this.customerid = customerid;
    }
    
    public Address(String city, String district, int noHome, String street) {
		super();
		this.city = city;
		this.district = district;
		this.noHome = noHome;
		this.street = street;
	}

	public Address(String city, String district, int noHome, String street, int customerid) {
		super();
		this.city = city;
		this.district = district;
		this.noHome = noHome;
		this.street = street;
		this.customerid = customerid;
	}

	public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getNoHome() {
        return noHome;
    }

    public void setNoHome(int noHome) {
        this.noHome = noHome;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}
