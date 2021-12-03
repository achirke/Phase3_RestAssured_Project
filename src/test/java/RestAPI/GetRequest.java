package RestAPI;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.testng.annotations.Test;


import io.restassured.RestAssured;

public class GetRequest {
	
	@Test
	public void GetCall() {
		
		Logger logger = Logger.getLogger("APILogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("**********Logging Info:[GetCall]***********");
		
		RestAssured.given()
					.baseUri("https://reqres.in/api")
					.when()
					.get("/users")
					.then()
					.statusCode(200)							//validation by code always added after then()
					.log()
					.all();

   }
	
}
