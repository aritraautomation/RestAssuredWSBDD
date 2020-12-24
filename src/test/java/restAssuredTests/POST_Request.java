package restAssuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class POST_Request {
	
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postData(){
		map.put("FirstName", RestUtil.getFirstName());
		map.put("LastName", RestUtil.getLastName());
		map.put("UserName", RestUtil.getUserName());
		map.put("Password", RestUtil.getPassword());
		map.put("Email", RestUtil.getEmail());
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";		
	}
	
	@Test
	public void testData(){
		
		given().
			contentType("application/json").
			body(map).
		when().
			post().
		then().
			//statusCode(200).
			body("SuccessCode", equalTo("OPERATION_SUCCESS")).
			body("Message",equalTo("Operation completed successfully")).and().
			log().all();		
	}

}
