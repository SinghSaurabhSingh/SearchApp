package springmvc.search;

public class Address {

	private String street;
	private String City;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", City=" + City + "]";
	}
	
	

}
