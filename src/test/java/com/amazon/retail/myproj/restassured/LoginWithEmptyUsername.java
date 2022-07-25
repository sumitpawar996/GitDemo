package com.amazon.retail.myproj.restassured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.hamcrest.Matchers;
public class LoginWithEmptyUsername {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Response resp;
		
		String reqBody ="{ \r\n"
				+ "    \"username\": \"\",\r\n"
				+ "    \"password\": \"Sumit@123\" \r\n"
				+ "}";
		
		resp = given().log().all()
				.baseUri("http://localhost:8080/rest")
				.basePath("/auth/1/session")
				.contentType(ContentType.JSON)
				.body(reqBody)
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(401)
		.statusLine("HTTP/1.1 401 ")
		.extract()
		.response();
		
		 System.out.println( resp.getStatusLine());
		 
		 // with harmcrest
		 
		 resp = given().log().all()
					.baseUri("http://localhost:8080/rest")
					.basePath("/auth/1/session")
					.contentType(ContentType.JSON)
					.body(reqBody)
			.when()
			.post()
			.then().log().all()
			.assertThat()
			.statusCode(Matchers.equalTo(401))
			.statusLine(Matchers.equalToIgnoringCase("http/1.1 401 "))
			.statusLine(Matchers.containsStringIgnoringCase("HTTP"))
			.statusLine(Matchers.notNullValue())
			.contentType(ContentType.JSON)
			.contentType(Matchers.notNullValue())
			.contentType(Matchers.containsStringIgnoringCase("JSON"))
			.extract()
			.response();
	}

}
