package api.endpoints;

import org.hamcrest.Matchers.*;

import api.payload.User;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;

public class User_endpoints {
	
	public static Response createUser(User payload) {
		
		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.create_user_url);
		return response;
		
	}
	
	public static Response read_user(String userName) {
		Response response= given()
				.pathParam("username", userName)
				
				.when()
				.get(Routes.get_user_url);
		return response;
	}
	
	public static Response update_user(String userName, User payload) {
		Response response= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				
				.when()
				.put(Routes.update_user_url);
		return response;
	}
	
	public static Response delete_user(String userName) {
		Response response= given()
				.pathParam("username", userName)
				
				.when()
				.delete(Routes.delete_user_url);
		return response;
		
	}

}
