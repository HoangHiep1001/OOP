package application;

import org.eclipse.rdf4j.model.impl.SimpleIRI;
import org.eclipse.rdf4j.model.impl.SimpleLiteral;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class Query {
	private static String[] strQuery = new String[20];
	static {
	    strQuery[0] =
	        "SELECT ?o FROM DEFAULT WHERE {" +
	        "<http://TEST/Vieng_Chan> <http://TEST/description> ?o .}";
	    strQuery[1] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Viet_Nam> <http://TEST/description> ?o .}";	
	    strQuery[2] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Chu_Tich_Quoc_Hoi_Nguyen_Thi_Kim_Ngan> <http://TEST/ChucVu> ?o .}";	
	    strQuery[3] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Van_Mieu_Quoc_Tu_Giam> <http://TEST/description> ?o .}";
	    strQuery[4] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Cam_pu_chia> <http://TEST/ThuDo> ?o .}";	

	    strQuery[5] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Apple> <http://TEST/TruSo> ?o .}";	

	    strQuery[6] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Bo_truong_bo_y_te_Nguyen_Thi_Kim_Tien> <http://TEST/ChucVu> ?o .}";	

	    strQuery[7] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Nhat_Ban> <http://TEST/Ngayrut> ?o .}";	

	    strQuery[8] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Paris> <http://TEST/description> ?o .}";	

	    strQuery[9] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/AFF_Cup> <http://TEST/description> ?o .}";	

	    strQuery[10] = 
		        "SELECT ?s FROM DEFAULT WHERE {" +
		        "?s <http://TEST/to_chuc_tai> ?Campuchia .}";	
	    
	    strQuery[11] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Chu_Tich_Quoc_Hoi_Nguyen_Thi_Kim_Ngan> <http://TEST/sinh_song> ?o .}";	

	    strQuery[12] = 
		        "SELECT ?s FROM DEFAULT WHERE {" +
		        "?s <http://TEST/sinh_song> ?Ha_Noi .}";
	    
	    strQuery[13] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Nguyen_Van_Khang> <http://TEST/anh_em> ?o .}";	
	    
	    strQuery[14] = 
		        "SELECT ?s FROM DEFAULT WHERE {" +
		        "?s <http://TEST/dien_ra_tai> ?Viet_Nam .}";	
	    
	    strQuery[15] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Pho_Thu_Tuong_Truong_Hoa_Binh> <http://TEST/du_lich> ?o .}";	

	    strQuery[16] = 
		        "SELECT ?s FROM DEFAULT WHERE {" +
		        "?s <http://TEST/lam_viec> ?Intel .}";	

	    strQuery[17] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Bo_truong_bo_y_te_Nguyen_Thi_Kim_Tien> <http://TEST/que_huong> ?o .}";	

	    strQuery[18] = 
		        "SELECT ?s FROM DEFAULT WHERE {" +
		        "?s <http://TEST/di_den> ?Dai_Loan .}";	

	    strQuery[19] = 
		        "SELECT ?o FROM DEFAULT WHERE {" +
		        "<http://TEST/Apple> <http://TEST/tru_so_tai> ?o .}";	

	    
  }
	 public String  singleQuery(RepositoryConnection repositoryConnection, int i) {
		 String rs = null;
			TupleQuery tupleQuery = repositoryConnection.prepareTupleQuery(QueryLanguage.SPARQL, strQuery[i]);
		    TupleQueryResult result = null;
		    
		    try {
		      result = tupleQuery.evaluate();
		      while (result.hasNext()) {
		        BindingSet bindingSet = result.next();
		        	SimpleLiteral gender1 = (SimpleLiteral)bindingSet.getValue("o");
		        	rs = gender1.stringValue();
		      }
		    }
		    catch (QueryEvaluationException qee) {
		      qee.getStackTrace();
		    }
		    finally {
		      result.close();
		    } 

		return rs;
	  } 
	 public void  advanceQuery(RepositoryConnection repositoryConnection, int i) {

			TupleQuery tupleQuery = repositoryConnection.prepareTupleQuery(QueryLanguage.SPARQL, strQuery[i]);
		    TupleQueryResult result = null;
		    
		    try {
		      result = tupleQuery.evaluate();
		      while (result.hasNext()) {
		        BindingSet bindingSet = result.next();
		        if(i%2==0) {
		        SimpleIRI gender = (SimpleIRI)bindingSet.getValue("s");
		        	System.out.println(gender.stringValue().substring(12));
		        }
		        else {
		        	SimpleIRI gender = (SimpleIRI)bindingSet.getValue("o");
		        	System.out.println(gender.stringValue().substring(12));
		        }
		      }
		    }
		    catch (QueryEvaluationException qee) {
		      qee.getStackTrace();
		    }
		    finally {
		      result.close();
		    } 
	  }
	  
}
