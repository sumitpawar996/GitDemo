package com.amazon.retail.myproj.restassured;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.amazon.retail.myproj.reqjsonpayload.LoginAPIReqPayload;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;

public class LoginAPI {

	//LoginAPI login = new LoginAPI();
	static Cookie cookie;
@Test
	protected void LoginwithValidCredentials()
	{
		// TODO Auto-generated method stub
		
		Response resp;

		
		resp = given().log().all()
				.baseUri("http://localhost:9090/rest")
				.basePath("auth/1/session")
				.body(LoginAPIReqPayload.LoginwithValidCredentialsReqBody)
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
	@Test
	protected void LoginWithEmptyUserName()
	{
		Response resp;
		
	
		
		resp = given().log().all()
				.baseUri("http://localhost:9090/rest")
				.basePath("/auth/1/session")
				.contentType(ContentType.JSON)
				.body(LoginAPIReqPayload.LoginWithEmptyUserNameReqBody)
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
					.baseUri("http://localhost:9090/rest")
					.basePath("/auth/1/session")
					.contentType(ContentType.JSON)
					.body(LoginAPIReqPayload.LoginWithEmptyUserNameReqBody)
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
	@Test
	protected void LoginWithNullPassword() 
	{
		
	Response resp;
	
	String reqBody= "{ \r\n"
			+ "    \"username\": \"sumitpawar996\",\r\n"
			+ "    \"password\": null \r\n"
			+ "}";
	
			given()
			.baseUri("http://localhost:9090/rest")
			.basePath("/auth/1/session")
			.body(reqBody)
			.contentType(ContentType.JSON)
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
@Test
	protected void LoginWithNullUserName()

	{
		Response resp;
		
		String reqBody= "{ \r\n"
				+ "    \"username\": null, \r\n"
				+ "    \"password\": \"Sumit@123\" \r\n"
				+ "}";
		
				given()
				.baseUri("http://localhost:9090/rest")
				.basePath("/auth/1/session")
				.body(reqBody)
				.contentType(ContentType.JSON)
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
@Test
	protected void LoginWithInvalidUserName()

	{
Response resp;
		
		String reqBody= "{ \r\n"
				+ "    \"username\": \"sumitpawar998\",\r\n"
				+ "    \"password\": \"Sumit@123\" \r\n"
				+ "}";
		
				given()
				.baseUri("http://localhost:9090/rest")
				.basePath("/auth/1/session")
				.body(reqBody)
				.contentType(ContentType.JSON)
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
@Test
	protected void LoginWithEmptyPassword() 
	{
			Response resp;
		
		String reqBody= "{ \r\n"
				+ "    \"username\": \"sumitpawar996\",\r\n"
				+ "    \"password\":  \"\"\r\n"
				+ "}";
		
				given()
				.baseUri("http://localhost:9090/rest")
				.basePath("/auth/1/session")
				.body(reqBody)
				.contentType(ContentType.JSON)
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
