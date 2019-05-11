lpackage application;

import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.rdf4j.model.impl.SimpleIRI;
import org.eclipse.rdf4j.model.impl.SimpleLiteral;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.query.Update;
import org.eclipse.rdf4j.query.algebra.InsertData;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import create.Country;
import create.Event;
import create.Location;
import create.Organization;
import create.Person;
import create.ThucThe;
import createdata.CreateRelationship;
import createdata.Manager;

/**
 *
 * @author 
 * Thực hiện truy vấn và ghi thông tin ra file log
 * Cần tạo file log4j và cấu hình logger cho nó
 *
 */
public class Main {
 
  
  // GraphDB 
  private static final String GRAPHDB_SERVER = "http://localhost:7200/";
  private static final String REPOSITORY_ID = "Group4";
  private static RepositoryConnection getRepositoryConnection() {
    Repository repository = new HTTPRepository(GRAPHDB_SERVER, REPOSITORY_ID);
    repository.initialize();
    RepositoryConnection repositoryConnection = repository.getConnection();
    return repositoryConnection;
  }
  public static void menuSimple(Query query){
	  RepositoryConnection repositoryConnection = null;
	  int luachon;
	  while(true) {
		  System.out.println("=========Cac câu lênh truy vấn cơ bản=======");
		  System.out.println("1. Mô tả Vieng_Chan(Location)");
		  System.out.println("2. Mô tả Viet_Nam(Location)");
		  System.out.println("3. Chức vụ Chu_Tich_Quoc_Hoi_Nguyen_Thi_Kim_Ngan(Person)");
		  System.out.println("4. Mô tả Van_Mieu_Quoc_Tu_Giam(Location)");
		  System.out.println("5. Thủ đô Campuchia(Country)");
		  System.out.println("6. Trụ sở Apple(Organization)");
		  System.out.println("7. Chức vụ Bo_truong_bo_y_te_Nguyen_Thi_Kim_Tien(Person)");
		  System.out.println("8. Ngày trích rút Nhật Ban(Country)");
		  System.out.println("9. Mô tả Paris(Country)");
		  System.out.println("10. Mô tả AFF_Cup(Event)");
		  System.out.println("Nhap vao lua chon: ");
		  luachon = new Scanner(System.in).nextInt();
		  if(luachon < 0|| luachon > 10) {
			  System.out.println("Lua chon khong hop le. Moi ban nhap lai");
		  }
		  else {
			  try { 
			      repositoryConnection = getRepositoryConnection();
			      long start = System.currentTimeMillis();
			      System.out.println(query.singleQuery(repositoryConnection, luachon - 1)); 
			      long end = System.currentTimeMillis();
			      System.out.println("Thoi Gian Truy Van : "+(end - start) + " miliseconds");          
			    } catch (Throwable t) {
			      t.getMessage();
			    } finally {
			      repositoryConnection.close();
			    }
		  }
	  }
  }
  public static void menuAdvance(Query query){
	  RepositoryConnection repositoryConnection = null;
	  int luachon;
	  while(true) {
		  System.out.println("=========Cac câu lênh truy vấn cơ bản=======");
		  System.out.println("11. Những sự kiện nào tổ chức tại campuchia");
		  System.out.println("12. Chu_Tich_Quoc_Hoi_Nguyen_Thi_Kim_Ngan sinh sống ở những đâu?");
		  System.out.println("13. Những ai đang sinh sống tại Hà Nội");
		  System.out.println("14. Nguyen VAn Khang có anh em với những ai?");
		  System.out.println("15. Những sự kiện nào diễn ra tại Việt Nam");
		  System.out.println("16. Pho_Thu_Tuong_Truong_Hoa_Binh du lịch ở những đâu?");
		  System.out.println("17. Những ai làm việc tại Intel?");
		  System.out.println("18. Bo_truong_bo_y_te_Nguyen_Thi_Kim_Tien có quê hương ở những đâu?");
		  System.out.println("19. Những ai đi đến Đài Loan?");
		  System.out.println("20. Apple co trụ sở tại những đâu?");
		  System.out.println("Nhap vao lua chon: ");
		  luachon = new Scanner(System.in).nextInt();
		  if(luachon < 10|| luachon > 20) {
			  System.out.println("Lua chon khong hop le. Moi ban nhap lai");
		  }
		  else {
			  try { 
			      repositoryConnection = getRepositoryConnection();
			      long start = System.currentTimeMillis();
			      query.advanceQuery(repositoryConnection, luachon - 1); 
			      long end = System.currentTimeMillis();
			      System.out.println("Thoi Gian Truy Van : "+(end - start) + " miliseconds");          
			    } catch (Throwable t) {
			      t.getMessage();
			    } finally {
			      repositoryConnection.close();
			    }
		  }
	  }
  }
  public static void main(String[] args) {
	  Query query = new Query();
	  menuSimple(query);
	  //menuAdvance(query);
  }
}