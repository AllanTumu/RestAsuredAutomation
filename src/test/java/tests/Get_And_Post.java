package tests;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Get_And_Post {
	
	@Test
	public void get () {
		
		baseURI = "https://reqres.in/api";
		//GET
		given().
			get("users?page=2").
				then().statusCode(200).
				body("data[3].first_name", equalTo("Byron")).
				body("data.first_name", hasItems("Tobias","George"));
		
	}
	
	//POST
	@Test
	public void post () {
		// TODO Auto-generated method stub
//		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Raghav");
//		map.put("job", "Teacher");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}

}
