package api.test;
import static io.restassured.RestAssured.responseSpecification;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserLoginEndPoints;
import api.payload.UserLoginPayload;
import api.utilities.BaseClass;
import io.restassured.response.Response;

public class LoginTestcase extends BaseClass{
	
	UserLoginPayload userLoginPayload = new UserLoginPayload();
	
	@Test
	public void testPositiveLogin() {
		
		userLoginPayload.setUsername(dotenv.get("USER_NAME"));
		userLoginPayload.setPassword(dotenv.get("USER_PASSWORD"));
		
		Response response = UserLoginEndPoints.positiveLogin(this.userLoginPayload.getUsername(), this.userLoginPayload.getPassword());
		response.then()
		//.log().all()
		.spec(responseSpecification);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test
	public void testLogout() {

		Response response = UserLoginEndPoints.logout();
		response.then()
		//.log().all()
		.spec(responseSpecification);

		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
}
