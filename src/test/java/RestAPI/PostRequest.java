package RestAPI;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void PostCall() {
		
		Logger logger = Logger.getLogger("APILogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("**********Logging Info:[PostCall]***********");
	
		RestAssured.given()
		.baseUri("https://reqres.in/api")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body("{\r\n"
				+ "        \"id\": 101,\r\n"
				+ "        \"email\": \"abc@xyz.com\",\r\n"
				+ "        \"first_name\": \"Nik\",\r\n"
				+ "        \"last_name\": \"Shah\",\r\n"
				+ "        \"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"\r\n"
				+ "    }")
		.when()
		.post("/users")
		.then()
		.statusCode(201)								//validation by code always added after then()
		.log()
		.all();
		
	}

}