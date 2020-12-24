package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Delete_Request {
	
	int emp_id=2;
	
	@Test
	public void testDelete(){
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/"+emp_id;
		
		Response jsonResponse = 
		given().
		when().
			delete().
		then().
			statusCode(200).
			log().all().
			extract().response();
		
		String jsonAsString=jsonResponse.asString();
		
		Assert.assertEquals(jsonAsString.contentEquals("successfully! deleted Records"),true);
	}
}
