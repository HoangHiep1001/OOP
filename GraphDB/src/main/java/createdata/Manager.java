package createdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import create.Country;
import create.Event;
import create.Location;
import create.NguonGoc;
import create.Organization;
import create.Person;
import create.Relationship;

public class Manager {
	public ArrayList<Person> personList;
	public ArrayList<Country> countryList;
	public ArrayList<Organization> organizationList;
	public ArrayList<Event> eventList;
	public ArrayList<Location> locationList;
	public ArrayList<NguonGoc> nguonGocList;
	public ArrayList<String> quanHeList;
	public ArrayList<String> timeList;
	
	
	
	public Manager() {
		
	}
	
	public static int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
	@SuppressWarnings("resource")
	public Manager(String nguonGocFile ,String personFile, String countryFile, String quanHeFile, String organizationFile, String eventFile, String locationFile,String timeFile) {
		personList = new ArrayList<>();
		countryList = new ArrayList<>();
		organizationList = new ArrayList<>();
		eventList = new ArrayList<>();
		locationList = new ArrayList<>();
		quanHeList = new ArrayList<>();
		timeList = new ArrayList<>();
		nguonGocList = new ArrayList<>();
		int n=0;
		try {
			
			// nap danh sach NguonGoc vao nguonGocList
			// Doc 2 dong trong file -> NguonGoc
			BufferedReader br = new BufferedReader(new FileReader(nguonGocFile));
			String line = null;
			while ((line = br.readLine())!=null) {	
					NguonGoc nguonGoc = new NguonGoc();
					
					nguonGoc.setLink(line);
					
					line = br.readLine();
					nguonGoc.setNgayTRichRut(line);
					
					nguonGocList.add(nguonGoc);
					n++;
			}	
			
			
			// nap danh sach Person vao personList
			// Doc 4 dong lien tiep trong file ->Person
			br = new BufferedReader(new FileReader(personFile));
			line = null;
			while ((line = br.readLine()) != null) {
				Person person = new Person();
				
				person.setDinhDanh(line); // add dinh danh
				
				line = br.readLine();
				person.setNhanHienThi(line); // add nhan hien thi
				
				line = br.readLine();
				person.setChucVu(line); // add Chuc vu
				
				line = br.readLine();
				person.setMoTa(line); // add mo ta
				
				person.setNguonGoc(nguonGocList.get(rand(0,n-1)));
				personList.add(person);		
			}
			
			// nap danh sach country vao countryList
			// chon 4 dong
			br = new BufferedReader(new FileReader(countryFile));
			line = null;
			while ((line = br.readLine()) != null) {
				Country country = new Country();
				country.setDinhDanh(line); // add dinh danh
				
				line = br.readLine();
				country.setNhanHienThi(line); // add nhan hien thi
				
				line = br.readLine();
				country.setThuDo(line); // add thu do
				
				line = br.readLine();
				country.setMoTa(line); // Add Mo ta
				
				country.setNguonGoc(nguonGocList.get(rand(0,n-1)));
				
				countryList.add(country);		
			}
		
			
			// nap danh sach OrganizationList
			// 4 dong
			br = new BufferedReader(new FileReader(organizationFile));
			line = null;
			while((line= br.readLine())!= null) {
				Organization organization= new Organization();
				organization.setDinhDanh(line); //add dinh danh
				
				line = br.readLine();
				organization.setNhanHienThi(line); // add nhan hien thi
				
				line = br.readLine();
				organization.setTruSo(line); // add tru so 
				
				line = br.readLine();
				organization.setMoTa(line); // add Mo ta
				
				organization.setNguonGoc(nguonGocList.get(rand(0,n-1)));
				
				organizationList.add(organization); // them vao list
				
			}
			
			// Nap danh sach Event vao eventList
			// doc 3 ddong
			br = new BufferedReader(new FileReader(eventFile));
			line = null;
			while((line= br.readLine())!= null) {
				Event event= new Event();
				event.setDinhDanh(line); //add dinh danh

				line = br.readLine();
				event.setNhanHienThi(line); // add nhan hien thi
				
				line = br.readLine();
				event.setMoTa(line); // add Mo ta
				
				event.setNguonGoc(nguonGocList.get(rand(0,n-1)));
				
				eventList.add(event); // them vao list
				
			}
			
			// Nap danh sach Location vao locationList
			// 3 dong
			br = new BufferedReader(new FileReader(locationFile));
			line = null;
			while((line= br.readLine())!= null) {
				Location location= new Location();
				location.setDinhDanh(line); //add dinh danh
				
				line = br.readLine();
				location.setNhanHienThi(line); // add nhan hien thi
				
				line = br.readLine();
				location.setMoTa(line); // add Mo ta
				
				location.setNguonGoc(nguonGocList.get(rand(0,n-1)));
				
				locationList.add(location); // them vao list
				
			}
			
			// nap danh sach quan he vao quanHeList
			br = new BufferedReader(new FileReader(quanHeFile));
			line = null;
			while ((line = br.readLine()) != null) {
					quanHeList.add(line);		// mang String cac quan he
			}			
			
			// nap danh sach thoi gian vao timeList
			br = new BufferedReader(new FileReader(timeFile));
			line = null;
			while ((line = br.readLine())!=null) {
				timeList.add(line);
			}			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getRelationShip(String fileNguonGoc){
		try {
			
			// nap danh sach NguonGoc vao nguonGocList
			// Doc 2 dong trong file -> NguonGoc
			BufferedReader br = new BufferedReader(new FileReader(fileNguonGoc));
			String line = null;
			while ((line = br.readLine())!=null) {	
					quanHeList.add(line);
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return quanHeList;
	}
}
