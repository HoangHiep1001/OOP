package create;

public class Relationship {
	private String quanhe; 
	private Country country;
	private Event event;
	private Location location;
	private Organization organization;
	private Person person;
	private String time;
	ThucThe thucThe1;
	ThucThe thucThe2;
//	public QuanHe(Location location, Country country, String quanhe) {
//		this.location = location;
//		this.country = country;
//		this.quanhe= quanhe;
//	}
	
	public Relationship(ThucThe thucThe1, String quanHe, ThucThe thucThe2) {
		this.thucThe1 = thucThe1;
		this.thucThe2 = thucThe2;
		this.quanhe = quanHe;
	}
	
	public Relationship(Person person , Organization organization, String quanhe , String time) {
		this.setPerson(person);
		this.setOrganization(organization);
		this.quanhe = quanhe;
		this.time = time;
	}
	
	public Relationship(Event event, Country country, String quanhe, String time) {
		this.setEvent(event);
		this.setCountry(country);
		this.quanhe = quanhe;
		this.time = time;
	}
	
	public Relationship(Event event, Location location , String quanhe,String time) {
		this.setEvent(event);
		this.setLocation(location);
		this.quanhe = quanhe;
		this.time = time;
	}
	
	public Relationship(Person person, Country country, String quanhe,String time) {
		this.setPerson(person);
		this.setCountry(country);
		this.quanhe = quanhe;
		this.time = time;
	}
	public Relationship(Person person, Location location, String quanhe,String time) {
		this.setPerson(person);
		this.setLocation(location);
		this.quanhe = quanhe;
		this.time = time;
	}
	
	public Relationship(Organization organization, Country country, String quanhe,String time) {
		this.setOrganization(organization);
		this.setCountry(country);
		this.quanhe = quanhe;
		this.time = time;
	}
	
	public Relationship(Organization organization, Location location, String quanhe,String time) {
		this.setOrganization(organization);
		this.setLocation(location);
		this.quanhe = quanhe;
		this.time = time;
	}
	public String getRelationship() {
		return quanhe;
	}
	public void setRelationship(String quanhe) {
		this.quanhe = quanhe;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
