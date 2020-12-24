package restAssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GET_Request {
	
	@Test(priority=1)
	public void getWeatherReport(){
		
		given().
		when().
			get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad").
		then().
			statusCode(200).
			and().
			statusLine("HTTP/1.1 200 OK").
			and().
			assertThat().body("City",equalTo("Hyderabad"));
	}
		
		@Test(priority=2)
		public void testParamHeader(){
			given().
				param("MyName", "pavan").
				header("MyHeader","Indian").
			when().
				get("http://services.groupkt.com/country/get/iso2code/IN").
			then().
				body("RestResponse.result.name", equalTo("India")).
				log().all();
		}
	}
