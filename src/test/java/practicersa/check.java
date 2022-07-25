package practicersa;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.amazon.retail.myproj.restassured.LoginAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class check {
	


		LoginAPI login = new LoginAPI();
		
		@Test
		public void getBoard()
		{
				
		
			
			Response resp;
			
			resp= given()
					.baseUri("http://localhost:9090/rest")
					.basePath("/auth/1/session")
					
					.when()
					.get()
					.then()
					.assertThat()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 ")
					.contentType(ContentType.JSON)
					.extract()
					.response();

}
}
