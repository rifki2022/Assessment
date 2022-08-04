package Files;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.internal.Utils;

//import static org.hamcrest.Matchers.*;
public class Basic {

	public static void main(String[] args) {
		
        Response response;
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String userName = Utils.getGlobalproperty("userName");
		

		// Create User
given().log().all().header("Content-type", "application/json")
				.body(Payload.createUser("Amal", "Amal", "Perera", "amal123@gmail.com", "abcd1234", "1234567890"))
				.when().post("/user").then().assertThat().statusCode(200);
		
		//Get User from user name
		response = given().log().all().when().get("/user/"+userName+"").then().log().all().assertThat().statusCode(200).extract().response();
		String headerGet = .getHeaders().getValue("Content-Type");
		assertEquals(headerGet,"application/json");
		given().log().all().when().get("/user/Acentura").then().log().all().assertThat().statusCode(404).extract().response();
		// displays 404 for invalid user
given().log().all().when().get("/user/Amal").then().log().all().assertThat().statusCode(404).extract().response();

	}
}