package api.test;

import org.testng.annotations.Test;

public class BasicCode {

	BasicCode2 userTest = new BasicCode2();
	
	

	
	@Test
	public void createUserTest(){
		userTest.createUserTestcase();
		System.out.println(BasicCode2.test);
		System.out.println(BasicCode2.test2);
		System.out.println(BasicCode2.test3);
		System.out.println(BasicCode2.test4);
	}
		
		
		
}