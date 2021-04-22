package tests;

import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Get_And_Post {
	
	@Test
	public void get_and_post () {
		
		baseURI = "https://reqres.in/api";
		//Check Status Code of the API
		given().
			get("users?page=2").
				then().statusCode(200).
				body("data[3].first_name", equalTo("Byron")).
				body("data.first_name", hasItems("Tobias","George"));
		
		
		
		
	}

}
