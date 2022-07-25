package com.amazon.retail.myproj.restassured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import com.google.gson.JsonParser;

public class GetBoardAPI {

	LoginAPI login = new LoginAPI();
	
	@Test
	public void getBoard(String url)
	{
			
		login.LoginwithValidCredentials();
		
		Response resp;
		
		resp= given()
				.baseUri(url)
				.basePath("/auth/1/session")
				.cookie(login.cookie)
				.when()
				.get()
				.then()
				.assertThat()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 ")
				.contentType(ContentType.JSON)
				.extract()
				.response();
				
			// first req - body as string
		String respBodyStr= resp.getBody().asPrettyString();
		
		// creating parser object to call parse method
		JsonParser parser = new JsonParser();
		
		// 
		
	}
}
