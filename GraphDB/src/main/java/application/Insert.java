package application;

import java.util.ArrayList;

import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.Update;
import org.eclipse.rdf4j.query.algebra.evaluation.function.numeric.Rand;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import create.Country;
import create.Event;
import create.Location;
import create.Organization;
import create.Person;
import create.ThucThe;
import createdata.Manager;

public class Insert {
	// GraphDB
	private static final String GRAPHDB_SERVER = "http://localhost:7200/";
	private static final String REPOSITORY_ID = "Group4";
	Manager manager = new Manager("D:\\NguonGoc.txt", "D:\\Person.txt", "D:\\Country.txt", "D:\\QuanHe.txt",
			"D:\\Organization.txt", "D:\\Event.txt", "D:\\Location.txt", "D:\\Time.txt");
	RepositoryConnection repositoryConnection = null;
	private String strInsert;
	private String[] strQuery = new String[5];
	String str;
	ArrayList<String> listRelationship;

	public String insertEntity(ThucThe thucthe, String str) {
		System.out.println(thucthe.getDinhDanh());
		return strInsert = "INSERT DATA {" + "" + str + " <http://TEST/identification> \"" + thucthe.getDinhDanh()
				+ "\" ." + "" + str + " <http://TEST/description> \"" + thucthe.getMoTa() + ".\" ." + "" + str
				+ " <http://TEST/label> \"" + thucthe.getNhanHienThi() + "\" ." + "" + str + " <http://TEST/Ngayrut> \""
				+ thucthe.getNguonGoc().getNgayTRichRut() + "\" ." + "" + str + " <http://TEST/Link> \""
				+ thucthe.getNguonGoc().getLink() + "\" ." + "}";
	}

	public void insertCountry() {
//		RepositoryConnection repositoryConnection = null;
		Country country = new Country();
		for (int i = 0; i < manager.personList.size(); i++) {
			country = manager.countryList.get(i);
//			for (int j = 0; j < manager.countryList.size(); j++) {
			str = "<http://TEST/" + country.getDinhDanh() + ">";
			strInsert = "INSERT DATA {" + "" + str + " <http://TEST/ThuDo> \"" + country.getThuDo() + "\" ." + "}";
			try {
				repositoryConnection = getRepositoryConnection();
				// repositoryConnections = getRepositoryConnection();

				insert(repositoryConnection, strInsert);
				insert(repositoryConnection, insertEntity(country, str));

			} catch (Throwable t) {
				t.getMessage();
			} finally {
				repositoryConnection.close();
				// repositoryConnections.close();
			}
		}
	}
//	}

	public void insertPerson() {
		// insert person`
//		RepositoryConnection repositoryConnection = null;
		Person person = new Person();
		Manager manager = new Manager("D:\\NguonGoc.txt", "D:\\Person.txt", "D:\\Country.txt", "D:\\QuanHe.txt",
				"D:\\Organization.txt", "D:\\Event.txt", "D:\\Location.txt", "D:\\Time.txt");
		// insert person
		for (int i = 0; i < manager.personList.size(); i++) {
			person = manager.personList.get(i);

			str = "<http://TEST/" + person.getDinhDanh() + ">";
			strInsert = "INSERT DATA {" + "" + str + " <http://TEST/ChucVu> \"" + person.getChucVu() + "\" ." + "}";
			try {
				repositoryConnection = getRepositoryConnection();
				// repositoryConnections = getRepositoryConnection();

				insert(repositoryConnection, strInsert);
				insert(repositoryConnection, insertEntity(person, str));

			} catch (Throwable t) {
				t.getMessage();
			} finally {
				repositoryConnection.close();
				// repositoryConnections.close();
			}

		}
	}

	public void insertOrganization() {
		Organization organization = new Organization();
		for (int i = 0; i < manager.organizationList.size(); i++) {
			organization = manager.organizationList.get(i);

			str = "<http://TEST/" + organization.getDinhDanh() + ">";
			strInsert = "INSERT DATA {" + "" + str + " <http://TEST/TruSo> \"" + organization.getTruSo() + "\" ." + "}";
			try {
				repositoryConnection = getRepositoryConnection();

				insert(repositoryConnection, strInsert);
				insert(repositoryConnection, insertEntity(organization, str));

			} catch (Throwable t) {
				t.getMessage();
			} finally {
				repositoryConnection.close();
			}

		}
	}

	public void insertRelationship(String filePath) {
		for (int i = 0; i < 500; i++) {
			listRelationship = manager.getRelationShip(filePath);
			int r1 = (int) Math.floor(Math.random() * manager.personList.size());
			int r2 = (int) Math.floor(Math.random() * manager.personList.size());
			int r3 = (int) Math.floor(Math.random() * listRelationship.size());
			String s = manager.personList.get(r1).getDinhDanh();
			String p = listRelationship.get(r3);
			String o = manager.personList.get(r2).getDinhDanh();

			strInsert = "PREFIX : <http://TEST/>" + "INSERT DATA {" + ":" + s + " :" + p + " :" + o + " ." + "}";
			try {
				repositoryConnection = getRepositoryConnection();

				insert(repositoryConnection, strInsert);

			} catch (Throwable t) {
				t.getMessage();
			} finally {
				repositoryConnection.close();
			}

		}
	}

	public void insertLocation() {
		Location location;
		for (int i = 0; i < manager.locationList.size(); i++) {
			location = manager.locationList.get(i);

			str = "<http://TEST/" + location.getDinhDanh() + ">";
//		 strInsert = 
//		            "INSERT DATA {"
//		             + ""+str+" <http://TEST/TruSo> \""+location.getTruSo()+"\" ."
//		             + "}";
			try {
				repositoryConnection = getRepositoryConnection();

				insert(repositoryConnection, strInsert);
				insert(repositoryConnection, insertEntity(location, str));

			} catch (Throwable t) {
				t.getMessage();
			} finally {
				repositoryConnection.close();
			}

		}
	}

	public void insertEvent() {
		Event event;
		for (int i = 0; i < manager.eventList.size(); i++) {
			event = manager.eventList.get(i);

			str = "<http://TEST/" + event.getDinhDanh() + ">";
//		 strInsert = 
//		            "INSERT DATA {"
//		             + ""+str+" <http://TEST/TruSo> \""+location.getTruSo()+"\" ."
//		             + "}";
			try {
				repositoryConnection = getRepositoryConnection();

				insert(repositoryConnection, strInsert);
				insert(repositoryConnection, insertEntity(event, str));

			} catch (Throwable t) {
				t.getMessage();
			} finally {
				repositoryConnection.close();
			}

		}
	}

	private RepositoryConnection getRepositoryConnection() {
		Repository repository = new HTTPRepository(GRAPHDB_SERVER, REPOSITORY_ID);
		repository.initialize();
		RepositoryConnection repositoryConnection = repository.getConnection();
		return repositoryConnection;
	}

	private void insert(RepositoryConnection repositoryConnection, String insert) {
		repositoryConnection.begin();

		Update updateOperation = repositoryConnection.prepareUpdate(QueryLanguage.SPARQL, insert);
		updateOperation.execute();

		try {
			repositoryConnection.commit();
		} catch (Exception e) {
			if (repositoryConnection.isActive())
				repositoryConnection.rollback();
		}
	}
}
