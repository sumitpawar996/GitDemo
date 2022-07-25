package practicersa;

import io.restassured.path.json.JsonPath;
import testrsa.Payload;
import org.hamcrest.Matchers.*;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		
		int countcourse = js.getInt("courses.size()");
		System.out.println(countcourse);
	
		// print purchase amount
		
		int totalamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);
		
		// print course title
		String cousres = js.get("courses[0].title");
		
		System.out.println(cousres);
		
		// print all courese and price 
		for (int i = 0; i<countcourse ;i++)
		{
			 String coursetile = js.get("courses["+i+"].title");
			int priceofcourese = js.get("courses["+i+"].price");
			System.out.println(coursetile);
			System.out.println(priceofcourese);
			
		}

		System.out.println("Print no of coures sold by rpa course");
		
		for (int i = 0; i<countcourse ;i++)
		{
			 String coursetile = js.get("courses["+i+"].title");
			if (coursetile.equalsIgnoreCase("RPA"))
			{
			int copies= 	js.get("courses["+i+"].copies");
				System.out.println(copies);
			}
			
		}
		
	}

}
