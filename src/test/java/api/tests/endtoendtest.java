package api.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.httpmethodsforusers.useroperations;
import api.payloads.pojopayload;
import io.restassured.response.Response;

public class endtoendtest  {
	pojopayload pojoobject;
	Faker fk;
	
	@BeforeClass	
	public void set_payload1() {			
		fk = new Faker();
		pojoobject = new pojopayload();	
		// setting payload value
		pojoobject.setId(fk.idNumber().hashCode());
		pojoobject.setUsername(fk.name().username());
		pojoobject.setFirstName(fk.name().firstName());
		pojoobject.setLastName(fk.name().lastName());
		pojoobject.setEmail(fk.internet().emailAddress());
		pojoobject.setPassword(fk.internet().password());
		pojoobject.setPhone(fk.phoneNumber().cellPhone());
		pojoobject.setUserStatus(0);	
		
	}
		
	@Test(priority=1)
	public void Testcase_1() {		
	
		/* Create a user - POST method and check response status code 200 */	
		System.out.println("Testcase_1 - Post Method");
		Response response = useroperations.createuser_post(pojoobject);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);		
	}
	
	
	@Test(priority=2)
	public void Testcase_2() {
		
		/* Get the user - GET method and check response status code 200 */
		System.out.println("Testcase_2 - Get Method");
		Response response = useroperations.getuser_get(pojoobject.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);		
	}
	
	@Test(priority=3)
	public void Testcase_3() {
		
		/* Update the user's email id - PUT method and check response status code 200 */
		System.out.println("Testcase_3 - Put Method");
		pojoobject.setEmail(fk.internet().emailAddress());
		Response response = useroperations.updateuser_put(pojoobject.getUsername(),pojoobject);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		//cross checking by retrieving the user
		// retrieve the same user and check whether email id of previous is updated to new email id
		Response response1 = useroperations.getuser_get(pojoobject.getUsername());
		response1.then().log().all();
	}
	
	@Test(priority=4)
	public void Testcase_4() {		
		/* Delete the user - GET method and check response status code 200 */
		System.out.println("Testcase_4 - Delete Method");
		Response response = useroperations.deleteuser_delete(pojoobject.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);	
		
		//cross checking by retrieving the user
		// retrieve the same user and check whether the user got deleted
		Response response1 = useroperations.getuser_get(pojoobject.getUsername());
		response1.then().log().all();
		Assert.assertEquals(response1.statusCode(), 404);
	}
}
