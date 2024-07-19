package api.test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_endpoints;
import api.payload.*;
import io.restassured.response.Response;

public class UserTests {

	Faker fake;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		fake=new Faker();
		userPayload= new User();
		
		userPayload.setId(fake.idNumber().hashCode());
		userPayload.setUsername(fake.name().username());
		userPayload.setFirstname(fake.name().firstName());
		userPayload.setLastname(fake.name().lastName());
		userPayload.setEmail(fake.internet().emailAddress());
		userPayload.setPassword(fake.internet().password());
		userPayload.setPhone(fake.phoneNumber().phoneNumber());
	}
	
	@Test(priority=1)
	public void testPostUser() {
		
		Response response= User_endpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void testGetUser() {
		Response response= User_endpoints.read_user(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	@Test(priority=3)
	public void testUpdateUserByName() {
		
		userPayload.setFirstname(fake.name().firstName());
		userPayload.setLastname(fake.name().lastName());
		userPayload.setEmail(fake.internet().safeEmailAddress());
		
		Response response= User_endpoints.update_user(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response response1= User_endpoints.read_user(this.userPayload.getUsername());
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		Response response=User_endpoints.delete_user(this.userPayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
