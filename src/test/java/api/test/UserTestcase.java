package api.test;

import static io.restassured.RestAssured.responseSpecification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.BaseClass;
import io.restassured.response.Response;

public class UserTestcase extends BaseClass {
	
	User userPaylaod= new User();
	public Logger logger = LogManager.getLogger(this.getClass());
	
	@Test(priority =1)
	public void testCreateUser(){
		
		userPaylaod.setId(faker.idNumber().hashCode());	
		userPaylaod.setUsername(faker.name().username());
		userPaylaod.setFirstName(faker.name().firstName());
		userPaylaod.setLastName(faker.name().lastName());
		userPaylaod.setEmail(faker.internet().safeEmailAddress());
		userPaylaod.setPassword(faker.internet().password(5, 10));
		userPaylaod.setPhone(faker.phoneNumber().cellPhone());
		logger.info("**************************Create user test case started**************************");
		Response response = UserEndPoints.createUser(userPaylaod);
		response.then()
		//.log().all()
        .spec(responseSpecification);
		
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Assertion passed for status code 200");
		logger.info("**************************Create user test case End**************************");
	}
	
	@Test(priority =2)
	public void testReadUser() {
		logger.info("**************************Read user test case started**************************");
		Response response = UserEndPoints.getUser(this.userPaylaod.getUsername());
		response.then()
		//.log().all()
		.spec(responseSpecification);
			
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Assertion passed for status code 200");
		logger.info("**************************Read user test case End**************************");
	}
	
	@Test(priority =3)
	public void testUpdateUse() {
		
		userPaylaod.setFirstName(faker.name().firstName());
		userPaylaod.setLastName(faker.name().lastName());
		
		logger.info("**************************Update user test case started**************************");
		Response response = UserEndPoints.upadteUser(this.userPaylaod.getUsername(), userPaylaod);
		response.then()
		//.log().all()
		.spec(responseSpecification);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Assertion passed for status code 200");
		logger.info("**************************Update user test case End**************************");
	}
	
	@Test(priority =4)
	public void testDeleteUser() {
		logger.info("**************************Delete user test case started**************************");
		Response response = UserEndPoints.deleteUser(this.userPaylaod.getUsername());
		response.then()
		//.log().all()
		.spec(responseSpecification);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("Assertion passed for status code 200");
		logger.info("**************************Delete user test case End**************************");
		
	}

}
