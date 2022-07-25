package com.amazon.retail.myproj.restassured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;

public class LoginWithValidData {
	static Cookie cookie;
	
	
	public static void main(String[] args) 
	{
	// TODO Auto-generated method stub
	
	Response resp;
	String reqBody = "{ \r\n"
			+ "    \"username\": \"sumitpawar996\",\r\n"
			+ "    \"password\": \"Sumit@123\" \r\n"
			+ "}";
	
	resp = given().log().all()
			.baseUri("http://localhost:8080/rest")
			.basePath("auth/1/session")
			.body(reqBody)
			.contentType(ContentType.JSON)
		.when()
		   .post()
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 ")
		
		.extract()
		.response();
	// printing values from response 
	System.out.println(resp.getStatusCode());
	System.out.println(resp.getStatusLine());
	System.out.println(resp.getTimeIn(TimeUnit.MILLISECONDS));
	System.out.println(resp.getDetailedCookie("JSESSIONID"));
	System.out.println(resp.getHeader("X-AUSERNAME"));
		
	cookie = resp.getDetailedCookie("JSESSIONID");
}

}


