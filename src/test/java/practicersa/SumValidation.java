package practicersa;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import testrsa.Payload;
@Test
public class SumValidation {
	public static void main(String[] args) {

	 
		int sum = 0;
		JsonPath js = new JsonPath(Payload.CoursePrice());
		int countcourse = js.getInt("courses.size()");
		
		for (int i=0;i<countcourse;i++)
		{
			int priceofcourese = js.get("courses["+i+"].price");
			int copies= js.get("courses["+i+"].copies");
			int totalPrice = priceofcourese * copies;
			System.out.println(totalPrice);
			sum = sum + totalPrice;
		}
		System.out.println(sum);
		int amount = js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, amount);
	}

}

