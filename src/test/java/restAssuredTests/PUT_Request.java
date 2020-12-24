package restAssuredTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class PUT_Request {
	
	public static HashMap hm = new HashMap();
	int emp_id=5;
	
	@BeforeClass
	public void postData(){
		hm.put("name", RestUtil.empName());
		hm.put("salary", RestUtil.empSalary());
		hm.put("age", RestUtil.empAge());
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void testPost(){
		
		//Response jsonResponse = 
		given().
			contentType("application/json").
			body(hm).
		when().
			put().
		then().
			statusCode(200).
			and().
			log().all();
			//extract().response();
	
	}

}
