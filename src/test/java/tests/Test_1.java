package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_1 {
	
	@Test
	public void test_1() {
		String url = "https://reqres.in/api/users?page=2";
		Response response = RestAssured.get(url);
		
		int statusCode = response.getStatusCode();
//		response.getTime();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		Assert.assertEquals(statusCode, 200);
	}

}
