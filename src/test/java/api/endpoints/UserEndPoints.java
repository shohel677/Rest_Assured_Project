package api.endpoints;
import static io.restassured.RestAssured.given;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//import io.restassured.matcher.RestAssuredMatchers.*;
//import org.hamcrest.Matchers.*;

public class UserEndPoints {
	
	public static Response createUser(User Payload){
		Response response = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(Payload)
		
		.when()
		.post(Routes.User_Create_API);
		
		return response;
		
	}
	public static Response getUser(String userName){
		Response response = 
		given()
			.pathParam("username", userName)
		.when()
		.get(Routes.User_Get_API);
		
		return response;
		
	}
	public static Response upadteUser(String userName, User Payload){
		Response response = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(Payload)
		
		.when()
		.put(Routes.User_Update_API);
		
		return response;
		
	}
	public static Response deleteUser(String userName){
		Response response = 
		given()
			.pathParam("username", userName)
		.when()
		.delete(Routes.User_Delete_API);
		
		return response;
		
	}

}
