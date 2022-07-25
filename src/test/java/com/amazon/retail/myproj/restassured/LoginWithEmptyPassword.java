package com.amazon.retail.myproj.restassured;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
public class LoginWithEmptyPassword {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Response resp;
		
	  String reqBody = "{ \r\n"
				+ "    \"username\": \"sumitpawar996\",\r\n"
				+ "    \"password\":  \"\"\r\n"
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
			.statusCode(Matchers.equalTo(403))
			.statusLine(Matchers.equalTo("HTTP/1.1 403 "))
			.statusLine(Matchers.notNullValue())
			.statusLine(Matchers.equalToIgnoringCase("http/1.1 403 "))
			
			.contentType(ContentType.JSON)
			.contentType(Matchers.notNullValue())
			.contentType(Matchers.containsStringIgnoringCase("JSON"))
			.extract()
			.response();

	}

}
