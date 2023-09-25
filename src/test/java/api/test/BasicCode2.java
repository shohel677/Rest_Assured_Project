package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class BasicCode2 {

	Faker faker = new Faker();
	User userPaylaod= new User();
	public static String test;
	public static String test2;
	public static int test3;
	public static int test4;
	
	@BeforeClass
	public void setup() {
		//faker = new Faker();
		//userPaylaod= new User();
		
		userPaylaod.setId(faker.idNumber().hashCode());	
		userPaylaod.setUsername(faker.name().username());
		userPaylaod.setFirstName(faker.name().firstName());
		userPaylaod.setLastName(faker.name().lastName());
		userPaylaod.setEmail(faker.internet().safeEmailAddress());
		userPaylaod.setPassword(faker.internet().password(5, 10));
		userPaylaod.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test
	public void createUserTestcase(){
		Response response = UserEndPoints.createUser(userPaylaod);
		response.then()
		.log().all();
		  test = response.getHeader("Access-Control-Allow-Methods");
		  test2 = response.getHeader("Server");
		  test3 = response.jsonPath().getInt("code");
		  test4 = response.jsonPath().getInt("message");
				  
		
		
	}
	@Test
	public void createTestUserTestcase(){
		createUserTestcase();

		 System.out.println(test);
		 System.out.println(test2);
		 System.out.println(test3);
		 System.out.println(test4);
		
		
	}
		
		
	

}
