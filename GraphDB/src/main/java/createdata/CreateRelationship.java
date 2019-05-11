package createdata;

import java.util.ArrayList;
import java.util.Random;

import application.Query;
import create.Country;
import create.Event;
import create.Location;
import create.Organization;
import create.Person;
import create.Relationship;

public class CreateRelationship {
	public static ArrayList<Relationship> relationshipList;
	public Country country;
	public Event event;
	public Location location;
	public Organization organization;
	public String quanhe;
	public static Person person;
	//Nguoi vs nguoi
	public ArrayList<String> quanHePPList;
	
	//Nguoi vs Event (tham gia)
	public ArrayList<String> quanHePEList;
	
	//Nguoi o dau
	public ArrayList<String> quanHePLList;
	
	//NG thuoc to chuc
	public ArrayList<String> quanHePOList;
	
	//Nguoi o quoc gia
	public ArrayList<String> quanHePCList;
	
	//Event to chuc o dau
	public ArrayList<String> quanHeELList;
	
	//Event dien ra quoc gia
	public ArrayList<String> quanHeECList;
	
	//to chuc to chuc su kien gi
	public ArrayList<String> quanHeOEList;
	
	//Location thuoc quoc gia nao
	public ArrayList<String> quanHeLCList;
	
	//Location vs Org co tru so tai
	public ArrayList<String> quanHeLOList;
	
	int n1,n2,n3,n4;
	
	// ham random mot so tu nhien trong khoang cho truoc 
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
}
