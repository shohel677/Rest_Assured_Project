package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserLoginEndPoints {
	
	public static Response positiveLogin(String userName, String Password){
		Response response = 
		given()
			.contentType(ContentType.JSON)
			.queryParam("username", userName)
			.queryParam("password", Password)
		.when()
		.get(Routes.User_Login_API);
		
		return response;
		
	}
	public static Response logout(){
		Response response = 
		given()
			.contentType(ContentType.JSON)
			
		.when()
		.get(Routes.User_Logout_API);
		
		return response;
		
	}

}
