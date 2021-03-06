package controllers;

import java.util.List;

import db.DatamodelUtility;
import db.Patient;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.neo4jdemo;

public class Neo4JDemo extends Controller {


	
	
   public Result demo() {
	   
	    String SERVER_ROOT_URI = "http://localhost:7474/db/data/";
	   	String username = "neo4j";
	   	String password = "neo4jpass";
	   
	   	try {
			DatamodelUtility caller = new DatamodelUtility(SERVER_ROOT_URI, username, password);
			List<Patient> patients = caller.getPatients();
			System.out.println(patients.size());
			return ok(neo4jdemo.render(patients));
		} catch (Exception e) {
			e.printStackTrace();
			return ok(index.render(e.getMessage()));
		}
	    
    }
}
