package api.utilities;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.responseSpecification;

import org.hamcrest.Matchers;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import io.github.cdimascio.dotenv.Dotenv;

public class BaseClass {
	
	public static Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
	public Faker faker = new Faker();
	
	//This method is used to check the response time
	@BeforeClass(alwaysRun = true)
	public void checkResponseTime(){
		responseSpecification = expect().response().time(Matchers.lessThan(150000L));
	}

	//This method is used to get the error in the console
	@AfterMethod(alwaysRun = true)
	public void printErrorInConsole(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println(result.getMethod());
			System.out.println(result.getThrowable());
			System.out.println("FAILED");
		}
		if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println(result.getMethod());
			System.out.println("PASSED");
		}
	}

}
